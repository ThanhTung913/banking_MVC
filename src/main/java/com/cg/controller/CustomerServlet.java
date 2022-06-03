package com.cg.controller;

import com.cg.model.Customer;
import com.cg.service.ICustomerService;
import com.cg.service.CustomerServicelmpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customers")
public class CustomerServlet extends HttpServlet {


    private final ICustomerService customerService = new CustomerServicelmpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        resp.setContentType("text/html;charset=UTF-8");
//        req.setCharacterEncoding("utf-8");
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(req, resp);
                break;
            case "edit":
                showEditForm(req, resp);
                break;
            case "deposit":
                showDepositForm(req, resp);
                break;
            case "withdraw":
                showWithdrawForm(req, resp);
                break;
            case "tranfer":
                showTranferForm(req, resp);
                break;
            case "delete":
                showDeleteForm(req, resp);
                break;
            case "tranferMoney":
                showTranferMoneyForm(req, resp);
                break;
            default:
                showCustomers(resp, req);
                break;
        }
    }

    private void showTranferMoneyForm(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/customer/tranferMoneyInformation.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showDeleteForm(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        Customer customer  = customerService.findById(id);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/customer/withdraw.jsp");
        req.setAttribute("nameCustomer", customer.getName());
        req.setAttribute("emailCustomer", customer.getEmail());
        req.setAttribute("addressCustomer",customer.getAddress());
        req.setAttribute("phoneCustomer",customer.getPhone());
        req.setAttribute("balanceCustomer",customer.getBalance());
        req.setAttribute("id",id);
        req.setAttribute("customer", customer);
        System.out.println(customer.getName());
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showTranferForm(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/customer/tranfer.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showWithdrawForm(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        Customer customer  = customerService.findById(id);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/customer/withdraw.jsp");
        req.setAttribute("nameCustomer", customer.getName());
        req.setAttribute("emailCustomer", customer.getEmail());
        req.setAttribute("addressCustomer",customer.getAddress());
        req.setAttribute("phoneCustomer",customer.getPhone());
        req.setAttribute("balanceCustomer",customer.getBalance());
        req.setAttribute("id",id);
        req.setAttribute("customer", customer);
        System.out.println(customer.getName());
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showDepositForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Customer customerExist = customerService.findById(id);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/customer/deposit.jsp");
        req.setAttribute("customerExist",customerExist);
        dispatcher.forward(req, resp);
    }


    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/customer/edit.jsp");
        int id = Integer.parseInt(req.getParameter("id"));
        System.out.println(id);
        Customer customer = customerService.findById(id);
        req.setAttribute("nameCustomer", customer.getName());
        req.setAttribute("emailCustomer", customer.getEmail());
        req.setAttribute("addressCustomer",customer.getAddress());
        req.setAttribute("phoneCustomer",customer.getPhone());
        req.setAttribute("id",id);
        System.out.println(customer.getName());
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {


    }

    private void showCreateForm(Customer newCustomer) {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                doDeposit(req, resp);
                break;
            case "findById":
                findById(req, resp);
                break;
            case "createOrder":
                break;
            case "edit" :
                editCustomer(req,resp);
                break;
            default:
                break;
        }

    }

    private void editCustomer(HttpServletRequest request,HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/customers/edit.jsp");
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerService.findById(id);
        customer.setName(request.getParameter("fullName"));
        customer.setEmail(request.getParameter("email"));
        customer.setPhone(request.getParameter("phone"));
        customer.setAddress(request.getParameter("address"));
        try {
            customerService.update(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("nameCustomer", customer.getName());
        request.setAttribute("emailCustomer", customer.getEmail());
        request.setAttribute("addressCustomer",customer.getAddress());
        request.setAttribute("phoneCustomer",customer.getPhone());
        request.setAttribute("id",id);
        request.setAttribute("message","Update successful !!!");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void findById(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));


    }

    private void doDeposit(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String messErrorName = "";
        String messErrorPrice = "";
        if (name == null || name.equals("")) {
            messErrorName = "Không được để trống trường này";
        }
        if (email == null || email.equals("")) {
            messErrorPrice = "Trường này không dược bỏ trống";
        }

        if (!messErrorName.equals("") || !messErrorPrice.equals("")) {
            request.setAttribute("id", id);
            request.setAttribute("name", name);
            request.setAttribute("email", email);
            request.setAttribute("phone", phone);
            request.setAttribute("address", address);
            request.setAttribute("phone", messErrorName);
            request.setAttribute("address", messErrorPrice);
            RequestDispatcher dispatcher = request.getRequestDispatcher("customer/createCustomer.jsp");
            try {
                dispatcher.forward(request, response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        } else {
            String newName = name;
            Customer newCustomer = new Customer(id, name, email, phone,address);
            showCreateForm(newCustomer);
            String messSuccess = "Thêm khách hàng " + newName + " thành công!!!";
            request.setAttribute("messSuccess", messSuccess);
            RequestDispatcher dispatcher = request.getRequestDispatcher("");
            try {
                dispatcher.forward(request, response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
//            createItem(request, response);
        }
    }


    private void showCustomers(HttpServletResponse resp, HttpServletRequest req) {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/customer/list.jsp");

        List<Customer> customers = customerService.findAll();

        req.setAttribute("customers", customers);
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



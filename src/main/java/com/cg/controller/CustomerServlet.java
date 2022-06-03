package com.cg.controller;

import com.cg.model.Customer;
import com.cg.service.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customers")
public class CustomerServlet extends HttpServlet {
    private CustomerServicelmpl customerServicelmpl;

    public void init() {
        customerServicelmpl = new CustomerServicelmpl();
    }

    private final ICustomerService customerService = new CustomerServicelmpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("utf-8");
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
        Customer customer = customerService.findById(id);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/customer/withdraw.jsp");
        req.setAttribute("nameCustomer", customer.getName());
        req.setAttribute("emailCustomer", customer.getEmail());
        req.setAttribute("addressCustomer", customer.getAddress());
        req.setAttribute("phoneCustomer", customer.getPhone());
        req.setAttribute("balanceCustomer", customer.getBalance());
        req.setAttribute("id", id);
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
        Customer customer = customerService.findById(id);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/customer/withdraw.jsp");
//        req.setAttribute("nameCustomer", customer.getName());
//        req.setAttribute("emailCustomer", customer.getEmail());
//        req.setAttribute("addressCustomer", customer.getAddress());
//        req.setAttribute("phoneCustomer", customer.getPhone());
//        req.setAttribute("balanceCustomer", customer.getBalance());
//        req.setAttribute("id", id);
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
        Customer customer = customerService.findById(id);
        req.setAttribute("customer", customer);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/customer/deposit.jsp");
        dispatcher.forward(req, resp);
    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        Customer customer = customerService.findById(id);
        req.setAttribute("full_name",customer.getName());
        req.setAttribute("email",customer.getEmail());
        req.setAttribute("phone",customer.getPhone());
        req.setAttribute("address",customer.getAddress());
        req.setAttribute("id",customer.getId());
//        req.setAttribute("customer", customer);
        System.out.println(customer.getName());
        RequestDispatcher dispatcher = req.getRequestDispatcher("/customer/edit.jsp");
        dispatcher.forward(req, resp);

    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/createCustomer.jsp");
        dispatcher.forward(request, response);
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
            case "deposit":
                doDeposit(req, resp);
                break;
            case "withdraw":
                doWithdraw(req, resp);
                break;
            case "create":
                createCustomer(req, resp);
                break;
            case "edit":
                editCustomer(req, resp);
                break;
            default:
                break;
        }

    }

    private void createCustomer(HttpServletRequest req, HttpServletResponse resp){
        try{
            String name = req.getParameter("full_name");
            String email = req.getParameter("email");
            String phone = req.getParameter("phone");
            String address = req.getParameter("address");
            Customer newCustomer = new Customer(name, email, phone, address);

            System.out.println(newCustomer);
            customerService.create(newCustomer);
            RequestDispatcher dispatcher = req.getRequestDispatcher("customer/createCustomer.jsp");
            dispatcher.forward(req, resp);
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }


    private void editCustomer(HttpServletRequest request, HttpServletResponse response) {
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
        request.setAttribute("addressCustomer", customer.getAddress());
        request.setAttribute("phoneCustomer", customer.getPhone());
        request.setAttribute("id", id);
        request.setAttribute("message", "Update successful !!!");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void findById(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));


    }

    private void doWithdraw(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerService.findById(id);
        BigDecimal transactionAmount = new BigDecimal(request.getParameter("transactionAmount"));
        IWithDrawService withDrawService = new WithDrawService();
        String messager = request.getParameter("messager");
        withDrawService.withdraw(id, transactionAmount, messager);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/withdraw.jsp");
        request.setAttribute("customer", customer);
        dispatcher.forward(request, response);
    }

    private void doDeposit(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerService.findById(id);
        BigDecimal transactionAmount = new BigDecimal(request.getParameter("transactionAmount"));
        IDepositSerVice depositSerVice = new DepositService();
        depositSerVice.deposit(id, transactionAmount);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/deposit.jsp");
        request.setAttribute("customer", customer);

        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

    }


    private void showCustomers(HttpServletResponse resp, HttpServletRequest req) {
        RequestDispatcher dispatcher = req.getRequestDispatcher("customer/list.jsp");

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



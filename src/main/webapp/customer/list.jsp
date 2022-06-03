<%--
  Created by IntelliJ IDEA.
  User: prom1
  Date: 01/06/2022
  Time: 10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<!DOCTYPE html>
<head>
    <%@include file="/layout/head.jsp" %>
    <title>List of customers</title>

</head>

<body>
<div class="container">
    <div class="table-title">
        <div class="row">
            <div class="col-sm-5">
                <h1>List of customers</h1>
            </div>
            <div class="col-sm-7">
                <a href="/customers?action=create">
                    <button type="button" class="btn btn-outline-light" data-bs-toggle="modal"
                            data-bs-target="#createModal">
                        <i class="fa-solid fa-plus"></i>
                        <span>Add New Customer</span>
                    </button>
                </a>
                <a href="/customers?action=tranferMoney" class="btn btn-outline-light">
                    <i class="fa fa-history" aria-hidden="true"></i>
                    <span>Transfer money Information</span>
                </a>
            </div>
        </div>
    </div>
    <div>
        <table class="table table-hover table-borderless">
            <thead>
            <tr>
                <th>#</th>
                <th>Full Name</th>
                <th>Email</th>
                <th>phone</th>
                <th>Address</th>
                <th>Balance</th>
                <th scope="col" colspan="2" style="text-align: center"> Action</th>
            </tr>
            </thead>
            <tbody id="tbCustomer">
           <c:forEach items="${customers}" var="item">
                <tr>
                    <td>${item.getId()}</td>
                    <td>${item.getName()}</td>
                    <td>${item.getEmail()}</td>
                    <td>${item.getPhone()}</td>
                    <td>${item.getAddress()}</td>
                    <td>${item.getBalance()}</td>
                    <td style="text-align: center">
<%--                        <a href="/customers?action=edit&id=${item.getId()}">--%>
                    <a href="/customers?action=edit&id=${item.getId()}">
                            <button class="btn btn-outline-primary">
                                <i class="fas fa-pencil-alt"></i>
<%--                                edit--%>
                            </button>
                        </a>
                    </td>
                    <td style="text-align: center">
                        <a href="/customers?action=deposit&id=${item.getId()}">

                            <button class="btn btn-outline-success">
                                <i class="far fa-plus-square"></i>
<%--                                Deposit--%>
                            </button>
                        </a>
                    </td>

                    <td style="text-align: center">
                        <a href="/customers?action=withdraw&id=${item.getId()}">

                            <button class="btn btn-outline-warning">
                                <i class="fas fa-minus-square"></i>
<%--                                withdraw--%>
                            </button>
                        </a>
                    </td>

                    <td style="text-align: center">
                        <a href="/customers?action=tranfer&id=${item.getId()}">

                            <button class="btn btn-outline-info">
                                <i class="fas fa-exchange-alt"></i>
<%--                                tranfer--%>
                            </button>
                        </a>
                    </td>

                    <td style="text-align: center">
                        <a href="/customers?action=delete&id=${item.getId()}">

                            <button class="btn btn-outline-danger">
                                <i class="fas fa-trash-alt"></i>
<%--                                delete--%>
                            </button>
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<%@include file="/layout/script.jsp" %>
</body>

</html>

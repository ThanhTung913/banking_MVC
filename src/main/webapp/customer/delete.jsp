<%--
  Created by IntelliJ IDEA.
  User: prom1
  Date: 01/06/2022
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Suspension of customers</title>

    <%@include file="/layout/head.jsp"%>

</head>
<body>
<div class="container">
    <div class="table-title mb-4">
        <div class="row">
            <div class="col-sm-6">
                <h1>Suspension of customers</h1>
            </div>
            <div class="col-sm-6">
                <a href="/customers" class="btn btn-outline-light"><i class="fa fa-list" aria-hidden="true"></i> <span>Customer list</span></a>
            </div>
        </div>
    </div>
    <form id="frmSuspensionCustomer" method="post">
        <fieldset class="row g-3">
            <input type="hidden" name="id" id="id" value="365">
            <div class="col-md-6">
                <label class="form-label">Full name</label>
                <input type="text" class="form-control" id="fullName" name="fullName" value="${customer.id}">
            </div>
            <div class="col-md-6">
                <label class="form-label">Email</label>
                <input type="email" class="form-control" id="email" name="email" value="${customer.email}">
            </div>
            <div class="col-md-6">
                <label class="form-label">Phone</label>
                <input type="tel" class="form-control" id="phone" name="phone" value="${customer.phone}">
            </div>
            <div class="col-md-6">
                <label class="form-label">Address</label>
                <input type="text" class="form-control" id="address" name="address" value="${customer.address}">
            </div>


            <div class="col-md-12">
                <button type="submit" id="btnSuspendedCustomer" class="btn btn-outline-danger">
                    <i class="fas fa-trash-alt"></i>
                    Suspended
                </button>
            </div>

        </fieldset>
    </form>
</div>
<div class="footer">
    <div id="message-alert">

    </div>
</div>

<%@include file="/layout/script.jsp"%>

</body>
</html>
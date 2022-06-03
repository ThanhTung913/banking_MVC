<%--
  Created by IntelliJ IDEA.
  User: prom1
  Date: 01/06/2022
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Deposit</title>

  <%@include file="/layout/head.jsp"%>


</head>
<body>
<div class="container">
  <div class="table-title mb-4">
    <div class="row">
      <div class="col-sm-8">
        <h2>Deposit money into customer's account</h2>
      </div>
      <div class="col-sm-4">
        <a href="/customers" class="btn btn-outline-light"><i class="fa fa-list" aria-hidden="true"></i> <span>Customer list</span></a>
      </div>
    </div>
  </div>

  <form id="frmDeposit" method="post" >
    <fieldset class="row g-3">
      <div class="mb-3 col-md-6">
        <div class="form-group row">
          <label class="col-sm-12 col-form-label">Customer ID</label>
          <div class="col-sm-12">
            <input type="text" class="form-control" readonly id="id" name="id" value="${customer.getId()}" />
          </div>
        </div>
      </div>
      <div class="mb-3 col-md-6">
        <div class="form-group row">
          <label class="col-sm-12 col-form-label">Full Name</label>
          <div class="col-sm-12">
            <input type="text" class="form-control" readonly id="fullName" name="fullName" value="${customer.getName()}" />
          </div>
        </div>
      </div>
      <div class="mb-3 col-md-6">
        <div class="form-group row">
          <label class="col-sm-12 col-form-label">Current balance ($)</label>
          <div class="col-sm-12">
            <input type="text" class="form-control num-space" readonly id="balance" name="balance" value="${customer.getBalance()}" />
          </div>
        </div>
      </div>
      <div class="mb-3 col-md-6">
        <div class="form-group row">
          <label class="col-sm-12 col-form-label">Transaction Amount ($)</label>
          <div class="col-sm-12">
            <input type="text" class="form-control" id="transactionAmount" name="transactionAmount" value="" />
            <!--                            <p th:if="${fields.hasErrors('transactionAmount')}" th:errorclass="th-error" th:errors="*{transactionAmount}">Name Error</p>-->
          </div>
        </div>
      </div>

      <div class="mb-3 col-md-12">
        <div class="form-group row">
          <div class="col-sm-4">
            <button type="submit" class="btn btn-outline-success">
              <i class="far fa-plus-square"></i>
              Deposit
            </button>
          </div>
        </div>
      </div>

</fieldset>
</form>
</div>
<%--<div class="footer">--%>
<%--  <div id="message-alert">--%>


<%--    <div class="alert-danger hide">--%>
<%--      <h5>Please correct errors below:</h5>--%>
<%--    </div>--%>

<%--  </div>--%>
<%--</div>--%>
<%@include file="/layout/script.jsp"%>
</body>
</html>
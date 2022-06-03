<%--
  Created by IntelliJ IDEA.
  User: prom1
  Date: 01/06/2022
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Withdraw</title>

  <%@include file="/layout/head.jsp"%>

</head>
<body>
<div class="container">
  <div class="table-title mb-4">
    <div class="row">
      <div class="col-sm-8">
        <h2>Withdraw money from the customer's account</h2>
      </div>
      <div class="col-sm-4">
        <a href="/customers" class="btn btn-outline-light"><i class="fa fa-list" aria-hidden="true"></i> <span>Customer list</span></a>
      </div>
    </div>
  </div>
  <form id="frmWithdraw" method="post" >
    <fieldset class="row g-3">
      <div class="mb-3 col-md-6">
        <div class="form-group row">
          <label class="col-sm-12 col-form-label">Customer ID</label>
          <div class="col-sm-12">
            <input type="text" class="form-control" readonly id="customerId" name="customerId" value="${customer.id}" />
          </div>
        </div>
      </div>
      <div class="mb-3 col-md-6">
        <div class="form-group row">
          <label class="col-sm-12 col-form-label">Full Name</label>
          <div class="col-sm-12">
            <input type="text" class="form-control" readonly id="full_name" name="full_name" value="${customer.name}" />
          </div>
        </div>
      </div>
      <div class="mb-3 col-md-6">
        <div class="form-group row">
          <label class="col-sm-12 col-form-label">Current balance ($)</label>
          <div class="col-sm-12">
            <input type="text" class="form-control num-space" readonly id="balance" name="balance" value="${customer.balance}" />
          </div>
        </div>
      </div>
      <div class="mb-3 col-md-6">
        <div class="form-group row">
          <label class="col-sm-12 col-form-label">Transaction Amount ($)</label>
          <div class="col-sm-12">
            <input type="text" class="form-control num-space" maxlength="14" id="transactionAmount" name="transactionAmount" value="" />
          </div>
        </div>
      </div>

      <div class="mb-3 col-md-12">
        <div class="form-group row">
          <div class="col-sm-4">
            <button type="submit" class="btn btn-outline-warning">
              <i class="fas fa-minus-square"></i>
              Withdraw
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
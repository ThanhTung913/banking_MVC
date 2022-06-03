<%--
  Created by IntelliJ IDEA.
  User: prom1
  Date: 01/06/2022
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <%@include file="/layout/head.jsp"%>

  <title>Update customer</title>

</head>
<body>
<div class="container">
  <div class="table-title mb-4">
    <div class="row">
      <div class="col-sm-6">
        <h1>Update customer information</h1>
      </div>
      <div class="col-sm-6">
        <a href="/customers" class="btn btn-outline-light"><i class="fa fa-list" aria-hidden="true"></i> <span>Customer list</span></a>
      </div>
    </div>
  </div>
  <form id="frmUpdateCustomer" method="post" action="/customers?action=edit">
    <fieldset class="row g-3">
      <input type="hidden" name="id" value="${id}">
      <!--                <input th:type="hidden" th:field="*{id}">-->
      <div class="col-md-6">
        <label class="form-label">Full name</label>
        <input type="text" class="form-control" id="full_name" name="full_name" value="${nameCustomer}">
      </div>
      <div class="col-md-6">
        <label class="form-label">Email</label>
        <input type="email" class="form-control" id="email" name="email" value="${emailCustomer}">
      </div>
      <div class="col-md-6">
        <label class="form-label">Phone</label>
        <input type="tel" class="form-control" id="phone" name="phone" value="${phoneCustomer}">
      </div>
      <div class="col-md-6">
        <label class="form-label">Address</label>
        <input type="text" class="form-control" id="address" name="address" value="${addressCustomer}">
      </div>
      <div class="col-md-12">
        <button type="submit" id="btnUpdateCustomer" class="btn btn-outline-secondary">
          <i class="fas fa-pencil-alt"></i>
          Save changes
        </button>
      </div>
    </fieldset>
  </form>
</div>
<%--<div class="alert-success hide">--%>
<%--  <h5>Please correct errors below: "${message}"</h5>--%>
<%--</div>--%>
<%--<div class="footer">--%>
<%--  <div id="message-alert">--%>

<%--    <div class="alert-danger hide">--%>
<%--      <h5>Please correct errors below:</h5>--%>
<%--    </div>--%>

<%--  </div>--%>
</div>


<%@include file="/layout/script.jsp"%>


</body>
</html>

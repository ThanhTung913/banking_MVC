<%--
  Created by IntelliJ IDEA.
  User: prom1
  Date: 01/06/2022
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <%@include file="/layout/head.jsp" %>
  <title>Create</title>
</head>
<body>
<div class="container">
  <div class="table-title">
    <div class="row">
      <div class="col-sm-5">
        <h1>Create customer</h1>
      </div>
      <div class="col-sm-7">
        <a href="/customers" class="btn btn-outline-light">
          <i class="fa-solid fa-bars"></i>
          <span>List of customers</span>
        </a>
      </div>
    </div>
  </div>
  <div>
    <form>
      <div class="row mt-3">
        <div class="col-md-6 mb-3">
          <label for="fullName" class="form-label">Full Name</label>
          <input type="text" class="form-control" id="fullName">
        </div>
        <div class="col-md-6 mb-3">
          <label for="email" class="form-label">Email</label>
          <input type="email" class="form-control" id="email">
        </div>
      </div>
      <div class="row">
        <div class="col-md-6 mb-3">
          <label for="password" class="form-label">Password</label>
          <input type="password" class="form-control" id="password">
        </div>
        <div class="col-md-6 mb-3">
          <label for="address" class="form-label">Address</label>
          <input type="text" class="form-control" id="address">
        </div>
      </div>

      <button type="submit" class="btn btn-outline-primary">
        <i class="fas fa-plus-square"></i>
        Create
      </button>
    </form>
  </div>
</div>
<%@include file="/layout/script.jsp" %>
</body>
</html>

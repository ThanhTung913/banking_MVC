<%--
  Created by IntelliJ IDEA.
  User: prom1
  Date: 01/06/2022
  Time: 14:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <%@include file="/layout/head.jsp"%>
  <title>Transfer money Information</title>

</head>
<body>
<div class="container">
  <div class="table-title">
    <div class="row">
      <div class="col-sm-6">
        <h1>Transfer money Information</h1>
      </div>
      <div class="col-sm-6">
        <a href="/customers" class="btn btn-outline-light">
          <i class="fa fa-list" aria-hidden="true"></i>
          <span>Customer list</span>
        </a>
      </div>
    </div>
  </div>
  <table class="table table-hover">
    <thead>
    <tr>
      <th class="text-center">#</th>
      <th class="text-center">Sender ID</th>
      <th class="text-center">Sender Name</th>
      <th class="text-center">Recipient ID</th>
      <th class="text-center">Recipient Name</th>
      <th class="text-center">Transfer Amount ($)</th>
      <th class="text-center">Fees (%)</th>
      <th class="text-center">Fees Amount ($)</th>
    </tr>
    </thead>
    <tbody>

    <tr>
      <td class="text-center">1</td>
      <td class="text-center">35</td>
      <td>Tatiana Kim</td>
      <td class="text-center">5</td>
      <td>Cody Avila</td>
      <td class="text-end num-comma pr-20">5000000</td>
      <td class="text-center">10</td>
      <td class="text-end num-comma pr-20">500000</td>
    </tr>

    <tr>
      <td class="text-center">2</td>
      <td class="text-center">35</td>
      <td>Tatiana Kim</td>
      <td class="text-center">5</td>
      <td>Cody Avila</td>
      <td class="text-end num-comma pr-20">5000000</td>
      <td class="text-center">10</td>
      <td class="text-end num-comma pr-20">500000</td>
    </tr>

    <tr>
      <td class="text-center">3</td>
      <td class="text-center">15</td>
      <td>Orlando Miranda</td>
      <td class="text-center">25</td>
      <td>Marshall Page</td>
      <td class="text-end num-comma pr-20">5000</td>
      <td class="text-center">10</td>
      <td class="text-end num-comma pr-20">500</td>
    </tr>

    <tr>
      <td class="text-center">4</td>
      <td class="text-center">5</td>
      <td>Cody Avila</td>
      <td class="text-center">15</td>
      <td>Orlando Miranda</td>
      <td class="text-end num-comma pr-20">5000000</td>
      <td class="text-center">10</td>
      <td class="text-end num-comma pr-20">500000</td>
    </tr>

    <tr>
      <td class="text-center">5</td>
      <td class="text-center">45</td>
      <td>Trần Ngọc Hữu</td>
      <td class="text-center">35</td>
      <td>Tatiana Kim</td>
      <td class="text-end num-comma pr-20">1000</td>
      <td class="text-center">10</td>
      <td class="text-end num-comma pr-20">100</td>
    </tr>

    <tr>
      <td class="text-center">6</td>
      <td class="text-center">5</td>
      <td>Cody Avila</td>
      <td class="text-center">15</td>
      <td>Orlando Miranda</td>
      <td class="text-end num-comma pr-20">5000</td>
      <td class="text-center">10</td>
      <td class="text-end num-comma pr-20">500</td>
    </tr>

    <tr>
      <td class="text-center">7</td>
      <td class="text-center">25</td>
      <td>Marshall Page</td>
      <td class="text-center">35</td>
      <td>Tatiana Kim</td>
      <td class="text-end num-comma pr-20">1000</td>
      <td class="text-center">10</td>
      <td class="text-end num-comma pr-20">100</td>
    </tr>

    <tr>
      <td class="text-center">8</td>
      <td class="text-center">25</td>
      <td>Marshall Page</td>
      <td class="text-center">85</td>
      <td>Rudyard Sargent</td>
      <td class="text-end num-comma pr-20">1000</td>
      <td class="text-center">10</td>
      <td class="text-end num-comma pr-20">100</td>
    </tr>

    <tr>
      <td class="text-center">9</td>
      <td class="text-center">175</td>
      <td>Cadman Dele</td>
      <td class="text-center">185</td>
      <td>Camden Yates</td>
      <td class="text-end num-comma pr-20">1000</td>
      <td class="text-center">10</td>
      <td class="text-end num-comma pr-20">100</td>
    </tr>

    <tr>
      <td class="text-center">10</td>
      <td class="text-center">255</td>
      <td>ho</td>
      <td class="text-center">315</td>
      <td>Giacomo Grant</td>
      <td class="text-end num-comma pr-20">50</td>
      <td class="text-center">10</td>
      <td class="text-end num-comma pr-20">5</td>
    </tr>

    <tr>
      <td class="text-center">11</td>
      <td class="text-center">255</td>
      <td>ho</td>
      <td class="text-center">295</td>
      <td>Joan Goodman</td>
      <td class="text-end num-comma pr-20">900</td>
      <td class="text-center">10</td>
      <td class="text-end num-comma pr-20">90</td>
    </tr>

    <tr>
      <td class="text-center">12</td>
      <td class="text-center">245</td>
      <td>Hammett Morrow</td>
      <td class="text-center">235</td>
      <td>Velma Vazquez</td>
      <td class="text-end num-comma pr-20">100</td>
      <td class="text-center">10</td>
      <td class="text-end num-comma pr-20">10</td>
    </tr>

    </tbody>
    <tfoot>
    <tr>
      <td colspan="5"></td>
      <td class="text-center fw-bold">Total Fees Amount:</td>
      <td colspan="2" class="text-end fw-bold num-comma pr-20" style="font-size: 24px">1501505</td>
    </tr>
    </tfoot>
  </table>
</div>


<%@include file="/layout/script.jsp"%>


</body>
</html>

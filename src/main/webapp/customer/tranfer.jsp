<%--
  Created by IntelliJ IDEA.
  User: prom1
  Date: 01/06/2022
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Transfer</title>

    <%@include file="/layout/head.jsp"%>

</head>
<body>
<div class="container">
    <div class="table-title mb-4">
        <div class="row">
            <div class="col-sm-6">
                <h1>Transfer money Information</h1>
            </div>
            <div class="col-sm-6">
                <a href="/customers" class="btn btn-outline-light"><i class="fa fa-list" aria-hidden="true"></i> <span>Customer list</span></a>
            </div>
        </div>
    </div>
    <form id="frmTransfer" method="post">
        <fieldset class="row g-3">
            <div class="form-group row">
                <div class="mb-3 col-md-3">
                    <label class="col-sm-12 col-form-label">Sender ID</label>
                    <div class="col-sm-12">
                        <input type="text" class="form-control" readonly id="senderId" name="senderId" value="365">
                    </div>
                </div>
                <div class="mb-3 col-md-3">
                    <label class="col-sm-12 col-form-label">Sender Name</label>
                    <div class="col-sm-12">
                        <input type="text" class="form-control" readonly id="senderName" name="senderName" value="Ariel Jones">
                    </div>
                </div>
                <div class="mb-3 col-md-3">
                    <label class="col-sm-12 col-form-label">Email</label>
                    <div class="col-sm-12">
                        <input type="email" class="form-control" readonly id="email" name="email" value="sitamygad@mailinator.com">
                    </div>
                </div>
                <div class="mb-3 col-md-3">
                    <label class="col-sm-12 col-form-label">Sender balance</label>
                    <div class="col-sm-12">
                        <input type="text" class="form-control num-space" readonly id="balance" name="balance" value="2950000">
                    </div>
                </div>
            </div>
            <div class="form-group row mb-4">
                <div class="mb-3 col-md-3">
                    <label for="recipient_id" class="col-sm-12 col-form-label">Recipient Name</label>
                    <div class="col-sm-12">
                        <select id="recipient_id" class="form-select" name="recipientId">
                            <option value="385">(385) Sierra Abbott</option>
                            <option value="395">(395) Brian Frazier</option>
                            <option value="405">(405) Emmanuel Owen</option>
                            <option value="415">(415) Lionel Malone</option>
                            <option value="435">(435) Valentine Luna</option>
                            <option value="445">(445) Barrack Obama</option>
                            <option value="455">(455) Kiara Jacobs</option>
                            <option value="465">(465) Violet Goodwin</option>
                            <option value="475">(475) Iola Lyons</option>
                            <option value="485">(485) Alan Buckner</option>
                            <option value="495">(495) Blaine Maldonado</option>
                            <option value="505">(505) Prescott Randall</option>
                            <option value="545">(545) Savannah Nicholson</option>
                            <option value="555">(555) Lillith Banks</option>
                            <option value="565">(565) Superman</option>
                            <option value="575">(575) Superman</option>
                            <option value="585">(585) Superman</option>
                        </select>
                    </div>
                </div>
                <div class="mb-3 col-md-3">
                    <label class="col-sm-12 col-form-label">Transfer Amount ($)</label>
                    <div class="col-sm-12">
                        <input type="text" id="transferAmount" class="form-control num-space" name="transferAmount" value="">
                    </div>
                </div>
                <div class="mb-3 col-md-3">
                    <label class="col-sm-12 col-form-label">Fees (%)</label>
                    <div class="col-sm-12">
                        <input type="text" class="form-control num-space" value="10" readonly>
                    </div>
                </div>
                <div class="mb-3 col-md-3">
                    <label class="col-sm-12 col-form-label">Total amount of transaction ($)</label>
                    <div class="col-sm-12">
                        <input type="text" class="form-control num-space" readonly id="transactionAmount" name="transactionAmount" value="">
                    </div>
                </div>
            </div>
            <div class="form-group row">
                <div class="mb-3 col-md-12">
                    <div class="col-sm-4">
                        <button type="submit" class="btn btn-outline-primary">
                            <i class="fas fa-exchange-alt"></i>
                            Transfer
                        </button>
                    </div>
                </div>
            </div>
        </fieldset>
    </form>
</div>


<%@include file="/layout/script.jsp"%>


<%--<div class="footer">--%>
<%--    <div id="message-alert">--%>


<%--        <div class="alert-danger hide">--%>
<%--            <h5>Please correct errors below FE:</h5>--%>
<%--        </div>--%>

<%--    </div>--%>
<%--</div>--%>



<script>
    $(function() {
        $("#transferAmount").on("change", function () {
            let transferAmount = $(this).val();
            let fees = 10;
            let feeAmount = transferAmount * fees / 100;
            let transactionAmount = parseInt(transferAmount) + feeAmount;
            $("#transactionAmount").val(transactionAmount);
        });
    });
</script>

</body>
</html>
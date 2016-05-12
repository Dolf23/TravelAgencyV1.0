<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="top.jsp" %>

<form class="form-horizontal" action="login.jsp" method="get">
    <fieldset>

        <!-- Form Name -->
        <legend>Завершение сеанса</legend>


        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="singlebutton"></label>
            <div class="col-md-4">
                <button id="singlebutton" name="singlebutton" class="btn btn-success">Login</button>
            </div>
        </div>

    </fieldset>
</form>

<%@ include file="bottom.jsp" %>
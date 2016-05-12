<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="top.jsp" %>

<form class="form-horizontal">
    <fieldset>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="Login">Login</label>
            <div class="col-md-4">
                <input id="Login" name="Login" type="text" placeholder="" class="form-control input-md">
                <span class="help-block">Enter login</span>
            </div>
        </div>

        <!-- Password input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="passwordinput">Password</label>
            <div class="col-md-4">
                <input id="passwordinput" name="passwordinput" type="password" placeholder="" class="form-control input-md">
                <span class="help-block">Enter password</span>
            </div>
        </div>

        <!-- Button (Double) -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="buttonLogin"></label>
            <div class="col-md-8">
                <button id="buttonLogin" name="buttonLogin" class="btn btn-success">Login</button>
                <button id="buttonRegistry" name="buttonRegistry" class="btn btn-primary">Registry</button>
            </div>
        </div>

    </fieldset>
</form>

<%@ include file="bottom.jsp" %>

<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="top.jsp" %>

<form class="form-horizontal" action="createtour" method="post">
    <fieldset>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="TypeTour">Type tour</label>
            <div class="col-md-4">
                <input id="TypeTour" name="TypeTour" type="text" placeholder="" class="form-control input-md">
                <span class="help-block">Enter type tour</span>
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="Country">Country</label>
            <div class="col-md-4">
                <input id="Country" name="Country" type="text" placeholder="" class="form-control input-md">
                <span class="help-block">Enter country</span>
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="Transport">Transport</label>
            <div class="col-md-4">
                <input id="Transport" name="Transport" type="text" placeholder="" class="form-control input-md">
                <span class="help-block">Enter transport</span>
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="Hotel">Hotel</label>
            <div class="col-md-4">
                <input id="Hotel" name="Hotel" type="text" placeholder="" class="form-control input-md">
                <span class="help-block">Enter hotel</span>
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="FoodComplex">Food complex</label>
            <div class="col-md-4">
                <input id="FoodComplex" name="FoodComplex" type="text" placeholder="" class="form-control input-md">
                <span class="help-block">Enter food complex</span>
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="Cost">Cost</label>
            <div class="col-md-4">
                <input id="Cost" name="Cost" type="text" placeholder="" class="form-control input-md">
                <span class="help-block">Enter cost</span>
            </div>
        </div>

        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="singlebuttonCreateTour"></label>
            <div class="col-md-4">
                <button id="singlebuttonCreateTour" name="singlebuttonCreateTour" class="btn btn-success">Create</button>
            </div>
        </div>

    </fieldset>
</form>

<%@ include file="bottom.jsp" %>
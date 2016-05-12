<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="top.jsp" %>

<form class="form-horizontal" action="select" method="post">
    <fieldset>

        <!-- Select Basic -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="selectbasicTypeTour">Type tour</label>
            <div class="col-md-4">
                <select id="selectbasicTypeTour" name="selectbasicTypeTour" class="form-control">
                    <c:forEach  var="TypeTour"  items="${typeTourList}">
                        <option value="${TypeTour.id}">${TypeTour.typeTour}</option>
                    </c:forEach>
                </select>
            </div>
        </div>

        <!-- Select Basic -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="selectbasicCountry">Country</label>
            <div class="col-md-4">
                <select id="selectbasicCountry" name="selectbasicCountry" class="form-control">
                    <c:forEach  var="Country" items="${countryList}">
                        <option value="${Countries.id}">${Countries.country}</option>
                    </c:forEach>
                </select>
            </div>
        </div>

        <!-- Select Basic -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="selectbasicTransport">Transport</label>
            <div class="col-md-4">
                <select id="selectbasicTransport" name="selectbasicTransport" class="form-control">
                    <c:forEach var="Transport" items="${transportList}">
                        <option value="${Transport.id}">${Transport.transport}</option>
                    </c:forEach>
                </select>
            </div>
        </div>

        <!-- Select Basic -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="selectbasicHotel">Hotel</label>
            <div class="col-md-4">
                <select id="selectbasicHotel" name="selectbasicHotel" class="form-control">
                    <c:forEach var="Hotel" items="${hotelList}">
                        <option value="${Hotel.id}">${Hotel.typeHotel}</option>
                    </c:forEach>
                </select>
            </div>
        </div>

        <!-- Select Basic -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="selectbasicFoodComplex">Food complex</label>
            <div class="col-md-4">
                <select id="selectbasicFoodComplex" name="selectbasicFoodComplex" class="form-control">
                    <c:forEach var="FoodComplex" items="${foodComplexList}">
                        <option value="${FoodComplex.id}">${FoodComplex.foodComplex}</option>
                    </c:forEach>
                </select>
            </div>
        </div>

        <!-- Button (Double) -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="buttonSelect"></label>
            <div class="col-md-8">
                <button id="buttonSelect" name="buttonSelect" class="btn btn-info">Select tour</button>
            </div>
        </div>

    </fieldset>
</form>

<%@ include file="bottom.jsp" %>
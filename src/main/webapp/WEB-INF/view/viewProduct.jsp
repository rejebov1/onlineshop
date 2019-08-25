<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--<script>
    $(document).ready(function() {
        $(document).on("click", ".addToBucket",
            function(){
                $.post("${pageContext.request.contextPath}/bucket/ajax/add/"+$(this).attr("productId"), {productCount: 1}, function(data){
                    $("#bucket_counter").html(data);
                    alert("Товар добавлен");
                });
            });
    });
</script>--%>
<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Product Detail</h1>

            <p class="lead">Here is the detail information of the product</p>
        </div>

        <!-- Grid system from Bootstrap -->
        <div class="container" ng-app="cartApp">
            <div class="row">
                <%--<div class="col-md-5">
                    <img
                            src="<c:url value="/resources/images/${product.productId}.png" /> "
                            alt="image" style="width: 100%" />
                </div>--%>
                <div class="col-md-5">
                    <h3>${product.name}</h3>
                    <p>${product.productCharacteristic}</p>
                    <p>
                        <strong>Brand name</strong> : ${product.brand.name}
                    </p>
                    <p>
                        <strong>Country produced</strong> : ${product.brand.country}
                    </p>
                    <p>
                        <strong>Date of issue</strong> : ${product.dateOfIssue}
                    </p>
                    <p>${product.price}USD</p>

                    <br>

                    <c:set var="role" scope="page" value="${param.role}" />
                    <c:set var="url" scope="page" value="/productList" />
                    <!-- if the user is admin we change the back page for the following "back" button -->
                    <c:if test="${role='admin'}">
                        <c:set var="url" scope="page" value="/admin/productInventory" />
                    </c:if>

                    <p ng-controller="cartCtrl">
                        <a href="<c:url value="${url}" />" class="btn btn-default">Back</a>
                        <!-- we use the angular funtction (#)  -->
                        <a href="/order/${product.id}" class="btn btn-warning btn-large"
                           ng-click="addToCart('${product.id}')">
                            <span class="glyphicon glyphicon-shopping-cart"></span>Order Now</a>
                       <%-- <form action="${pageContext.request.contextPath}/addToCart/${product.id}" method="post">
                        <button class="btn btn-primary addToBucket" productId="${product.id}">Add to cart</button>--%>
                </form>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="<c:url value="/resources/js/controller.js" /> "></script>

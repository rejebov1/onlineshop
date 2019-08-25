<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<script>
    $(document).ready(
        function() {
            var searchCondition = '${searchCondition}';
            $('.table').DataTable(
                {
                    "lengthMenu" : [ [ 1, 2, 3, 5, 10, -1 ],
                        [ 1, 2, 3, 5, 10, "All" ] ],
                    "oSearch" : {
                        "sSearch" : searchCondition
                    }
                });
        });
</script>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>All Products</h1>

            <p class="lead">Checkout all the awesome products available now</p>
        </div>

        <table class="table table-striped table-hover">
            <thead>
            <tr class="bg-success">
                <th>Product name</th>
                <th>Date of issue</th>
                <th>Description</th>
                <th>Price</th>
                <th>Brand name</th>
                <th>Brand country</th>
                <th></th>

            </tr>
            </thead>
            <!-- Loop for all the products -->
            <c:forEach items="${products}" var="product">
                <tr>
                        <%--<td><img
                                src="<c:url value="/resources/images/${product.id}.png" /> "
                                alt="image" style="width: 100%" /></td>--%>
                    <td>${product.name}</td>
                    <td>${product.dateOfIssue}</td>
                    <td>${product.productCharacteristic}</td>
                    <td>${product.price}USD</td>
                    <td>${product.brand.name}</td>
                    <td>${product.brand.country}</td>
                    <!-- http://getbootstrap.com/components/ -->
                    <td><a
                            href="<spring:url value="/viewProduct/${product.id}" />">
                        <span class="glyphicon glyphicon-info-sign">View Product</span>
                    </a></td>

                </tr>
            </c:forEach>
        </table>
    </div>
</div>


<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security"
           uri="http://www.springframework.org/security/tags" %>
<%@ include file="header.jsp" %>
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
<div class="row">
    <div class="col-sm-4">
        <div class="thumbnail">
            <div class="caption">
                <h3>
                    <c:out value="${product.name}"/>
                </h3>
                <p>
                    Описание: <c:out value="${product.productCharacteristic}"/>
                </p>
                <p>
                    Цена: <c:out value="${product.price}"/>
                </p>
                <p>
                    <security:authorize access="hasRole('USER')">
                        <form action="/bucket/ajax/add/${product.id}" method="post">
                        <button class="btn btn-primary addToBucket" productId="${product.id}">В корзину</button>
            </form>
                    </security:authorize>
                </p>
            </div>
        </div>
    </div>
</div>

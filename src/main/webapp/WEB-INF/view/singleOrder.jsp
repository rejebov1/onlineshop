<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">

            <h3 class="text-primary">
                Заказ номер: <c:out value="${order.id}"/>
            </h3>

            <p>Состояние заказа: <c:out value="${order.status.toString()}"/></p>

            <div class="well">
                <div class="row">
                    <div class="col-md-12">
                        <table class="table">
                            <thead>
                            <tr>
                                <th>#</th>
                                <th>Наименование</th>
                                <th>Количество</th>
                                <th>Стоимость</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:set var="iter" value="1"/>
                            <c:forEach var="entry" items="${order.products.entrySet()}">
                                <tr>
                                    <th scope="row"><c:out value="${iter}"/></th>
                                    <td><c:out value="${entry.getKey().getName()}"/></td>
                                    <td><c:out value="${entry.getValue()}"/></td>
                                    <td><c:out value="${entry.getKey().getPrice()}"/></td>
                                </tr>
                                <c:set var="iter" value="${iter+1}"/>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>

                <p>Итого: ${totalPrice}</p>

                <div class="row">
                    <div class="col-md-10">
                    </div>
                    <div class="col-md-2">
                        <c:if test="${order.possibleToEdit}">
                            <a href="${pageContext.request.contextPath}/orders/${order.id}/return" class="btn btn-default" type="button">Вернуть в корзину</a>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sping" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<sping:url var="resources" value="/resources" />
<sping:url var="js" value="/js" />
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Checkout | E-Shopper</title>
    <link href="${resources}/bootstrap.min.css" rel="stylesheet">
    <link href="${resources}/font-awesome.min.css" rel="stylesheet">
    <link href="${resources}/prettyPhoto.css" rel="stylesheet">
    <link href="${resources}/price-range.css" rel="stylesheet">
    <link href="${resources}/animate.css" rel="stylesheet">
    <link href="${resources}/main.css" rel="stylesheet">
    <link href="${resources}/responsive.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="${js}/html5shiv.js"></script>
    <script src="${js}/respond.min.js"></script>
    <![endif]-->
        <style >
        .error {
            color: #ff0000;
            font-style: italic;
        }
    </style>
</head><!--/head-->

<body>
<!--header phase-->
<jsp:include page="header.jsp"></jsp:include>
<section id="cart_items" style="margin-bottom: 20px;">
        <div class="table-responsive cart_info">
            <table class="table table-condensed">
                <thead>
                <tr class="cart_menu">
                    <td class="description">Description</td>
                    <td class="price">Price</td>
                    <td class="quantity">Quantity</td>
                    <td class="total">Total</td>
                    <td></td>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td class="cart_description">
                        <h4><a href="">${product.name}</a></h4>
                        <p>Web ID: ${product.id}</p>
                    </td>
                    <td class="cart_price">
                        <p>$${product.price}</p>
                    </td>
                    <td class="cart_quantity">
                        <div class="cart_quantity_button">
                            <a class="cart_quantity_up" href=""> + </a>
                            <input class="cart_quantity_input" type="text" name="quantity" value="1" autocomplete="off" size="2">
                            <a class="cart_quantity_down" href=""> - </a>
                        </div>
                    </td>
                    <td class="cart_total">
                        <p class="cart_total_price">$${product.price}</p>
                    </td>
                    <td class="cart_delete">
                        <a class="cart_quantity_delete" href=""><i class="fa fa-times"></i></a>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
</section> <!--/#cart_items-->

<!--Footer phase-->

<script src="${js}/jquery.js"></script>
<script src="${js}/bootstrap.min.js"></script>
<script src="${js}/jquery.scrollUp.min.js"></script>
<script src="${js}/jquery.prettyPhoto.js"></script>
<script src="${js}/main.js"></script>
<!-- <script type="text/javascript">
    $('button[name="refreshCart"]').click(function(){
        // fetch the cart line id
        var cartLineId = $(this).attr('value');
        var countElement = $('#count_' + cartLineId);

        var originalCount = countElement.attr('value');
        var currentCount = countElement.val();

        // work only when the count has changed
        if(currentCount !== originalCount) {
            if(currentCount < 1 || currentCount > 3) {
                // reverting back to the original count
                // user has given value below 1 and above 3
                countElement.val(originalCount);
                bootbox.alert({
                    size: 'medium',
                    title: 'Error',
                    message: 'Product count should be minium 1 and maximum 3!'
                });
            } else {
                var updateUrl= window.contextRoot + '/cart/' + cartLineId + '/update?count=' + currentCount;
                // forward it to the controller
                window.location.href = updateUrl;
            }
        }
    });
</script> -->
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>

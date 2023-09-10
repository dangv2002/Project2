<%-- 
    Document   : Panner
    Created on : Aug 15, 2023, 11:43:59 AM
    Author     : dangv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">


            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">

                    <li class="nav-item active">
                        <a class="nav-link" href="HomeUser">Home </a>
                    </li>

                    <li class="nav-item active">
                        <a class="nav-link" href="HomeUser?service=login">Login</a>
                    </li>


                    <c:if test="${sessionScope.customer!=null}">
                        <li class="nav-item active">
                            <a class="nav-link" href="HomeUser?service=logout"">Logout</a
                        </li>
                    </c:if>

                    <li class="nav-item">
                        <a class="nav-link active" href="HomeUser?service=register">Register</a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link active" href="CartManager?service=show">Show Cart</a>

                    </li>

                    <c:if test="${sessionScope.customer!=null}">
                         <li class="nav-item">
                            <a class="nav-link active" > Full Name: ${customer.first_name} ${customer.last_name} </a>
                        </li>

                        <li class="nav-item">
                            <a class="nav-link active" > WelCome: ${customer.email}  </a>
                        </li>
                    </c:if>
                </ul>
            </div>
        </nav>

    </body>
</html>

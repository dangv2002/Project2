<%-- 
    Document   : homeAdmin
    Created on : Aug 8, 2023, 11:19:51 AM
    Author     : dangv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">        <title>JSP Page</title>

    </head>
    <body>
        <%@include file="headerAdmin.jsp" %>
        <div class="container">

            <div class="row"> 
              
                 
                        <div class="col-5">  
                            <a href="StoreManager">  Store Manager </a> </br>
                            <a href="StaffManager">  Staff manager</a> </br>
                            <a href="CustomerManager"> Customer manager </a> </br>
                            <a href="ProductManager"> Product manager</a> </br>
                            <a href="BillManager">  Bill manager</a> </br>
                        
                        </div>

                        <div class="col-7">
                            Home-ADMIN
                        </div>

                </body>
                </html>

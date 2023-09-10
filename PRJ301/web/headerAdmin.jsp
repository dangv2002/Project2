<%-- 
    Document   : headerAdmin
    Created on : Aug 10, 2023, 11:08:36 PM
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
                        <a class="nav-link" href="AdminHome">Home </a>
                    </li>
                   
                        <li class="nav-item active">
                            <a class="nav-link" href="AdminHome?service=logout"">Logout</a
                        </li>
                        
                         <c:if test="${sessionScope.staff!=null}">
                         <li class="nav-item">
                            <a class="nav-link active" > Full Name: ${staff.first_name} ${customer.last_name} </a>
                        </li>

                        <li class="nav-item">
                            <a class="nav-link active" > WelCome: ${staff.email}  </a>
                        </li>
                    </c:if>

                </ul>
             
            </div>
           </br><!-- comment -->
               </br>
        </nav>
    </body>
</html>

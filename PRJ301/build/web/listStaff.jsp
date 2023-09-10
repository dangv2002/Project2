<%-- 
    Document   : listStaff
    Created on : Aug 9, 2023, 9:13:06 AM
    Author     : dangv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">        <title>JSP Page</title>

        <title>Staff</title>
    </head>
    <body>
        <%@include file="headerAdmin.jsp" %>
        <h1 style="text-align: center"> Staff manager </h1>

        <div class="container">  

            <div class="row"> 
                <div class="col-3">  
                       <a href="StoreManager">  Store Manager </a> </br>
                    <a href="StaffManager">  Staff manager</a> </br>
                    <a href="CustomerManager"> Customer manager </a> </br>
                    <a href="ProductManager"> Product manager</a> </br>
                    <a href="BillManager">  Bill manager</a> </br>
                </div>
                <div class="col-9">  

                   
                    
                <div class="col-9">
                    <form action="StaffManager" method="POST">
                        <input type="hidden" name="service" value="addStaff"> 
                        <input type="submit"  value="ADD"/> 
                    </form>
                    
                    <div>
                        <form action="StaffManager" method="post">
                            <input type="hidden" name="service" value="searchStaff"> 
                            <div class="d-flex justify-content-end">

                                <input type="text" class="form-control rounded" name="inputName" placeholder="Search by name" aria-label="Search" aria-describedby="search-addon" />
                                <div class="input-group-append">
                                    <button type="submit" class="btn btn-outline-primary">Search</button>
                                </div>

                            </div>

                        </form>
                    </div>
                    </br>
                    <h5 style="color: red"> ${error}</h5>  
                    <table border="1">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>First_Name</th>
                                <th>Last_Name</th>
                                <th>Email</th>
                                <th>Phone</th>
                                <th>Active</th>
                                <th>Store_id</th>
                                <th>Manager_id</th>
                                <th>Action</th>

                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="staff" items="${listStaff}">

                                <tr>
                                    <td>${staff.staff_id}</td>
                                    <td>${staff.first_name}</td>
                                    <td>${staff.last_name}</td>
                                    <td>${staff.email}</td>
                                    <td>${staff.phone}</td>
                                    <td>${staff.active}</td>
                                    <td>${staff.store_id}</td>
                                    <td>${staff.manager_id}</td>
                                    <th>                                            </br>
                                        </br>
                                        <form action="StaffManager" method="post"> 
                                            <input type="hidden" name="service" value="delete"> 
                                            <input type="hidden"  name="staffID" value="${staff.staff_id}" />
                                            <input type="submit" value="Delete" />
                                        </form>
                                        </br>
                                        <form action="StaffManager" method="post"> 
                                            <input type="hidden" name="service" value="getStaff"> 
                                            <input type="hidden"  name="staffID" value="${staff.staff_id}" />
                                            <input type="submit" value="Update" />
                                        </form> 
                                        </br>

                                    </th>

                                </tr>
                            </c:forEach>

                        </tbody>
                    </table>


                </div>

            </div>
        </div>


    </body>
</html>

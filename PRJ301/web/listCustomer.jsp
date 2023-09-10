<%-- 
    Document   : listCustomer
    Created on : Aug 9, 2023, 9:12:55 AM
    Author     : dangv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <title>Custommer Manager</title>
    </head>
    <body>
        <%@include file="headerAdmin.jsp" %>
        </br>
        <h1 style="text-align: center"> Customer manager </h1>

        <div class="container">  

            <div class="row"> 
                <div class="col-2">  
                      <a href="StoreManager">  Store Manager </a> </br>
                    <a href="StaffManager">  Staff manager</a> </br>
                    <a href="CustomerManager">  Customer manager</a> </br>
                    <a href="ProductManager">Product Manager</a></br>
                    <a href=" BillManager">  Bill manager</a> </br>
                </div>

                <div class="col-10">  

                    <form action="CustomerManager" method="POST">
                     <input type="hidden" name="service" value="addCustomer"> 
                     <input type="submit"  name="formAdd" value="ADD"/> 
                    </form>

                    <div> 
                        <form action="CustomerManager" method="POST">
                            <input type="hidden" name="service" value="serachCustomer"> 
                            <div class="d-flex justify-content-end">

                                <input type="text" class="form-control rounded" name="nameCustomer" placeholder="Search" aria-label="Search" aria-describedby="search-addon" />
                                <div class="input-group-append">
                                    <button type="submit" class="btn btn-outline-primary" name="submit">Search</button>
                                </div>

                            </div>

                        </form>
                    </div> </br>
                    <table border="1" >
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>First_Name</th>
                                <th>Last_Name</th>
                                <th>Phone</th>
                                <th>Email</th>
                                <th>Street</th>
                                <th>City</th>
                                <th>State</th>
                                <th>Zip_Code</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="customer" items="${listCustomer}">

                                <tr>
                                    <td>${customer.customer_id}</td>
                                    <td>${customer.first_name}</td>
                                    <td>${customer.last_name}</td>
                                    <td>${customer.phone}</td>
                                    <td>${customer.email}</td>
                                    <td>${customer.street}</td>
                                    <td>${customer.city}</td>
                                    <td>${customer.state}</td>
                                    <td>${customer.zip_code}</td>
                                    <th>                                            
                                        </br>
                                       
                                        <form action="CustomerManager" method="post"> 
                                            <input type="hidden"  name="service" value="deleteCustomer"/> 
                                            <input type="hidden"  name="customerID"  value="${customer.customer_id}"/>
                                            <input type="submit"  name="submitD" value="Delete" />
                                        </form>
                                        </br>
                                        
                                        <form action="CustomerManager" method="post"> 
                                            <input type="hidden"  name="service"    value="getCustomer"/> 
                                            <input type="hidden"  name="customerID" value="${customer.customer_id}" />
                                            <input type="submit"  name="form"       value="Update" />
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

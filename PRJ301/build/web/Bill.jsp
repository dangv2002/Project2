<%-- 
    Document   : Bill
    Created on : Aug 16, 2023, 4:31:05 PM
    Author     : dangv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.sql.ResultSet,model.DAOOrder, jakarta.servlet.http.HttpServletRequest" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <title>Bill Manager</title>
    </head>
    <body>
        <%@include file="headerAdmin.jsp" %>
        <h1 style="text-align: center">Bill Manager</h1>


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


                    <div> 
                        <form action="BillManager" method="post">
                            <input type="hidden" name="service" value="search"> 
                            <div class="d-flex justify-content">

                                <input type="text" class="form-control rounded" name="namecustomer" placeholder="Search" aria-label="Search" aria-describedby="search-addon" />

                                <div class="input-group-append">
                                    <button type="submit" class="btn btn-outline-primary">Search</button>
                                </div>

                            </div>

                        </form>
                    </div> </br>


                    <div class="row">
                        
                        <div class="col-6"> 
                        
                          <table border="1">
                        <thead>
                            <tr>
                                <th> Bill ID</th>
                                <th> Customer Name</th>
                                <th> Date    </th>
                                <th> Total </th>
                                <th> Status</th>
                                <th> View  </th>
                            </tr>
                        </thead>
                        <tbody>


                            <% 
                              ResultSet rs = (ResultSet) request.getAttribute("Order");
                            %>

                            <%
                              while (rs.next()) {
                               
                                            int orderId = rs.getInt(1);
                                            String nameC = rs.getString(2);
                                            String date = rs.getString(3);
                                          double total = rs.getDouble(4);
                                            int status = rs.getInt(5);
                            %>
                            <tr>
                                <td> <%= orderId %> </td>
                                <td> <%=  nameC%> </td>
                                <td> <%=  date%> </td>
                                <td> <%= total %> </td>

                                <td> <%=status%> </td>

                                <td>    
                                    <form action="BillManager" method="POST">
                                        <input type="hidden"  value="detail" name="service"/>
                                        <input type="hidden"  value="<%= orderId %>" name="orderid"/>
                                        <input type="hidden"  value=" <%= total %>" name="total"/>
                                        <input type="submit" value="Detail" name="Detail"/>
                                    </form>
                                </td>


                            </tr>

                            <% } %>

                        </tbody>
                    </table>

                        </div>
                        
                         <div class="col-6"> 
                          <table border="1">
                        <thead>
                            <tr>
                                <th> Customer ID</th>
                                <th> Customer Name</th>
                                <th> Quantity Order </th>
                           
                            </tr>
                        </thead>
                        <tbody>


                            <% 
                              ResultSet rsC = (ResultSet) request.getAttribute("quantityOrder");
                            %>

                            <%
                              while (rsC.next()) {
                                            int customerid= rsC.getInt(1);
                                            String nameC = rsC.getString(2);
                                             int quantity = rsC.getInt(3);
                            %>
                            <tr>
                                <td> <%= customerid %> </td>
                                <td> <%=  nameC%> </td>
                                <td> <%=  quantity %> </td>
                            

                            </tr>

                            <% } %>

                        </tbody>
                    </table>

                             
                             
                        
                        </div>
                    
                    
                    </div>
                  
                </div>


            </div>


        </div>



    </body>
</html>

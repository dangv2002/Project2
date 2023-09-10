<%-- 
    Document   : BillDetail
    Created on : Aug 16, 2023, 4:33:04 PM
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
        <title>JSP Page</title>
    </head>
    <body>

        <%@include file="headerAdmin.jsp" %>
        <h1 style="text-align: center">Bill Detail</h1>

        <div class="container"> 
            <div class="row"> 
                <div class="col-2">  
                    <a href="StaffManager">  Staff manager</a> </br>
                    <a href="CustomerManager">  Customer manager</a> </br>
                    <a href="ProductManager">Product Manager</a></br>
                    <a href=" BillManager">  Bill manager</a> </br>
                </div>
                <div class="col-10">

                    <table border="1">
                        <thead>
                            <tr>
                                <th> Bill ID</th>
                                <th> Customer Name</th>
                                 <th> Date </th>
                                <th> Quantity </th>
                                <th> Product-ID </th>
                                <th> Price </th>
                          
                            </tr>
                        </thead>
                        <tbody> 
                            <% 
                                ResultSet rs = (ResultSet) request.getAttribute("listOrder");
                            %>

                            <%
                              while (rs.next()) {
                               
                                            int orderId = rs.getInt(1);
                                            String nameC = rs.getString(2);
                                            String date = rs.getString(3);
                                            int quantity = rs.getInt(4);
                                            int productid = rs.getInt(5);
                                            double price = rs.getDouble(6);
                                        
                            %>
                            <tr>
                                <td> <%= orderId %> </td>
                                <td> <%=  nameC%> </td>
                                <td> <%=  date%> </td>
                                <td> <%= quantity %> </td>
                                <td> <%= productid %> </td>
                                <td> <%=  price %> </td>
                            </tr>
                            <% } %>
                         
                        </tbody>
                  
                    
                    </table>
                              
                          Total: ${total}
                </div>



            </div>


        </div>





    </body>
</html>

<%-- 
    Document   : ShowCart
    Created on : Aug 22, 2023, 9:56:44 AM
    Author     : dangv
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="entity.Cart,entity.Product" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="Panner.jsp" %>
        <div class="container" style="text-align: center"> 
            <%
            java.util.Enumeration em = session.getAttributeNames();
            
            double all = 0; 
            %> 
            <h3 style="text-align: center"> Cart</h3>
            <table border="1" style="margin: auto">
                <tr>
                    <th>Product ID</th>
                    <th>Product Name</th>
                    <th>Quantity</th>
                    <th>List Price</th>
                    <th>Total</th>
                    <th>Item_ID</th>
                    <th>Action</th>
                    <th>Change Quantity</th>
                </tr>
                <% while (em.hasMoreElements()) {
                    String id = em.nextElement().toString(); 
                    if (!id.equals("customer")&&!id.equals("staff")) {   
                        Cart c = (Cart) session.getAttribute(id);
                        double total = c.getTotal(); 
                        all += total; 
                             
                %>
                <tr>
                    <td><%= c.getProduct_id() %></td>
                    <td><%= c.getProduct_name() %></td>

                <form action="CartManager" method="POST">
                    <input type="hidden" name="service" value="UpdateQuantity"/>
                   
                    <td>  
                        <input type="text" name="quantity" value="<%= c.getQuantity() %>"/>
                        <input type="hidden" name="id" value="<%= c.getProduct_id() %>"/>
                    </td>
                     
                    <td><%= c.getList_price() %></td>
                    <td><%= total %></td>
                    <td><%= c.getId() %></td>
                    <td><a href="CartManager?service=remove&id_delete=<%= c.getProduct_id() %>">Remove</a></td>
                    <td><input type="submit" name="submit" value="Update"/> </td>
                </form>
                
            </tr>
                <% 
                  }
                } %>
                <tr>
                    <td colspan="4"> All Total </td>
                    <td><%= all %></td>
                </tr>
                <tr>
                    <td colspan="8">
                        <a href="CartManager?service=removeall"> Remove All</a>
                    </td>
                </tr>
                <tr>
                    <td colspan="8">
                        <a href="CartManager?service=checkout"> Check Out </a>
                    </td>
                </tr>
           
            </table>

        </div>
    </body>
</html>


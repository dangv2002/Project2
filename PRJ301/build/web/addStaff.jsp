<%-- 
    Document   : addStaff
    Created on : Aug 16, 2023, 11:53:32 AM
    Author     : dangv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Add Staff</h1>
        <a href="StaffManager"> List Staff </a>
        <form action="StaffManager" method="POST">
            <input  type="hidden" name="service" value="addStaff"/>
            <table > 
                <tr>
                    <td> <label  for="firstName">First Name</label></td>
                    <td> <input type="text" id="firstName"  name="first" /></td>
                </tr>
                <tr>
                    <td>  <label  for="lastName">Last Name</label></td>
                    <td>   <input type="text" id="lastName"  name="last" /> </td>
                </tr>

                <tr>
                    <td>   <label for="phone" >Phone</label></td>
                    <td>    <input type="text"  id="phone" name="phone"  /></td>
                </tr>

                <tr>
                    <td> 
                        <label  for="emailAddress">Email</label></td>
                    <td>  <input type="email" id="emailAddress" name="email"  /></td>
                </tr>

                <tr>
                    <td> 
                        <label  for="a">Active</label></td>
                    <td>  <input type="text" id="a" name="Active"  /></td>
                </tr>

                <tr>
                    <td> 
                        <label  for="s">Store</label>
                    </td>
                    <td>  <select name="Store"> 
                            <c:forEach items="${store}" var="s">
                                <option value="${s.store_id}">
                                    ${s.store_name}
                                </option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td> 
                        <label  for="m">Manager</label>
                    </td>
                    <td>  
                        <input type="text" id="m" name="Manager"  />
                    </td>
                </tr>
                <tr>
                    <td><input name="submit" type="submit" value="Submit" /> </td>
                </tr>


            </table>
        </form>





    </body>
</html>

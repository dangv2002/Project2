<%-- 
    Document   : updateStore
    Created on : Aug 21, 2023, 7:58:08 AM
    Author     : dangv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <h1>Update Store</h1>
        <a href="StoreManager"> List </a>
        <form action="StoreManager" method="POST">
            <input  type="hidden" name="service" value="update"/>
            <table > 
               <tr>
                    <td> <label  for="firstName">Store Id</label></td>
                    <td> <input type="text" id="firstName"  name="id" value="${store.store_id}" readonly /></td>
                </tr>
                
                <tr>
                    <td> <label  for="firstName">Store Name</label></td>
                    <td> <input type="text" id="firstName"  name="name" value="${store.store_name}" /></td>
                </tr>
                <tr>
                    <td>   <label for="phone" >Phone</label></td>
                    <td>    <input type="text"  id="phone" name="phone" value="${store.phone}" /></td>
                </tr>

                <tr>
                    <td> 
                        <label  for="emailAddress">Email</label></td>
                    <td>  <input type="email" id="emailAddress" name="email"  value="${store.email}"/></td>
                </tr>

                <tr>
                    <td>   <label  for="street">Street</label></td>
                    <td>  <input type="text" id="street" name="street" value="${store.street}" /> </td>
                </tr>

                <tr>
                    <td> <label  for="city">City</label> </td>
                    <td>   <input type="text" id="city" name="city"  value="${store.city}"/></td>
                </tr>

                <tr>
                    <td>    <label for="state">State</label> </td>
                    <td>  <input type="text" id="state" name="state" value="${store.state}"/></td>
                </tr>

                <tr>
                    <td>   <label  for="zip">Zip_Code</label></td>
                    <td>  <input type="text" id="zip" name="zip" value="${store.zip_code}"/></td>
                </tr>

                <tr>
                    <td> <input name="submit" type="submit" value="Submit" /> </td>
                </tr>

            </table>
        </form>
    </body>
</html>

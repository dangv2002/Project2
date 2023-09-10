<%-- 
    Document   : updateCustomer
    Created on : Aug 16, 2023, 10:43:08 AM
    Author     : dangv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Customer</title>
    </head>
    <body>
        <h1>Update Customer</h1>


        <form action="CustomerManager" method="POST">
            <input  type="hidden" name="service" value="updateCustomer"/>
            <table > 
              
                <tr>
                    <td> <label  for="id">CustomerID:</label></td>
                    <td> <input type="text" id="id"  name="id"  value="${customer.customer_id}" readonly/></td>
                </tr>
                <tr>
                    <td> <label  for="firstName">First Name:</label></td>
                    <td> <input type="text" id="firstName"  name="first"  value="${customer.first_name}"/></td>
                </tr>
                <tr>
                    <td>  <label  for="lastName">Last Name:</label></td>
                    <td>   <input type="text" id="lastName"  name="last" value="${customer.last_name}"/> </td>
                </tr>

                <tr>
                    <td>   <label for="phone" >Phone:</label></td>
                    <td>    <input type="text"  id="phone" name="phone" value="${customer.phone}" /></td>
                </tr>

                <tr>
                    <td> 
                        <label  for="emailAddress">Email:</label></td>
                    <td>  <input type="email" id="emailAddress" name="email" value="${customer.email}" /></td>
                </tr>

                <tr>
                    <td>   <label  for="street">Street:</label></td>
                    <td>  <input type="text" id="street" name="street" value="${customer.street}" /> </td>
                </tr>

                <tr>
                    <td> <label  for="city">City:</label> </td>
                    <td>   <input type="text" id="city" name="city" value="${customer.city}" /></td>
                </tr>

                <tr>
                    <td>    <label for="state">State:</label> </td>
                    <td>  <input type="text" id="state" name="state" value="${customer.state}"/></td>
                </tr>

                <tr>
                    <td>   <label  for="zip">Zip_Code:</label></td>
                    <td>  <input type="text" id="zip" name="zip" value="${customer.zip_code}"/></td>
                </tr>

                <tr>

                    <td> <input name="submit" type="submit" value="Update" /> </td>
                
                
                </tr>


            </table>
        </form>







    </body>
</html>

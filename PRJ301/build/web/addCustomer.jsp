<%-- 
    Document   : addCustomer
    Created on : Aug 16, 2023, 10:43:40 AM
    Author     : dangv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Add Customer</h1>
        <a href="CustomerManager"> List </a>
        <form action="CustomerManager" method="POST">
            <input  type="hidden" name="service" value="addCustomer"/>
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
                    <td>   <label  for="street">Street</label></td>
                    <td>  <input type="text" id="street" name="street"  /> </td>
                </tr>

                <tr>
                    <td> <label  for="city">City</label> </td>
                    <td>   <input type="text" id="city" name="city"  /></td>
                </tr>

                <tr>
                    <td>    <label for="state">State</label> </td>
                    <td>  <input type="text" id="state" name="state" /></td>
                </tr>

                <tr>
                    <td>   <label  for="zip">Zip_Code</label></td>
                    <td>  <input type="text" id="zip" name="zip" /></td>
                </tr>

                <tr>

                    <td>     <input name="submit" type="submit" value="Submit" /> </td>
                </tr>


            </table>
        </form>


    </body>
</html>

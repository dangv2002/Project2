<%-- 
    Document   : updateStaff
    Created on : Aug 16, 2023, 11:53:43 AM
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
        <h1>Update Staff</h1>
        <a href="StaffManager"> List</a>
      
        <form action="StaffManager" method="POST">
            <input  type="hidden" name="service" value="update"/>
            <table > 
                  <tr>
                    <td> <label  for="firstName">Staff ID</label></td>
                    <td> <input type="text" name="id"  value="${staff.staff_id}" readonly/></td>
                </tr>
                
                <tr>
                    <td> <label  for="firstName">First Name</label></td>
                    <td> <input type="text" id="firstName"  name="first"  value="${staff.first_name}"/></td>
                </tr>
                <tr>
                    <td>  <label  for="lastName">Last Name</label></td>
                    <td>   <input type="text" id="lastName"  name="last" value="${staff.last_name}"/> </td>
                </tr>

                <tr>
                    <td>   <label for="phone" >Phone</label></td>
                    <td>    <input type="text"  id="phone" name="phone" value="${staff.phone}" /></td>
                </tr>

                <tr>
                    <td> 
                        <label  for="emailAddress">Email</label></td>
                    <td>  <input type="email" id="emailAddress" name="email"  value="${staff.email}"/></td>
                </tr>

                <tr>
                    <td> 
                        <label >Active</label></td>
                    <td>  <input type="text"  name="active" value="${staff.active}" /></td>
                </tr>

                <tr>
                    <td> 
                        <label>Store</label>
                    </td>
                     <td> 
                        <select name="store"> 
                            <c:forEach items="${store}" var="s">
                                <option value="${s.store_id}"  ${staff.store_id==s.store_id?'selectd':''}>
                                    ${s.store_name}
                                </option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td> 
                        <label >Manager</label>
                    </td>
                    <td>  
                        <input type="text" name="manager" value="${staff.manager_id}" />
                    </td>
                </tr>
                <tr>
                    <td> <input name="submit" type="submit" value="Update" /> </td>
                </tr>
            </table>
        </form>
    </body>
</html>

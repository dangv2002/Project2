<%-- 
    Document   : listStore
    Created on : Aug 21, 2023, 7:58:45 AM
    Author     : dangv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
          <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">        <title>JSP Page</title>

        <title>JSP Page</title>
    </head>
    <body>
    
              <%@include file="headerAdmin.jsp" %>
        </br>
        <h1 style="text-align: center"> Store Manager </h1>

        <div class="container">  

            <div class="row"> 
                <div class="col-3">  
                    <a href="StaffManager">  Staff manager</a> </br>
                    <a href="CustomerManager">  Customer manager</a> </br>
                    <a href="ProductManager">Product Manager</a></br>
                    <a href=" BillManager">  Bill manager</a> </br>
                </div>

                <div class="col-9">  

                    <form action="StoreManager" method="POST">
                     <input type="hidden" name="service" value="add"> 
                     <input type="submit"  name="formAdd" value="ADD"/> 
                    </form>

                        <div> 
                        <form action="StoreManager" method="post">
                            <input type="hidden" name="service" value="search"> 
                            <div class="d-flex justify-content-end">

                                <input type="text" class="form-control rounded" name="nameSearch" placeholder="Search" aria-label="Search" aria-describedby="search-addon" />
                                <div class="input-group-append">
                                    <button type="submit" class="btn btn-outline-primary">Search</button>
                                </div>

                            </div>

                        </form>
                    </div> </br>

                    <table border="1" >
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Store_Name</th>
                                <th>Phone</th>
                                <th>Email</th>
                                <th>Street</th>
                                <th>City</th>
                                <th>State</th>
                                <th>Zip_Code</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="store" items="${listStore}">

                                <tr>
                                    <td>${store.store_id}</td>
                                    <td>${store.store_name}</td>
                                    <td>${store.phone}</td>
                                    <td>${store.email}</td>
                                    <td>${store.street}</td>
                                    <td>${store.city}</td>
                                    <td>${store.state}</td>
                                    <td>${store.zip_code}</td>
                                    <th>                                            
                                        </br>
                                       
                                        <form action="StoreManager" method="post"> 
                                            <input type="hidden"  name="service" value="delete"/> 
                                            <input type="hidden"  name="storeID"  value="${store.store_id}"/>
                                            <input type="submit"  name="submitD" value="Delete" />
                                        </form>
                                        </br>
                                        
                                        <form action="StoreManager" method="post"> 
                                            <input type="hidden"  name="service" value="getStore"/> 
                                            <input type="hidden"  name="storeID" value="${store.store_id}" />
                                            <input type="submit"  name="update"    value="Update" />
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

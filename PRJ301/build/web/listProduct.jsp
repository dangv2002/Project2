<%-- 
    Document   : listProduct
    Created on : Aug 7, 2023, 5:02:49 PM
    Author     : dangv
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

        <title>Product manager</title>
    </head>
    <body>
        <%@include file="headerAdmin.jsp" %>
        </br>
        <h1 style="text-align: center"> Product manager </h1>

        <div class="container"> 
           
            <div class="row"> 
                <div class="col-3">
                      <a href="StoreManager">  Store Manager </a> </br>
                    <a href="StaffManager">   Staff manager</a> </br>
                    <a href="CustomerManager">Customer manager</a> </br>
                    <a href="ProductManager">Product Manager</a></br>
                    <a href=" BillManager">  Bill manager</a> </br>
                </div>

                <div class="col-9">
                    <form action="ProductManager" method="POST">
                        <input type="hidden" name="service" value="addProduct"> 
                        <input type="submit"  value="ADD"/> 
                    </form>


                    <div> 
                        <form action="ProductManager" method="post">
                            <input type="hidden" name="service" value="searchProduct"> 
                            <div class="d-flex justify-content-end">

                                <input type="text" class="form-control rounded" name="nameSearch" placeholder="Search" aria-label="Search" aria-describedby="search-addon" />
                                <div class="input-group-append">
                                    <button type="submit" class="btn btn-outline-primary">Search</button>
                                </div>

                            </div>

                        </form>
                    </div> </br>

                    <table border="1">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Product_Name</th>
                                <th>Model_Year</th>
                                <th>List_Price</th>
                                <th>Brand_Name</th>
                                <th>Category_Name</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="product" items="${listProduct}">

                                <tr>
                                    <td>${product.product_id}</td>
                                    <td>${product.product_name}</td>
                                    <td>${product.model_year}</td>
                                    <td>${product.list_price}</td>
                                    <td>${product.brand_name}</td>
                                    <td>${product.category_name}</td>
                                    <th>                                            </br>
                                        </br>
                                        <form action="ProductManager" method="post"> 
                                            <input  <input type="hidden"  name="service" value="deleteProduct" >
                                            <input type="hidden"  name="productID" value="${product.product_id}" />
                                            <input type="submit" value="Delete" />
                                        </form>
                                        </br>
                                        <form action="ProductManager" method="post"> 
                                            <input  <input type="hidden"  name="service" value="getProduct" >
                                            <input type="hidden"  name="productID" value="${product.product_id}" />
                                            <input type="submit" value="Update" />
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

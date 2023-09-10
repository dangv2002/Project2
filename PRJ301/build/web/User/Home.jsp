<%-- 
    Document   : Home
    Created on : Aug 15, 2023, 11:50:25 AM
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
        <%@include file="Panner.jsp" %>
        <div class="container">
            <div class="row"> 
                <div class="col-4">
                    <h4>  Category Name </h4>
                            <c:forEach var="category" items="${listCategory}">
                                <tr>
                                    <td>
                                        <form action="HomeUser" method="post">
                                            <input  type="hidden" value="filterByCategory" name="service"  />
                                            <input  type="hidden"  name="c"value="${category}"  />

                                            <input  type="submit" value="${category}"    />
                                        </form
                                    </td>
                                </tr>
                            </c:forEach>
                  


                </div>
                <div class="col-8">
                   
                    
                 <div class="container"> 

            <div class="row">                   
                    <div> 
                        <form action="HomeUser" method="post">
                            <input type="hidden" name="service" value="searchProduct"> 
                            <div class="d-flex justify-content-end">

                                <input type="text" class="form-control rounded" name="nameSearch" placeholder="Search" aria-label="Search" aria-describedby="search-addon" />
                                <div class="input-group-append">
                                    <button type="submit" class="btn btn-outline-primary">Search</button>
                                </div>

                            </div>

                        </form>
                    </div> 
                </br>

                    <table border="1">
                        <thead>
                            <tr>  
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
                                    <td>${product.product_name}</td>
                                    <td>${product.model_year}</td>
                                    <td>${product.list_price}</td>
                                    <td>${product.brand_name}</td>
                                    <td>${product.category_name}</td>
                                    <th>                                            </br>
                                        </br>
                                        <form action="CartManager" method="post"> 
                                            <input  <input type="hidden"  name="service" value="add2cart" >
                                            <input type="hidden"  name="productID" value="${product.product_id}" />
                                            <input type="submit" value="Add Cart" />
                                        </form>
                                        </br>
                                       
                                        </br>

                                    </th>
                                </tr>
                            </c:forEach>

                        </tbody>
                    </table>



                </div>

            </div>



        </div>
        
        
        
        
        


                </div>

            </div>


        </div>



    </body>
</html>

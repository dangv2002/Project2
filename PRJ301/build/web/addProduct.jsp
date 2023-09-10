<%-- 
    Document   : addProduct
    Created on : Aug 7, 2023, 5:28:28 PM
    Author     : dangv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>Add Product</title>
    </head>
    <body>
        <%@include file="headerAdmin.jsp" %>
        <h1>Add Product</h1>

        <a href="ProductManager">LIST</a>
     
        <form action="ProductManager" method="post">
        <input type="hidden"  name="service" value="addProduct" >
            <table>
             
                <tr>
                    <td> <label for="product_name">Product Name:</label> </td>
                    <td>  <input type="text" id="product_name" name="product_name" required> </td>
                </tr>

                <tr> 
                    <td> <label for="model_year">Model Year:</label></td>
                    <td>   <input type="number" id="model_year" name="model_year" required></td>
                </tr>

                <tr> 
                    <td><label for="list_price">List Price:</label> </td>
                    <td>  <input type="number" step="0.01" id="list_price" name="list_price" required></td>
                </tr>

                <tr> 
                    <td><label for="brand_name">Brand Name:</label> </td>
                    <td> <select name="brand_name"> 
                            <c:forEach var="brand" items="${listBrandName}"> 
                              
                                <option value=${brand}> ${brand} </option>
                          
                            </c:forEach>
                         
                  
                        </select></td>
                </tr>

                <tr>
                    <td><label for="category_name">category_name:</label></td>   
                    <td> <select name="category_name"> 
                            <c:forEach var="category" items="${listCategoryName}"> 
                              
                                <option value=${category}> ${category} </option>
                          
                            </c:forEach>

                        </select></td>
                </tr>       
                <tr> 
                    <td> <input type="submit"  name ="submit" value="ADD"> </td>
                    <td> <input type="reset"  name ="reset" value="Reset"> </td>
                </tr>


            </table>
    


        </form>


    </body>
</html>

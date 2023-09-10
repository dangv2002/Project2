<%-- 
    Document   : updateProduct
    Created on : Aug 9, 2023, 10:14:43 AM
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
        <h1>Update</h1>


        <a href="ProductManager">LIST</a>

        <form action="ProductManager" method="POST">
            <input type="hidden"  name="service" value="updateProduct" >
            <table>
                <tr>
                    <td> <label for="product_name"> ProductID: </label> </td>
                    <td>   <input type="text"  name="product_id" value="${productUpdate.product_id}" readonly /></td>

                </tr>


                <tr>
                    <td> <label for="product_name">Product Name:</label> </td>
                    <td>  <input type="text" id="product_name" name="product_name" value="${productUpdate.product_name}" required> </td>
                </tr>

                <tr> 
                    <td> <label for="model_year">Model Year:</label></td>
                    <td>   <input type="number" id="model_year" name="model_year"  value="${productUpdate.model_year}"required></td>
                </tr>

                <tr> 
                    <td><label for="list_price">List Price:</label> </td>
                    <td>  <input type="number" step="0.01" id="list_price" name="list_price"  value="${productUpdate.list_price}"></td>
                </tr>

                <tr> 
                    <td><label for="brand_name">Brand Name:</label> </td>
                    <td> <select name="brand_name"> 


                            <c:forEach var="brand" items="${listBrandName}">
                                <c:if test="${brand == productUpdate.brand_name}">
                                    <option value="${brand}" selected>${brand}</option>
                                </c:if>
                                <c:if test="${brand != productUpdate.brand_name}">
                                    <option value="${brand}">${brand}</option>
                                </c:if>
                            </c:forEach>
                        </select></td>
                </tr>

                <tr>
                    <td><label for="category_name">category_name:</label></td>   
                    <td> <select name="category_name"> 


                            <c:forEach var="category" items="${listCategoryName}">
                                <c:if test="${category == productUpdate.category_name}">
                                    <option value="${category}" selected>${category}</option>
                                </c:if>

                                <c:if test="${category != productUpdate.category_name}">
                                    <option value="${category}"> ${category} </option>
                                </c:if>
                            </c:forEach>

                        </select></td>
                </tr>       
                <tr> 
                    <td> <input type="submit"  name ="submitUpdate" value="Update"> </td>
                </tr>


            </table>



        </form>


    </body>
</html>

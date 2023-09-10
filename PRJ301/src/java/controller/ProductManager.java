/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Vector;
import model.DAOProduct;

/**
 *
 * @author dangv
 */
@WebServlet(name = "ProductManager", urlPatterns = {"/ProductManager"})
public class ProductManager extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProductManager</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProductManager at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            DAOProduct productDAO = new DAOProduct();
            ArrayList<Product> listProduct = productDAO.getAllProducts();
            request.setAttribute("listProduct", listProduct);
            request.getRequestDispatcher("listProduct.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        DAOProduct productDAO = new DAOProduct();
        String service = request.getParameter("service");
//add product
        if (service.equals("addProduct")) {
            String add = request.getParameter("submit");

            if (add == null) {

                ArrayList<String> brandName = productDAO.getFileds("brand_name");
                ArrayList<String> categotyName = productDAO.getFileds("category_name");
                request.setAttribute("listBrandName", brandName);
                request.setAttribute("listCategoryName", categotyName);
                request.getRequestDispatcher("addProduct.jsp").forward(request, response);
            } else {
                
                String product_name = request.getParameter("product_name");
                int model_year = Integer.parseInt(request.getParameter("model_year"));
                double list_price = Double.parseDouble(request.getParameter("list_price"));
                String brand_name = request.getParameter("brand_name");
                String category_name = request.getParameter("category_name");

                Product newProduct = new Product();

                newProduct.setProduct_name(product_name);
                newProduct.setModel_year(model_year);
                newProduct.setList_price(list_price);
                newProduct.setBrand_name(brand_name);
                newProduct.setCategory_name(category_name);

                 int n = productDAO.insertProduct(newProduct);
                 response.sendRedirect("ProductManager");
               
            }

        }
// delete product
        if (service.equals("deleteProduct")) {
            int productID = Integer.parseInt(request.getParameter("productID"));
            productDAO.deleteProduct(productID);

            response.sendRedirect("ProductManager");
        }

        if (service.equals("getProduct")) {
            int productID = Integer.parseInt(request.getParameter("productID"));
            Product pro = productDAO.getProductByID(productID);
            ArrayList<String> brandName = productDAO.getFileds("brand_name");
            ArrayList<String> categotyName = productDAO.getFileds("category_name");
            request.setAttribute("listBrandName", brandName);
            request.setAttribute("listCategoryName", categotyName);
            request.setAttribute("productUpdate", pro);
            request.getRequestDispatcher("updateProduct.jsp").forward(request, response);

        }
        
        //update product
        if (service.equals("updateProduct")) {

            int product_id = Integer.parseInt(request.getParameter("product_id"));
            String product_name = request.getParameter("product_name");
            int model_year = Integer.parseInt(request.getParameter("model_year"));
            double list_price = Double.parseDouble(request.getParameter("list_price"));
            String brand_name = request.getParameter("brand_name");
            String category_name = request.getParameter("category_name");

            Product product = new Product();
            product.setProduct_name(product_name);
            product.setModel_year(model_year);
            product.setList_price(list_price);
            product.setBrand_name(brand_name);
            product.setCategory_name(category_name);

            productDAO.updateProduct(product_id, product);
            response.sendRedirect("ProductManager");
        }
         //search product
        if (service.equals("searchProduct")) {

            String nameSearch = request.getParameter("nameSearch");

            if (nameSearch != null) {
                Vector<Product> listSearch = productDAO.searchProductByName(nameSearch.trim());
                request.setAttribute("listProduct", listSearch);
                request.getRequestDispatcher("listProduct.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("listProduct.jsp").forward(request, response);
            }
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import entity.Cart;
import entity.Customer;
import entity.Order;
import entity.OrderItem;
import entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Enumeration;
import model.DAOOrder;
import model.DAOProduct;

/**
 *
 * @author dangv
 */
public class CartManager extends HttpServlet {

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
            String service = request.getParameter("service");

            HttpSession session = request.getSession();

            if (service.equals("add2cart")) {

                int productId = Integer.parseInt(request.getParameter("productID"));
                String key = "" + productId;

                DAOProduct dao = new DAOProduct();
                Product product = dao.getProductByID(productId);

                Cart cartItem = (Cart) session.getAttribute(key);

                int id_item = 0;
                Enumeration em = session.getAttributeNames();
                while (em.hasMoreElements()) {
                    String a = em.nextElement().toString();
                    if (!a.equals("customer") && !a.equals("staff")) {
                        Cart c = (Cart) session.getAttribute(a);
                        int id_check = c.getId();
                        if (id_check > id_item) {
                            id_item = id_check;
                        }
                    }
                }

                if (cartItem == null) {
                    cartItem = new Cart();
                    cartItem.setProduct_id(product.getProduct_id());
                    cartItem.setProduct_name(product.getProduct_name());
                    cartItem.setList_price(product.getList_price());
                    cartItem.setQuantity(1);
                    cartItem.setId(id_item + 1);
                } else {
                    cartItem.setQuantity(cartItem.getQuantity() + 1);
                }

                cartItem.setTotal(cartItem.getList_price() * cartItem.getQuantity());
                session.setAttribute(key, cartItem);
                response.sendRedirect("HomeUser");

            }

            if (service.equals("show")) {
                request.getRequestDispatcher("/User/ShowCart.jsp").forward(request, response);
            }

            if (service.equals("remove")) {
                String id_remove = request.getParameter("id_delete");
                session.removeAttribute(id_remove);
                request.getRequestDispatcher("/User/ShowCart.jsp").forward(request, response);
            }

            if (service.equals("removeall")) {

                Enumeration em = session.getAttributeNames();

                while (em.hasMoreElements()) {
                    String id = em.nextElement().toString();
                    if (!id.equals("customer")) {
                        session.removeAttribute(id);
                    }
                }
                request.getRequestDispatcher("/User/ShowCart.jsp").forward(request, response);

            }

            if (service.equals("UpdateQuantity")) {

                try {
                    int quantity = Integer.parseInt(request.getParameter("quantity"));
                    if (quantity > 0) {
                        String product_id = request.getParameter("id");
                        java.util.Enumeration em = session.getAttributeNames();

                        while (em.hasMoreElements()) {
                            String key = em.nextElement().toString();
                            if (!key.equals("customer") && !key.equals("staff") && key.equals(product_id)) {

                                Cart cartItem = (Cart) session.getAttribute(key);
                                cartItem.setQuantity(quantity);

                                session.setAttribute(key, cartItem);
                                request.getRequestDispatcher("/User/ShowCart.jsp").forward(request, response);
                            }
                        }
                    } else {

                        request.getRequestDispatcher("/User/ShowCart.jsp").forward(request, response);
                    }

                } catch (Exception e) {

                    request.getRequestDispatcher("/User/ShowCart.jsp").forward(request, response);
                }
            }

            if (service.equals("checkout")) {

                if (session.getAttribute("customer") == null) {
               request.getRequestDispatcher("/User/login.jsp").forward(request, response);
                    
                } else {
                    Customer c = (Customer) session.getAttribute("customer");
                    LocalDate currentDate = LocalDate.now();
                    String date = currentDate.toString();

                    Order o = new Order();
                    o.setCustomer_id(c.getCustomer_id());
                    o.setOrder_date(date);
                    o.setRequired_date(date);
                    DAOOrder dao = new DAOOrder();
                    int n = dao.addOrder(o);

                    if (n != 0) {
                        Enumeration em = session.getAttributeNames();
                        while (em.hasMoreElements()) {
                            String id = em.nextElement().toString();
                            if (!id.equals("customer") && !id.equals("staff")) {
                                Cart cartItem = (Cart) session.getAttribute(id);

                                OrderItem orderItem = new OrderItem();
                                int id_order = dao.getNewOrder_ID();
                                orderItem.setOrder_id(id_order);
                                orderItem.setItem_id(cartItem.getId());
                                orderItem.setProduct_id(cartItem.getProduct_id());
                                orderItem.setQuantity(cartItem.getQuantity());
                                orderItem.setList_price((int) cartItem.getList_price());
                                orderItem.setDiscount(1);

                                dao.addOrderItem(orderItem);
                            }
                        }

                        response.sendRedirect("HomeUser");
                    }

                }

            }
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
        processRequest(request, response);

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

        processRequest(request, response);

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

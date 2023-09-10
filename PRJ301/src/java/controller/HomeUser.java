/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import entity.Customer;
import entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Vector;
import model.DAOCustomer;
import model.DAOProduct;

/**
 *
 * @author dangv
 */
public class HomeUser extends HttpServlet {

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
            DAOProduct dao = new DAOProduct();
            DAOCustomer daoc = new DAOCustomer();
            HttpSession session = request.getSession(true);

            if (service == null) {
                service = "display";
            }

            if (service.equals("display")) {

                ArrayList<String> list = dao.getFileds("category_name");
                ArrayList<Product> listProduct = dao.getAllProducts();

                request.setAttribute("listProduct", listProduct);
                request.setAttribute("listCategory", list);

                request.getRequestDispatcher("/User/Home.jsp").forward(request, response);
            }
            // login
            if (service.equals("login")) {

                String loginSubmit = request.getParameter("submitLogin");

                if (loginSubmit != null) {

                    String userName = request.getParameter("email");
                    String passWord = request.getParameter("password");

                    Customer customer = daoc.login(userName, passWord);

                    if (customer != null) {
                        session.setAttribute("customer", customer);
                        response.sendRedirect("HomeUser");

                    } else {
                        request.setAttribute("error", "Wrong email or password");
                        request.getRequestDispatcher("/User/login.jsp").forward(request, response);
                    }
                } else {

                    request.getRequestDispatcher("/User/login.jsp").forward(request, response);

                }

            }
            //register
            if (service.equals("register")) {

                String register = request.getParameter("submitRe");
                if (register != null) {
                    String firstName = request.getParameter("first");
                    String lastName = request.getParameter("last");
                    String phone = request.getParameter("phone");
                    String email = request.getParameter("email");
                    String street = request.getParameter("street");
                    String city = request.getParameter("city");
                    String state = request.getParameter("state");
                    String zip = request.getParameter("zip");

                    Customer customer = new Customer();

                    customer.setFirst_name(firstName);
                    customer.setLast_name(lastName);
                    customer.setEmail(email);
                    customer.setPhone(phone);
                    customer.setStreet(street);
                    customer.setState(state);
                    customer.setCity(city);
                    customer.setZip_code(zip);
                    daoc.insertCustomer(customer);
                    response.sendRedirect("HomeUser");
                } else {
                    request.getRequestDispatcher("/User/register.jsp").forward(request, response);

                }
            }

            if (service.equals("logout")) {

                session.removeAttribute("customer");
                response.sendRedirect("HomeUser");
            }

            if (service.equals("searchProduct")) {

                String nameSearch = request.getParameter("nameSearch");
                ArrayList<String> list = dao.getFileds("category_name");
                request.setAttribute("listCategory", list);
                Vector<Product> p = dao.searchProductByName(nameSearch);
                request.setAttribute("listProduct", p);
                request.getRequestDispatcher("/User/Home.jsp").forward(request, response);

            }

            if (service.equals("filterByCategory")) {
                ArrayList<String> listc = dao.getFileds("category_name");
                request.setAttribute("listCategory", listc);
                String category = request.getParameter("c");
                ArrayList<Product> list = dao.filterByCategory(category);
                request.setAttribute("listProduct", list);
                request.getRequestDispatcher("/User/Home.jsp").forward(request, response);

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

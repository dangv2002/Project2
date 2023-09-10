/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import entity.Customer;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Vector;
import model.DAOCustomer;

/**
 *
 * @author dangv
 */
public class CustomerManager extends HttpServlet {

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
            out.println("<title>Servlet CustomerManager</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CustomerManager at " + request.getContextPath() + "</h1>");
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
        DAOCustomer dao = new DAOCustomer();
        ArrayList<Customer> listCustomer = dao.getAllCustomer();
        request.setAttribute("listCustomer", listCustomer);
        request.getRequestDispatcher("listCustomer.jsp").forward(request, response);
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

        String service = request.getParameter("service");

        DAOCustomer dao = new DAOCustomer();

        //delete customer
        if (service.equals("deleteCustomer")) {

            int customerID = Integer.parseInt(request.getParameter("customerID"));
            dao.deleteCustomer(customerID);

            response.sendRedirect("CustomerManager");

        }

        // search customer
        if (service.equals("serachCustomer")) {

            String nameCustomer = request.getParameter("nameCustomer");

            if (nameCustomer != null && nameCustomer != "") {
                Vector<Customer> customerList = dao.searchByName(nameCustomer.trim());
                request.setAttribute("listCustomer", customerList);

                request.getRequestDispatcher("listCustomer.jsp").forward(request, response);

            } else {

                response.sendRedirect("CustomerManager");

            }
        }

        //add customer
        if (service.equals("addCustomer")) {
            String submit = request.getParameter("submit");

            if (submit == null) {
                request.getRequestDispatcher("addCustomer.jsp").forward(request, response);

            } else {

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

                dao.insertCustomer(customer);
                response.sendRedirect("CustomerManager");
            }
        }

        if (service.equals("getCustomer")) {
            int customer_id = Integer.parseInt(request.getParameter("customerID"));
            Customer customer = dao.getCustomerByID(customer_id);
            request.setAttribute("customer", customer);

           
            request.getRequestDispatcher("updateCustomer.jsp").forward(request, response);

        }
        //update customer 
        if (service.equals("updateCustomer")) {

            int id = Integer.parseInt(request.getParameter("id"));
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

            dao.updateCustomer(id, customer);

            response.sendRedirect("CustomerManager");

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

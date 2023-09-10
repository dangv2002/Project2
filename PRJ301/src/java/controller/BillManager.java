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
import java.sql.ResultSet;
import java.util.Vector;
import model.DAOCustomer;
import model.DAOOrder;

/**
 *
 * @author dangv
 */
public class BillManager extends HttpServlet {

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
            out.println("<title>Servlet BillManager</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet BillManager at " + request.getContextPath() + "</h1>");
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

        DAOOrder dao = new DAOOrder();
        ResultSet rs = dao.getAllOrder();
        ResultSet rsC = dao.quantityOrderOfCustomer();
        request.setAttribute("quantityOrder", rsC);
        request.setAttribute("Order", rs);
        request.getRequestDispatcher("Bill.jsp").forward(request, response);

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
        DAOOrder dao = new DAOOrder();
        String service = request.getParameter("service");

        if (service.equals("detail")) {
            int id = Integer.parseInt(request.getParameter("orderid"));
            ResultSet rs = dao.getAllOrderDetail(id);
            String total = request.getParameter("total");

            request.setAttribute("total", total);
            request.setAttribute("listOrder", rs);
            request.getRequestDispatcher("BillDetail.jsp").forward(request, response);
        }

        if (service.equals("search")) {
            String nameCustomer = request.getParameter("namecustomer");
            ResultSet rs = dao.searchOrderByNameC(nameCustomer.trim());
            request.setAttribute("Order", rs);
            request.getRequestDispatcher("Bill.jsp").forward(request, response);
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

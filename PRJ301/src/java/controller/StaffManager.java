/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import entity.Staff;
import entity.Store;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import model.DAOStaff;
import model.DAOStore;

/**
 *
 * @author dangv
 */
public class StaffManager extends HttpServlet {

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
            out.println("<title>Servlet StaffManager</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet StaffManager at " + request.getContextPath() + "</h1>");
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

        DAOStaff dao = new DAOStaff();
        ArrayList<Staff> listStaff = dao.getAllStaff();
        request.setAttribute("listStaff", listStaff);
        request.getRequestDispatcher("listStaff.jsp").forward(request, response);
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
        DAOStaff dao = new DAOStaff();
        String service = request.getParameter("service");
        // search staff by first name
        if (service.equals("searchStaff")) {
            String nameSearch = request.getParameter("inputName");

            ArrayList<Staff> s = dao.searchStaffByName(nameSearch);
            request.setAttribute("listStaff", s);
            request.getRequestDispatcher("listStaff.jsp").forward(request, response);

        }
        // add staff
        if (service.equals("addStaff")) {
            String add = request.getParameter("submit");

            if (add == null) {
                DAOStore daos = new DAOStore();
                ArrayList<Store> list = daos.getAllStore();
                request.setAttribute("store", list);
                request.getRequestDispatcher("addStaff.jsp").forward(request, response);

            } else {

                String firstName = request.getParameter("first");
                String lastName = request.getParameter("last");
                String phone = request.getParameter("phone");
                String email = request.getParameter("email");
                int active = Integer.parseInt(request.getParameter("Active"));
                int storeid = Integer.parseInt(request.getParameter("Store"));
                int managerid = Integer.parseInt(request.getParameter("Manager"));

                Staff s = new Staff();
                s.setFirst_name(firstName);
                s.setLast_name(lastName);
                s.setPhone(phone);
                s.setEmail(email);
                s.setActive(active);
                s.setStore_id(storeid);
                s.setManager_id(managerid);

                dao.addStaff(s);
                response.sendRedirect("StaffManager");

            }

        }

        if (service.equals("delete")) {
            int staff_id = Integer.parseInt(request.getParameter("staffID"));
            int n = dao.deleteStaff(staff_id);
            if (n == 0) {
                    request.setAttribute("error", "Delete Fail");
                    ArrayList<Staff> listStaff = dao.getAllStaff();
                    request.setAttribute("listStaff", listStaff);
                
                request.getRequestDispatcher("listStaff.jsp").forward(request, response);
            } else {
               
                response.sendRedirect("StaffManager");
            }

        }

        if (service.equals("getStaff")) {
            int staff_id = Integer.parseInt(request.getParameter("staffID"));
            Staff s = dao.getStaffById(staff_id);
            DAOStore daos = new DAOStore();
            ArrayList<Store> list = daos.getAllStore();
            request.setAttribute("store", list);
            request.setAttribute("staff", s);
            request.getRequestDispatcher("updateStaff.jsp").forward(request, response);
        }

        if (service.equals("update")) {

            int staff_id = Integer.parseInt(request.getParameter("id"));
            String firstName = request.getParameter("first");
            String lastName = request.getParameter("last");
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");

            int active = Integer.parseInt(request.getParameter("active"));
            int storeid = Integer.parseInt(request.getParameter("store"));
            int managerid = Integer.parseInt(request.getParameter("manager"));

            Staff s = new Staff();
            s.setFirst_name(firstName);
            s.setLast_name(lastName);
            s.setPhone(phone);
            s.setEmail(email);
            s.setActive(active);
            s.setStore_id(storeid);
            s.setManager_id(managerid);
            dao.updateStaff(staff_id, s);

            response.sendRedirect("StaffManager");

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

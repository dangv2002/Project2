/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import entity.Store;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import model.DAOStore;

/**
 *
 * @author dangv
 */
public class StoreManager extends HttpServlet {

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
            out.println("<title>Servlet StoreManager</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet StoreManager at " + request.getContextPath() + "</h1>");
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
        DAOStore dao = new DAOStore();
        ArrayList<Store> list = dao.getAllStore();
        request.setAttribute("listStore", list);
        request.getRequestDispatcher("listStore.jsp").forward(request, response);
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
        DAOStore dao = new DAOStore();
        //add
        if (service.equals("add")) {
            String submit = request.getParameter("submit");
            if (submit == null) {
                request.getRequestDispatcher("addStore.jsp").forward(request, response);

            } else {

                String name = request.getParameter("name");
                String phone = request.getParameter("phone");
                String email = request.getParameter("email");
                String street = request.getParameter("street");
                String city = request.getParameter("city");
                String state = request.getParameter("state");
                String zip = request.getParameter("zip");

                Store store = new Store();

                store.setStore_name(name);
                store.setEmail(email);
                store.setPhone(phone);
                store.setStreet(street);
                store.setState(state);
                store.setCity(city);
                store.setZip_code(zip);

                dao.addStore(store);
                response.sendRedirect("StoreManager");
            }

        }
        //search

        if (service.equals("search")) {
            String name = request.getParameter("nameSearch");
            ArrayList<Store> list = dao.searchStoreByName(name);
            request.setAttribute("listStore", list);
            request.getRequestDispatcher("listStore.jsp").forward(request, response);

        }
        //update

        if (service.equals("getStore")) {

            int id = Integer.parseInt(request.getParameter("storeID"));
            Store s = dao.getStoreById(id);
            request.setAttribute("store", s);
            request.getRequestDispatcher("updateStore.jsp").forward(request, response);

        }

        if (service.equals("update")) {

            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");
            String street = request.getParameter("street");
            String city = request.getParameter("city");
            String state = request.getParameter("state");
            String zip = request.getParameter("zip");

            Store store = new Store();

            store.setStore_name(name);
            store.setEmail(email);
            store.setPhone(phone);
            store.setStreet(street);
            store.setState(state);
            store.setCity(city);
            store.setZip_code(zip);

            dao.updateStore(store, id);

            response.sendRedirect("StoreManager");

        }
        //delete

        if (service.equals("delete")) {

            int id = Integer.parseInt(request.getParameter("storeID"));
            dao.deleteStore(id);
            response.sendRedirect("StoreManager");

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

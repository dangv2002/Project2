/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entity.Customer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dangv
 */
public class DAOCustomer extends DBConect {

    public int insertCustomer(Customer customer) {

        int n = 0;

        String sql = "INSERT INTO [dbo].[customers]\n"
                + "           ([first_name]\n"
                + "           ,[last_name]\n"
                + "           ,[phone]\n"
                + "           ,[email]\n"
                + "           ,[street]\n"
                + "           ,[city]\n"
                + "           ,[state]\n"
                + "           ,[zip_code])\n"
                + "     VALUES(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, customer.getFirst_name());
            preparedStatement.setString(2, customer.getLast_name());
            preparedStatement.setString(3, customer.getPhone());
            preparedStatement.setString(4, customer.getEmail());
            preparedStatement.setString(5, customer.getStreet());
            preparedStatement.setString(6, customer.getCity());
            preparedStatement.setString(7, customer.getState());
            preparedStatement.setString(8, customer.getZip_code());
            n = preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException ex) {
            Logger.getLogger(DAOCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;

    }

    public ArrayList<Customer> getAllCustomer() {

        try {

            String sql = "SELECT *FROM customers";
            PreparedStatement ps;
            ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            ArrayList<Customer> listCustomer = new ArrayList<>();
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setCustomer_id(rs.getInt(1));
                customer.setFirst_name(rs.getString(2));
                customer.setLast_name(rs.getString(3));
                customer.setPhone(rs.getString(4));
                customer.setEmail(rs.getString(5));
                customer.setStreet(rs.getString(6));
                customer.setCity(rs.getString(7));
                customer.setState(rs.getString(8));
                customer.setZip_code(rs.getString(9));
                listCustomer.add(customer);

            }
            return listCustomer;
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;

    }

    public Customer login(String userName, String passWord) {

        try {

            String sql = "SELECT * FROM customers WHERE email= ? and phone = ?";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, userName);
            pre.setString(2, passWord);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {

                Customer customer = new Customer();
                customer.setCustomer_id(rs.getInt(1));
                customer.setFirst_name(rs.getString(2));
                customer.setLast_name(rs.getString(3));
                customer.setPhone(rs.getString(4));
                customer.setEmail(rs.getString(5));
                customer.setStreet(rs.getString(6));
                customer.setCity(rs.getString(7));
                customer.setState(rs.getString(8));
                customer.setZip_code(rs.getString(9));

                return customer;

            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public int updateCustomer(int customerID, Customer customer) {
        int n = 0;
        try {
            String sql = "UPDATE [dbo].[customers]\n"
                    + "   SET [first_name] =? \n"
                    + "      ,[last_name] =? \n"
                    + "      ,[phone] = ?\n"
                    + "      ,[email] =?\n"
                    + "      ,[street] =? \n"
                    + "      ,[city] = ?\n"
                    + "      ,[state] = ?\n"
                    + "      ,[zip_code] = ?\n"
                    + " WHERE  customer_id = ?";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, customer.getFirst_name());
            pre.setString(2, customer.getLast_name());
            pre.setString(3, customer.getPhone());
            pre.setString(4, customer.getEmail());
            pre.setString(5, customer.getStreet());
            pre.setString(6, customer.getCity());
            pre.setString(7, customer.getState());
            pre.setString(8, customer.getZip_code());
            pre.setInt(9, customerID);

            n = pre.executeUpdate();
            pre.close();

        } catch (SQLException ex) {
            Logger.getLogger(DAOCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int deleteCustomer(int customer_id) {
        int n = 0;
        String sql = "DELETE FROM [dbo].[customers]\n"
                + "      WHERE customer_id = ?";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, customer_id);
            n = pre.executeUpdate();
            pre.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public Vector searchByName(String name) {
        Vector<Customer> vector = new Vector<Customer>();

        String sql = "select * from customers where first_name like ?";

        try {
            PreparedStatement pre = connection.prepareStatement(sql);
               pre.setString(1, "%" + name + "%");
            ResultSet rs = pre.executeQuery();

            while (rs.next()) {
                Customer customer = new Customer();
                customer.setCustomer_id(rs.getInt("customer_id"));
                customer.setFirst_name(rs.getString("first_name"));
                customer.setLast_name(rs.getString("last_name"));
                customer.setPhone(rs.getString("phone"));
                customer.setEmail(rs.getString("email"));
                customer.setStreet(rs.getString("street"));
                customer.setCity(rs.getString("city"));
                customer.setState(rs.getString("state"));
                customer.setZip_code(rs.getString("zip_code"));

                vector.add(customer);

            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }

        return vector;
    }

    public Customer getCustomerByID(int id) {

        try {
            String sql = "SELECT * FROM customers WHERE customer_id =" + id;
            Statement state = connection.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setCustomer_id(rs.getInt(1));
                customer.setFirst_name(rs.getString(2));
                customer.setLast_name(rs.getString(3));
                customer.setPhone(rs.getString(4));
                customer.setEmail(rs.getString(5));
                customer.setStreet(rs.getString(6));
                customer.setCity(rs.getString(7));
                customer.setState(rs.getString(8));
                customer.setZip_code(rs.getString(9));
     return customer;
            }
       

        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public static void main(String[] args) {
//        DAOCustomer dao = new DAOCustomer();
//        Customer c = new Customer();
//       Customer list = dao.getCustomerByID(1);
//        System.out.println(list);


//        c.setFirst_name("DANG2");
//        c.setLast_name("VU");
//        c.setPhone("1234567");
//        c.setEmail("dang123@gmail.com");
//        c.setCity("Lai Chau");
//        c.setStreet("bbbb");
//        c.setState("NY");
//        c.setZip_code("123");
//
//        dao.insertCustomer(c);
    }

}

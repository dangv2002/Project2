/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entity.Staff;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dangv
 */
public class DAOStaff extends DBConect {

    public ArrayList<Staff> getAllStaff() {

        try {
            ArrayList<Staff> staffList = new ArrayList<>();

            String sql = "SELECT * FROM [dbo].[staffs]";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Staff staff = new Staff();
                staff.setStaff_id(resultSet.getInt("staff_id"));
                staff.setFirst_name(resultSet.getString("first_name"));
                staff.setLast_name(resultSet.getString("last_name"));
                staff.setEmail(resultSet.getString("email"));
                staff.setPhone(resultSet.getString("phone"));
                staff.setActive(resultSet.getInt("active"));
                staff.setStore_id(resultSet.getInt("store_id"));
                staff.setManager_id(resultSet.getInt("manager_id"));

                staffList.add(staff);

            }
            return staffList;

        } catch (SQLException ex) {
            Logger.getLogger(DAOStaff.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int addStaff(Staff staff) {
        int n = 0;
        try {

            String sql = "INSERT INTO [dbo].[staffs]\n"
                    + "           ([first_name]\n"
                    + "           ,[last_name]\n"
                    + "           ,[email]\n"
                    + "           ,[phone]\n"
                    + "           ,[active]\n"
                    + "           ,[store_id]\n"
                    + "           ,[manager_id])\n"
                    + "     VALUES(?,?,?,?,?,?,?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, staff.getFirst_name());
            preparedStatement.setString(2, staff.getLast_name());
            preparedStatement.setString(3, staff.getEmail());
            preparedStatement.setString(4, staff.getPhone());
            preparedStatement.setInt(5, staff.getActive());
            preparedStatement.setInt(6, staff.getStore_id());
            preparedStatement.setInt(7, staff.getManager_id());
            n = preparedStatement.executeUpdate();
            return n;
        } catch (SQLException ex) {
            Logger.getLogger(DAOStaff.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;

    }

    public int updateStaff(int staffID, Staff staff) {
        int n = 0;
        String sql ="UPDATE staffs SET first_name = ?, last_name = ?, email = ?, phone = ?, "
                + "active = ?, store_id = ?, manager_id = ? WHERE staff_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, staff.getFirst_name());
            preparedStatement.setString(2, staff.getLast_name());
            preparedStatement.setString(3, staff.getEmail());
            preparedStatement.setString(4, staff.getPhone());
            preparedStatement.setInt(5, staff.getActive());
            preparedStatement.setInt(6, staff.getStore_id());
            preparedStatement.setInt(7, staff.getManager_id());
            preparedStatement.setInt(8, staffID);

            n = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOStaff.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int deleteStaff(int id) {
        int n = 0;
        String deleteQuery = "DELETE FROM staffs WHERE staff_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setInt(1, id);
            n = preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAOStaff.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public Staff loginAdmin(String userName, String pass) {

        try {
            String sql = "SELECT * FROM staffs WHERE email= ? and phone = ?";
            PreparedStatement pre = connection.prepareStatement(sql);

            pre.setString(1, userName);
            pre.setString(2, pass);
            ResultSet resultSet = pre.executeQuery();
            while (resultSet.next()) {
                Staff staff = new Staff();
                staff.setStaff_id(resultSet.getInt("staff_id"));
                staff.setFirst_name(resultSet.getString("first_name"));
                staff.setLast_name(resultSet.getString("last_name"));
                staff.setEmail(resultSet.getString("email"));
                staff.setPhone(resultSet.getString("phone"));
                staff.setActive(resultSet.getInt("active"));
                staff.setStore_id(resultSet.getInt("store_id"));
                staff.setManager_id(resultSet.getInt("manager_id"));

                return staff;

            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOStaff.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public ArrayList<Staff> searchStaffByName(String firstName) {

        try {
            ArrayList<Staff> staffList = new ArrayList<>();

            String sql = "SELECT * FROM [dbo].[staffs] where first_name like ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "%" + firstName + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Staff staff = new Staff();
                staff.setStaff_id(resultSet.getInt("staff_id"));
                staff.setFirst_name(resultSet.getString("first_name"));
                staff.setLast_name(resultSet.getString("last_name"));
                staff.setEmail(resultSet.getString("email"));
                staff.setPhone(resultSet.getString("phone"));
                staff.setActive(resultSet.getInt("active"));
                staff.setStore_id(resultSet.getInt("store_id"));
                staff.setManager_id(resultSet.getInt("manager_id"));

                staffList.add(staff);

            }
            return staffList;

        } catch (SQLException ex) {
            Logger.getLogger(DAOStaff.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Staff getStaffById(int id) {
        try {
            String sql = "SELECT * FROM [dbo].[staffs] where staff_id = ? ";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, id);
            ResultSet resultSet = pre.executeQuery();
            while (resultSet.next()) {
                Staff staff = new Staff();
                staff.setStaff_id(resultSet.getInt("staff_id"));
                staff.setFirst_name(resultSet.getString("first_name"));
                staff.setLast_name(resultSet.getString("last_name"));
                staff.setEmail(resultSet.getString("email"));
                staff.setPhone(resultSet.getString("phone"));
                staff.setActive(resultSet.getInt("active"));
                staff.setStore_id(resultSet.getInt("store_id"));
                staff.setManager_id(resultSet.getInt("manager_id"));
                return staff;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOStaff.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void main(String[] args) {
        DAOStaff dao = new DAOStaff();
        Staff s = new Staff();
        
         s.setFirst_name("testupdate");
         s.setLast_name("admin2");
         s.setEmail("admin1@gmai.com");
         s.setPhone("123");
         s.setActive(1);
         s.setStore_id(1);
         s.setManager_id(1);
       dao.updateStaff(1003, s);

    }

}

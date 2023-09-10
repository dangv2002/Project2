/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entity.Store;
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
public class DAOStore extends DBConect {

    public ArrayList<Store> getAllStore() {
        try {
            String sql = "SELECT * FROM stores";
            PreparedStatement pre = connection.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            ArrayList<Store> list = new ArrayList();
            while (rs.next()) {
                Store s = new Store(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getString(7), rs.getString(8));
                list.add(s);
            }
            return list;

        } catch (SQLException ex) {
            Logger.getLogger(DAOStore.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void addStore(Store store) {

        try {
            String sql = "INSERT INTO [dbo].[stores]\n"
                    + "           ([store_name]\n"
                    + "           ,[phone]\n"
                    + "           ,[email]\n"
                    + "           ,[street]\n"
                    + "           ,[city]\n"
                    + "           ,[state]\n"
                    + "           ,[zip_code])\n"
                    + "     VALUES(?,?,?,?,?,?,?)";
            PreparedStatement pre = connection.prepareStatement(sql);

            pre.setString(1, store.getStore_name());
            pre.setString(2, store.getPhone());
            pre.setString(3, store.getEmail());
            pre.setString(4, store.getStreet());
            pre.setString(5, store.getCity());
            pre.setString(6, store.getState());
            pre.setString(7, store.getZip_code());
            pre.executeUpdate();
            pre.close();

        } catch (SQLException ex) {
            Logger.getLogger(DAOStore.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void main(String[] args) {
        DAOStore dao = new DAOStore();
          Store s = new Store();
          s.setEmail("da");
          s.setStore_name("test");
          dao.updateStore(s,11);
       
    }

    public void deleteStore(int id) {
        try {
            String sql = "DELETE FROM [dbo].[stores]\n"
                    + "      WHERE store_id = ?";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, id);
            pre.executeUpdate();
            pre.close();

        } catch (SQLException ex) {
            Logger.getLogger(DAOStore.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ArrayList<Store> searchStoreByName(String name) {

        try {

            String sql = "select * from stores where store_name like ?";

            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, "%" + name + "%");
            ResultSet rs = pre.executeQuery();
            ArrayList<Store> list = new ArrayList<>();
            while (rs.next()) {
                Store store = new Store();

                store.setStore_id(rs.getInt("store_id"));
                store.setStore_name(rs.getString("store_name"));
                store.setPhone(rs.getString("phone"));
                store.setEmail(rs.getString("email"));
                store.setStreet(rs.getString("street"));
                store.setCity(rs.getString("city"));
                store.setState(rs.getString("state"));
                store.setZip_code(rs.getString("zip_code"));

                list.add(store);

            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;

    }

    public Store getStoreById(int id) {

        try {
            String sql = "SELECT * FROM stores where store_id = ?";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, id);
            ResultSet rs = pre.executeQuery();

            while (rs.next()) {
                Store s = new Store(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getString(7), rs.getString(8));
                return s;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOStore.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public void updateStore(Store store, int id) {

        try {
            String sql = "UPDATE [dbo].[stores]\n"
                    + "   SET [store_name] = ?\n"
                    + "      ,[phone] =? \n"
                    + "      ,[email] = ?\n"
                    + "      ,[street] = ?\n"
                    + "      ,[city] = ?\n"
                    + "      ,[state] = ?\n"
                    + "      ,[zip_code] = ?\n"
                    + " WHERE  store_id=? ";

            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, store.getStore_name());
            pre.setString(2, store.getPhone());
            pre.setString(3, store.getEmail());
            pre.setString(4, store.getStreet());
            pre.setString(5, store.getCity());
            pre.setString(6, store.getState());
            pre.setString(7, store.getZip_code());
            pre.setInt(8, id);
            pre.executeUpdate();
            pre.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAOStore.class.getName()).log(Level.SEVERE, null, ex);
        }

    
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dangv
 */
public class DAOStock  extends DBConect{
    
    
    public int deleteStockByProductID(int productID){
        int n=0;
        try {
            String sql = "DELETE FROM dbo.stocks\n" +
                    "WHERE product_id = "+productID;
            Statement s = connection.createStatement();
           n = s.executeUpdate(sql);
            s.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAOStock.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    
    
    
    public static void main(String[] args) {
        DAOStock dao = new DAOStock();
           
              
    }
}

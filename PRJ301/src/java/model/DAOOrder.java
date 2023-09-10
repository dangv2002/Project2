/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entity.Order;
import entity.OrderItem;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dangv
 */
public class DAOOrder extends DBConect {

    public ResultSet quantityOrderOfCustomer() {

        try {
            String sql = "   Select  o.customer_id, c.first_name,count(o.order_id)  as quantity_order from orders o left join customers c on c.customer_id = o.customer_id\n"
                    + "   group by o.customer_id,c.first_name order by o.customer_id asc";

            PreparedStatement pre = connection.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            return rs;

        } catch (SQLException ex) {
            Logger.getLogger(DAOOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int getNewOrder_ID() {
        try {
            String sql = "SELECT TOP (1) [order_id]\n"
                    + "FROM [PRJ301A].[dbo].[orders] ORDER BY [order_id] DESC";
            PreparedStatement pre = connection.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                return id;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public int addOrder(Order order) {
        int n = 0;
        try {

            String sql = "INSERT INTO [dbo].[orders]\n"
                    + "           ([customer_id]\n"
                    + "           ,[order_status]\n"
                    + "           ,[order_date]\n"
                    + "           ,[required_date]\n"
                    + "           ,[shipped_date]\n"
                    + "           ,[store_id]\n"
                    + "           ,[staff_id])\n"
                    + "     VALUES(?,?,?,?,?,?,?)";

            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, order.getCustomer_id());
            pre.setInt(2, 1);
            pre.setString(3, order.getOrder_date());
            pre.setString(4, order.getRequired_date());
            pre.setString(5, null);
            pre.setInt(6, 1);
            pre.setInt(7, 1);
            n = pre.executeUpdate();
            pre.close();

            return n;
        } catch (SQLException ex) {
            Logger.getLogger(DAOOrder.class.getName()).log(Level.SEVERE, null, ex);
        }

        return n;

    }

    public ResultSet getAllOrder() {
        try {
            String sql = "	 SELECT o.order_id,c.first_name,o.order_date\n"
                    + "        , sum(oi.list_price) as total,o.order_status FROM orders o  "
                    + "          right join order_items oi on o.order_id = oi.order_id left join customers "
                    + "          c on c.customer_id=o.customer_id\n"
                    + "	         group by o.order_id,o.order_date,o.order_status,c.first_name\n"
                    + "		 ORDER BY o.order_id asc";

            PreparedStatement pre = connection.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            return rs;

        } catch (SQLException ex) {
            Logger.getLogger(DAOOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public ResultSet getAllOrderDetail(int id) {
        try {
            String sql = "  SELECT o.order_id,c.first_name,o.order_date  ,oi.quantity,oi.product_id\n"
                    + "   , oi.list_price,o.order_status FROM orders o  right join order_items oi \n"
                    + "   on o.order_id = oi.order_id left join customers c on c.customer_id=o.customer_id\n"
                    + "    where o.order_id = ?  \n"
                    + "	group by o.order_id,o.order_date,o.order_status,c.first_name,oi.list_price,oi.quantity,oi.product_id\n"
                    + "	 ORDER BY o.order_id asc";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, id);
            ResultSet rs = pre.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(DAOOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public double getTotal(int id) {
        try {
            String sql = "  SELECT sum(list_price) as total FROM order_items where order_id= ?";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, id);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                double total = rs.getDouble(1);
                return total;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOOrder.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;
    }

    public static void main(String[] args) {
        DAOOrder dao = new DAOOrder();
       // int i = dao.getNewOrder_ID();
        ResultSet rs = dao.quantityOrderOfCustomer();
        System.out.println(rs);

        // Tạo một đối tượng OrderItem để thêm vào cơ sở dữ liệu
//        OrderItem orderItem = new OrderItem();
//       
//        orderItem.setOrder_id(1627); // Thay bằng ID đơn hàng thực tế
//        orderItem.setItem_id(1); // Thay bằng ID mục đơn hàng thực tế
//        orderItem.setProduct_id(11); // Thay bằng ID sản phẩm thực tế
//        orderItem.setQuantity(1);
//        orderItem.setList_price(111);
//        orderItem.setDiscount(11);
//
//        int n = dao.addOrderItem(orderItem);
//        if (n != 0) {
//            System.out.println("OrderItem added successfully!");
//        }
    }

    public int addOrderItem(OrderItem o) {
        int n = 0;
        try {
            String sql = "  INSERT INTO [order_items] ([order_id], [item_id],"
                    + " [product_id], [quantity], [list_price], [discount])\n"
                    + "VALUES (?, ?, ?, ?, ?, ?)";

            PreparedStatement pre = connection.prepareStatement(sql);

            pre.setInt(1, o.getOrder_id());
            pre.setInt(2, o.getItem_id());
            pre.setInt(3, o.getProduct_id());
            pre.setInt(4, o.getQuantity());
            pre.setDouble(5, o.getList_price());
            pre.setInt(6, o.getDiscount());

            n = pre.executeUpdate();
            pre.close();

        } catch (SQLException ex) {
            Logger.getLogger(DAOOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public ResultSet searchOrderByNameC(String name) {

        try {
            String sql = "SELECT o.order_id, c.first_name, o.order_date,\n"
                    + "       SUM(oi.list_price) AS total, o.order_status\n"
                    + "FROM orders o  \n"
                    + "RIGHT JOIN order_items oi ON o.order_id = oi.order_id\n"
                    + "LEFT JOIN customers c ON c.customer_id = o.customer_id\n"
                    + "WHERE c.first_name LIKE ? \n"
                    + "GROUP BY o.order_id, c.first_name, o.order_date, o.order_status\n"
                    + "ORDER BY o.order_id ASC";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, "%" + name + "%");

            ResultSet rs = pre.executeQuery();

            return rs;

        } catch (SQLException ex) {
            Logger.getLogger(DAOOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entity.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dangv
 */
public class DAOProduct extends DBConect {

    public ArrayList<Product> filterByCategory(String category) {
        try {
            String sql = "SELECT *FROM products where category_name = ?";
            PreparedStatement pre = connection.prepareStatement(sql);
           pre.setString(1, category);
            ResultSet rs = pre.executeQuery();
            ArrayList<Product> listProduct = new ArrayList<>();
            while (rs.next()) {
                Product product = new Product();
                product.setProduct_id(rs.getInt("product_id"));
                product.setProduct_name(rs.getString("product_name"));
                product.setModel_year(rs.getInt("model_year"));
                product.setList_price((int) rs.getDouble("list_price"));
                product.setBrand_name(rs.getString("brand_name"));
                product.setCategory_name(rs.getString("category_name"));

                listProduct.add(product);

            }
            return listProduct;
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public int insertProduct(Product product) {
        int n = 0;
        try {
            String sql = "INSERT INTO [dbo].[products] "
                    + "([product_name],[model_year], [list_price], [brand_name], [category_name]) "
                    + "VALUES (?, ?, ?, ?,?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, product.getProduct_name());
            preparedStatement.setInt(2, product.getModel_year());
            preparedStatement.setDouble(3, product.getList_price());
            preparedStatement.setString(4, product.getBrand_name());
            preparedStatement.setString(5, product.getCategory_name());
            n = preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;

    }

    public ArrayList<Product> getAllProducts() {

        try {

            String sql = "SELECT *FROM products";
            PreparedStatement ps = connection.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            ArrayList<Product> listProduct = new ArrayList<>();
            while (rs.next()) {

                Product product = new Product();
                product.setProduct_id(rs.getInt("product_id"));
                product.setProduct_name(rs.getString("product_name"));
                product.setModel_year(rs.getInt("model_year"));
                product.setList_price((int) rs.getDouble("list_price"));
                product.setBrand_name(rs.getString("brand_name"));
                product.setCategory_name(rs.getString("category_name"));

                listProduct.add(product);

            }
            return listProduct;
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;

    }

    public ArrayList getFileds(String name) {

        try {

            String sql = "SELECT DISTINCT " + name + " FROM products";
            PreparedStatement ps = connection.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            ArrayList<String> listProduct = new ArrayList<>();
            while (rs.next()) {

                listProduct.add(rs.getString(1));

            }
            return listProduct;
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;

    }

    public int deleteProduct(int productID) {
        int n = 0;
        try {
            String sql = "DELETE FROM products where product_id=?";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, productID);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public void displayAll() {

        try {
            String sql = " SELECT * from products";
            Statement st = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                // dataType varName = rs.getDataType(fieldName|index);

                //int id = rs.getInt("product_id");
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int year = rs.getInt(3);
                double price = rs.getDouble(4);
                String brandName = rs.getString(5);
                String categoryName = rs.getString(6);

                Product pro = new Product(id, name, year, price, brandName, categoryName);
                System.out.println(pro);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int updateProduct(int productID, Product product) {
        int n = 0;
        String sql = "UPDATE [dbo].[products]\n"
                + "   SET [product_name] = ?\n"
                + "      ,[model_year] = ?\n"
                + "      ,[list_price] = ?\n"
                + "      ,[brand_name] = ?\n"
                + "      ,[category_name] = ?\n"
                + " WHERE product_id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, product.getProduct_name());
            preparedStatement.setInt(2, product.getModel_year());
            preparedStatement.setDouble(3, product.getList_price());
            preparedStatement.setString(4, product.getBrand_name());
            preparedStatement.setString(5, product.getCategory_name());
            preparedStatement.setInt(6, productID);
            n = preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public Vector<Product> searchProductByName(String nameProduct) {
        Vector<Product> listProduct = new Vector<>();
        String sql = "SELECT * from products WHERE product_name like ?";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, "%" + nameProduct + "%");
            ResultSet rs = pre.executeQuery();

            while (rs.next()) {
                Product product = new Product();
                product.setProduct_id(rs.getInt("product_id"));
                product.setProduct_name(rs.getString("product_name"));
                product.setModel_year(rs.getInt("model_year"));
                product.setList_price((int) rs.getDouble("list_price"));
                product.setBrand_name(rs.getString("brand_name"));
                product.setCategory_name(rs.getString("category_name"));

                listProduct.add(product);

            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listProduct;
    }

    public Product getProductByID(int id) {
        try {
            String sql = "SELECT * from products WHERE product_id =" + id;

            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                Product pro = new Product();
                pro.setProduct_id(rs.getInt(1));
                pro.setProduct_name(rs.getString(2));
                pro.setModel_year(rs.getInt(3));
                pro.setList_price(rs.getDouble(4));
                pro.setBrand_name(rs.getString(5));
                pro.setCategory_name(rs.getString(6));
                return pro;

            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Vector getProducts(String sql) {
        Vector<Product> vector = new Vector<Product>();
        try {
            Statement state = connection.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                //dataType varName=rs.getDataType(fieldName|index);
                int id = rs.getInt("product_id");
                // int id=rs.getInt(1);
                String name = rs.getString(2);
                //   String name=rs.getString("product_name");
                int year = rs.getInt(3);
                double price = rs.getDouble(4);
                String brand = rs.getString(5);
                String cate = rs.getString(6);
                Product pro = new Product(id, name, year, price, brand, cate);
                vector.add(pro);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }

        return vector;
    }

    public static void main(String[] args) {
        DAOProduct dao = new DAOProduct();
        //Product p = new Product(206,"DEMO",12,12,"dang","dang");
        //dao.updateProduct(206,p);
        ArrayList pro = dao.getFileds("category_name");
        System.out.println(pro);
//        Vector<Product> list = dao.searchProductByName("Surly");

    }

}

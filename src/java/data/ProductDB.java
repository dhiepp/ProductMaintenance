package data;

import java.sql.*;
import java.util.ArrayList;
import model.Product;

public class ProductDB {
    
        public static ArrayList<Product> selectAllProduct() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "SELECT * FROM product";
        
        try
        {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            
            ArrayList<Product> productList = new ArrayList<>();
            while (rs.next())
            {
                Product product = new Product();
                product.setCode(rs.getString("code"));
                product.setName(rs.getString("name"));
                product.setDescription(rs.getString("description"));
                product.setWeight(rs.getInt("weight"));
                product.setPrice(rs.getFloat("price"));
                productList.add(product);
            }
            return productList;
        }
        catch (SQLException e){
            e.printStackTrace();
            return null;
        }        
        finally
        {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    public static Product selectProduct(String code) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "SELECT * FROM product WHERE code = ?";
        
        try
        {
            ps = connection.prepareStatement(query);
            ps.setString(1, code);
            rs = ps.executeQuery();
            
            Product product = null;
            if (rs.next())
            {
                product = new Product();
                product.setCode(code);
                product.setName(rs.getString("name"));
                product.setDescription(rs.getString("description"));
                product.setWeight(rs.getInt("weight"));
                product.setPrice(rs.getFloat("price"));
            }
            return product;
        }
        catch (SQLException e){
            e.printStackTrace();
            return null;
        }        
        finally
        {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static int insertProduct(Product product) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        String query = "INSERT INTO product (code, name, description, weight, price) VALUES (?, ?, ?, ?, ?)";
        
        try
        {
            ps = connection.prepareStatement(query);
            ps.setString(1, product.getCode());
            ps.setString(2, product.getName());
            ps.setString(3, product.getDescription());
            ps.setInt(4, product.getWeight());
            ps.setFloat(5, product.getPrice());
            return ps.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
            return 0;
        }        
        finally
        {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    public static int updateProduct(Product product) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        String query = "UPDATE product SET name = ?, description = ?, weight = ?, price = ? WHERE code = ?";
        
        try
        {
            ps = connection.prepareStatement(query);
            ps.setString(1, product.getName());
            ps.setString(2, product.getDescription());
            ps.setInt(3, product.getWeight());
            ps.setFloat(4, product.getPrice());
            ps.setString(5, product.getCode());
            return ps.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
            return 0;
        }        
        finally
        {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    public static int deleteProduct(String code) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        String query = "DELETE FROM product WHERE code = ?";
        
        try
        {
            ps = connection.prepareStatement(query);
            ps.setString(1, code);
            return ps.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
            return 0;
        }        
        finally
        {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
}

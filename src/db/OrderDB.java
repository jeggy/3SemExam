package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Jógvan 29/12-2015 02:07.
 */
public class OrderDB extends DBModel{

    public int create(Order order) throws SQLException {
        this.establishConnetion();
        String sql = "INSERT INTO `order` (`status`) VALUES(?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, order.getStatus());
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            con.close();
        }
        return -1;
    }

    public Order read(int id) throws SQLException {
        this.establishConnetion();
        String sql = "SELECT `id`, `status` FROM `order` WHERE `id` = '"+id+"';";
        try {
            ResultSet rs = con.createStatement().executeQuery(sql);

            rs.next();
            int rsId = rs.getInt("id");
            String rsStatus = rs.getString("status");
            return new Order(rsId, rsStatus);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            con.close();
        }
        return null;
    }

    public int update(Order order) throws SQLException {
        this.establishConnetion();
        String sql = "UPDATE `order` SET `status` = ? WHERE `id` = ?;";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, order.getStatus());
            ps.setInt(2, order.getId());
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            con.close();
        }
        return -1;
    }

    public int delete(int order) throws SQLException {
        this.establishConnetion();
        String sql = "DELETE FROM `order` WHERE `id` = "+order+";";
        try {
            return con.createStatement().executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            con.close();
        }
        return -1;
    }
}

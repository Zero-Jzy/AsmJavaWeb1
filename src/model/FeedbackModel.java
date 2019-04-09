package model;

import entity.FeedBack;

import java.sql.*;
import java.util.ArrayList;

public class FeedbackModel {

    private static Connection connection;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost/asm_javaweb1?user=root&password=");
        } catch (SQLException e) {
            System.out.println("SQLException " + e.getMessage());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean insert(FeedBack feedBack) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("insert into feedback (username,content) values (?,?)");
            preparedStatement.setString(1, feedBack.getUsername());
            preparedStatement.setString(2, feedBack.getContent());
            System.out.println(feedBack.getContent());
            System.out.println(feedBack.getUsername());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(String id) {
        try {
            System.out.println(id);
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE feedback SET status = -1 WHERE id = ?");
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean apccept(String id) {
        try {
            System.out.println(id);
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE feedback SET status = 1 WHERE id = ?");
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<FeedBack> getFeedback(String sql) {
        ArrayList<FeedBack> feedBacks = new ArrayList<>();
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                FeedBack feedBack = new FeedBack();
                feedBack.setId(rs.getInt("id"));
                feedBack.setUsername(rs.getString("username"));
                feedBack.setContent(rs.getString("content"));
                feedBack.setCreateAt(rs.getTimestamp("createAt"));
                feedBacks.add(feedBack);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return feedBacks;
    }

    public ArrayList<FeedBack> getNotAccepted(){
        return getFeedback("select  * FROM feedback where status = 0");
    }

    public ArrayList<FeedBack> getAccepted(){
        return getFeedback("select  * FROM feedback where status = 1");
    }



}

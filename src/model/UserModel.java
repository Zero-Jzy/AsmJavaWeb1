package model;

import entity.User;

import java.sql.*;

public class UserModel {

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

    public boolean insert(User user) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("insert into Account (fullname,username,password) values (?,?,?)");
            preparedStatement.setString(1, user.getFullName());
            preparedStatement.setString(2, user.getUsername());
            preparedStatement.setString(3, user.getPassword());

            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("SQLException " + e.getMessage());

        }
        return false;
    }

    public User getUserByUserNameAndPassword(String username, String password) {

        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("select * from Account where username = ? and password = ?");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String existFullName = rs.getString(1);
                String existUsername = rs.getString(2);
                String existPassword = rs.getString(3);
                Integer existRole = rs.getInt(4);
                User user = new User(existUsername, existPassword, existFullName, existRole);
                return user;
            }
        } catch (SQLException e) {
            System.out.println("SQLException " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }


    public User finOne(String username){
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT * FROM Account WHERE username = ?");
            preparedStatement.setString(1,username);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()){
                User user = new User();
                user.setFullName(rs.getString("fullname"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getInt("role"));
                return user;
            }
        } catch (SQLException e) {
            System.out.println("SQLException " + e.getMessage());

        }
        return null;
    }

}

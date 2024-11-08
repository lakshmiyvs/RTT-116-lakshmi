package Homework;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import java.util.Scanner;

public class Update_preparedSt_Example {
    public static void main(String args[]) {

        Connection con = null;
        PreparedStatement prepstmt = null;
        ResultSet rs = null;
        String dburl = "jdbc:mysql://127.0.0.1:3306/classic_models";
        String user = "root";
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter you DB pwd");
        String password = sc.nextLine();

        try {
            con = DriverManager.getConnection(dburl, user, password);
            System.out.println("Connection established successfully");

            String sql = "UPDATE employees SET firstName= ? , lastName=? WHERE id = ?";

            prepstmt = con.prepareStatement(sql);
            prepstmt.setString(1, "Gary");
            prepstmt.setString(2, "Larson");
            prepstmt.setLong(3, 0003);

            int rowsAffected = prepstmt.executeUpdate();

            prepstmt = con.prepareStatement("SELECT * FROM employees WHERE id=?");
            prepstmt.setInt(1, 0003);

            //execute select query
            rs = prepstmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("firstName"));
                System.out.println(rs.getString("lastname"));
                System.out.println(rs.getString("email"));
                System.out.println(rs.getString("office_id"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}


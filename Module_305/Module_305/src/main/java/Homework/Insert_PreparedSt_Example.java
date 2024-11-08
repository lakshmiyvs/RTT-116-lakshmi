package Homework;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import java.util.Scanner;

public class Insert_PreparedSt_Example {
    public static void main (String args[]){

        Connection con = null;
        PreparedStatement prepstmt = null;
        ResultSet rs = null;
        String dburl = "jdbc:mysql://127.0.0.1:3306/classic_models";
        String user = "root";
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter you DB pwd");
        String password = sc.nextLine();

        try{
            con = DriverManager.getConnection(dburl, user, password);
            System.out.println("Connection established successfully");

            // let's insert one record using a prepared statement
            String sqlQuery = "INSERT INTO employees (office_id, firstname, lastname, email, extension, reports_to, " +
                    "vacation_hours, id, job_title) VALUES (?,?,?,?,?,?,?,?,?)";

            prepstmt = con.prepareStatement(sqlQuery);

            prepstmt.setInt(1,6);
            prepstmt.setString(2, "Jamil");
            prepstmt.setString(3, "fink");
            prepstmt.setString(4, "JJ@gmail.com");
            prepstmt.setString(5, "2759");
            prepstmt.setInt(6, 1143);
            prepstmt.setInt(7, 9);
            prepstmt.setInt(8,0003);
            prepstmt.setString(9, "Manager");

            int affectedRows = prepstmt.executeUpdate();
            System.out.println(affectedRows + " row(s) affected!");

            //let's pull data from database for an inserted record
            //query which needs parameter

            prepstmt = con.prepareStatement("SELECT * FROM employees WHERE id = ? ");

            prepstmt.setInt(1, 0003);
            //execute select query
            rs = prepstmt.executeQuery();
            //display function to show the resultset
            while(rs.next()) {
                System.out.println(rs.getString("firstname"));
                System.out.println(rs.getString("lastname"));
                System.out.println(rs.getString("email"));
                System.out.println(rs.getString("office_id"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            prepstmt.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}


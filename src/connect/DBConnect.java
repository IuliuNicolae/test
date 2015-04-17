/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect;

//import java.beans.Statement;
import java.sql.*;
//import java.sql.ResultSet;

public class DBConnect {

    private Connection con;
    private Statement st;
    private ResultSet rs;

    public DBConnect() {
        try {
               // String URL = "jdbc:mysql://194.47.47.18:3306/YOUR_DATABASE_NAME?user=YOUR_USER_NAME&password=YOUR_PASSWORD";
            // String URL = "jdbc:mysql://127.0.0.1:3306/company?user=root&password=root";
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/santaclaus?user=fred&password=barney");
            st = (Statement) con.createStatement();
        } catch (Exception ex) {
            System.out.println("Error:b " + ex);
        }
    }

    public void getData() {
        try {
            String query = "select child_id,child_name,country from child";
            rs = st.executeQuery(query);
            while (rs.next()) {
                String id = rs.getString("child_id");
                String name = rs.getString("child_name");
                String country = rs.getString("country");
                System.out.println("ID: " + id + " Name: " + name + " Country: " + country + " Adress: ");
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

}

package org.apache.struts.login.service;

import org.apache.struts.login.model.Person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginService {
    private static final String URL = "jdbc:mysql://localhost/authentication";
    private static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";

    public Connection getConnection() throws Exception {
        Class.forName(DRIVER_CLASS);
        return DriverManager.getConnection(URL, "testing", "password");
    }

    public boolean authenticate(Person person) throws Exception {
        Connection conn = getConnection();
        String sql = "SELECT * FROM account WHERE username = ? AND password = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, person.getUsername());
        ps.setString(2, person.getPassword());
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            // return true if account exists in the database
            return true;
        }

        return false;
    }
}

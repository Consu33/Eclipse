package com.myconstruccion.auth.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.myconstruccion.auth.model.User;
import com.myconstruccion.utils.DatabaseConnection;
import org.mindrot.jbcrypt.BCrypt;

public class UserDAO {
    public boolean validateUser(String username, String password) {
        String query = "SELECT password FROM users WHERE username=?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement stmt = con.prepareStatement(query)) {

            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return BCrypt.checkpw(password, rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

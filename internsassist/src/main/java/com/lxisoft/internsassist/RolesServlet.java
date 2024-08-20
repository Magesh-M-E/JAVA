package com.lxisoft.internsassist;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/roles")
public class RolesServlet extends HttpServlet {

    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException
    {
 String person =  request.getParameter("personName");
 String role =  request.getParameter("rolesAssign");

 String jdbcURL = "jdbc:mysql://localhost:3306/userdb";
        String dbUser = "root";
        String dbPassword = "Jayaram";

        try (Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword)) {
            String sql = "INSERT INTO user_roles (user_name, role_Name) VALUES (?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1,person);
                statement.setString(2, role);

                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    response.getWriter().print("Project assigned successfully");
                } else {
                    response.getWriter().print("Failed to assign project");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().print("Database error: " + e.getMessage());
        }


    }
}
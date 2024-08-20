<%@ page session = "true" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, java.util.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Assign Roles</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        table, th, td {
            border: 1px solid black;
        }
        th, td {
            padding: 10px;
            text-align: left;
        }
    </style>
</head>
<body>
    <h2>Assign Projects to People</h2>
    <form action="roles" method="post">
        <label for="person">Person:</label>
        <select id="person" name="personName">
            <% 
                Connection conn = null;
                PreparedStatement stmt = null;
                ResultSet rs = null;
                String jdbcURL = "jdbc:mysql://localhost:3306/userdb";
                String dbUser = "root";
                String dbPassword = "Jayaram";
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    conn = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
                    String sql = "SELECT user_name FROM users";
                    stmt = conn.prepareStatement(sql);
                    rs = stmt.executeQuery();
                    while (rs.next()) {
                        String personName = rs.getString("user_name");
            %>
                        <option value="<%= personName %>"><%= personName %></option>
            <% 
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            %>
        </select><br>

        <label for="roles">Roles:</label>
        <select id="roles" name="rolesAssign">
            <% 
                try {
                    conn = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
                    String sql = "SELECT role_name FROM roles";
                    stmt = conn.prepareStatement(sql);
                    rs = stmt.executeQuery();
                    while (rs.next()) {
                        String role = rs.getString("role_name");
            %>
                        <option value="<%= role %>"><%= role %></option>
            <% 
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            %>
        </select><br>

        <button type="submit">Assign Project</button>
    </form>

</body>
</html>

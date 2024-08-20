package com.lxisoft.internsassist;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/InternDetails")
public class InternDetalis extends HttpServlet
{
    Connection connection ;
    public void init()
    {
        String url = "jdbc:mysql://localhost:3306/userdb";
        String userName = "root";
        String password = "vipin@2002";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, userName, password);
        }
        catch(ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();
        }
    }
    public void doGet(HttpServletRequest request , HttpServletResponse response)throws ServletException , IOException
    {
        try{
            List<Internsassist> internsassists = this.internDetails(request);
            request.setAttribute("interns", internsassists);
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("secure/admin/RoleAssigning.jsp");
            dispatcher.forward(request, response);    
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    public List<Internsassist> internDetails(HttpServletRequest request) throws SQLException 
    {
        List<Internsassist> interns = new ArrayList<>();
        String name = request.getParameter("name");
        String viewQuery = "SELECT * FROM users WHERE user_name=?"; 
        PreparedStatement preparedStatement = connection.prepareStatement(viewQuery);
        preparedStatement.setString(1, name);
        ResultSet resultSet = preparedStatement.executeQuery(); 
        while (resultSet.next()) {
            Internsassist internsassist = new Internsassist();
            internsassist.setName(resultSet.getString("user_name"));
            interns.add(internsassist);
        }
        return interns;
    }
    
}
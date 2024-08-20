<%@ page session="true" %>
<%@ page import="com.lxisoft.internsassist.Internsassist" %>
<%@ page import="java.security.Principal" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Profile Page</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f0f0f0; /* Light grey background */
        margin: 0;
        padding: 0;
    }
    .container {
        max-width: 800px;
        margin: 20px auto;
        background-color: #fff; /* White background for the container */
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1); /* Soft shadow */
    }
    h1, h2, h3 {
        color: #333; /* Dark text color */
    }
    .profile-info {
        margin-bottom: 20px;
    }
    .profile-info label {
        font-weight: bold;
    }
    .profile-info span {
        display: block;
        margin-top: 5px;
    }
    .null-message {
        color: red; /* Red color for null message */
    }
</style>
</head>
<body>
    <div class="container">
        <%
            Principal principal = request.getUserPrincipal();
            String name = principal.getName();
            Internsassist intern = (Internsassist) request.getAttribute("intern");
        %>
        <h1>Profile Page</h1>
        <div class="profile-info">
            <label>Name:</label>
            <span><%= name %></span>
        </div>
        <% if(intern != null) { %>
            <div class="profile-info">
                <label>User Name:</label>
                <span><%= intern.getName() %></span>
            </div>
            <div class="profile-info">
                <label>User Points:</label>
                <span><%= intern.getPoints() %></span>
            </div>
        <% } else { %>
            <div class="null-message">
                <p>No data available.</p>
            </div>
        <% } %>

        <div class="submit-container">
            <form action="logout" method="post">
                <input type="submit" value="Logout" class="submit-button">
            </form>
        </div>
    </div>
</body>
</html>

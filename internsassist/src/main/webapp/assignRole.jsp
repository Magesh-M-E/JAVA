<%@page import="com.lxisoft.internassist.*"%>
<%@page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
  <title>Intern Details</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      margin: 0;
      padding: 0;
      background-color: #f0f0f0;
    }
    .container {
      max-width: 800px;
      margin: 0 auto;
      padding: 20px;
      background-color: #fff;
      border-radius: 10px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
    h1 {
      text-align: center;
      margin-bottom: 20px;
    }
    .intern-list {
      list-style: none;
      padding: 0;
      margin: 0;
    }
    .intern-item {
      background-color: #f9f9f9;
      border: 1px solid #ccc;
      border-radius: 5px;
      margin-bottom: 10px;
    }
    .intern-item td {
      padding: 10px;
      text-align: center;
    }
    .intern-item input[type="checkbox"] {
      margin-right: 5px;
    }
    .submit-button {
      display: block;
      width: 100%;
      padding: 10px 20px;
      background-color: #4CAF50;
      color: white;
      border: none;
      border-radius: 5px;
      cursor: pointer;
      transition: background-color 0.3s ease;
    }
    .submit-button:hover {
      background-color: #45a049;
    }
  </style>
</head>
<body>
  <div class="container">
    <%
        List<Internsassist> interns = (List<Internsassist>)request.getAttribute("interns");
    %>
    <ul class="intern-list">
      <form action="RoleAssigningCRUD" method="post">
        <table border="2">
            <tr>
              <th>Name</th>
              <th>Role</th>
            </tr>
            <% for (Internsassist intern : interns) { %>
                <h1><%=intern.getName()%> Details</h1>
            <tr class="intern-item">
              <td><%= intern.getName() %></td>
              <td>
                <select>
                    <option>Admin</option>
                    <option>Intern</option>
                </select>
              </td>
            </tr>
            <% } %>
        </table>   
      </form>
    </ul>
    <input type="submit" value="Submit" class="submit-button">
  </div>
</body>
</html>

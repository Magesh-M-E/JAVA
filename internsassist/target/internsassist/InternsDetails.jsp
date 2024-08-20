<%@page import="com.lxisoft.internassist.*"%>
<%@page import="java.util.*"%>

<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Intern Details</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      margin: 0;
      padding: 0;
      background-color: aqua;
    }
    .container {
      max-width: 800px;
      margin: 0 auto;
      padding: 20px;
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
      background-color: #fff; /* White background for each item */
      border: 1px solid #ccc;
      border-radius: 5px;
      margin-bottom: 10px;
    }
    .intern-item a {
      display: block;
      padding: 15px;
      text-decoration: none;
      color: #333; /* Text color */
      transition: background-color 0.3s ease; /* Smooth transition on hover */
    }
    .intern-item a:hover {
      background-color: #f0f0f0; /* Light gray background on hover */
    }
  </style>
</head>
<body>
  <div class="container">
    <h1>Interns Details</h1>
    <%
List<Internsassist> interns = (List<Internsassist>)request.getAttribute("interns");
%>
    <ul class="intern-list">
      <% for (Internsassist intern : interns) { %>
        <li class="intern-item">
            <a href="InternDetails?name=<%= intern.getName() %>"><%= intern.getName() %></a>
        </li>
      <% } %>
    </ul>
  </div>
</body>
</html>

<%@ page import="com.lxisoft.internsassist.Internsassist" %>
<%@ page import="java.util.*"%>
<html>
<head>
    <title>Admin Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            padding: 20px;
        }
        h2 {
            color: #333;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            border: 1px solid #ccc;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
    </style>
</head>
<body>
    <h2>Attendance Table</h2>
    <% List<Internsassist> list = (ArrayList<Internsassist>) request.getAttribute("list"); %>
    <table>
        <tr>
            <th>Attendance Id</th>
            <th>Mail_Id</th>
            <th>Present</th>
            <th>Date</th>
        </tr>
        <% for (Internsassist intern : list) { %>
        <tr>
            <td><%= intern.getSl_no() %></td>
            <td><%= intern.getMail_id() %></td>
            <td><%= intern.getAtendence() %></td>
            <td><%= intern.getDate() %></td>
        </tr>
        <% } %>
    </table>
</body>
</html>

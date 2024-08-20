<%@ page import ="java.util.*" %>
<%@ page import="com.lxisoft.internsassist.Internsassist" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Assigned Projects</title>
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
    <h2>Projects assigned to ${username}</h2>
    <%List<Internsassist> listt = (ArrayList<Internsassist>) request.getAttribute("in");%>
    <table >
            <tr>
                <th>Sl_No</th>
                <th>Project Name</th>
            </tr>

                 <%
                    for(Internsassist li:listt)
                    {%>
                <tr>
                    
                    <td><%= li.getSl_no() %></td>
                    <td><%= li.getProjectName() %></td>
                 
                </tr>
                <%}%>
          
    </table>
</body>
</html>

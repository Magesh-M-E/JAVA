<%@ page import="java.util.ResourceBundle" %>
<%@ page session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign Up</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
            background-color: #333333; /* Dark grey background */
            color: #ffffff; /* White text */
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .container {
            width: 400px; /* Equal size to the signup page */
            padding: 20px;
            background-color: #6abf69; /* Light green */
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            position: relative; /* To position the language switch */
        }

        input[type="text"],
        input[type="password"],
        input[type="email"] 
        {
            width: calc(100% - 20px);
            padding: 15px;
            margin: 10px 0 20px 0;
            border: none;
            border-radius: 8px;
            background-color: #4d4d4d; /* Dark grey input background */
            color: #ffffff; /* White text */
            box-sizing: border-box;
        }

        input[type="submit"] {
            background-color: #4d4d4d; /* Dark grey button */
            color: #ffffff; /* White text */
            padding: 15px 20px;
            margin: 10px 0;
            border: none;
            border-radius: 8px;
            cursor: pointer;
            width: calc(100% - 20px);
        }

        input[type="submit"]:hover {
            background-color: #333333; /* Darker grey on hover */
        }

        .forgot-password a {
            color: #ffffff; /* White text */
            text-decoration: none;
        }

        .forgot-password a:hover {
            text-decoration: underline;
        }

        .language-switch {
            position: absolute;
            top: 10px;
            right: 20px;
        }

        .language-dropdown {
            background-color: transparent; /* No background color */
            border: none;
            color: #ffffff; /* White text */
            padding: 10px;
            border-radius: 8px;
            cursor: pointer;
        }

        .language-dropdown:hover {
            background-color: #333333; /* Darker grey on hover */
        }

        .language-options {
            display: none;
            position: absolute;
            top: 40px;
            right: 0;
            background-color: #4d4d4d; /* Dark grey dropdown background */
            border-radius: 8px;
            padding: 10px;
            z-index: 1;
        }

        .language-options a {
            display: block;
            color: #ffffff; /* White text */
            text-decoration: none;
            padding: 5px 0;
        }

        .language-options a:hover {
            background-color: #333333; /* Darker grey on hover */
        }

        .fas {
            margin-right: 5px;
        }
    </style>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <script>
        function toggleLanguageOptions() {
            var options = document.getElementById('languageOptions');
            if (options.style.display === 'none' || options.style.display === '') {
                options.style.display = 'block';
            } else {
                options.style.display = 'none';
            }
        } 
    </script>
</head>
<body>
    <div class="container">
        <c:choose>
            <c:when test="${empty language}">
                <form name="signupForm" action="mainServlet" method="post">
                    <h2>Sign Up</h2>
                    
                    <input type="email" name="gmail" placeholder="Gmail"><br>
                    <input type="text" name="username" placeholder="Username"><br>
                    <input type="password" name="password" placeholder="Password"><br>
            
                    <% 
                        String passwordError = (String)request.getAttribute("error");
                        if (passwordError != null) {
                    %>
                        <span style="color: red;"><%= passwordError %></span><br>
                    <% } %>
            
                    <input type="submit" value="Sign Up">
                    <div class="login-link">
                        <span>Already have an account? </span><a href="login.jsp">Login</a>
                    </div>
                </form>
            </c:when>
            <c:otherwise>
                <form name="signupForm" action="mainServlet" method="post">
                    <h2><c:out value="${language['signup']}"/></h2>
                    
                    <input type="email" name="gmail" placeholder="<c:out value="${language['gmail']}"/>"><br>
                    <input type="text" name="username" placeholder="<c:out value="${language['username.label']}"/>"><br>
                    <input type="password" name="password" placeholder="<c:out value="${language['password.label']}"/>"><br>
            
                    <% 
                        String password = (String)request.getAttribute("error");
                        if (password != null) {
                    %>
                        <span style="color: red;"><%= password %></span><br>
                    <% } %>
            
                    <input type="submit" value="<c:out value="${language['signup']}"/>">
                    <div class="login-link">
                        <span><c:out value="${language['haveAccount']}"/></span><a href="login.jsp"><c:out value="${language['login.button']}"/></a>
                    </div>
                </form>
            </c:otherwise>
        </c:choose>
        <div class="language-switch">
            <button class="language-dropdown" onclick="toggleLanguageOptions()">
                <i class="fas fa-globe"></i> <!-- Font Awesome globe icon -->
                Language
            </button>
            <div class="language-options" id="languageOptions">
                <a href="LocaleServlet?lang=loginml">Malayalam</a>
                <a href="LocaleServlet?lang=loginen">English</a>
            </div>
        </div>
    </div>
</body>
</html>

<%@ page session="true" %>
<%@ page import="java.security.Principal" %>

<!DOCTYPE html>
<html>
<head>
  <title>Hi</title>

  <style>
    /* Profile image styles (not used in this case) */
    .profile-img {
      /* ... (remove styles) */
    }

    /* Dropdown styles */
    .dropdown {
      position: relative;
      display: inline-block;
    }

    .dropdown-content {
      display: none;
      position: absolute;
      background-color: #f1f1f1;
      min-width: 160px;
      box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
      z-index: 101; /* Higher than profile image */
    }
    .content-area {
    float: right;
    width: 20px;  /* Adjust width as needed */
    }

    .dropdown-content a {
      color: rgb(5, 0, 0);
      padding: 12px 16px;
      text-decoration: none;
      display: block;
      position: relative;
      left: 30px;
    }

    .dropdown:hover .dropdown-content {
      display: block; /* Show dropdown on hover */
    }
    .profile-container {
    display: inline-block; /* Allow elements to float side-by-side */
  }
#content{

  position: relative;
  right:150px;
  bottom: 190px;
}
    .profile-img {
    width: 60px;
    height: 60px;
    position: relative;
    bottom: 170px;
    right: 38px;
    border-radius: 80%;
    border: 2px solid #6abf69;
    z-index: 100;
  }
  </style>

</head>

<body style="background-color: #333333; color: #f5f5f5;">
    <div class="content-area">
        <div class="dropdown">
          <a href="profile" style="text-decoration: none;">
            <img   src="OIP.jpg" alt="Profile Image" class="profile-img">
            <i class="fa fa-user" style="color: #333; font-size: 18px;"></i>
          </a>
          <div id="content" class="dropdown-content">
            <a href="profile">Profile</a>
            <a href="logout">Settings</a>
            <a href="logout">Logout</a>
          </div>
        </div>
      </div>

  <% Principal principal = request.getUserPrincipal();
     String username = (principal != null) ? principal.getName() : "Guest"; %>

  <h1 style="text-align: center; margin-top: 200px;">Hi <%= username %> &#128075</h1>
</body>
</html>


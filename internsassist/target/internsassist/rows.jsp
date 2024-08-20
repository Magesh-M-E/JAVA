<%@ page session="true" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Navigation</title>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        background: #333333; /* Dark grey background */
    }

    .container {
        display: flex;
        position: relative;
        flex-direction: column;
        align-items: center;
        justify-content: center;
        height: 100vh;
        background-color: #333333; /* Dark grey background */
    }

    h2 {
        color: #6abf69; /* Light green heading color */
        margin-left: 10px;
        font-family: cursive;
        text-shadow: 2px 2px 2px #333333; /* Dark grey text shadow */
    }

    .row {
        display: flex;
        align-items: center;
        justify-content: center;
        width: 300px;
        height: 60px;
        box-shadow: 2px 3px 3px rgba(0, 0, 0, 0.5); /* Dark shadow */
        margin-bottom: 10px;
        background-color: #6abf69; /* Light green color */
        border-radius: 5px;
        color: #fff;
        text-decoration: none;
    }

    .row:nth-child(even) {
        background-color: #424242; /* Dark grey color for even rows */
    }

    .emoji {
        margin-right: 10px;
    }

    .logout-form {
        position: absolute;
        bottom: 10px;
        left: 10px;
    }

    .submit-button {
        background-color: transparent; /* No background color */
        border: none;
        color: #6abf69; /* Light green font color */
        padding: 10px 20px;
        cursor: pointer;
        font-size: 16px;
        text-decoration: underline;
    }

    .submit-button:hover {
        color: #5aad5d; /* Slightly darker green on hover */
    }

    .logout-icon {
        margin-right: 10px;
    }
</style>
<script>
    function confirmLogout(event) {
        if (!confirm("Are you sure you want to logout?")) {
            event.preventDefault();
        }
    }
</script>
</head>
<body>

    <div class="container">
        <h2 id="h2" style="text-shadow:2px;">InternAssist </h2>
                <a href="#" target="f2" class="row">
                    <span class="emoji">&#128200;Dashboard</span>
            
                </a>
            <% 
            boolean isIntern = request.isUserInRole("intern");
          
            boolean isAdmin = request.isUserInRole("admin");

            boolean isGroupCoordinator = request.isUserInRole("gc");
          
            if(isAdmin){%>
              
                <a href="/internsassist/admin" target="f2" class="row">
                    <span>&#x1F4C5;Attendance</span>  
            </a>
        
            <a href="/internsassist/gitAdmin" target="f2" class="row">
                <span>&#128640;Git Pushes</span>      
              </a>
              
                <a href="/internsassist/leaderBoardd" target="f2" class="row">
                    <div>
                    <span>&#127942;Rewards</span>   
                </div>
                 </a>    
             
           <% }
          
          
           else if(isIntern){
            %>
             
              <a href="attendence.jsp" target="f2" class="row">
                <span>&#x1F4C5;Attendance</span> 
          <a href="GitInput.jsp" target="f2" class="row">
            <span>&#128640;Git Pushes</span>    
            </a>
              <a href="leaderBoard" target="f2" class="row">
            <div>
                <span>&#127942;Rewards</span>
            </div>  </a>
            
          <%}
          
          
          else{
          %>
           
            <a href="/internsassist/admin" target="f2" class="row">
                <span>&#x1F4C5;Attendance</span> 
          </a>
          <a href="/internsassist/gitAdmin" target="f2" class="row">
            <span>&#128640;Git Pushes</span>  
          </a>
            <a href="leaderBoard" target="f2" class="row">
                <div>
                <span>&#127942;Rewards</span> </div> </a>          
        </div>
          <% }%>

          <div class="submit-container">
            <form action="logout" method="post" class="logout-form" onsubmit="confirmLogout(event)">
                <span class="logout-icon">&#x1F512;</span> <!-- Lock emoji as logout icon -->
                <input type="submit" value="Logout" class="submit-button">
            </form>
    
        </div>
</body>
</html>
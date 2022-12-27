<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>Send message</title>
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    </head>

    <body class="w3-light-grey">
        <div class="w3-container w3-blue-grey w3-opacity w3-left-align">
            <h1>Messanger</h1>
        </div>
        <div class="w3-container w3-padding">
            <div class="w3-card-4">
                <div class="w3-container w3-center w3-green">
                    <h2>Form message</h2>
                </div>
                <form method="post" action ="${pageContext.request.contextPath}/api/message" class="w3-selection w3-light-grey w3-padding">
                    <label>For user:
                        <input type="text" name="forUser" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
                    </label>
                    <label>Message content:
                        <input type="text" name="message" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
                    </label>
                    <button type="submit" class="w3-btn w3-green w3-round-large w3-margin-bottom">Send</button>
                </form>
            </div>
        </div>
    </body>
</html>
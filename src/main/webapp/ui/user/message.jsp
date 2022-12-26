<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="by.it_academy.jd2.Mk_JD2_95_22.core.dto.UserDTO" %>
<%@ page import="by.it_academy.jd2.Mk_JD2_95_22.core.dto.MessageDTO" %>
<%@ page import="by.it_academy.jd2.Mk_JD2_95_22.dao.fabrics.MessageDaoSingleton" %>
<%@ page import="by.it_academy.jd2.Mk_JD2_95_22.servise.MessageService" %>
<%@ page import="by.it_academy.jd2.Mk_JD2_95_22.servise.api.IMessageService" %>
<%@ page import="by.it_academy.jd2.Mk_JD2_95_22.servise.fabrics.UserServiceSingleton" %>
<%@ page import="javax.servlet.ServletException" %>
<%@ page import="javax.servlet.annotation.WebServlet" %>
<%@ page import="javax.servlet.http.HttpServlet" %>
<%@ page import="javax.servlet.http.HttpServletRequest" %>
<%@ page import="javax.servlet.http.HttpServletResponse" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="java.io.IOException" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
    private static final String MY_LOGIN = "login";
    private static final String FOR_USER = "forUser";

    private HttpSession session;

    private final IMessageService messageService = new MessageService(MessageDaoSingleton.getInstance(), UserServiceSingleton.getInstance());
%>

<html>
    <head>
        <title>Form message</title>
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    </head>

    <body class="w3-light-grey">
        <div class="w3-container w3-blue-grey w3-opacity w3-left-align">
            <h1>Messanger</h1>
        </div>

        <div class="w3-container w3-padding">
            <%
                if (request.getAttribute("login") != null) {
                    out.println("<div class=\"w3-panel w3-green w3-display-container w3-card-4 w3-round\">\n" +
                            "   <span onclick=\"this.parentElement.style.display='none'\"\n" +
                            "   class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-green w3-border w3-border-green w3-hover-border-grey\">×</span>\n" +
                            "   <h5>User '" + request.getAttribute("userName") + "' added!</h5>\n" +
                            "</div>");
                }
            %>
            <div class="w3-card-4">
                <div class="w3-container w3-center w3-green">
                    <h2>Form message</h2>
                </div>
                <form method="post" action="/api/message" class="w3-selection w3-light-grey w3-padding">
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
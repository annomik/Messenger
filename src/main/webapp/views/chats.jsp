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
    private static final String MY_LOGIN = "user";
    private HttpSession session;
    private final IMessageService messageService = new MessageService(MessageDaoSingleton.getInstance(), UserServiceSingleton.getInstance());
%>

<html>
    <head>
        <meta charset="UTF-8">
        <title>Messager</title>
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    </head>

    <body class="w3-light-grey">

        <div>
            <div>
                <div class="w3-container w3-blue-grey w3-opacity w3-left-align">
                    <h2>Chats</h2>
                </div>
                <%
                    String param = request.getParameter(MY_LOGIN);

                    if(param == null){
                                session = request.getSession();
                                if(!session.isNew()){
                                    param = (String)session.getAttribute(MY_LOGIN);
                                }
                            }
                    if(param == null){
                                throw new IllegalArgumentException("Один из параметров не передан в сессии!");
                            };

                    session = request.getSession();
                    String login = param;
                    List<MessageDTO> myMessanges = messageService.getMessageForUser(login);

                            if(myMessanges.size() > 0){
                                out.println("<p>Для пользователя " + login + " имеются следующие сообщения:</p>");
                                out.println("<ul class=\"w3-ul\">");
                                for (MessageDTO myMessange : myMessanges) {
                                    out.println("<p>><span style='color: red;'>" +
                                            "Сообщение от пользователя:" + myMessange.getFromUser()
                                            + " дата сообщения: " + myMessange.getDate() +  "!</span></p>");

                                    out.println("<li class=\"w3-hover-sand\">" + myMessange.getMessage() + "</li>");
                                }
                                out.println("</ul>");
                            }else {
                                out.println("<p>Для пользователя " + login + " нету сообщений!</p>");
                            }
                %>
            </div>
        </div>

    </body>
</html>


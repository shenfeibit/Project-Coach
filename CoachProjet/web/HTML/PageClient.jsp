<%-- 
    Document   : PageClient
    Created on : 2 avr. 2019, 16:19:05
    Author     : 21511708
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Show Profile</title>
        <link rel="stylesheet" href="CSS/Style.css" type="text/css" />
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script type="text/JavaScript" src="JS/ShowProgCliJs.js"></script>
    </head>
    <body>
        <%
            String idCli = (String) session.getAttribute("idC");
        %>
         <div>
            <div id="image"></div>
            <div id="descp">
                <p>the informations of the client</p>
                <input type="hidden" id="idClient" value="<%=idCli%>">
            </div>
            <div id="objectif"></div>
        </div>
        
        <div id="nameProg"></div>
        <div id='barOneLine'></div>
        <div id="descripPP"></div>
        <!-- Vertical Timeline -->
        <section id="conference-timeline">
          <div class="timeline-start">Start</div>
          <div class="conference-timeline-content">
              <table>
                  <tr>
                      <td class='tableLine'></td>
                      <td></td>
                  </tr>
              </table>
        <!-- Article -->
        <div id="tableSP" class="clientColor"></div>
        </div>
        <div class="timeline-end">End</div>
        </section>
    </body>
</html>

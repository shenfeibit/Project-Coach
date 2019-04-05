<%-- 
    Document   : EndSeancejsp
    Created on : 4 avr. 2019, 18:19:46
    Author     : 21611924
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>End Seance</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<link rel="stylesheet" href="CSS/StyleBeginSeance.css" type="text/css" />
        <script type="text/JavaScript" src="FunctionEndSeance"></script>
    </head>
    <body>
        <%
            String idSea = request.getParameter("idSea");
            out.println("<input type='hidden' id='idSea' value='"+idSea+"'>");
        %>
        
        <div class="header">
            <h1 id="nameSea">name of the seance</h1>
        </div>
        <h2>Félicitation, vous avez bien fait !</h2>
        <div id='res_performance'></div>
    </body>
</html>

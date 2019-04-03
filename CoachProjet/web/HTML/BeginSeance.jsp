<%-- 
    Document   : BeginSeance
    Created on : 3 avr. 2019, 11:36:46
    Author     : 21611943
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Begin Seance</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<link rel="stylesheet" href="CSS/Style.css" type="text/css" />
        <script type="text/JavaScript" src="JS/ExePerso.js"></script>
    </head>
    <body>
        <%
            String idSea = request.getParameter("idSea");
            out.println("<input type='hidden' id='idSea' value='"+idSea+"'>");
        %>
        <div id="nomSea">
            <div class="header">
                <h2 id="nameSea">name of the seance</h2>
                <div class="progress-container">
                    <div class="progress-bar" id="myBar"></div>
                </div>
            </div>
        </div>
        <div id="seance">
            
            <div id="buttonleft">
                <input id="btn_Left" class="btnLeftRight" type="button" value="<" />
            </div>
            
            <div id="exercise">
                <p>name of the exercise</p>
                <p>description of the exercise</p>
            </div>  
            
            
            
            <div id="buttonright">
                <input id="btn_Right" class="btnLeftRight" type="button" value=">" />
            </div>
        </div>
        
        <div id="performance">
                <h1>performance : </h1>
                <table border="0">
                    <tr>
                        <td><div id="easy"><input type="image"  src="IMAGE/performance/easy.png" width ="150" alt="image easy"/></div></td>
                        <td><div id="normal"><input type="image"  src="IMAGE/performance/normal.png" width ="150" alt="image easy"/></div></td>
                        <td><div id="hard"><input type="image"  src="IMAGE/performance/hard.png" width ="150" alt="image easy"/></div></td>
                    </tr>
                </table>
            </div>
            
            <div id="chrono"><h1>chrono : </h1></div>
        
    </body>
</html>

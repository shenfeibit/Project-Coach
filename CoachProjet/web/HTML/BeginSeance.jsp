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
	<link rel="stylesheet" href="CSS/StyleBeginSeance.css" type="text/css" />
        <script type="text/JavaScript" src="JS/ExePerso.js"></script>
    </head>
    <body>
        <%
            String idSea = request.getParameter("idSea");
            out.println("<input type='hidden' id='idSea' value='"+idSea+"'>");
        %>
        
        <div class="header">
            <h1 id="nameSea">name of the seance</h1>
        </div>
        
        <div id="seance">
            <div id="buttonleft">
                <input id="btn_Left" class="btnLeftRight" type="button" value="<" />
            </div>
            
            <div id="exercise">
                <h2 id="nameExercise">name of the exercise</h2>
                <div id="libExercise">description of the exercise</div>
                <div id="img_video"><input type="image"  src="IMAGE/performance/easy.png" width ="150" alt="image easy"/></div>
                <div>
                    <input class="btn_time" type="button" id="time_begin" value="begin">
                    <input class="btn_time" type="button" id="time_end" value="end">
                    <span id="time"></span><span id="time_out"></span>
                </div>
                <div id="performance">
                    <h1>Performance : </h1>
                    <table>
                        <tr>
                            <td><div id="easy"><input type="image"  src="IMAGE/performance/easy.png" width ="50" alt="image easy"/></div></td>
                            <td><div id="normal"><input type="image"  src="IMAGE/performance/normal.png" width ="50" alt="image easy"/></div></td>
                            <td><div id="hard"><input type="image"  src="IMAGE/performance/hard.png" width ="50" alt="image easy"/></div></td>
                        </tr>
                    </table>
                </div>
            </div>  
            
            <div id="buttonright">
                <input id="btn_Right" class="btnLeftRight" type="button" value=">" />
            </div>
        </div>
        
        
            
        
    </body>
</html>

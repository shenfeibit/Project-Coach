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
                <div id="clock"><span id="time_minute">0</span> : <span id="time_second">0</span></div>
                <span id="time_out"></span>
                <div>
                    <input class="btn_time" type="button" id="time_begin" value="begin">
                    <input class="btn_time" type="button" id="time_end" value="end">
                </div>
                <div id="performance">
                    <h3>How do you feel ? </h3>
                            <input type="radio" name="emotion" id="easy" class="input-hidden" />
                            <label for="easy">
                              <img src="IMAGE/performance/easy.png" alt="image easy"/>
                            </label>
                            <input type="radio" name="emotion" id="normal" class="input-hidden" />
                            <label for="normal">
                              <img src="IMAGE/performance/normal.png" alt="image normal"/>
                            </label>
                            <input type="radio" name="emotion" id="hard" class="input-hidden" />
                            <label for="hard">
                              <img src="IMAGE/performance/hard.png" alt="image hard"/>
                            </label>
                            
                </div>
                <input id="btn_finish" class="btn_time" type="button" value="Finish">
            </div>  
            
            <div id="buttonright">
                <input id="btn_Right" class="btnLeftRight" type="button" value=">" />
            </div>
        </div>
        
        
            
        
    </body>
</html>

<%-- 
    Document   : BeginSeance
    Created on : 3 avr. 2019, 11:36:46
    Author     : FEI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Begin Seance</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<link rel="stylesheet" href="CSS/StyleBeginSeance.css" type="text/css" />
        <script type="text/JavaScript" src="BilanExoDo"></script>
        
        <link href="CSS/bootstrap.min.css" rel="stylesheet" type="text/css">
        <!-- Fonts -->
        <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="CSS/animate.css" rel="stylesheet" />
        <!-- Squad theme CSS -->
        <link href="CSS/style2.css" rel="stylesheet">
        <link href="color/default.css" rel="stylesheet">
        <link rel="stylesheet" href="CSS/cssfreq.css" type="text/css" />

        
        
    </head>
    <body>
        <%
            String idSea = (String)session.getAttribute("idSea");
            out.println("<input type='hidden' id='idSea' value='"+idSea+"'>");
            out.println("<input type='hidden' name='idSea' value='"+idSea+"'>");
        %>
        
        <div>
            <h1 id="nameSea">name of the seance</h1>
        </div>
        
        <div id="seance">
            <div id="buttonleft">
            </div>
            
            <div id="exercise">
                <h2 id="nameExercise">name of the exercise</h2>
                <div id="libExercise">description of the exercise</div>
                <div id="img_video"><input type="image"  src="IMAGE/performance/easy.png" width ="150" alt="image easy"/></div>
                
                
                <div>
                    <h2>Nombre répétion et durée</h2>
                    <div>
                    <p>Durée réalisée</p>
                    <div id="clock"><span id="time_minute">0</span> : <span id="time_second">0</span></div>
                    <span id="time_out"></span>
                    <div>
                        <input class="btn_time" type="button" id="time_begin" value="begin">
                        <input class="btn_time" type="button" id="time_end" value="end">
                    </div>
                    </div>
                    <div>
                        <p>Nombre répetition réalisé</p>
                        <div class="form-group">
                            <input id="nbrep" type="text" class="" name="idRepet" placeholder="0"/>
                        </div>
                    </div>
                    <input type="button" id="suivant" class="btn_time" value="Suivant" />
                    <input type="button" id="Terminer" class="btn_time" value="Terminer" />
                
            </div>  
            
            <div id="buttonright">
            </div>
        </div>
        
        
            
        
    </body>
</html>

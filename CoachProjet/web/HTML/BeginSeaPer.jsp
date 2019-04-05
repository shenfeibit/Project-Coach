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
        <script type="text/JavaScript" src="JS/PerformanceMens.js"></script>
        
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
            String idSea = request.getParameter("idSea");
            out.println("<input type='hidden' id='idSea' value='"+idSea+"'>");
        %>
        
        <div>
            <h1 id="nameSea">name of the seance</h1>
        </div>
        
        <div id="seance">
            <div id="buttonleft">
                <input id="btn_Left" class="btnLeftRight" type="button" value="<" />
            </div>
            
            <div id="exercise">
                <div id="exe">
                <h2 id="nameExercise">name of the exercise</h2>
                <div id="libExercise">description of the exercise</div>
                <div id="img_video"><input type="image"  src="IMAGE/performance/easy.png" width ="150" alt="image easy"/></div>
                <div>
                    <input class="btn_time" type="button" id="time_begin" value="begin">
                    <input class="btn_time" type="button" id="time_end" value="end">
                    <span id="time"></span><span id="time_out"></span>
                </div>
                
                <div>
                    <h3>Nombre répétion et durée</h3>
                    <form action="ServletPerfBilan" method="GET">
                        <label class="control-label col-sm-2" for="email">Durée réalisée</label>            
                        <div class="form-group">
                            <input type="text" class="form-control" name="idDuree" placeholder="00" required/>
                        </div>
                        <label class="control-label col-sm-2" for="email">Nombre répetition réalisé</label>
                        <div class="form-group">
                            <input type="text" class="form-control" name="idRepet" placeholder="00*" required/>
                        </div>
                        
                        <div class="form-group">
                        <!--<input type="hidden" name="idCoachAccueil" value="1" />-->
                        <input type="submit" class="btnSubmitFreq" value="Suivant" />
                        </div>
                        <%
                            String avrtCl = (String) request.getAttribute("avrtPerf");
                            String errCl = (String) request.getAttribute("erreurReqBil");
                            if(avrtCl!=null)
                            out.println("<div class=\"form-group\"><a href=\"#\" class=\"ForgetPwd\">"+avrtCl+"</a></div>");
                            if(errCl!=null)
                            out.println("<div class=\"form-group\"><a href=\"#\" class=\"ForgetPwd\">"+errCl+"</a></div>");
                   
                        %>
                    </form>
                </div>
                </div>
                
                <div  id="freq">
                    <h3>Fréquence cardiaque</h3>
                    <form action="../ServletPerfBilan" method="GET">
                        <p>Fréquence 5 min allongé au calme :</p>            
                        <div class="form-group">
                            <input type="text" class="form-control" name="idCalme" placeholder="00" required/>
                        </div>
                        <label class="control-label col-sm-2" for="email">Fréquence après 30 flexions complètes en 45 sec </label>
                        <div class="form-group">
                            <input type="text" class="form-control" name="idFlex" placeholder="00*" required />
                        </div>
                        <label class="control-label col-sm-2" for="email">Fréquence 1 min après exercice allongé</label>
                        <div class="form-group">
                            <input type="text" class="form-control" name="idExAll" placeholder="00*" required/>
                        </div>
                        <div class="form-group">
                        <!--<input type="hidden" name="idCoachAccueil" value="1" />-->
                        <input type="submit" class="btnSubmitFreq" value="Enregistrer" />
                        </div>
                        <%
                            String avrtCli = (String) request.getAttribute("avrtPerf");
                            String errCli = (String) request.getAttribute("erreurReqBil");
                            if(avrtCl!=null)
                            out.println("<div class=\"form-group\"><a href=\"#\" class=\"ForgetPwd\">"+avrtCli+"</a></div>");
                            if(errCl!=null)
                            out.println("<div class=\"form-group\"><a href=\"#\" class=\"ForgetPwd\">"+errCli+"</a></div>");
                        %>
                    </form>
                </div>
            
            </div>  
            
            <div id="buttonright">
            </div>
        </div>
        
        
            
        
    </body>
</html>

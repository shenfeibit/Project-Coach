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
        
        <div>
            <h1 id="nameSea">name of the seance</h1>
        </div>
        
        <div id="seance">
            <div id="buttonleft">
                
            </div>
            
            <div id="exercise">
                
                <div  id="freq">
                    <h3>Fréquence cardiaque</h3>
                    <form action="ServletPerfBilan" method="GET">
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
                        <%
                            String idSea = (String)session.getAttribute("idSea");
                            out.println("<input type='hidden' name='idSea' value='"+idSea+"'>");
                        %>
                        <input type="submit" class="btnSubmitFreq" value="Enregistrer" />
                        </div>
                        <%
                            String avrtCli = (String) request.getAttribute("avrtPerf");
                            String errCli = (String) request.getAttribute("erreurReqBil");
                            if(avrtCli!=null)
                            out.println("<div class=\"form-group\"><a href=\"#\" class=\"ForgetPwd\">"+avrtCli+"</a></div>");
                            if(errCli!=null)
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

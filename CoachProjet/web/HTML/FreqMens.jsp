<%-- 
    Document   : FreqMens
    Created on : 4 avr. 2019, 11:46:19
    Author     : 21511708
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       <title>Frequence cardiaque mensuration</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<link rel="stylesheet" href="../CSS/StyleBeginSeance.css" type="text/css" />
        <script type="text/JavaScript" src="../JS/ExePerso.js"></script>
        
        <link href="../CSS/bootstrap.min.css" rel="stylesheet" type="text/css">
        <!-- Fonts -->
        <link href="../font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="../CSS/animate.css" rel="stylesheet" />
        <!-- Squad theme CSS -->
        <link href="../CSS/style2.css" rel="stylesheet">
        <link href="../color/default.css" rel="stylesheet">
        
    </head>
    <body>
       
        <div class="container login-container">
            <div class="row">
                <div class="col-md-6 login-form-1">
                    <h3>Mensurations</h3>
                    <form action="../ServletMens" method="GET">
                        <label class="control-label col-sm-2" for="email">Bras :</label>            
                        <div class="form-group">
                            <input type="text" class="form-control" name="idBras" placeholder="00.00"/>
                        </div>
                        <label class="control-label col-sm-2" for="email">Poitrine :</label>
                        <div class="form-group">
                            <input type="text" class="form-control" name="idPoitrine" placeholder="00.00*" />
                        </div>
                        <label class="control-label col-sm-2" for="email">Tour de taille :</label>
                        <div class="form-group">
                            <input type="text" class="form-control" name="idTaille" placeholder="00.00*" />
                        </div>
                        <label class="control-label col-sm-2" for="email">Hanches :</label>
                        <div class="form-group">
                            <input type="text" class="form-control" name="idHanches" placeholder="00.00*" />
                        </div>
                        <label class="control-label col-sm-2" for="email">Cuisses :</label>
                        <div class="form-group">
                            <input type="text" class="form-control" name="idCuisses" placeholder="00.00*" />
                        </div>
                        <input type="hidden" name="idSea" value="19"/>
                        <div class="form-group">
                        <!--<input type="hidden" name="idCoachAccueil" value="1" />-->
                        <input type="submit" class="btnSubmitMens" value="Enregistrer" />                            
                        </div>
                        <%
                            String avrt = (String) request.getAttribute("avrtMensuration");
                            String err = (String) request.getAttribute("erreurReq");
                            if(avrt!=null)
                            out.println("<div class=\"form-group\"><a href=\"#\" class=\"ForgetPwd\">"+avrt+"</a></div>");
                            if(err!=null)
                            out.println("<div class=\"form-group\"><a href=\"#\" class=\"ForgetPwd\">"+err+"</a></div>");
                        %>
                    </form>
                </div>
                <div class="col-md-6 login-form-2">
                    <h3>Fréquence cardiaque</h3>
                    <form action="../ServletPerfBilan" method="GET">
                        <label class="control-label col-sm-2" for="email">Fréquence 5 min allongé au calme :</label>            
                        <div class="form-group">
                            <input type="text" class="form-control" name="idCalme" placeholder="00"/>
                        </div>
                        <label class="control-label col-sm-2" for="email">Fréquence après 30 flexions complètes en 45 sec </label>
                        <div class="form-group">
                            <input type="text" class="form-control" name="idFlex" placeholder="00*" />
                        </div>
                        <label class="control-label col-sm-2" for="email">Fréquence 1 min après exercice allongé</label>
                        <div class="form-group">
                            <input type="text" class="form-control" name="idExAll" placeholder="00*" />
                        </div>
                        <div class="form-group">
                        <!--<input type="hidden" name="idCoachAccueil" value="1" />-->
                        <input type="submit" class="btnSubmitFreq" value="Enregistrer" />
                        <input type="hidden" name="idSea" value="19"/>
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
        </div>
    </body>
</html>

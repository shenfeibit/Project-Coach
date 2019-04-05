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
        <script type="text/JavaScript" src="PerformanceMens"></script>
        
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
                <div id="mens">
                    <h3>Mensurations</h3>
                    <form action="ServletMens" method="GET">
                        <label class="control-label col-sm-2" for="email">Bras :</label>            
                        <div class="form-group">
                            <input type="text" class="form-control" name="idBras" placeholder="00.00" required/>
                        </div>
                        <label class="control-label col-sm-2" for="email">Poitrine :</label>
                        <div class="form-group">
                            <input type="text" class="form-control" name="idPoitrine" placeholder="00.00*" required/>
                        </div>
                        <label class="control-label col-sm-2" for="email">Tour de taille :</label>
                        <div class="form-group">
                            <input type="text" class="form-control" name="idTaille" placeholder="00.00*" required/>
                        </div>
                        <label class="control-label col-sm-2" for="email">Hanches :</label>
                        <div class="form-group">
                            <input type="text" class="form-control" name="idHanches" placeholder="00.00*" required/>
                        </div>
                        <label class="control-label col-sm-2" for="email">Cuisses :</label>
                        <div class="form-group">
                            <input type="text" class="form-control" name="idCuisses" placeholder="00.00*" required/>
                        </div>
                        <div class="form-group">
                        <%
                            String idSea = request.getParameter("idSea");
                            out.println("<input type='hidden' id='idSea' value='"+idSea+"'>");
                            out.println("<input type='hidden' name='idSea' value='"+idSea+"'>");
                        %>
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
                
            </div>  
            
            <div id="buttonright">
            </div>
        </div>
        
        
            
        
    </body>
</html>

<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <!-- the head of the page which identify the style and javascript-->
    <head>
        <!-- the title of the page-->
        <title>Coach</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<link rel="stylesheet" href="CSS/Style.css" type="text/css" />
        <script type="text/JavaScript" src="JS/tableauBord.js"></script>
</head>
    <body>
        <!--the part of acueil page, shows the table of clients in programm and in wait line-->
        <div id="listeCli">
            <div class="header">
                <h2>Tableau de bord clients</h2>
                
                <div class="progress-container">
                    <div class="progress-bar" id="myBar"></div>
                </div>
            </div>
            
            <div class="form-group">
            <label for="email">Rechercher par nom :</label>
            <input type="email" class="form-control" id="saisieNom">
            <div id="zoneaff" class="form-control"></div>
            </div>
            
            
            <div id="contentcli">
                <!--the table shows the clients in programme-->
                <div id="cliProg"></div>
                <!--the table shows the clients in wait line-->
                <div id="cliNoProg"></div>
            </div>
        </div>
        
        <!--the part of basic informations of the client-->
        <div id="detailCli">
            <div><input id="idClient" type="text" value="" /></div>
            <div>
                <div id="image"></div>                
                <div id="descp"><p>the informations of the client</p></div>
                <div id="evoluation"></div>
            </div>
        </div>
        
        <!--the part of search program standard (possible with type)-->
        <div id='chercherProg'>
            Type <select id="typeProg" class="selectOption"><option></option></select>
            Programme <select id="nomProg" class="selectOption"><option></option></select>
        </div>
        
        <!--the part of information of program of client-->
        <div id="progcli">
            <div id="nameProg"></div>
            <div id='barOneLine'></div>
            <div id="descripPP"></div>
        </div>
        
        <!--the details of program person with the seances-->
        <div id="detailProg">
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
            <!-- the part of informations of seances (from javascript) -->
            <div id="tableSP"></div>
            </div>
                <div class="timeline-end">End</div>
            </section>            
        </div>
        
        <form action="AccueilJd" method="GET">
            <div class="form-group">
                <!--<input type="hidden" name="idCoachAccueil" value="1" />-->
                <input type="submit" class="btn btn-warning" value="Deconnexion" />                            
            </div>
        </form>
        
        <!--the button for affect a program to a client-->
        <div id="affecter"><input class="l_btn" type="button" value="Affecter" /></div>
        
        <!--the button for turn back to the previous page-->
        <div id="bt_ctrl_back"> <input class="l_btn" type="button" value="Back" /></div>
    </body>
</html>

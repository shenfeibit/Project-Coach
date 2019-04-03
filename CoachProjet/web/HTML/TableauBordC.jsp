<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>Coach</title>
	<link rel="stylesheet" href="CSS/Style.css" type="text/css" />
        <script type="text/JavaScript" src="JS/tableauBord.js"></script>
</head>
    <body>
        
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
                <div id="cliProg"></div>
                <div id="cliNoProg"></div>
            </div>
        </div>

        
        <div id="detailCli">
            <div><input id="idClient" type="text" value="" /></div>
            <div>
                <div id="image"></div>
                
                <div id="descp"><p>the informations of the client</p></div>
                <div id="objectif"><h1>Objectif</h1><p id="libobj">client's objectif</p></div>
            </div>
        </div>
        
        <div id='chercherProg'>
            Type <select id="typeProg" class="selectOption"><option></option></select>

            Programme <select id="nomProg" class="selectOption"><option></option></select>

        </div>
        
        <div id="progcli">
            <div id="nameProg"></div>
            <div id='barOneLine'></div>
            <div id="descripPP"></div>
        </div>
        
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
                <!-- Article -->
            <div id="tableSP"></div>
            </div>
              <div class="timeline-end">End</div>
            </section>
             
        </div>
        
        <div id="affecter"><input type="button" value="affecter" /></div>
        
        
        <div id="bt_ctrl_back"> <input id="bt_back" type="button" value="back to the menu" /></div>
    </body>
</html>

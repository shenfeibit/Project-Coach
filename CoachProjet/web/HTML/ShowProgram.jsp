<!DOCTYPE html>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>AssignProgramme</title>
	<link rel="stylesheet" href="../CSS/Style.css" type="text/css" />
        <script type="text/JavaScript" src="../JS/tableauBord.js"></script>
        <script type="text/JavaScript" src="../JS/FonctionJs.js"></script>
</head>

<body>
    
	<div>
            <div id="image"></div>
            <div id="descp"><p>the informations of the client</p></div>
            <div id="objectif"><h1>Objectif</h1><p id="libobj">client's objectif</p></div>
        </div>
        <div id='barOneLine'>
            Type <select id="typeProg" class="selectOption"><option></option></select>

            Programme <select id="nomProg" class="selectOption"><option></option></select>

        </div>
        
    <a href="../ServletObjectifs">objGo</a>
    <a href="../ServletProgObjectif">objGo</a>
    <a href="../ServletClientEnPgrm">objGopgr</a>
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
            <div id="tableSS"></div>
            <!-- // Article -->
          </div>
          <div class="timeline-end">End</div>
        </section>


</body>
</html>

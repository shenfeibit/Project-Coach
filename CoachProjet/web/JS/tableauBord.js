//show the list of all the clients which have a programme
function showIdCliP ()
    { 
        //hide the first page
        document.getElementById("detailCli").style.display = "none";
        document.getElementById("chercherProg").style.display = "none";
        document.getElementById("detailProg").style.display = "none";
        document.getElementById("progcli").style.display = "none";
        document.getElementById("bt_ctrl_back").style.display = "none";
        document.getElementById("affecter").style.display = "none";
        //show the new page
        document.getElementById("listeCli").style.display = "block";  
        
        //create a requery with a value entry
        var xhr = new XMLHttpRequest();
	xhr.open("GET","ServletClientEnPgrm");
       

	xhr.onload = function()
            {
		if (xhr.status === 200)
                    {
                        //if it successed
                        var rep = xhr.responseXML;
                        //get all the info of clients from servelet
                        var l_obj=rep.getElementsByTagName("client");
                        var texte="<div class='content_liste_client'><h2>"+l_obj.length+" Clients on Programme</h2></div>";
                                for(var i=0;i<l_obj.length;i++){
                                var clip = l_obj[i].children;
                                    texte+="<div id=\"imagecl\"><div id='photocli'>"
                                            +clip[0].firstChild.nodeValue
                                            +"<br><input type=\"image\"  src=\"IMAGE/"
                                            +clip[4].firstChild.nodeValue
                                            +"\" width =\"50\" value='1' alt=\"See the detail\"/></div></div>";
                                    texte+="<div id=\"descpcl\">"+clip[1].firstChild.nodeValue
                                            +"<br>"+clip[2].firstChild.nodeValue+"</div>";
                                    texte+="<div id=\"objectifcl\"><span>"+clip[5].firstChild.nodeValue+"%</span>";
                                    texte += "<progress id='percentProg' max='100' value=" 
                                            +clip[5].firstChild.nodeValue+ "></progress>";
                                    texte+="</div>";
                        }
                        //put into html
                        var elt = document.getElementById("cliProg");
			elt.innerHTML = texte; 
                        
                        //add the event listener to jump to the page next withe the image chosed
                        var choix =  document.querySelectorAll("#photocli");
                        for (var i = 0; i<choix.length;i++){
                                choix[i].addEventListener("click",showinfoCli);
                                choix[i].addEventListener("click",affichePP);
                                choix[i].addEventListener("click",afficheProgression);
                            }
                    }
	};
        xhr.send();
    }
   
   
//show the list of all the clients which demand a programme
function showIdCliNonP ()
    { 
        var xhr = new XMLHttpRequest();
	xhr.open("GET","ServletClientNonPgrm");
       
	xhr.onload = function()
            {
		if (xhr.status === 200)
                    {
                        var rep = xhr.responseXML;
                        var l_obj=rep.getElementsByTagName("client");
                            var texte="<div class='content_liste_client'><h2>"+l_obj.length+" Clients on demande</h2></div>";
                            for(var i=0;i<l_obj.length ;i++){
                                var clip = l_obj[i].children;
                                    texte+="<div id=\"imagecl\"><div id='photocliNoProg'>"+clip[0].firstChild.nodeValue+"<br><input type=\"image\"  src=\"IMAGE/"+clip[4].firstChild.nodeValue+"\" width =\"50\" alt=\"See the detail\"/></div></div>";
                                    texte+="<div id=\"descpcl\">"+clip[1].firstChild.nodeValue+"<br>"+clip[2].firstChild.nodeValue+"</div>";
                                    texte+="<div id=\"objectifcl\">";
                                        var obj = clip[5].children;
                                        if(obj.length!==0){
                                            for (var j =0; j < obj.length; j++){
                                                texte += obj[j].firstChild.nodeValue + "</br>";                    
                                            }
                                        }
                                    texte += "</div>";
                            }
                       
                        var elt = document.getElementById("cliNoProg");
			elt.innerHTML = texte; 
                        var choix =  document.querySelectorAll("#photocliNoProg");
                        for (var i = 0; i<choix.length;i++){
                                choix[i].addEventListener("click",showinfoCli);
                                choix[i].addEventListener("click",showType);
                                choix[i].addEventListener("click",showProgramme);
                            }
                    }
	};
        xhr.send();
    };
    
    
//show all infomation about a client which has been chose
function showinfoCli ()
    {
        //hide the first page
       document.getElementById("detailCli").style.display = "block";
       document.getElementById("bt_ctrl_back").style.display = "block";
        
        
       //create a requery with a value entry
        var xhr = new XMLHttpRequest();
        var param = encodeURIComponent(this.firstChild.nodeValue);
	xhr.open("GET","ServletShowInfoCli?idc=" + param);
        
        xhr.onload = function(){
            //if the connect succees
            if (xhr.status === 200){
                
                //extract all the information of this client
                var nom = xhr.responseXML.getElementsByTagName("nom");
                var prenom = xhr.responseXML.getElementsByTagName("prenom");
                var sexe = xhr.responseXML.getElementsByTagName("sexe");
                var tele = xhr.responseXML.getElementsByTagName("tele");
                var email = xhr.responseXML.getElementsByTagName("email");
                var image = xhr.responseXML.getElementsByTagName("image");
                
                //change to format html
                var imageCli = "<img src=\"IMAGE/" 
                        + image[0].firstChild.nodeValue 
                        + "\" width =\"150\" alt=\"image of Client\"/>";
                var texte = nom[0].firstChild.nodeValue + " " 
                        + prenom[0].firstChild.nodeValue + "</br>" 
                        + sexe[0].firstChild.nodeValue + "</br>" 
                        + tele[0].firstChild.nodeValue + "</br>" 
                        + email[0].firstChild.nodeValue + "</br>" ;
                
                var l_obj = xhr.responseXML.getElementsByTagName("lib");
                var lib = "<p>";
                for (var i =0; i < l_obj.length; i++){       
                    lib += l_obj[i].firstChild.nodeValue + "</br>";                    
                }
                lib += "</p>";
                
                //show all the information
                var eltimage = document.getElementById("image");;
                eltimage.innerHTML = imageCli; 
                var eltdescp = document.getElementById("descp");
		eltdescp.innerHTML = texte; 
                var eltlib = document.getElementById("libobj");
		eltlib.innerHTML = lib;  
                var eltid = document.getElementById("idClient");
                eltid.value =param ;
                document.getElementById("listeCli").style.display = "none";
            };
	};
        xhr.send();
    }
   
//show the programme which a client has began to do
function affichePP ()
	{
            //hide the first page
            document.getElementById("progcli").style.display = "block";
            document.getElementById("detailProg").style.display = "block";
            document.getElementById("chercherProg").style.display = "none";
            // Object XMLHttpRequest.
            var xhr = new XMLHttpRequest();
            // requery with a value entry.
            var param = encodeURIComponent(this.firstChild.nodeValue);
            xhr.open("GET","ServletTableProg?idc=" + param);
            xhr.onload = function()
                    {
                    //if the connect succees
                    if (xhr.status === 200)
			{
                        //get the reponse of serveur
                        var rep = xhr.responseXML;
                        //for lib progPerso
                        var libPP = rep.getElementsByTagName("libPP");
                        var texteLibPP = libPP[0].firstChild.nodeValue;
                        
			// Elément html que l'on va mettre à jour.
			var eltLibPP = document.getElementById("nameProg");
                        //elt.innerHTML = xhr.responseXML;
                        eltLibPP.innerHTML = texteLibPP;
                        
                        //for descrip ProgPerso
                        var descripPP = rep.getElementsByTagName("descripPP");
                        var textDescripPP = descripPP[0].firstChild.nodeValue;
                        var eltDescripPP = document.getElementById("descripPP");
                        eltDescripPP.innerHTML = textDescripPP;
                        
                        //for seances
                        var l_sea = rep.getElementsByTagName("seancePerso");
                        var texteSea="";
                        for(var i=0;i<l_sea.length;i++){
                            var sea = l_sea[i].children;
                            texteSea+="<div class=\"timeline-article\">";
                            texteSea+="<div>";
                                texteSea+="<table>";
                                    texteSea+="<tr>";
                                        //show the name of the seance
                                        texteSea+="<td class='content-left'>"+sea[1].firstChild.nodeValue+"</td>";
                                        //show the description of the seance
                                        texteSea+="<td class='content-right'>"+sea[2].firstChild.nodeValue+"</td>";
                                    texteSea+="</tr>";
                                texteSea+="</table>";
                            texteSea+="</div>";
                            
                            //check the date to identify the style
                            if(sea[3].firstChild.nodeValue!="null"){
                                texteSea+="<div class=\"meta-date-pass\">";
                                texteSea+="<span class=\"date\">"+sea[0].firstChild.nodeValue+"</span>";
                            }
                            else{
                                texteSea+="<div class=\"meta-date\">";
                                texteSea+="<span class=\"date\">"+sea[0].firstChild.nodeValue+"</span>";
                            }
                            texteSea+="</div>";
                            texteSea+="</div>";
                        }
                        var eltSea=document.getElementById("tableSP");
                        eltSea.innerHTML=texteSea;
			}
		};
	// Envoie de la requête.
	xhr.send();
	}
        
//show progress    
function afficheProgression ()
	{
	// Object XMLHttpRequest.
	var xhr = new XMLHttpRequest();
	// requery with a value entry.
        var param = encodeURIComponent(this.firstChild.nodeValue);
	xhr.open("GET","ServletProgressionProg?idc=" + param);
	xhr.onload = function()
		{
		// if the query succes
		if (xhr.status === 200)
			{
                        //get the reponse of serveur
                        var rep = xhr.responseXML;
                        //for lib progPerso
                        var percent = rep.getElementsByTagName("percent");
                        var res = percent[0].firstChild.nodeValue;
                        var texte ="<span>"+res+"%</span>";
                            texte += "<progress id='percentProg' max='100' value=" + res + "></progress>";
                        var eltSea=document.getElementById("barOneLine");
                        eltSea.innerHTML=texte;
                        
			}
		};
	// send the query
	xhr.send();
	}
    
//this is the function help us back to the first page
function backToMenu ()
    {
        document.getElementById("chercherProg").style.display = "none";
        document.getElementById("detailProg").style.display = "none";
        document.getElementById("detailCli").style.display = "none";
        document.getElementById("progcli").style.display = "none";
        document.getElementById("bt_ctrl_back").style.display = "none";
        document.getElementById("affecter").style.display = "none";
        document.getElementById("listeCli").style.display = "block";
    }
    
    

    
function showType ()
    { 
        document.getElementById("chercherProg").style.display = "block";
        
        var xhr = new XMLHttpRequest();
	xhr.open("GET","ServletObjectifs");

	xhr.onload = function()
        
            {

		if (xhr.status === 200)
                    {//if connection is success
                        var rep = xhr.responseXML;
                        var l_obj=rep.getElementsByTagName("nom");
                        
                        var texte = "<option></option>";
                        
                        for(var i=0;i<l_obj.length;i++)
                        {
                            texte +="<option>"+ l_obj[i].firstChild.nodeValue+"</option>";
                        }
                        
                        var elt = document.getElementById("typeProg");
                        
			elt.innerHTML = texte;  
                    }
	
	};
        xhr.send();
} 
    //function which show the program
   function showProgramme ()
    { 
        document.getElementById("chercherProg").style.display = "block";
        var xhr = new XMLHttpRequest();
	xhr.open("GET","ServletProgrammeSt");
       

	xhr.onload = function()
        
            {

		if (xhr.status === 200)
                    {//if the connections is successed
                        var rep = xhr.responseXML;
                        
                        var pStandard = rep.getElementsByTagName("prog");
                        
                        var texte = "<option></option>";
                        
                        for(var i=0;i<pStandard.length;i++)
                        {
                            var pS = pStandard[i].children;
                            texte +="<option value=\""+pS[1].firstChild.nodeValue+"\">"+ pS[0].firstChild.nodeValue+"</option>";
                        }
                        
                        var elt = document.getElementById("nomProg");
                        
			elt.innerHTML = texte; 
                    }
	
	};
        xhr.send();
}
    
    //function  which show the objectifs +
    function l_clickObj ()
	{
            
                // Objet XMLHttpRequest.
	var xhr = new XMLHttpRequest();

        var objectif = document.getElementById("typeProg").value;
        
        if(objectif!==''){
	xhr.open("GET","ServletProgObjectif?nomObj="+objectif);
	// On précise ce que l'on va faire quand on aura reçu la réponse du serveur.
	xhr.onload = function()
		{
		if (xhr.status === 200)
			{//if connection is successed
                        var rep = xhr.responseXML;
                        
                        var pStandard = rep.getElementsByTagName("prog");
                        
                        var texte = "<option></option>";
                        
                        for(var i=0;i<pStandard.length;i++)
                        {
                            var pS = pStandard[i].children;
                            texte +="<option value=\""+pS[1].firstChild.nodeValue+"\">"+ pS[0].firstChild.nodeValue+"</option>";
                        }
                        
                        var elt = document.getElementById("nomProg");
                        
			elt.innerHTML = texte;
                        }               
		};
            
	xhr.send();
        }else{
            showProgramme();
        }
    }
    
    // function which shows the detail of program whith their seances
    function l_clickProg ()
	{
            document.getElementById("detailProg").style.display = "block";
            document.getElementById("affecter").style.display = "block";
                // Objet XMLHttpRequest.
	var xhr = new XMLHttpRequest();

        var idPS = document.getElementById("nomProg").value;
        
        if(idPS!==''){
	xhr.open("GET","ServletSeanceStandPs?idPS="+idPS);
	// On précise ce que l'on va faire quand on aura reçu la réponse du serveur.
	xhr.onload = function()
		{
		if (xhr.status === 200)
			{//if the connection is successed
                        var rep = xhr.responseXML;
			//for secances
                        var l_sea = rep.getElementsByTagName("seance");
                        var texteSea="";
                        for(var i=0;i<l_sea.length;i++){
                            var sea = l_sea[i].children;
                            texteSea+="<div class=\"timeline-article\">";
                            texteSea+="<div>";
                                texteSea+="<table>";
                                    texteSea+="<tr>";
                                        texteSea+="<td class='content-left'>"+sea[1].firstChild.nodeValue+"</td>";
                                        texteSea+="<td class='content-right'>"+sea[2].firstChild.nodeValue+"</td>";
                                    texteSea+="</tr>";
                                texteSea+="</table>";
                            texteSea+="</div>";
                            texteSea+="<div class=\"meta-date\">";
                            texteSea+="<span class=\"date\">"+sea[0].firstChild.nodeValue+"</span>";
                            texteSea+="</div>";
                            texteSea+="</div>";
                        }
                        var eltSea=document.getElementById("tableSP");
                        eltSea.innerHTML=texteSea;
                        }
                        
		};
            

	xhr.send();
        }else{
            showProgramme();
        }
    }
    //function affecter wgich return the program affect to the client
    function affecter (){
        var idProg = document.getElementById("nomProg").value;
        var idClient = document.getElementById("idClient").value;
        var xhr = new XMLHttpRequest();
        xhr.open("GET","ServletAffecter?idProg=" + idProg+"&idClient="+idClient);
        document.getElementById("affecter").disabled="true";
        xhr.send();
        
    }
      //the events corresponding for each function

        document.addEventListener("DOMContentLoaded", () => {
        window.addEventListener("load",showIdCliP);
        window.addEventListener("load",showIdCliNonP);
        document.getElementById("typeProg").addEventListener("change",l_clickObj);
        document.getElementById("nomProg").addEventListener("change",l_clickProg);
        document.getElementById("bt_back").addEventListener("click",backToMenu);
        document.getElementById("affecter").addEventListener("click",affecter);
        
});

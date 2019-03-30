//show the list of all the clients which have a programme
function showIdCliP ()
    { 
        
        var xhr = new XMLHttpRequest();
	xhr.open("GET","../ServletClientEnPgrm");
       

	xhr.onload = function()
        
            {
		if (xhr.status === 200)
                    {
                        var rep = xhr.responseXML;
                        var l_obj=rep.getElementsByTagName("client");
                        var texte="";
                                for(var i=0;i<l_obj.length;i++){
                                var clip = l_obj[i].children;
                                    texte+="<div id=\"imagecl\"><div id='photocli'>"+clip[0].firstChild.nodeValue+"<input type=\"image\"  src=\"../IMAGE/"+clip[4].firstChild.nodeValue+"\" width =\"50\" value='1' alt=\"See the detail\"/></div></div>";
                                    texte+="<div id=\"descpcl\"><p>"+clip[1].firstChild.nodeValue+"</p></div>";
                                    texte+="<div id=\"objectifcl\"><p >client's objectif</p></div>";
                            
                        }
                      
                        var elt = document.getElementById("cliProg");
			elt.innerHTML = texte; 
                        
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
    
function showinfoCli ()
    {
       document.getElementById("detailCli").style.display = "block";
        
       //create a requery with a value entry
        var xhr = new XMLHttpRequest();
        var param = encodeURIComponent(this.firstChild.nodeValue);
	xhr.open("GET","../ServletShowInfoCli?idc=" + param);
        
        xhr.onload = function(){
            //if the connect succees
            if (xhr.status === 200){
                
                //extract all the information
                var nom = xhr.responseXML.getElementsByTagName("nom");
                var prenom = xhr.responseXML.getElementsByTagName("prenom");
                var sexe = xhr.responseXML.getElementsByTagName("sexe");
                var tele = xhr.responseXML.getElementsByTagName("tele");
                var email = xhr.responseXML.getElementsByTagName("email");
                var image = xhr.responseXML.getElementsByTagName("image");
                
                //format html
                var imageCli = "<img src=\"../IMAGE/" + image[0].firstChild.nodeValue + "\" width =\"150\" alt=\"image of Client\"/>";
                var texte = nom[0].firstChild.nodeValue + " " +prenom[0].firstChild.nodeValue + "</br>" + sexe[0].firstChild.nodeValue + "</br>" + tele[0].firstChild.nodeValue + "</br>" + email[0].firstChild.nodeValue + "</br>" ;
              
                var l_obj = xhr.responseXML.getElementsByTagName("lib");
                var lib = "<p>";
                for (var i =0; i < l_obj.length; i++){       
                    lib += l_obj[i].firstChild.nodeValue + "</br>";                    
                }
                lib += "</p>";
                
                document.getElementById("listeCli").style.display = "none";
                //show all the information
                var eltimage = document.getElementById("image");;
                eltimage.innerHTML = imageCli; 
                var eltdescp = document.getElementById("descp");
		eltdescp.innerHTML = texte; 
                var eltlib = document.getElementById("libobj");
		eltlib.innerHTML = lib;  
                
             
            };
	};
        xhr.send();
    }
    
function affichePP ()
	{
	// Object XMLHttpRequest.
	var xhr = new XMLHttpRequest();
	// requery with a value entry.
        var param = encodeURIComponent(this.firstChild.nodeValue);
	xhr.open("GET","../ServletTableProg?idc=" + param);
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
                        
                        //for secances
                        var l_sea = rep.getElementsByTagName("seancePerso");
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
        
        
function afficheProgression ()
	{
	// Object XMLHttpRequest.
	var xhr = new XMLHttpRequest();
	// requery with a value entry.
        var param = encodeURIComponent(this.firstChild.nodeValue);
	xhr.open("GET","../ServletProgressionProg?idc=" + param);
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
    
function backToMenu ()
    {
        document.getElementById("detailCli").style.display = "none";
        document.getElementById("listeCli").style.display = "block";
        
    }
    
document.addEventListener("DOMContentLoaded", () => {
        window.addEventListener("load",showIdCliP);
        document.getElementById("bt_back").addEventListener("click",backToMenu);
        
        
});
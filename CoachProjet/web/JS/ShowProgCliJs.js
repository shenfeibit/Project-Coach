function affichePP ()
	{
	// Objet XMLHttpRequest.
	var xhr = new XMLHttpRequest();
	// Requête au serveur avec les paramètres éventuels.
	xhr.open("GET","../ServletTableProg");
	// On précise ce que l'on va faire quand on aura reçu la réponse du serveur.
	xhr.onload = function()
		{
		// Si la requête http s'est bien passée.
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
        
document.addEventListener("DOMContentLoaded", () => {
    window.addEventListener("load",affichePP);
});





function affichePP ()
	{
	// Objet XMLHttpRequest.
	var xhr = new XMLHttpRequest();
	// Requête au serveur avec les paramètres éventuels.
	xhr.open("GET","../TestServletTableProg");
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
			var eltLibPP = document.getElementById("libPP");
                        //elt.innerHTML = xhr.responseXML;
                        eltLibPP.innerHTML = texteLibPP;
                        
                        //for descrip ProgPerso
                        var descripPP = rep.getElementsByTagName("descripPP");
                        var textDescripPP = descripPP[0].firstChild.nodeValue;
                        var eltDescripPP = document.getElementById("descripPP");
                        eltDescripPP.innerHTML = textDescripPP;
                        
                        //for secances
                        var l_sea = rep.getElementsByTagName("seancePerso");
                        console.log("a");
                        var texteSea="";
                        console.log("a");
                        for(var i=0;i<l_sea.length;i++){
                            console.log("a");
                            var sea = l_sea[i].children; // tous les infos de seance
                            texteSea+="<p>-"+sea[0].firstChild.nodeValue+
                                    "/lib:"+sea[1].firstChild.nodeValue+
                                    "/descrip:"+sea[2].firstChild.nodeValue+"</p>";
                        }
                        var eltSea=document.getElementById("tableSP");
                        text="111"
                        eltSea.innerHTML=texteSea;
                        
			}
		};
	// Envoie de la requête.
	xhr.send();
	}
        
document.addEventListener("DOMContentLoaded", () => {
    window.addEventListener("load",affichePP);
});


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
                            console.log("inin");
                        //get the reponse of serveur
                        var rep = xhr.responseXML;
                        var libPP = rep.getElementsByTagName("libPP")[0].firstChild.nodeValue;
                        
			// Elément html que l'on va mettre à jour.
			var eltLibPP = document.getElementById("libPP");
                        //elt.innerHTML = xhr.responseXML;
                        var texte="<div>affiche</div>"
                        eltLibPP.innerHTML = texte;
			}
		};	
	// Envoie de la requête.
	xhr.send();
	}
        
document.addEventListener("DOMContentLoaded", () => {
    window.addEventListener("load",affichePP);
});


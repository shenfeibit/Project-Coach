
function showinfoCli ()
    { 
//      var idCli = document.getElementById("idc").value;   	
        var xhr = new XMLHttpRequest();
	xhr.open("GET","ServletShowInfoCli?idc=" + 1); // 1 va être changé à idCli
	xhr.onload = function()
            {
		if (xhr.status === 200)
                    {
                        var nom = xhr.responseXML.getElementsByTagName("nom");
                        var texte = nom[0].firstChild.nodeValue;
                        var elt = document.getElementById("descp");
			elt.innerHTML = texte;  
		};
	xhr.send();
	}
    } 
        
   



/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function enregistrerNBrepet ()
	{
	// Object XMLHttpRequest.
	var xhr = new XMLHttpRequest();
	// requery with a value entry.
	xhr.open("GET","../ServletrecupererNBrepet");
	xhr.onload = function()
        {
            if (xhr.status === 200){
                 var rep = xhr.responseXML;
                 
                 var nbr = rep.getElementsByTagName("nbr");
                 var nbrepet = document.getElementById("nbrepet");
                 nbrepet.innerHTML = nbr;
            }
        };
        xhr.send();
    }
    
    function enregistrerDuree ()
	{
	// Object XMLHttpRequest.
	var xhr = new XMLHttpRequest();
	// requery with a value entry.
	xhr.open("GET","../ServletrecupererDureereal");
	xhr.onload = function()
        {
            if (xhr.status === 200){
                 var rep = xhr.responseXML;
                 
                 var duree = rep.getElementsByTagName("duree");
                 var dureereal = document.getElementById("dureereal");
                 dureereal.innerHTML = duree;
            }
        };
        xhr.send();
    }
    document.addEventListener("DOMContentLoaded", () => {
    window.addEventListener("click",enregistrerNBrepet);
    window.addEventListener("click",enregistrerDuree);
});

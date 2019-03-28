function showType ()
    { 
        var xhr = new XMLHttpRequest();
	xhr.open("GET","../ServletObjectifs");
       

	xhr.onload = function()
        
            {

		if (xhr.status === 200)
                    {
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
    
    
    function showProgramme ()
    { 
        
        var xhr = new XMLHttpRequest();
	xhr.open("GET","../ServletProgrammeSt");
       

	xhr.onload = function()
        
            {

		if (xhr.status === 200)
                    {
                        var rep = xhr.responseXML;
                        var l_obj=rep.getElementsByTagName("nom");
                        
                        var texte = "";
                        
                        for(var i=0;i<l_obj.length;i++)
                        {
                            texte +="<option>"+ l_obj[i].firstChild.nodeValue+"</option>";
                        }
                        
                        var elt = document.getElementById("nomProg");
                        
			elt.innerHTML = texte;  
                    }
	
	};
        xhr.send();
    }
    
    
    function l_clickObj ()
	{
                // Objet XMLHttpRequest.
	var xhr = new XMLHttpRequest();

        var objectif = document.getElementById("typeProg").value;
        
        if(objectif!==''){
	xhr.open("GET","../ServletProgObjectif?nomObj="+objectif);
	// On précise ce que l'on va faire quand on aura reçu la réponse du serveur.
	xhr.onload = function()
		{
		if (xhr.status === 200)
			{
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
    
    function l_clickProg ()
	{
                // Objet XMLHttpRequest.
	var xhr = new XMLHttpRequest();

        var idPS = document.getElementById("nomProg").value;
        
        if(idPS!==''){
	xhr.open("GET","../ServletSeanceStandPs?idPS="+idPS);
	// On précise ce que l'on va faire quand on aura reçu la réponse du serveur.
	xhr.onload = function()
		{
		if (xhr.status === 200)
			{
                        var rep = xhr.responseXML;
                        console.log("1111");
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
                        var eltSea=document.getElementById("tableSS");
                        eltSea.innerHTML=texteSea;
                        }
                        
		};
            

	xhr.send();
        }else{
            showProgramme();
        }
    }
    
    
    document.addEventListener("DOMContentLoaded", () => {
        window.addEventListener("load",showType);
        document.getElementById("typeProg").addEventListener("change",l_clickObj);
        document.getElementById("nomProg").addEventListener("change",l_clickProg)
});

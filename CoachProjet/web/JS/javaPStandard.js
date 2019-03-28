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
                        
                        var pStandard = rep.getElementsByTagName("nom");
                        
                        var texte = "";
                        
                        for(var i=0;i<pStandard.length;i++)
                        {
                            texte +="<option>"+ pStandard[i].firstChild.nodeValue+"</option>";
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
    
    
    
    document.addEventListener("DOMContentLoaded", () => {
//        document.getElementById("typeProg").addEventListener("click",showType);
        window.addEventListener("load",showType);
        //window.addEventListener("load",showProgramme);
        document.getElementById("typeProg").addEventListener("change",l_clickObj);
});

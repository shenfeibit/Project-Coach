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
                        var lengthTab = l_obj.length;
                        
                        var texte = "<option></option>";
                        
                        for(var i=0;i<l_obj.length;i++)
                        {
                            texte +="<option value=\""+l_obj[i].children[0].firstChild.nodeValue+"\">"+ l_obj[i].children[1].firstChild.nodeValue+"</option>";
                        }
                        
                        var elt = document.getElementById("clientPgrm");
                        
                        
			elt.innerHTML = texte;  
                    }
	
	};
        xhr.send();
    }
    
    
    function showIdCliNonP ()
    { 
        
        var xhr = new XMLHttpRequest();
	xhr.open("GET","../ServletClientNonPgrm");
       

	xhr.onload = function()
        
            {

		if (xhr.status === 200)
                    {
                        var rep = xhr.responseXML;
                        var l_obj=rep.getElementsByTagName("client");
                        
                        var texte = "<option></option>";
                        
                        for(var i=0;i<l_obj.length;i++)
                        {
                            texte +="<option value=\""+l_obj[i].children[0].firstChild.nodeValue+"\">"+ l_obj[i].children[1].firstChild.nodeValue+"</option>";
                        }
                        
                        var elt = document.getElementById("clientNonPgrm");
                        
			elt.innerHTML = texte;  
                    }
	
	};
        xhr.send();
    }


document.addEventListener("DOMContentLoaded", () => {
//        document.getElementById("typeProg").addEventListener("click",showType);
        window.addEventListener("load",showIdCliP);
        window.addEventListener("load",showIdCliNonP);
        
});
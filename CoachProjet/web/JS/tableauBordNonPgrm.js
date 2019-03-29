   
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

        window.addEventListener("load",showIdCliNonP);
        
});
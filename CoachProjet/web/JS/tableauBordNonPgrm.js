 function showIdCliNonP ()
    { 
        var xhr = new XMLHttpRequest();
	xhr.open("GET","ServletClientNonPgrm");
       
	xhr.onload = function()
        
            {
		if (xhr.status === 200)
                    {
                        var rep = xhr.responseXML;
                        var l_obj=rep.getElementsByTagName("client");
                        
                                var texte="";
                                
                                texte+="<table>";
                                for(var i=0;i<l_obj.length;i++){
                                var clip = l_obj[i].children;
                           
                                    texte+="<tr>";
                                    texte+="<td>"+clip[0].firstChild.nodeValue+"</td>";
                                    texte+="<td>"+clip[1].firstChild.nodeValue+"</td>";
                                    texte+="</tr>";
                        
                        }
                        
                        texte+="</table>";

                        var elt = document.getElementById("tableCNP");
                        
                        
			elt.innerHTML = texte;  
                    }
	
	};
        xhr.send();
    }
    
    
    
    
    
    
    
    
    

document.addEventListener("DOMContentLoaded", () => {

        window.addEventListener("load",showIdCliNonP);
        
});
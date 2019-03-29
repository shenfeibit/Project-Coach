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
                        var lengthTab = l_obj.length;
                        
//                        var texte = "";        
//                        for(var i=0;i<l_obj.length;i++)
//                        {
//                            texte +="<td class='content-left' value=\""+l_obj[i].children[0].firstChild.nodeValue+"\">"+ l_obj[i].children[1].firstChild.nodeValue+"</td></tr>";
//                        }
 
                                var texte="";
                                
                                texte+="<table>";
                                for(var i=0;i<l_obj.length;i++){
                                var clip = l_obj[i].children;
                           
                                    texte+="<tr>";
                                    texte+="<td>"+clip[0].firstChild.nodeValue+"</td>";
                                    texte+="<td>"+clip[1].firstChild.nodeValue+"</td>";
                                    texte+="</tr>";
                                
                            
//                            if(sea[3].firstChild.nodeValue!="null"){
//                                texte+="<div class=\"meta-date-pass\">";
//                                texte+="<span class=\"date\">"+clip[0].firstChild.nodeValue+"</span>";
//                            }
//                            else{
//                                texte+="<div class=\"meta-date\">";
//                                texte+="<span class=\"date\">"+clip[0].firstChild.nodeValue+"</span>";
//                            }
//                            texte+="</div>";
                            
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
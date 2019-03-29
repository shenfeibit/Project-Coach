function showinfoCli ()
    { 
        alert("1");
        //create a requery with a value entry
        var xhr = new XMLHttpRequest();
        var param = encodeURIComponent(this.firstChild.nodeValue);
	xhr.open("GET","../ServletShowInfoCli?idc=" + param);
        
        xhr.onload = function(){
            //if the connect succees
            if (xhr.status === 200){
                //extract all the information
                var nom = xhr.responseXML.getElementsByTagName("nom");
                var prenom = xhr.responseXML.getElementsByTagName("prenom");
                var sexe = xhr.responseXML.getElementsByTagName("sexe");
                var tele = xhr.responseXML.getElementsByTagName("tele");
                var email = xhr.responseXML.getElementsByTagName("email");
                var image = xhr.responseXML.getElementsByTagName("image");
                
                //format html
                var imageCli = "<img src=\"../IMAGE/" + image[0].firstChild.nodeValue + "\" width =\"150\" alt=\"image of Client\"/>";
                var texte = nom[0].firstChild.nodeValue + " " +prenom[0].firstChild.nodeValue + "</br>" + sexe[0].firstChild.nodeValue + "</br>" + tele[0].firstChild.nodeValue + "</br>" + email[0].firstChild.nodeValue + "</br>" ;
              
                var l_obj = xhr.responseXML.getElementsByTagName("lib");
                var lib = "<p>";
                for (var i =0; i < l_obj.length; i++){       
                    lib += l_obj[i].firstChild.nodeValue + "</br>";                    
                }
                lib += "</p>";
                
                //show all the information
                var eltimage = document.getElementById("image");;
                eltimage.innerHTML = imageCli; 
                var eltdescp = document.getElementById("descp");
		eltdescp.innerHTML = texte; 
                var eltlib = document.getElementById("libobj");
		eltlib.innerHTML = lib;  
             
            };
	};
        xhr.send();
    } 




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
                        
//                        var texte = "";        
//                        for(var i=0;i<l_obj.length;i++)
//                        {
//                            texte +="<td class='content-left' value=\""+l_obj[i].children[0].firstChild.nodeValue+"\">"+ l_obj[i].children[1].firstChild.nodeValue+"</td></tr>";
//                        }
 
                                var texte="";
                                for(var i=0;i<l_obj.length;i++){
                                var clip = l_obj[i].children;
                                    texte+="<div id=\"imagecl\"><a href=ShowProgramClient.html><div id='photocli'>"+clip[0].firstChild.nodeValue+"</div></a></div>";
                                    texte+="<div id=\"descpcl\"><p>"+clip[1].firstChild.nodeValue+"</p></div>";
                                    texte+="<div id=\"objectifcl\"><p >client's objectif</p></div>";
                                
                            
//                            if(sea[3].firstChild.nodeValue!="null"){
//                                texte+="<div class=\"meta-date-pass\">";
//                                texte+="<span class=\"date\">"+clip[0].firstChild.nodeValue+"</span>";
//                            }
//                            else{
//                                texte+="<div class=\"meta-date\">";
//                                texte+="<span class=\"date\">"+clip[0].firstChild.nodeValue+"</span>";
//                            }
//                            texte+="</div>";<input type=\"image\"  src=\"../IMAGE/"+clip[4].firstChild.nodeValue+"\" width =\"50\" alt=\"image of Client\"/>
                            
                        }
                      
                        var elt = document.getElementById("tableCP");
			elt.innerHTML = texte; 
                        
                        var choix =  document.querySelectorAll("#photocli");
                        alert(choix);
                        alert(choix.length);
                      for(var i=0;i<choix.lenght;i++){
                          choix[i].addEventListener("click",showinfoCli);
                      }
                    }
	
	};
        xhr.send();
    }
    
    
    
    
    

document.addEventListener("DOMContentLoaded", () => {
//        document.getElementById("typeProg").addEventListener("click",showType);
        window.addEventListener("load",showIdCliP);
        
        //window.addEventListener("load",showIdCliNonP);
        
});
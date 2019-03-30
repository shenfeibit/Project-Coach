/*
 * this function is to show all the information of the client
 * name, address,tel, photo, objectifs
 */
function showinfoCli ()
    { 
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

document.addEventListener("DOMContentLoaded", () => {
       // window.addEventListener("load",showinfoCli);
        //document.getElementById("imagecl").addEventListener("click",showinfoCli);
});
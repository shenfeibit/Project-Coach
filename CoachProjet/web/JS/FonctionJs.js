
function showinfoCli ()
    { 
//      var idCli = document.getElementById("idc").value; 

        var xhr = new XMLHttpRequest();
	xhr.open("GET","../ServletShowInfoCli?idc=" + 6); // 1 va être changé à idCli

        xhr.onload = function(){
            if (xhr.status === 200){
                console.log("XML200");
                //var donnees = xhr.responseXML.getElementsByTagName("donnees");
                var nom = xhr.responseXML.getElementsByTagName("nom");
                var prenom = xhr.responseXML.getElementsByTagName("prenom");
                var sexe = xhr.responseXML.getElementsByTagName("sexe");
                var tele = xhr.responseXML.getElementsByTagName("tele");
                var email = xhr.responseXML.getElementsByTagName("email");
                var image = xhr.responseXML.getElementsByTagName("image");
                var imageCli = "<img src=\"../IMAGE/" + image[0].firstChild.nodeValue + "\" width =\"150\" alt=\"image of Client\"/>"
                
                var texte = nom[0].firstChild.nodeValue + " " +prenom[0].firstChild.nodeValue + "</br>" + sexe[0].firstChild.nodeValue + "</br>" + tele[0].firstChild.nodeValue + "</br>" + email[0].firstChild.nodeValue + "</br>" ;
                
                var l_obj = xhr.responseXML.getElementsByTagName("lib");
                var lib = "<p>";
                for (var i =0; i < l_obj.length; i++){       
                    lib += l_obj[i].firstChild.nodeValue + "</br>";                    
                }
                lib += "</p>";
           var eltlib = document.getElementById("libobj");
		eltlib.innerHTML = lib;  
                
                var eltdescp = document.getElementById("descp");
		eltdescp.innerHTML = texte;  
                
                var eltimage = document.getElementById("image");;
                eltimage.innerHTML = imageCli; 
                

            };
	};
        xhr.send();
    } 
    


document.addEventListener("DOMContentLoaded", () => {
        window.addEventListener("load",showinfoCli);
});

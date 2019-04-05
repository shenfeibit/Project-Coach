// Function which return tne program perso and her seance perso
function affichePP ()
	{
	// Object XMLHttpRequest.
	var xhr = new XMLHttpRequest();
	// requery with a value entry.
        var param=encodeURIComponent(document.getElementById("idClient").value);
	xhr.open("GET","ServletTableProg?idc=" + param);
	xhr.onload = function()
		{
		//if the connect succees
		if (xhr.status === 200)
			{
                        //get the reponse of serveur
                        var rep = xhr.responseXML;
                        
                        //for lib of the programme (get and set into html)
                        var libPP = rep.getElementsByTagName("libPP");
                        var texteLibPP = libPP[0].firstChild.nodeValue;
			var eltLibPP = document.getElementById("nameProg");
                        eltLibPP.innerHTML = texteLibPP;
                        
                        //for descrip ProgPerso(get and set into html)
                        var descripPP = rep.getElementsByTagName("descripPP");
                        var textDescripPP = descripPP[0].firstChild.nodeValue;
                        var eltDescripPP = document.getElementById("descripPP");
                        eltDescripPP.innerHTML = textDescripPP;
                        
                        //for secances(get and set into html)
                        var encours = rep.getElementsByTagName("encours")[0].firstChild.nodeValue;
                        var next = encours - 1 + 2;
                        var l_sea = rep.getElementsByTagName("seancePerso");
                        var texteSea="";
                        for(var i=0;i<l_sea.length;i++){
                            var sea = l_sea[i].children;
                            texteSea+="<div class=\"timeline-article\">";
                            texteSea+="<div>";
                                texteSea+="<table>";
                                    texteSea+="<tr>";
                                        texteSea+="<td class='content-left'>"+sea[1].firstChild.nodeValue+"</td>";
                                        //if the date is not null(already done)
                                        if(sea[3].firstChild.nodeValue!=="null"){
                                            //show the exercise on the detail
                                            var exe=sea[4].children;
                                            texteSea+="<td class='content-exercise'>";
                                            for(j=0;j<exe.length;j++){
                                                texteSea+="-"+exe[j].firstChild.nodeValue+"</br>";
                                            }
                                            texteSea+= "</td>";
                                        }
                                        //else (the seances not open yet)
                                        else{
                                            texteSea+="<td class='content-right'>"+sea[2].firstChild.nodeValue+"</td>";
                                        }
                                    texteSea+="</tr>";
                                texteSea+="</table>";
                            texteSea+="</div>";
                            
                            //identify different classes to show differently in style
                            if(sea[0].firstChild.nodeValue===encours){
                                texteSea+="<div id=\"encours\" value=\""+sea[5].firstChild.nodeValue+"\">";
                            }else if(sea[0].firstChild.nodeValue === next.toString()){
                                texteSea+="<div id=\"next\" value=\""+sea[5].firstChild.nodeValue+"\">";
                            }else{
                                texteSea+="<div>";
                            }
                            if(sea[3].firstChild.nodeValue!=="null"){
                                texteSea+="<div class=\"meta-date\">";
                                texteSea+="<span class=\"date\">"+sea[0].firstChild.nodeValue+"</span>";
                            }
                            else{
                                texteSea+="<div class=\"meta-date-pass\">";
                                texteSea+="<span class=\"date\">"+sea[0].firstChild.nodeValue+"</span>";
                            }
                            texteSea+="</div>";
                            texteSea+="</div>";
                        }
                        var eltSea=document.getElementById("tableSP");
                        eltSea.innerHTML=texteSea;
                        document.getElementById("encours").addEventListener("click",click_encours);
                        document.getElementById("next").addEventListener("click",click_next);
			}
		};
	xhr.send();
	}
        
// function which shows the progression of the taining of this client  
function afficheProgression ()
	{
	// Object XMLHttpRequest.
	var xhr = new XMLHttpRequest();
	// requery with a value entry.
         var param=encodeURIComponent(document.getElementById("idClient").value);
	xhr.open("GET","ServletProgressionProg?idc=" + param);
	xhr.onload = function()
		{
		// if the query succes
		if (xhr.status === 200)
			{
                        //get the reponse of serveur
                        var rep = xhr.responseXML;
                        //get the percentage of progress
                        var percent = rep.getElementsByTagName("percent");
                        var res = percent[0].firstChild.nodeValue;
                        var texte ="<span>"+res+"%</span>";
                        texte += "<progress id='percentProg' max='100' value=" + res + "></progress>";
                        var eltSea=document.getElementById("barOneLine");
                        eltSea.innerHTML=texte;
                        
			}
		};
	// send the query
	xhr.send();
        
	}
        
/*
 * this function is to show all the information of the client
 * name, address,tel, photo, objectifs
 */
function showinfoCli ()

    { 
        //create a requery with a value 
        var xhr = new XMLHttpRequest();
        var param=encodeURIComponent(document.getElementById("idClient").value);
	xhr.open("GET","ServletShowInfoCli?idc=" + param);
        
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
                var imageCli = "<img src=\"IMAGE/" 
                        + image[0].firstChild.nodeValue 
                        + "\" width =\"150\" alt=\"image of Client\"/>";
                //show all the objectifs of the client
                var lib = "<strong>Objectifs : </strong><span id='list_objectif'>";
                var l_obj = xhr.responseXML.getElementsByTagName("lib");
                for (var i =0; i < l_obj.length; i++){       
                    lib += l_obj[i].firstChild.nodeValue + "</br>";                    
                }
                lib+="</span></br>";
                var texte = lib+nom[0].firstChild.nodeValue + " " 
                        + prenom[0].firstChild.nodeValue + "</br>" 
                        + sexe[0].firstChild.nodeValue + "</br>" 
                        + tele[0].firstChild.nodeValue + "</br>" 
                        + email[0].firstChild.nodeValue + "</br>" ;
                
                //show all the information
                var eltimage = document.getElementById("image");;
                eltimage.innerHTML = imageCli; 
                var eltdescp = document.getElementById("descp");
		eltdescp.innerHTML = texte; 
            };
	};
        
        xhr.send();
        
    }
    

function click_encours(){
    var idSea = document.getElementById("encours").getAttribute('value');
    window.location.href="ServletBeginSea?idSea="+idSea;
}

function click_next(){
    var idSea = document.getElementById("next").getAttribute('value');
    var xhr = new XMLHttpRequest();
    xhr.open("GET","ServletExerciseBySea?idSea="+idSea);
    xhr.onload = function()
            {
		if (xhr.status === 200)
                    {
                        var rep = xhr.responseXML;
                        var l_exe = rep.getElementsByTagName("libexe");
                        var texte = "";
                        for(var i=0;i<l_exe.length;i++){
                            texte += "\r\n";
                            texte += "-"+l_exe[i].firstChild.nodeValue;
                        }
                        confirm("Cet seance n'est pas ouvert, voici des détails"
                                +texte);
                    }
            };
    xhr.send();
}

function evoluation(){
    var xhr = new XMLHttpRequest();
        var param=encodeURIComponent(document.getElementById("idClient").value);
	xhr.open("GET","ServletEvoluation?idc=" + param);
        xhr.onload = function(){
            //if the connect succees
            if (xhr.status === 200){
                var res = xhr.responseXML;
                var l_mes = res.getElementsByTagName("mes");
                
                var texte ="<table><tr><td>Mesure</td><td>Bilan N°1</td><td>Bilan Dernier</td><td>Evoluation</td></tr>";
                for(var i=0; i<l_mes.length; i++){
                    var mes=l_mes[i];
                    texte+="<tr><td>"+mes.children[0].firstChild.nodeValue;+"</td>";
                    var l_res=mes.children[1];
                    for(var j=0;j<3;j++){
                        texte+="<td>"+l_res.children[j].firstChild.nodeValue+"</td>";
                    }
                    texte+="</tr>";
                }
                texte += "</table>";
                var elt = document.getElementById("evoluation");
                elt.innerHTML = texte;
                
            }
            
        };
        xhr.send();
}
function load(){
    showinfoCli();
    evoluation();
    afficheProgression();
    affichePP();
}
//the events corresponding for each function
document.addEventListener("DOMContentLoaded", () => {
    window.addEventListener("load",load);
});





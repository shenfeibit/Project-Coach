/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function visualiserProgrammestandard(){
     var xhr = new XMLHttpRequest();
	xhr.open("GET","../ServletvisualiserPs="+1);

        xhr.onload = function(){
         if (xhr.status === 200){
              console.log("XML200");
              var identifiant = document.getElementsByTagName("idps");
              console.log(identifiant[0].firstChild.nodeValue);
              var texte = identifiant[0].firstChild.nodeValue;
              var elt = document.getElementById("idps");
              elt.innerHTML = texte;



        }

    };

 }



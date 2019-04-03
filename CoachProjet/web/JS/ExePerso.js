var idExe = 0;
var idExemin = 0;
var idExemax = 0;

function showExe(){
        var xhr = new XMLHttpRequest();
	xhr.open("GET","ServletShowExe?idExe="+ idExe);
        alert(idExe);
        xhr.onload = function()
            {
            if (xhr.status === 200)
                {
                var rep = xhr.responseXML;
                //var l_exe = rep.getElementsByTagName("exercise");
                //var exe = l_exe.children;
                var lib = rep.getElementsByTagName("libexe")[0].firstChild.nodeValue;
                var des = rep.getElementsByTagName("descripexe")[0].firstChild.nodeValue;
                var image = rep.getElementsByTagName("photoexe")[0].firstChild.nodeValue;
                
                
                var texteExe = lib +"</br>"+ des + "</br>";
                texteExe += "<div><input type=\"image\"  src=\"IMAGE/Exercises/"+image+"\" width =\"250\" alt=\"See the detail\"/></div>";
                var elt = document.getElementById("exercise");
                elt.innerHTML = texteExe; 
                if(idExe<=idExemin){
                    document.getElementById("btn_Left").disabled=true;
                }
                else{
                    document.getElementById("btn_Left").disabled=false;
                }
                if(parseInt(idExe)>=parseInt(idExemax)){
                    document.getElementById("btn_Right").disabled=true;
                }
                else{
                    document.getElementById("btn_Right").disabled=false;
                }
        }
    };
    xhr.send();
}

function showLeftExe(){
        idExe -= 1;
        showExe();
}

function showRightExe(){
        idExe -= 1;
        idExe += 2;
        showExe();
}

function showSeaName(){
    var xhr = new XMLHttpRequest();
    
    var idSea = document.getElementById("idSea").value;
    xhr.open("GET","ServletSeaName?idSea="+idSea);
    xhr.onload = function()
	{
	if (xhr.status === 200)
            {
            var rep = xhr.responseXML;
            var nameSea = rep.getElementsByTagName("name");
            var texte = nameSea[0].firstChild.nodeValue;
            var elt = document.getElementById("nameSea");
            elt.innerHTML = texte;
            
            var id = rep.getElementsByTagName("idexemin");
            idExe = id[0].firstChild.nodeValue;
            idExemin = id[0].firstChild.nodeValue;
            
            var id = rep.getElementsByTagName("idexemax");
            idExemax = id[0].firstChild.nodeValue;
            showExe();
            }               
	};
    xhr.send();
    
}

document.addEventListener("DOMContentLoaded", () => {
        window.addEventListener("load",showSeaName);
        document.getElementById("btn_Left").addEventListener("click",showLeftExe);
        document.getElementById("btn_Right").addEventListener("click",showRightExe);
});
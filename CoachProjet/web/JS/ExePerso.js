var order;
var order_length;
var idExe;
var listExe;
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
                
                
                var texteExe = lib +"</br>"+ des + "</br>";
                var elt = document.getElementById("exercise");
                elt.innerHTML = texteExe; 
                if(order<=0){
                    document.getElementById("btn_Left").disabled=true;
                }
                else{
                    document.getElementById("btn_Left").disabled=false;
                }
                if(parseInt(order)>=parseInt(order_length-1)){
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
        order -= 1;
        idExe = listExe[order].children[1].firstChild.nodeValue;
        showExe();
}

function showRightExe(){
        order -= 1;
        order += 2;
        idExe = listExe[order].children[1].firstChild.nodeValue;
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
            
            var id = rep.getElementsByTagName("exercise");
            order=0;
            order_length=id.length;
            listExe = id;
            idExe = listExe[order].children[1].firstChild.nodeValue;
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
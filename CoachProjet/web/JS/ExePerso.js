

function showExe(){
    
        var xhr = new XMLHttpRequest();
        var idSea = 1; 
	xhr.open("GET","../ServletShowExe?idSea="+ idSea);
        xhr.onload = function(){
            if (xhr.status === 200){
                var rep = xhr.responseXML;
                var l_exe = rep.getElementsByTagName("ligneExe");
                alert(l_exe.length);
                var texteExe = "<div id=\"exercise\">";
                
                for ( var i=0; i<l_exe.length; i++){
                    var exe = l_exe[i].children;
                    texteExe += exe[0].firstChild.nodeValue + exe[1].firstChild.nodeValue + "</br>";
                }
                texteExe += "</div>";
            
            var elt = document.getElementById("exercise");
            elt.innerHTML = texteExe; 
        }
    };
    xhr.send();
};

document.addEventListener("DOMContentLoaded", () => {
        window.addEventListener("load",showExe);
        
});
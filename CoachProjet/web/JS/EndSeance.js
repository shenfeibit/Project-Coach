function showPerformance(){
    var xhr = new XMLHttpRequest();
    var idSea = document.getElementById("idSea").value;
    xhr.open("GET","ServletEndSeaPerformance?idSea="+idSea);
    xhr.onload = function()
	{
	if (xhr.status === 200)
            {
            var rep = xhr.responseXML;
            var l_exe = rep.getElementsByTagName("exe");
            
            var texte = "<table><tr><th>Exercise</th><th>Performance</th></tr>";
            for(var i=0;i<l_exe.length;i++){
                var exe = l_exe[i].children;
                texte+="<tr><td>"+exe[0].firstChild.nodeValue+"</td><td>";
                texte+="<td>"+exe[1].firstChild.nodeValue+"</td></tr>";
            }
            texte+="</table>";
            
            var elt=document.getElementById("res_performance");
            elt.innerHTML = texte;
            
            }               
	};
    xhr.send();
    
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
            }               
	};
    xhr.send();
    
}

document.addEventListener("DOMContentLoaded", () => {
    window.addEventListener("load",showSeaName);
        window.addEventListener("load",showPerformance);
});



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

//the events corresponding for each function
document.addEventListener("DOMContentLoaded", () => {
        window.addEventListener("load",showSeaName);
        
});



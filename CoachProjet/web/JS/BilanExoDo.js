var order;
var order_length;
var idExe;
var listExe;
//count the time
var i=0;
var x;
var temps;

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
            order=3;
            order_length=id.length;
            listExe = id;
            idExe = listExe[order].children[1].firstChild.nodeValue;
            showExe();
            }               
	};
    xhr.send();
}

function showExe(){
        var xhr = new XMLHttpRequest();
	xhr.open("GET","ServletShowExe?idExe="+ idExe);
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
                var eltNameExercise = document.getElementById("nameExercise");
                eltNameExercise.innerHTML = lib;
                var eltLibExercise = document.getElementById("libExercise");
                eltLibExercise.innerHTML = des;
                var eltImgExercise = document.getElementById("img_video");
                var texteExe = "<input type=\"image\"  src=\"IMAGE/Exercises/"+image+"\" width =\"250\" alt=\"See the detail\"/>";
                eltImgExercise.innerHTML=texteExe;
                
                document.getElementById("time_minute").innerHTML="0";
                document.getElementById("time_second").innerHTML="0";
                document.getElementById("time_out").innerHTML="";
                document.getElementById("nbrep").value="";
                temps="";
                
                if(parseInt(order)>=parseInt(order_length-1)){
                    document.getElementById("suivant").type="hidden";
                    document.getElementById("Terminer").type="button";
                }
                else{
                    document.getElementById("suivant").type="button";
                    document.getElementById("Terminer").type="hidden";
                }
        }
    };
    xhr.send();
};

function addparam(){
        var xhr = new XMLHttpRequest();
        var duree = encodeURIComponent(temps);
        var nbrept = encodeURIComponent(document.getElementById("nbrep").value);
        alert(duree);
        alert(nbrept);
	xhr.open("GET","ServletEnregBilan?idExe="+ idExe+"&duree="+duree+"&nbrep="+nbrept);
        xhr.send();
        order -= 1;
        order += 2;
        idExe = listExe[order].children[1].firstChild.nodeValue;
        clearInterval(x);
        showExe();
        
}

function finish(){
        var xhr = new XMLHttpRequest();
        var duree = encodeURIComponent(temps);
        var nbrept = encodeURIComponent(document.getElementById("nbrep").value);
        alert(duree);
        alert(nbrept);
	xhr.open("GET","ServletEnregBilan?idExe="+ idExe+"&duree="+duree+"&nbrep="+nbrept);
        xhr.send();
        document.getElementById("exercise").innerHTML="<h1>Bravo, vous avez terminez le séance!</h1>";
}

function endPerformance(){
    var xhr = new XMLHttpRequest();
    var idSea = document.getElementById("idSea").value;
    xhr.open("GET","ServletEndSeaPerformance?idSea="+idSea);
    xhr.send();
    
}

function timebegin(){
    i=0;
    x=setInterval(function(){
        i+=1;
    var seconde = Math.floor(i % 60);
    var minute = Math.floor(i/60);
      
    document.getElementById("time_minute").innerHTML=minute;
    document.getElementById("time_second").innerHTML=seconde;
    
    temps=minute+":"+seconde;
    if(minute>5){
        clearInterval(x);
        document.getElementById("timeout").innerHTML="Expired";
    }
    },1000);
};

function timeend(){
    clearInterval(x);
}


function finish_seance(){
    var idSea = document.getElementById("idSea").value;
    window.location.href="ServletEndSea?idSea="+idSea;
}

//the events corresponding for each function
document.addEventListener("DOMContentLoaded", () => {
        window.addEventListener("load",showSeaName);
        window.addEventListener("load",timeend);
        document.getElementById("time_begin").addEventListener("click",timebegin);
        document.getElementById("time_end").addEventListener("click",timeend);
        document.getElementById("suivant").addEventListener("click",addparam);
        document.getElementById("Terminer").addEventListener("click",finish);
        document.getElementById("Terminer").addEventListener("click",endPerformance);
        
});




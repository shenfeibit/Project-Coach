var order;
var order_length;
var idExe;
var listExe;
//count the time
var i=0;
var x;
var perfo;
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
               
                if(order<=0){
                    document.getElementById("btn_Left").disabled=true;
                    document.getElementById("btn_Left").type="hidden";
                }
                else{
                    document.getElementById("btn_Left").disabled=false;
                    document.getElementById("btn_Left").type="button";
                }
                document.getElementById("btn_Right").type="hidden";
                document.getElementById("btn_finish").type="hidden";
                document.getElementById("time_minute").innerHTML="0";
                document.getElementById("time_second").innerHTML="0";
                document.getElementById("time_out").innerHTML="0";
        }
    };
    xhr.send();
};

function showLeftExe(){
        order -= 1;
        idExe = listExe[order].children[1].firstChild.nodeValue;
        clearInterval(x);
        document.getElementById("easy").checked=false;
        document.getElementById("normal").checked=false;
        document.getElementById("hard").checked=false;
        showExe();
}

function showRightExe(){
        order -= 1;
        order += 2;
        idExe = listExe[order].children[1].firstChild.nodeValue;
        clearInterval(x);
        document.getElementById("easy").checked=false;
        document.getElementById("normal").checked=false;
        document.getElementById("hard").checked=false;
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

function timebegin(){
    i=0;
    x=setInterval(function(){
        i+=1;
    var seconde = Math.floor(i % 60);
    var minute = Math.floor(i/60);
      
    document.getElementById("time_minute").innerHTML=minute;
    document.getElementById("time_second").innerHTML=seconde;
    
    if(minute>5){
        clearInterval(x);
        document.getElementById("timeout").innerHTML="Expired";
    }
    },1000);
};

function timeend(){
    clearInterval(x);
}

function continu(){
    if(parseInt(order)>=parseInt(order_length-1)){
        document.getElementById("btn_Right").disabled=true;
        document.getElementById("btn_Right").type="hidden";
        document.getElementById("btn_finish").type="button";
        
    }
    else{
        document.getElementById("btn_Right").disabled=false;
        document.getElementById("btn_Right").type="button";
        document.getElementById("btn_finish").type="hidden";
    }
    perfo = this.value;
}

function addPerformance(){
    var xhr = new XMLHttpRequest();
    var performance = null;
    if (perfo === "1") {
        performance = "easy";
    }
    else if (perfo === "2"){
        performance = "normal";
    }
    else{
        performance = "hard";
    }
    var id=idExe-1;
    xhr.open("GET","ServletAddPer?idExe=" +id+ "&performance="+performance);
    xhr.send();   
}

function addPerformancefinal(){
    var xhr = new XMLHttpRequest();
    var performance = null;
    if (perfo === "1") {
        performance = "easy";
    }
    else if (perfo === "2"){
        performance = "normal";
    }
    else{
        performance = "hard";
    }
    xhr.open("GET","ServletAddPer?idExe=" +idExe+ "&performance="+performance);
    xhr.send();   
}

function finish_seance(){
    var idSea = document.getElementById("idSea").value;
    window.location.href="ServletEndSea?idSea="+idSea;
}

//the events corresponding for each function
document.addEventListener("DOMContentLoaded", () => {
        window.addEventListener("load",showSeaName);
        window.addEventListener("load",timeend);
        document.getElementById("btn_Left").addEventListener("click",showLeftExe);
        document.getElementById("btn_Right").addEventListener("click",showRightExe);
        document.getElementById("time_begin").addEventListener("click",timebegin);
        document.getElementById("time_end").addEventListener("click",timeend);
        document.getElementById("easy").addEventListener("click",continu);
        document.getElementById("normal").addEventListener("click",continu);
        document.getElementById("hard").addEventListener("click",continu);
        document.getElementById("btn_Right").addEventListener("click",addPerformance);
        document.getElementById("btn_finish").addEventListener("click",addPerformancefinal);
        document.getElementById("btn_finish").addEventListener("click",finish_seance);
});

 
    function showIdCliNonP ()
    { 
        
        var xhr = new XMLHttpRequest();
	xhr.open("GET","../ServletShowInfoCli");
       

	xhr.onload = function()
        
            {

		if (xhr.status === 200)
                    {
                        var rep = xhr.responseXML;
                        var l_obj=rep.getElementsByTagName("client");
                        
                        var texte = "";
                        
                        for(var i=0;i<l_obj.length;i++)
                        {
                            texte +="<p>"+l_obj[i].children[0].firstChild.nodeValue+"</p><p>"+ l_obj[i].children[1].firstChild.nodeValue+"</p>";
                        }
                        
                        var elt = document.getElementById("descp");
                        
			elt.innerHTML = texte;  
                    }
	
	};
        xhr.send();
    }
    
    
    
// When the user scrolls the page, execute myFunction 


function myFunction() {
  var winScroll = document.body.scrollTop || document.documentElement.scrollTop;
  var height = document.documentElement.scrollHeight - document.documentElement.clientHeight;
  var scrolled = (winScroll / height) * 100;
  document.getElementById("myBar").style.width = scrolled + "%";
}

    
    
    
    document.addEventListener("DOMContentLoaded", () => {
        window.addEventListener("scroll",myFunction);

        });






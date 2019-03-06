const app = (function(){

    function onScrollFixed(navNavBas, linkNavbas, linkNavbas){
        if(window.scrollY > 95){
            navbas.style.top = "0";
            navbas.style.position = "fixed";
            // navbas.style.background = "black";
            // navNavBas.style.background = "black";
        }
        else{
            navbas.style.top = "95px";
            navbas.style.position = "absolute";
            // navbas.style.background = "white";
            // navNavBas.style.background = "white";
        }
    }

    const start = function start(){
        /*Variables to control the navbar fixed on scroll*/
        const navbas = document.getElementById('navbas');
        const navNavBas = document.getElementById('navNavbas');
        const linkNavbas = document.getElementsByClassName("linkNavbas");
        
        window.addEventListener("scroll", function(){
            onScrollFixed(navNavBas, linkNavbas, linkNavbas);
        })

    }

    window.addEventListener("DOMContentLoaded", start);
}());
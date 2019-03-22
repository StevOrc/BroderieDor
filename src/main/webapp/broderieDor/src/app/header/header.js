const app = (function(){

    function onScrollFixed(navNavBas, linkNavbas, linkNavbas){
        if(window.scrollY > 95){
            navbas.style.top = "0";
            navbas.style.position = "fixed";
        }
        else{
            navbas.style.top = "95px";
            navbas.style.position = "absolute";
        }
    }

    function onScrollHideNavMenu(navResponsvie, prevScroll){
        var currentScroll = window.pageYOffset;
        if(prevScroll === currentScroll || currentScroll <285) {
            navResponsvie.style.top = "0";
          }
          else{
            navResponsvie.style.top = "-285px";
          }
    }

    const start = function start(){
        /*Variables to control the navbar fixed on scroll*/
        const navbas = document.getElementById('navbas');
        const navNavBas = document.getElementById('navNavbas');
        const linkNavbas = document.getElementsByClassName("linkNavbas");
        /*Variable to control the burger menu*/
        const navResponsvie = document.getElementById('navResponsvie');
        const prevScroll = window.pageYOffset;
        
        window.addEventListener("scroll", function(){
            onScrollFixed(navNavBas, linkNavbas, linkNavbas);
            onScrollHideNavMenu(navResponsvie, prevScroll);
        })

    }

    window.addEventListener("DOMContentLoaded", start);
}());
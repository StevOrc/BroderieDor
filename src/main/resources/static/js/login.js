const app = (function(){

    var emptyField = 0;
    var errorField = 0;

    function controlChamp(pseudo, pwd){
        controlePseudo(pseudo);
        pwdControl(pwd);
        console.log("empty  : " +emptyField);
        console.log("error  : " +errorField);
    }

    /*Controle Nom*/
    function controlePseudo(pseudo){
        if(pseudo.value.length > 0){
            if(textRegExpr(pseudo.value)){
                pseudo.style.border  = "1px solid red";
                errorField += 1;
            }
        }else{
            pseudo.style.border  = "1px solid red";
                emptyField += 1;
        }
        
    }

    /*Control prenom*/
    function pwdControl(pwd){
        if(pwd.value.length > 0){
            if(pswRegExpr(pwd.value)){
                pwd.style.border  = "1px solid red";
                errorField += 1;
            }
        }else{
            pwd.style.border  = "1px solid red";
                emptyField += 1;
        }
    }

    /*Regular Expression => psw*/
    function pswRegExpr(input){
        var myRegExpr = /^[a-zA-Z0-9]*$/;
        if(!myRegExpr.test(input)){
            return true;
        }
    }

    /*Regular Expression => text*/
    function textRegExpr(input){
        var myRegExpr = /^[a-zA-Z ]*$/;
        if(!myRegExpr.test(input)){
            return true;
        }
    }

    /*Regular Expression => number*/
    function numberRegExpr(input){
        var myRegExpr = /^[0-9]*$/;
        if(!myRegExpr.test(input)){
            return true;
        }
    }

    const start = function start(){
        const pseudo = document.getElementById('pseudo');
        const pwd = document.getElementById('pwd');
        const valider = document.getElementById('valider');

        valider.addEventListener('mouseover', function(){
            controlChamp(pseudo, pwd);
        })
    }

    window.addEventListener("DOMContentLoaded", start);
}());
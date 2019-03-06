const app = (function(){

    var emptyField = 0;
    var errorField = 0;

    function controlChamp(nom, prenom, numRue, nomRue, ville, codePostal,pseudo, telephone, psw, pswconfirm, email){
        controleNom(nom);
        firstNameControl(prenom);
        villeControl(ville);
        nomRueControl(nomRue);
        numRueControl(numRue);
        codePostalControl(codePostal);
        telephoneControl(telephone);
        passwordControl(psw, pswconfirm);
        pseudoControl(pseudo);
        pseudoControl(email);
        console.log("empty  : " +emptyField);
        console.log("error  : " +errorField);
    }

    /*Controle Nom*/
    function controleNom(nom){
        if(nom.value.length > 0){
            if(textRegExpr(nom.value)){
                nom.style.border  = "1px solid red";
                errorField += 1;
            }
        }else{
            nom.style.border  = "1px solid red";
                emptyField += 1;
        }
        
    }

    /*Control prenom*/
    function firstNameControl(prenom){
        if(prenom.value.length > 0){
            if(textRegExpr(prenom.value)){
                prenom.style.border  = "1px solid red";
                errorField += 1;
            }
        }else{
            prenom.style.border  = "1px solid red";
                emptyField += 1;
        }
    }



    /*Controle Ville*/
    function villeControl(ville){
        if(ville.value.length > 0){
            if(textRegExpr(ville.value)){
                ville.style.border  = "1px solid red";
                errorField += 1;
            }
        }else{
            ville.style.border  = "1px solid red";
                emptyField += 1;
        }
    }

     /*Controle nomRue*/
     function nomRueControl(nomRue){
        if(nomRue.value.length > 0){
            if(textRegExpr(nomRue.value)){
                nomRue.style.border  = "1px solid red";
                errorField += 1;
            }
        }else{
            nomRue.style.border  = "1px solid red";
                emptyField += 1;
        }
    }

    /*Controle numRue if number*/
    function numRueControl(numRue){
        if(numRue.value.length > 0){
            if(numberRegExpr(numRue.value)){
                numRue.style.border  = "1px solid red";
                errorField += 1;
            }
        }else{
            numRue.style.border  = "1px solid red";
                emptyField += 1;
        }
    }

    /*Controle CodePostal*/
    function codePostalControl(codePostal){
        if(codePostal.value.length > 0){
            if(numberRegExpr(codePostal.value)){
                codePostal.style.border  = "1px solid red";
                errorField += 1;
            }
        }else{
            codePostal.style.border  = "1px solid red";
                emptyField += 1;
        }
    }

    /*Controle telephone*/
    function telephoneControl(telephone){
        if(telephone.value.length > 0){
            if(numberRegExpr(telephone.value)){
                telephone.style.border  = "1px solid red";
                errorField += 1;
            }
        }else{
            telephone.style.border  = "1px solid red";
                emptyField += 1;
        }
    }

    /*password Control*/
    function passwordControl(psw, pswconfirm){
        if(psw.value.length === 0){
            psw.style.border = "1px solid red";
            emptyField += 1;
        }
        if(pswconfirm.value.length === 0){
            pswconfirm.style.border = "1px solid red";
            emptyField += 1;
        }
        else if(psw.value != pswconfirm.value){
            psw.style.border = "1px solid red";
            pswconfirm.style.border = "1px solid red";
            errorField += 1;
        }
        else{
            if(pswRegExpr(psw.value)){
                psw.style.border = "1px solid red";
                pswconfirm.style.border = "1px solid red";
                errorField +=1;
            }
        }
    }

    function pseudoControl(pseudo){
        if(pseudo.value.length > 0){
            if(pswRegExpr(pseudo.value)){
                pseudo.style.border  = "1px solid red";
                errorField += 1;
            }
        }else{
            pseudo.style.border  = "1px solid red";
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
        const nom = document.getElementById('nom');
        const prenom = document.getElementById('prenom');
        const numRue = document.getElementById('numRue');
        const nomRue = document.getElementById('nomRue');
        const ville = document.getElementById('ville');
        const codePostal = document.getElementById('codePostal');
        const telephone = document.getElementById('telephone');
        const pseudo = document.getElementById('pseudo');
        const psw = document.getElementById('psw');
        const pswconfirm = document.getElementById('pswconfirm');
        const email = document.getElementById('email');

        const valider = document.getElementById('valider');
        valider.addEventListener('mouseover', function(){
            controlChamp(nom, prenom, numRue, nomRue, ville, codePostal,pseudo, telephone, psw, pswconfirm, email);
        })
    }

    window.addEventListener("DOMContentLoaded", start);
}());
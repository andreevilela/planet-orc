/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function playAudio(audio) {
    document.getElementById(audio).play();
}
function pauseAudio(audio) {
    var controle = document.getElementById(audio);
    controle.pause();
    controle.currentTime = 0;
}

function validarFormulario1() {
    inputs = document.getElementsByTagName("input");
    for (var i = 0; i < inputs.length; i++) {
        if (((inputs[i].type == "text") || (inputs[i].type == "password")) && (inputs[i].value == "")) {
            document.getElementById(i).innerHTML = inputs[i].name.toUpperCase() + " Obrigatório!";
            return false;
            break;
        } else {
            document.getElementById(i).innerHTML = "";
        }
    }
}

function validarFormulario2() {
    var padrao = /^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-.]+$/;
    inputs = document.getElementsByTagName("input");
    for (var i = 0; i < inputs.length; i++) {
        if (((inputs[i].type == "text") || (inputs[i].type == "password")) && (inputs[i].value == "")) {
            document.getElementById(i).innerHTML = inputs[i].name.toUpperCase() + " Obrigatório!";
            return false;
            break;
        } else {
            document.getElementById(i).innerHTML = "";
        }
        if (inputs[0].value.length > 10) {
            document.getElementById(0).innerHTML = "Utilize no máximo 10 caracteres";
            return false;
            break;
        } else if (inputs[0].value.length < 3) {
            document.getElementById(0).innerHTML = "Utilize no mínimo 3 caracteres";
            return false;
            break;
        }else if ((!padrao.test(inputs[1].value))) {
            document.getElementById(1).innerHTML = "E-mail inválido!";
            return false;
            break;
        }else if (inputs[1].value !== inputs[2].value) {
            document.getElementById(2).innerHTML = "E-mail diferentes!";
            return false;
            break;
        }else if(inputs[3].value.length < 8){
            document.getElementById(3).innerHTML = "Utilize no mínimo 8 caracteres";
        }else if (inputs[3].value !== inputs[4].value) {
            document.getElementById(4).innerHTML = "Senhas diferentes!";
            return false;
            break;
        } else {
            document.getElementById(0).innerHTML = "";
            document.getElementById(1).innerHTML = "";
            document.getElementById(2).innerHTML = "";
            document.getElementById(3).innerHTML = "";
            document.getElementById(4).innerHTML = "";
        }
    }
}

function validarFormulario3() {
    var dificuldade = document.getElementsByName("dificuldade");
    for (var i = 0; i < dificuldade.length; i++) {
        if (dificuldade[i].checked)
            dificuldade = dificuldade[i].value;
    }
    if (dificuldade == "[object NodeList]") {
        document.getElementById(0).innerHTML = "Nível de Dificuldade Inválido!";
        return false;
    } else
        document.getElementById(0).innerHTML = "";
}

var elem = document.documentElement;
function openFullscreen() {
    if (elem.requestFullscreen) {
        elem.requestFullscreen();
    } else if (elem.mozRequestFullScreen) { /* Firefox */
        elem.mozRequestFullScreen();
    } else if (elem.webkitRequestFullscreen) { /* Chrome, Safari & Opera */
        elem.webkitRequestFullscreen();
    } else if (elem.msRequestFullscreen) { /* IE/Edge */
        elem.msRequestFullscreen();
    }
}

var tempo = 0;
var cronometro;

function redirecionar(id, nome, dificuldade) {
    tempo = Math.round(Math.random() * 10) + 10;
    iniciar(id, nome, dificuldade);
}

function iniciar(id, nome, dificuldade) {
    tempo--;
    document.getElementById("tempoProcessamento").innerHTML = tempo;
    if (tempo <= 5)
        document.getElementById("tempoProcessamento").classList.add("vermelho");
    if (tempo == 0) {
        window.open("Servlet?id=" + id + "&nome=" + nome + "&dificuldade=" + dificuldade, "_self");
    }
    cronometro = setTimeout(iniciar, 1000, id, nome, dificuldade);
}


var tempo2 = 0;
var cronometro2;

function jogou(id, nome, dificuldade) {
    jogar(id, nome, dificuldade);
}

function jogar(id, nome, dificuldade) {
    tempo2++;
    if (tempo2 == 5) {
        window.open("Servlet?id=" + id + "&nome=" + nome + "&dificuldade=" + dificuldade, "_self");
    } else {
        cronometro2 = setTimeout(jogar, 1000, id, nome, dificuldade);
    }
}



function sortearNro(x) {
    return parseInt(Math.random()*x);
}

function iniciarJogo() {
    var ponto1 = {x:0, y:0}
    var ponto2 = {x:0, y:0}
    var m, k;
    var larguraImg = document.getElementById("planeta").clientWidth;
    // Sorteio da coordenada do primeiro ponto
    ponto1.x = sortearNro(window.innerWidth-larguraImg);
    // Sorteio da coordenada do segundo ponto
    ponto2.x = sortearNro(window.innerWidth-larguraImg);
    ponto2.y = window.innerHeight - document.getElementById("planeta").clientHeight;
    m = getCoefAngular(ponto1, ponto2)
    k = getCoefLinear(ponto1, m);
    voar(ponto1.y, ponto2.y, m, k);
}

function voar(y_inicial, y_final, m, k) {
    if (y_inicial < y_final) {
        y_inicial =  y_inicial + 0.1;
        x_atual = (y_inicial - k)/m;
        posicionarObj("planeta", x_atual, y_inicial);
        var colisao = detectarColisao("planeta");
        if(colisao == 1){
        iniciarJogo();
        }else{
            setTimeout(voar, 1, y_inicial, y_final, m, k);
        }
    }
}

function getCoefAngular(ponto1, ponto2) {
    return (ponto2.y - ponto1.y)/(ponto2.x -ponto1.x);  
}

function getCoefLinear(ponto, m) {
    return ponto.y - m*ponto.x;
}

function posicionarObj(idCampo, x, y) {
    document.getElementById(idCampo).style.position = "absolute";        
    document.getElementById(idCampo).style.top = y+"px"; 
    document.getElementById(idCampo).style.left = x+"px";     
}

function detectarColisao(objeto) {
    var planeta = document.getElementById(objeto).getBoundingClientRect(); 

    var colisao;
    if(planeta.bottom > window.innerHeight - 1){
        colisao = 1;
    }
    return colisao;
}

function fim() {
    window.open("Servlet?sair=sair", "_self");
}


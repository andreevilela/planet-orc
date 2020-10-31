<%-- 
    Document   : index
    Created on : 28/09/2018, 01:39:29
    Author     : Andre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Planet Orc</title>
        <link rel="icon" type="image/png" href="img/icone.png">
        <link rel="stylesheet" href="css/restom.css" type="text/css">
        <link href="css/estilos.css" rel="stylesheet" type="text/css">
        <script src="js/funcoes.js"></script>
    </head>
    <body class="fundo" onload="iniciarJogo()">
        <audio autoplay="true" loop>
            <source src="sons/bomber.mp3" type="audio/mpeg">
        </audio>
        <ul>
            <li><a href="Control3">Ranking</a></li>
            <li><a href="cadastrar.jsp">Cadastrar</a></li>
            <li><a href="login.jsp">Entrar</a></li>
            <li><a class="active" href="index.jsp">Início</a></li>
        </ul>
        <div class="caixa100">
            <h1 class="center">Planet Orc</h1>
            <img id="planeta" src="img/logo200.png" class="index" alt="Logo do Jogo Planet Orc">
            <h2 class="left">Seja Bem-Vindo!</h2>
            <p>Planet Orc é um jogo eletrônico de tabuleiro de dois jogadores, no qual os jogadores irão batalhar para tentar descobrir em quais quadrados estão os planetas do oponente e assim destruí-los. Nessa jornada os jogadores encontrarão obstáculos que colocarão sua missão em risco.</p>
            <!--<h2 class="left">Objetivo:</h2>
            <p>Destruir os planetas inimigos.</p>-->
            <h2 class="left">Regras</h2>
            <p>A área de jogo consiste num campo de batalha formado por quadrados. Os jogadores terão direito a um ataque por vez, cada ataque revelará uma parte do tabuleiro e uma pontuação será atribuida conforme a tabela abaixo:</p>
            <table style="width:40%" class="color" border=1 cellspacing=0 cellpadding=1 bordercolor="gray">
                <tr style="padding:30px">
                  <th>Campos</th>
                  <th>Descrição</th> 
                  <th>Pontuação</th>
                </tr>
                <tr>
                  <td><img src="img/orc.png" class="img80" alt="Orc"></td>
                  <td>Soldados Inimigos</td> 
                  <td>30 Pontos</td>
                </tr>
                <tr>
                  <td><img src="img/bandeira.png" class="img80" alt="Bandeira"></td>
                  <td>Dicas! Próximo Existe uma Armadilha</td> 
                  <td>10 Pontos</td>
                </tr>
                <tr>
                  <td><img src="img/armadilha.png" class="img80" alt="Armadilha"></td>
                  <td>Armadilhas</td> 
                  <td>-50 Pontos</td>
                </tr>
                <tr>
                  <td><img src="img/logo3200.png" class="img80" alt="Planeta"></td>
                  <td>Alvos</td> 
                  <td>100 Pontos</td>
                </tr>
            </table>
            <h1></h1>
        </div>
        <div id="footer">
            <footer>
                <div style="display: block; float: left; width: 50%">
                    <p>
                        Direitos Autorais - Atribuições
                        <br/><br/></br>
                        Imagens: <a class="a" href="https://br.freepik.com/" target="_blank">freepik.com</a>
                        <br/><br/>
                        Personagem: <a class="a" href="https://www.kenney.nl/" target="_blank">kenney.nl</a>
                        <br/><br/>
                        Fonte: <a class="a" href="https://www.maisfontes.com/" target="_blank">maisfontes.com</a>
                        <br/><br/>
                        Sons: <a class="a" href="https://downloads.khinsider.com//" target="_blank">downloads.khinsider.com</a>
                        <br/><br/>
                    </p>
                </div>
                <div>
                <p><a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/" target="_blank"><img alt="Licença Creative Commons" style="border-width:0" src="https://i.creativecommons.org/l/by-nc-nd/4.0/88x31.png" /></a>
                    <br/><br/>
                    Este obra está licenciado com uma Licença <a class="a" rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/" target="_blank">
                    <br/><br/>
                    Creative Commons Atribuição-NãoComercial-SemDerivações 4.0 Internacional</a>
                    <br/><br/>
                    Desenvolvido por: André Vilela
                    <br/>
                    Cristian Passos
                    <br/><br/>
                    Informações de contato: <a class="a" href="mailto:iftmandre@gmail.com">
                    iftmandre@gmail.com</a>
                    <br/>
                    <a class="a" href="mailto:cristianpassosdasilva@gmail.com">
                    cristianpassosdasilva@gmail.com</a>
                </p>
                </div>
            </footer>
        </div>
    </body>
</html>

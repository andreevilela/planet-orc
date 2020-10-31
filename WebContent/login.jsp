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
    <body class="fundo">
        <audio id="audioForm">
            <source src="sons/alert.mp3" type="audio/mpeg">
        </audio>
        <ul>
            <li><a href="Control3">Ranking</a></li>
            <li><a href="cadastrar.jsp">Cadastrar</a></li>
            <li><a class="active">Entrar</a></li>
            <li><a href="index.jsp">Início</a></li>
        </ul>
        <div class="formulario">
            <h1 class="center">Planet Orc</h1>
            <img src="img/logo200.png" class="logo" alt="Logo do Jogo Planet Orc">
            <h2 class="center">Acessar</h2>
            <!-- Enviando Jogadores para Servlet -->
            <form action="Control2" method="POST" onsubmit="return validarFormulario1()">
                <label for="txtEmail" class="input">E-mail</label>
                <input type="text" name="e-mail" id="txtEmail" onfocus="playAudio('audioForm')" onblur="pauseAudio('audioForm')" />
                <span id="0" class="validacao"></span>
                
                <label for="txtSenha" class="input">Senha</label>
                <input type="password" name="senha" id="txtSenha" onfocus="playAudio('audioForm')" onblur="pauseAudio('audioForm')" />
                <span id="1" class="validacao"></span>
                
                <label> <input type="checkbox" name="lembrar" value="lembrar" checked="" disabled=""> Mantenha-me conectado </label>
                <a href="cadastrar.jsp" class="cadastrar">Cadastre-se</a>
                <input type="submit" class="entrar" value="ENTRAR" />
            </form>
        </div>
        </br></br></br></br>
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

<%-- 
    Document   : logado
    Created on : 12/10/2018, 01:37:21
    Author     : Andre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% int id = (Integer) request.getAttribute("id");%>
<% String nome = (String) request.getAttribute("nome");%>
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
    <body class="fundo" onload="">
        <audio autoplay="true" loop>
            <source src="sons/trilha.mp3" type="audio/mpeg">
        </audio>
        <ul>
            <li><a href="index.jsp">Sair</a></li>
            <li><a class="active">Olá! <%=nome%></a></li>
        </ul>
        <div class="formulario">
            <h1 class="center">Planet Orc</h1>
            <img src="img/logo5200.png" class="logo" alt="Logo do Jogo Planet Orc">
            <h2 class="center">Nível de Dificuldade</h2>
            <form action="Servlet" method="POST" onsubmit="return validarFormulario3()">
                <span id="0" class="validacao" style="margin-left: 195px"></span>
                <input type="hidden" name="id" value="<%=id%>">
                <input type="hidden" name="nome" value="<%=nome%>">
                <label> <input type="radio" name="dificuldade" value="1"><span class="fontm"> Fácil </span></label>
                <label> <input type="radio" name="dificuldade" value="2"><span class="fontm"> Médio </span></label>
                <label> <input type="radio" name="dificuldade" value="3"><span class="fontm"> Difícil </span></label>
                <input type="submit" class="escolher" value="Escolher" />
            </form>
        </div>
        </br></br></br></br>
    </body>
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
</html>

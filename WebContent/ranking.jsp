<%-- 
    Document   : index
    Created on : 28/09/2018, 01:39:29
    Author     : Andre
--%>

<%@page import="Model.Ranking"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%List<Ranking> result = (List<Ranking>) request.getAttribute("result");%>
<% String ranking[] = { "Aguardando","0","Aguardando","0","Aguardando","0","Aguardando","0","Aguardando","0"}; %>
<% int cont = 0; %>
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
    <body class="fundo2">
        <audio autoplay="true" loop>
            <source src="sons/trilha.mp3" type="audio/mpeg">
        </audio>
        <ul>
            <li><a class="active" href="Control3">Ranking</a></li>
            <li><a href="cadastrar.jsp">Cadastrar</a></li>
            <li><a href="login.jsp">Entrar</a></li>
            <li><a href="index.jsp">Início</a></li>
        </ul>
        <div class="ranking">
            <h1 class="fontgg center">Ranking</h1>
            <br><br>
            <% 
                for (Ranking c : result){
                        if(cont < 10){
                            ranking[cont] = c.getNome();
                            cont++;
                            ranking[cont] = Integer.toString(c.getPontuacao());
                            cont++; 
                        }              
                }
            %>
            <table>
                <tr>
                    <td><img src="img/orc_yellow.png" class="rankingImg" alt="Personagem do Jogo Planet Orc"></td>
                    <td><span class="ranking2">1ST -</span></td>
                    <td><span class="ranking2"><%=ranking[0]%></span></td>
                    <td><span class="ranking2">- <%=ranking[1]%> Pts.</span></td>
                </tr>
                <tr>
                    <td><img src="img/orc_blue.png" class="rankingImg" alt="Personagem do Jogo Planet Orc"></td>
                    <td><span class="ranking2">2ND -</span></td>
                    <td><span class="ranking2"><%=ranking[2]%></span></td>
                    <td><span class="ranking2">- <%=ranking[3]%> Pts.</span></td>
                </tr>
                <tr>
                    <td><img src="img/orc_red.png" class="rankingImg" alt="Personagem do Jogo Planet Orc"></td>
                    <td><span class="ranking2">3RD -</span></td>
                    <td><span class="ranking2"><%=ranking[4]%></span></td>
                    <td><span class="ranking2">- <%=ranking[5]%> Pts.</span></td>
                </tr>
                <tr>
                    <td><img src="img/orc_green.png" class="rankingImg" alt="Personagem do Jogo Planet Orc"></td>
                    <td><span class="ranking2">4TH -</span></td>
                    <td><span class="ranking2"><%=ranking[6]%></span></td>
                    <td><span class="ranking2">- <%=ranking[7]%> Pts.</span></td>
                </tr>
                <tr>
                    <td><img src="img/orc_green.png" class="rankingImg" alt="Personagem do Jogo Planet Orc"></td>
                    <td><span class="ranking2">5TH -</span></td>
                    <td><span class="ranking2"><%=ranking[8]%></span></td>
                    <td><span class="ranking2">- <%=ranking[9]%> Pts.</span></td>
                </tr>
            </table>
            <br><br>
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

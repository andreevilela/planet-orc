<%-- 
    Document   : jogo
    Created on : 10/11/2018, 16:24:04
    Author     : Andre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% String id = (String) request.getAttribute("id");%>
<% String nome = (String) request.getAttribute("nome"); %>
<% String dificuldade = (String) request.getAttribute("dificuldade"); %>
<% int jogadas = (Integer) request.getAttribute("jogadas"); %>
<% String pasta = (String) request.getAttribute("pasta"); %>
<% String bt[] = (String[]) request.getAttribute("bt"); %>
<% String btoff[] = (String[]) request.getAttribute("btoff"); %>
<% int pontuacao = (Integer) request.getAttribute("pontuacao"); %>
<% String oponente = (String) request.getAttribute("oponente"); %>
<% int pontOponente = (Integer) request.getAttribute("pontOponente"); %>
<% int contagem = (Integer) request.getAttribute("cont"); %>
<% int contJog1 = (Integer) request.getAttribute("contJog1"); %>
<% int contJog2 = (Integer) request.getAttribute("contJog2"); %>
<% String[] vetJog = oponente.split(";"); %>
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
    <body class="fundo" <%
                            if((contJog1 == 12) || (pontOponente < 0)){
                                out.print("");
                            } else if((contJog2 == 12) || (pontuacao < 0)){
                                out.print("");
                            } else if (jogadas % 2 == 1 && jogadas > 0) {
                                out.print("onload=\"jogou('"+id+"','"+nome+"','"+dificuldade+"')\"");
                            }
                        %> >
        <ul>
            <li><a href="Servlet?sair=sair">Sair</a></li>
            <li><a class="active">Olá! <%=nome%></a></li>
        </ul>
        <div class="caixa100">
            <% if((contJog1 == 12) || (pontOponente < 0)){out.println("<center><img class='vitoria' src='img/confetes.gif' /></center><input type='button' class='fim' value='Fim!' onclick='fim()'>");}%>
            <% if((contJog2 == 12) || (pontuacao < 0)){out.println("<img class='gameOver' src='img/gameover.gif' /><input type='button' class='fim' value='Fim!' onclick='fim()'>");}%>
            <h1 class="center">Planet Orc</h1>
            <table style="width:100%;" class="color">
                <td class="left" style="width:60px;"><img src="img/orc_red.png" class="img60" alt="Orc"></td>
                <td class="left">&nbsp;&nbsp;<%=vetJog[1]%> - <%=pontOponente%> Pts.</td>
                <td class="right"><%=pontuacao%> Pts.&nbsp;&nbsp;</td>
                <td class="right" style="width:60px;"><img src="img/orc.png" class="img60" alt="Orc"></td>
            </table>
            <div class="tabuleiro">
                <form action="Servlet?id=<%=id%>&nome=<%=nome%>&dificuldade=<%=dificuldade%>" method="POST">
                    <table>
                        <% if(jogadas % 2 == 1 && contJog1 < 12 && contJog2 < 12 && pontuacao >= 0 && pontOponente >= 0){out.print("<img class='aguarde' src='img/aguarde.gif' />");}%>
                        <%  int cont = 0;
                            for (int i = 0; i < 8; i++) {
                                out.print("<tr>");
                                for (int j = 0; j < 8; j++) {
                                    out.print("<td><input type='submit' class='botao' style='background: url(\"img/"+ pasta +"/"+ bt[cont] +".gif\"' name='botao" + cont + "' value='" + (cont+1) + "' " + btoff[cont] + "></td>");
                                    cont++;
                                }
                                out.print("</tr>");
                            }
                        %>
                    </table>
                </form>
            </div>
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

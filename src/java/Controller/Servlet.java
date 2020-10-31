/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Andre
 */
@WebServlet(name = "Servlet", urlPatterns = {"/Servlet"})
public class Servlet extends HttpServlet {
//Declaração das variáveis
    public String jogador01 = "";
    public String jogador02 = "";
    public String dificuldade1 = "";
    public String dificuldade2 = "";
    public int jogadas = 0;
    public String pasta = "1";
    public String pasta2 = "1";
    public String bt[] = { "0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0" };
    public String btoff[] = { "","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","" };
    public String bt2[] = { "0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0" };
    public String btoff2[] = { "","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","" };
    public int pontuacao = 0;
    public int pontuacao2 = 0;
    public int cenario1[] = { 0,0,0,100,100,0,0,0,0,0,0,100,100,10,-50,0,0,0,-50,10,-50,0,0,0,0,0,0,30,0,100,100,30,0,0,0,-50,10,100,100,0,100,100,30,0,0,30,0,0,100,100,0,10,-50,0,0,0,0,0,0,0,0,0,0,0 };
    public int cenario2[] = { 0,0,0,0,0,0,0,0,0,10,0,0,0,0,0,0,0,-50,30,0,0,30,0,0,0,100,100,0,30,-50,0,0,0,100,100,0,0,10,0,0,0,-50,10,30,100,100,-50,0,100,100,-50,0,100,100,10,0,100,100,0,0,0,0,0,0 };
    public int cenario3[] = { 0,0,0,0,100,100,0,0,10,0,0,30,100,100,0,0,-50,0,0,10,-50,30,0,0,0,0,0,0,0,0,100,100,30,0,10,-50,0,0,100,100,0,0,0,100,100,30,0,-50,0,0,0,100,100,0,0,10,0,0,-50,10,0,0,0,0 };
    public int cenario4[] = { 0,30,-50,10,0,0,0,0,0,100,100,0,0,0,0,0,0,100,100,0,100,100,0,-50,100,100,-50,0,100,100,10,0,100,100,10,0,30,0,-50,0,0,30,0,0,0,0,0,0,0,10,0,30,0,0,0,0,0,-50,0,0,0,0,0,0 };
    public int cenario5[] = { 0,0,0,0,0,10,-50,0,0,0,0,10,-50,0,0,0,0,0,-50,0,100,100,0,0,0,30,10,30,100,100,0,0,0,0,0,100,100,-50,0,0,0,0,0,100,100,0,30,0,-50,10,100,100,0,0,0,0,0,0,100,100,0,0,0,0 };
    public int cenario6[] = { 0,10,-50,0,0,10,-50,0,10,-50,100,100,-50,30,100,100,-50,0,100,100,30,0,100,100,0,30,10,30,-50,0,10,-50,0,100,100,0,10,0,30,0,0,100,100,-50,0,0,30,0,-50,10,30,-50,30,10,0,0,0,0,0,0,0,-50,0,0 };
    public int cenario7[] = { 100,100,10,0,0,0,100,100,100,100,-50,30,0,0,100,100,30,0,30,-50,10,0,-50,30,0,0,0,0,-50,0,10,0,-50,10,-50,0,10,-50,0,0,30,-50,10,30,-50,30,0,0,0,0,30,100,100,0,0,-50,0,0,0,100,100,0,0,10 };
    public int cenario8[] = { 0,0,0,0,-50,10,0,0,30,-50,30,0,0,30,-50,0,10,-50,10,0,100,100,30,0,0,-50,100,100,100,100,10,-50,0,10,100,100,-50,30,100,100,30,0,0,30,10,0,100,100,10,0,0,-50,30,-50,10,0,-50,0,0,0,0,0,0,0 };
    public int cenario9[] = { 0,30,0,100,100,10,0,0,0,-50,-50,100,100,-50,30,0,0,0,10,100,100,50,10,0,0,30,-50,100,100,30,0,0,0,0,0,-50,30,0,30,0,0,-50,30,10,100,100,-50,10,0,10,0,10,100,100,0,0,0,30,0,-50,0,-50,10,0 };
    public int cenario10[] = { 0,0,0,-50,30,0,0,0,0,30,30,10,-50,0,10,-50,10,100,100,-50,10,100,100,-50,0,30,-50,10,0,0,100,100,-50,10,30,0,0,-50,100,100,0,0,0,0,30,0,0,0,0,0,0,30,0,0,0,0 };
    public int cenario11[] = { 30,-50,30,-50,10,10,-50,30,30,10,-50,10,-50,-50,10,-50,-50,100,100,-50,10,30,0,-50,10,100,100,30,-50,10,100,100,30,100,100,0,30,-50,100,100,-50,100,100,30,-50,10,50,30,30,10,30,10,-50,30,0,30,-50,30,0,-50,-50,30,10,-50 };
    public int cenario12[] = { 10,-50,-50,30,0,30,0,-50,100,100,30,0,-50,30,10,0,100,100,-50,10,30,-50,-50,30,100,100,30,-50,30,-50,30,-50,100,100,-50,-50,10,10,30,10,100,100,10,-50,10,30,-50,-50,100,100,30,10,30,10,-50,-50,30,-50,30,10,-50,-50,10,30 };
    public int cenario13[] = { 10,-50,-50,10,-50,30,10,-50,30,10,-50,30,-50,100,100,0,10,-50,-50,10,-50,100,100,30,30,0,30,100,100,30,-50,0,0,30,-50,100,100,-50,10,30,30,0,10,-50,30,30,-50,-50,10,-50,30,10,-50,10,100,100,30,-50,30,-50,30,-50,100,100 };
    public int cenario14[] = { 0,30,30,100,100,-50,10,30,-50,30,0,100,100,30,0,-50,10,-50,30,10,-50,10,30,-50,10,-50,-50,-50,30,-50,0,10,-50,30,10,30,-50,10,30,-50,30,-50,30,-50,30,-50,0,-50,10,-50,100,100,100,100,30,10,-50,10,100,100,100,100,30,-50 };
    public int cenario15[] = { 30,-50,30,-50,30,-50,10,0,10,-50,-50,30,10,-50,30,-50,0,30,-50,10,-50,10,-50,30,100,100,10,100,100,30,100,100,100,100,30,100,100,10,100,100,30,-50,30,-50,10,-50,30,-50,30,10,-50,30,-50,0,-50,10,-50,10,30,-50,10,-50,0,30 };
    public boolean control = false;
    public int cont = 0;
    public int contJog1 = 0;
    public int contJog2 = 0;
    
    public int le() throws FileNotFoundException, IOException
    {
            int i=0;
            String caminhoDir = getServletContext().getRealPath("/WEB-INF");    
            File arquivo = new File(caminhoDir,"ranking.txt");
	    if(arquivo.exists()==false)
                arquivo.createNewFile();
            String rank = getServletContext().getRealPath("/WEB-INF/ranking.txt");    
            BufferedReader b = new BufferedReader(
                                   new InputStreamReader(
                                       new FileInputStream(rank), Charset.forName("UTF-8").newDecoder()));
            while(b.readLine() != null)
                    i++;
            b.close();
            return i;
    }
    
    public void grava(int i,String n,String p) throws IOException
    {
            String caminhoDir = getServletContext().getRealPath("/WEB-INF");    
            File arquivo = new File(caminhoDir,"ranking.txt");
	    if(arquivo.exists()==false)
                arquivo.createNewFile();
            String rank = getServletContext().getRealPath("/WEB-INF/ranking.txt");    
            OutputStreamWriter g = new OutputStreamWriter(
                                       new FileOutputStream(rank,true),Charset.forName("UTF-8").newEncoder());
            BufferedWriter b = new BufferedWriter(g);
            b.write(i+";");
            b.write(n+";");
            b.write(p);
            b.newLine();
            b.flush();
            b.close();   
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
    //Declaração das variáveis
        String id = "";
        String nome = "";
        String sair = "";
        String dificuldade = "";
    
    //Recebendo os valores e salvando nas variáveis
        if(request.getParameter("id") != null)
            {id= request.getParameter("id");}
        
        if(request.getParameter("nome") != null)
            {nome= request.getParameter("nome");}
        
        if(request.getParameter("sair") != null)
            {sair= request.getParameter("sair");}
        
        if(request.getParameter("dificuldade") != null)
            {dificuldade= request.getParameter("dificuldade");}
        
        
    //Sorteando os cenários
        if(dificuldade.equals("1")){
            dificuldade = String.valueOf(Math.round(Math.random()*4)+1);
        }else if(dificuldade.equals("2")){
            dificuldade = String.valueOf(Math.round(Math.random()*4)+6);
        }else{
            dificuldade = String.valueOf(Math.round(Math.random()*4)+11);
        }
        
        
    //Condições do fim de jogo
        if(sair.equals("sair") || sair.equals("esgotou")){
            jogador01 = "";
            jogador02 = "";
            dificuldade1 = "";
            dificuldade2 = "";
            jogadas = 0;
            pasta = "";
            pasta2 = "";            
            for(int i = 0; i<bt.length; i++){
                bt[i] = "0";
                btoff[i] = "";
            }
            for(int i = 0; i<bt2.length; i++){
                bt2[i] = "0";
                btoff2[i] = "";   
            }
            pontuacao = 0;
            pontuacao2 = 0;
            control = true;
            cont = 0;
            contJog1 = 0;
            contJog2 = 0;
            if(sair.equals("sair")){
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }else{
                request.getRequestDispatcher("esgotou.jsp").forward(request, response);
            }
        }
                
        if(control){
            jogador01 = "";
            jogador02 = "";
            dificuldade1 = "";
            dificuldade2 = "";
            jogadas = 0;
            pasta = "";
            pasta2 = ""; 
            id = "";
            nome = "";
            dificuldade = "";
            if(sair.equals("")){
                control = false;
                request.getRequestDispatcher("saiu.jsp").forward(request, response);
            }
        }
        
        if(cont > 10){
            request.getRequestDispatcher("Servlet?sair=esgotou").forward(request, response);
        }
        
        
    //Criando uma chave
        String chave = id + ";" + nome;
        cont++;
        
        
    //Definindo os jogadores
        if(jogador01.equals("") && !chave.equals(";")){
            jogador01 = chave;
            dificuldade1 = dificuldade;
            pasta = dificuldade1;
        }else if(jogador02.equals("") && !jogador01.equals("") && !jogador01.equals(chave) && !chave.equals(";")){
            jogador02 = chave;
            dificuldade2 = dificuldade;
            pasta2 = dificuldade2;
        }else if(!jogador01.equals(chave) && !jogador02.equals(chave) && !chave.equals(";")){
            request.setAttribute("id", id);
            request.setAttribute("nome", nome);
            request.setAttribute("dificuldade", dificuldade);
            request.setAttribute("pagina", "1");
            request.getRequestDispatcher("aguarde.jsp").forward(request, response);
        }
        
        
    //Processando jogadas
        if(jogador01.equals(chave) && !jogador02.equals("")){
            for(int i = 0; i<bt.length; i++){
                if(request.getParameter("botao"+i) != null){bt[i] = request.getParameter("botao"+i); btoff[i] = "disabled";jogadas++;pontuacao=0;cont=0;contJog1=0;
                    for(int j = 0; j < bt.length; j++){
                        if(!bt[j].equals("0")){
                            if(pasta.equals("1")){
                                pontuacao += cenario1[j];
                                if(cenario1[j] == 100){
                                    contJog1++;
                                }
                            }
                            else if(pasta.equals("2")){
                                pontuacao += cenario2[j];
                                if(cenario2[j] == 100){
                                    contJog1++;
                                }
                            }
                            else if(pasta.equals("3")){
                                pontuacao += cenario3[j];
                                if(cenario3[j] == 100){
                                    contJog1++;
                                }
                            }
                            else if(pasta.equals("4")){
                                pontuacao += cenario4[j];
                                if(cenario4[j] == 100){
                                    contJog1++;
                                }
                            }
                            else if(pasta.equals("5")){
                                pontuacao += cenario5[j];
                                if(cenario5[j] == 100){
                                    contJog1++;
                                }
                            }
                            else if(pasta.equals("6")){
                                pontuacao += cenario6[j];
                                if(cenario6[j] == 100){
                                    contJog1++;
                                }
                            }
                            else if(pasta.equals("7")){
                                pontuacao += cenario7[j];
                                if(cenario7[j] == 100){
                                    contJog1++;
                                }
                            }
                            else if(pasta.equals("8")){
                                pontuacao += cenario8[j];
                                if(cenario8[j] == 100){
                                    contJog1++;
                                }
                            }
                            else if(pasta.equals("9")){
                                pontuacao += cenario9[j];
                                if(cenario9[j] == 100){
                                    contJog1++;
                                }
                            }
                            else if(pasta.equals("10")){
                                pontuacao += cenario10[j];
                                if(cenario10[j] == 100){
                                    contJog1++;
                                }
                            }
                            else if(pasta.equals("11")){
                                pontuacao += cenario11[j];
                                if(cenario11[j] == 100){
                                    contJog1++;
                                }
                            }
                            else if(pasta.equals("12")){
                                pontuacao += cenario12[j];
                                if(cenario12[j] == 100){
                                    contJog1++;
                                }
                            }
                            else if(pasta.equals("13")){
                                pontuacao += cenario13[j];
                                if(cenario13[j] == 100){
                                    contJog1++;
                                }
                            }
                            else if(pasta.equals("14")){
                                pontuacao += cenario14[j];
                                if(cenario14[j] == 100){
                                    contJog1++;
                                }
                            }
                            else if(pasta.equals("15")){
                                pontuacao += cenario15[j];
                                if(cenario15[j] == 100){
                                    contJog1++;
                                }
                            }
                        }
                    }
                }
            }
            if(contJog1 == 12 || pontuacao < 0){
                int i = le();
                String[] vetJog1 = jogador01.split(";"); 
                grava(++i,vetJog1[1],Integer.toString(pontuacao));
                int j = le();
                String[] vetJog2 = jogador02.split(";");
                grava(++j,vetJog2[1],Integer.toString(pontuacao2));
            }
            
            request.setAttribute("id", id);
            request.setAttribute("nome", nome);
            request.setAttribute("dificuldade", dificuldade1);
            request.setAttribute("jogadas", jogadas);
            request.setAttribute("pasta", pasta);
            request.setAttribute("bt", bt);
            request.setAttribute("btoff", btoff);
            request.setAttribute("pontuacao", pontuacao);
            request.setAttribute("oponente", jogador02);
            request.setAttribute("pontOponente", pontuacao2);
            request.setAttribute("cont", cont);
            request.setAttribute("contJog1", contJog1);
            request.setAttribute("contJog2", contJog2);
            request.getRequestDispatcher("jogo.jsp").forward(request, response);
        }
        else if(jogador02.equals(chave)){
            for(int i = 0; i<bt2.length; i++){
                if(request.getParameter("botao2"+i) != null){bt2[i] = request.getParameter("botao2"+i); btoff2[i] = "disabled";jogadas++;pontuacao2=0;cont=0;contJog2=0;
                    for(int j = 0; j < bt.length; j++){
                        if(!bt2[j].equals("0")){
                            if(pasta2.equals("1")){
                                pontuacao2 += cenario1[j];
                                if(cenario1[j] == 100){
                                    contJog2++;
                                }
                            }
                            else if(pasta2.equals("2")){
                                pontuacao2 += cenario2[j];
                                if(cenario2[j] == 100){
                                    contJog2++;
                                }
                            }
                            else if(pasta2.equals("3")){
                                pontuacao2 += cenario3[j];
                                if(cenario3[j] == 100){
                                    contJog2++;
                                }
                            }
                            else if(pasta2.equals("4")){
                                pontuacao2 += cenario4[j];
                                if(cenario4[j] == 100){
                                    contJog2++;
                                }
                            }
                            else if(pasta2.equals("5")){
                                pontuacao2 += cenario5[j];
                                if(cenario5[j] == 100){
                                    contJog2++;
                                }
                            }
                            else if(pasta2.equals("6")){
                                pontuacao2 += cenario6[j];
                                if(cenario6[j] == 100){
                                    contJog2++;
                                }
                            }
                            else if(pasta2.equals("7")){
                                pontuacao2 += cenario7[j];
                                if(cenario7[j] == 100){
                                    contJog2++;
                                }
                            }
                            else if(pasta2.equals("8")){
                                pontuacao2 += cenario8[j];
                                if(cenario8[j] == 100){
                                    contJog2++;
                                }
                            }
                            else if(pasta2.equals("9")){
                                pontuacao2 += cenario9[j];
                                if(cenario9[j] == 100){
                                    contJog2++;
                                }
                            }
                            else if(pasta2.equals("10")){
                                pontuacao2 += cenario10[j];
                                if(cenario10[j] == 100){
                                    contJog2++;
                                }
                            }
                            else if(pasta2.equals("11")){
                                pontuacao2 += cenario11[j];
                                if(cenario11[j] == 100){
                                    contJog2++;
                                }
                            }
                            else if(pasta2.equals("12")){
                                pontuacao2 += cenario12[j];
                                if(cenario12[j] == 100){
                                    contJog2++;
                                }
                            }
                            else if(pasta2.equals("13")){
                                pontuacao2 += cenario13[j];
                                if(cenario13[j] == 100){
                                    contJog2++;
                                }
                            }
                            else if(pasta2.equals("14")){
                                pontuacao2 += cenario14[j];
                                if(cenario14[j] == 100){
                                    contJog2++;
                                }
                            }
                            else if(pasta2.equals("15")){
                                pontuacao2 += cenario15[j];
                                if(cenario15[j] == 100){
                                    contJog2++;
                                }
                            }
                        }
                    }
                }
            }
            if(contJog2 == 12 || pontuacao2 < 0){
                int i = le();
                String[] vetJog1 = jogador01.split(";"); 
                grava(++i,vetJog1[1],Integer.toString(pontuacao));
                int j = le();
                String[] vetJog2 = jogador02.split(";");
                grava(++j,vetJog2[1],Integer.toString(pontuacao2));
            }
            
            request.setAttribute("id", id);
            request.setAttribute("nome", nome);
            request.setAttribute("dificuldade", dificuldade2);
            request.setAttribute("jogadas", jogadas);
            request.setAttribute("pasta", pasta2);
            request.setAttribute("bt", bt2);
            request.setAttribute("btoff", btoff2);
            request.setAttribute("pontuacao", pontuacao2);
            request.setAttribute("oponente", jogador01);
            request.setAttribute("pontOponente", pontuacao);
            request.setAttribute("cont", cont);
            request.setAttribute("contJog1", contJog1);
            request.setAttribute("contJog2", contJog2);
            request.getRequestDispatcher("jogo2.jsp").forward(request, response);
        }else{
            request.setAttribute("id", id);
            request.setAttribute("nome", nome);
            request.setAttribute("dificuldade", dificuldade);
            request.setAttribute("pagina", "2");
            request.getRequestDispatcher("aguarde.jsp").forward(request, response);
        }
        
        
        /*response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Servlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Servlet at " + pasta + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }*/
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

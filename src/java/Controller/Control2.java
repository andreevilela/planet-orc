/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static Controller.Control1.crip;
import Model.Jogadores;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Andre
 */
@WebServlet(name = "Control2", urlPatterns = {"/Control2"})
public class Control2 extends HttpServlet {
    
    public static final String paginaLogado = "logado.jsp";
    
    public List<Jogadores> le() throws FileNotFoundException, IOException
    {
            List<Jogadores> result = new ArrayList<>();
            String caminhoDir = getServletContext().getRealPath("/WEB-INF");    
            File arquivo = new File(caminhoDir,"jogadores.txt");
	    if(arquivo.exists())
            {
               String linha;
               String jog = getServletContext().getRealPath("/WEB-INF/jogadores.txt");    
               BufferedReader b = new BufferedReader(
                                      new InputStreamReader(
                                          new FileInputStream(jog), Charset.forName("UTF-8").newDecoder()));
               while(( linha = b.readLine()) != null)
                  if ((linha != null) && (!linha.isEmpty()))
                  {
                    Jogadores c = new Jogadores();
                    String[] vetJogador = linha.split(";");
                    c.setId(Integer.parseInt(vetJogador[0]));
                    c.setNome(vetJogador[1]);
                    c.setEmail(vetJogador[2]);
                    c.setSenha(vetJogador[3]);
                    result.add(c);
                  }
               b.close();
            }
            return result;
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
        
            String email = "";
            String senha = "";
            String nome = "";
            int id = 0;
            boolean achou = false;
        
            //Recebendo variáveis do Post
            if(request.getParameter("e-mail") != null)
                {email = request.getParameter("e-mail");}
            
            if(request.getParameter("senha") != null){
                senha = request.getParameter("senha");
                try {
                    senha = crip(senha);
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(Control2.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedEncodingException ex) {
                    Logger.getLogger(Control2.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            
            List<Jogadores> result = le();
            if(!result.isEmpty())
            {
               for (Jogadores c : result)
                {
                   if(c.getEmail().equalsIgnoreCase(email) && c.getSenha().equalsIgnoreCase(senha)){
                       id = c.getId();
                       nome = c.getNome();
                       achou = true;
                       break;
                   }
                }
               //request.setAttribute("resp", result);
               //request.getRequestDispatcher("Exibicao.jsp").forward(request, response);        
            }
            if(achou){
                request.setAttribute("id", id);
                request.setAttribute("nome", nome);
                request.getRequestDispatcher(paginaLogado).forward(request, response);
            }else{
                request.getRequestDispatcher("erro.jsp").forward(request, response);
               }                    
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

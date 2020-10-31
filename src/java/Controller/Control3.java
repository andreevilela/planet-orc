/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Ranking;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Andre
 */
@WebServlet(name = "Control3", urlPatterns = {"/Control3"})
public class Control3 extends HttpServlet {
    
    public List<Ranking> le() throws FileNotFoundException, IOException
    {
            List<Ranking> result = new ArrayList<>();
            String caminhoDir = getServletContext().getRealPath("/WEB-INF");    
            File arquivo = new File(caminhoDir,"ranking.txt");
	    if(arquivo.exists())
            {
               String linha;
               String rank = getServletContext().getRealPath("/WEB-INF/ranking.txt");    
               BufferedReader b = new BufferedReader(
                                      new InputStreamReader(
                                          new FileInputStream(rank), Charset.forName("UTF-8").newDecoder()));
               while(( linha = b.readLine()) != null)
                  if ((linha != null) && (!linha.isEmpty()))
                  {
                    Ranking c = new Ranking();
                    String[] vetRanking = linha.split(";");
                    c.setId(Integer.parseInt(vetRanking[0]));
                    c.setNome(vetRanking[1]);
                    c.setPontuacao(Integer.parseInt(vetRanking[2]));
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
        response.setContentType("text/html;charset=UTF-8");
        
        List<Ranking> result = le();
        selectionSort(result);
        request.setAttribute("result", result);
        request.getRequestDispatcher("ranking.jsp").forward(request, response);
    }
    
    public static void selectionSort(List<Ranking> entrada) {
        int i, j, posMaior;
        for (i = 0; i < entrada.size(); i++) {
            posMaior = 0;
            for (j = 0; j < entrada.size() - i; j++) {
                if (entrada.get(posMaior).pontuacao > entrada.get(j).pontuacao) {
                    posMaior = j;
                }
            }
            troca(entrada, entrada.size() - i - 1, posMaior);
        }
    }
    
    private static void troca(List<Ranking> entrada, int e1, int e2) {
        Ranking temp = entrada.get(e1);
        entrada.set(e1, entrada.get(e2));
        entrada.set(e2, temp);
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

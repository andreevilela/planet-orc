/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Jogadores;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
@WebServlet(name = "Control1", urlPatterns = {"/Control1"})
public class Control1 extends HttpServlet {
    
    public int le() throws FileNotFoundException, IOException
    {
            int cont=0;
            String caminhoDir = getServletContext().getRealPath("/WEB-INF");    
            File arquivo = new File(caminhoDir,"jogadores.txt");
	    if(arquivo.exists()==false)
                arquivo.createNewFile();
            String jog = getServletContext().getRealPath("/WEB-INF/jogadores.txt");    
            BufferedReader b = new BufferedReader(
                                   new InputStreamReader(
                                       new FileInputStream(jog), Charset.forName("UTF-8").newDecoder()));
            while(b.readLine() != null)
                    cont++;
            b.close();
            return cont;
    }
    
    public void grava(Jogadores c) throws IOException
    {
            String caminhoDir = getServletContext().getRealPath("/WEB-INF");    
            File arquivo = new File(caminhoDir,"jogadores.txt");
	    if(arquivo.exists()==false)
                arquivo.createNewFile();
            String jog = getServletContext().getRealPath("/WEB-INF/jogadores.txt");    
            OutputStreamWriter g = new OutputStreamWriter(
                                       new FileOutputStream(jog,true),Charset.forName("UTF-8").newEncoder());
            BufferedWriter b = new BufferedWriter(g);
            b.write(c.getId()+";");
            b.write(c.getNome()+";");
            b.write(c.getEmail()+";");
            try {
                b.write(crip(c.getSenha()));
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(Control1.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(Control1.class.getName()).log(Level.SEVERE, null, ex);
            }
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
        
            request.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=UTF-8");

            int cont = le();
            Jogadores c = new Jogadores();
            c.setId(++cont);
            c.setNome(request.getParameter("nome"));
            c.setEmail(request.getParameter("e-mail"));
            c.setSenha(request.getParameter("senha"));
            grava(c);
            response.sendRedirect( "cadastrado.jsp" );  
    }
    
    public static String crip(String entrada) throws NoSuchAlgorithmException, UnsupportedEncodingException{            
        MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
        byte messageDigest[] = algorithm.digest(entrada.getBytes("UTF-8"));

        StringBuilder hexString = new StringBuilder();
        for (byte b : messageDigest) {
          hexString.append(String.format("%02X", 0xFF & b));
        }
        String senhahex = hexString.toString();

        //System.out.println(senhahex);
        return senhahex;
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

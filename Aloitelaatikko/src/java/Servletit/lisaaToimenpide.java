/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servletit;

import Tietovarastopakkaus.Tietovarasto;
import Tietovarastopakkaus.Toimenpide;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author s1601385
 */
@WebServlet(name = "lisaaToimenpide", urlPatterns = {"/lisaaToimenpide"})
public class lisaaToimenpide extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    //Määritellään viittaus Tietovarato-luokkaan
    private Tietovarasto tietovarasto = new Tietovarasto();
     //Määritellään päiväysolio ja päiväysformaatti 
    private Date date = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
        String kuvaus = request.getParameter("kuvaus");
        String kayttajaID = request.getParameter("kayttajaID");
        String aloiteID = request.getParameter("kuvaus");
        String luontipaivays = sdf.format(date);
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet lisaaToimenpide</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet lisaaToimenpide at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            
            out.println("Kuvaus:"+kuvaus+"<br>");
            out.println("KäyttäjäID: "+kayttajaID+"<br>");
            out.println("AloiteID: "+aloiteID+"<br>");
            out.println("Luontipäivä: "+luontipaivays+"<br>");
            
            //Tallennetaan toimenpide. Luodaan toimenpide-olio lomakkeelta
            Toimenpide toimipide = new Toimenpide (0,kuvaus,luontipaivays,Integer.parseInt(kayttajaID),Integer.parseInt(aloiteID));
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

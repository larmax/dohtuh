/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package register;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author s1601385
 */
public class RegisterController extends HttpServlet {

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
        request.getRequestDispatcher("index.html").forward(request, response);
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
        // validointi: tarkista, etä kaikki kentät on täytetty
        UserBean user = new UserBean();
       user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));

        PrintWriter out = response.getWriter();
        String connectionURL = "jdbc:mysql://localhost/dblogin";
        Connection connection = null;
        ResultSet rs = null;
        try {
                 ArrayList<String> errors = new ArrayList<>();
                
                if (user.getUsername().isEmpty()) {
                    errors.add("Käyttäjänimi puuttuu");
                }
                if (user.getPassword().isEmpty()) {
                    errors.add("Salasana puuttuu");
                }
                
        
            if(rs.next()) {
              
            }
            else {
              errors.add("Käyttäjää ei löydy");
                
           
                
                if (errors.isEmpty()) {
                    // jos on, ohjaa sivulle
                    request.getRequestDispatcher("succes.jsp").forward(request, response);
                } else {
                    //jos ei ole, ohjaa takaisin register-sivulle ja välitä virheilmoitukset ja lomakkeen tiedot takaisin
                    request.setAttribute("errors", errors);
                    request.setAttribute("user", user);
                    request.getRequestDispatcher("register.jsp").forward(request, response);
                }
                
            }
            // jos on, ohjaa succes-sivulle
            //jos ei ole, ohjaa takaisin register-sivulle ja välitä lomakkeen tiedot takaisin
        } catch (SQLException ex) {
            Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
            
        }
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

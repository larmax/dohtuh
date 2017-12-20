/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tietovarasto;

import java.sql.*;

public class YhteydenHallinta {

    // Metodi avaa yhteyden tietokantaan
    public static Connection avaaYhteys(String ajuri, String url,
            String kayttaja, String salasana) {
        try {
            Class.forName(ajuri).newInstance();
            return DriverManager.getConnection(url, kayttaja, salasana);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    // Metodi joka sulkee tietokantayhteyden
    public static void suljeYhteys(Connection suljettavaYhteys) {
        if (suljettavaYhteys != null) {
            try {
                suljettavaYhteys.close();
            } catch (Exception e) {
                //ei mitään tehtävissä
            }
        }
    }
    
    // Metodi, joka sulkee 
    public static void suljeLause(Statement suljettavaLause) {
        if (suljettavaLause != null) {
            try {
                suljettavaLause.close();
            } catch (Exception e) {
                //ei mitään tehtävissä
            }
        }
    }
   
    // Metodi, joka sulkee tietuejoukon
    public static void suljeTulosjoukko(ResultSet suljettavaTulosjoukko) {
        if (suljettavaTulosjoukko != null) {
            try {
                suljettavaTulosjoukko.close();
            } catch (Exception e) {
                //ei mitään tehtävissä
            }
        }
    }
}

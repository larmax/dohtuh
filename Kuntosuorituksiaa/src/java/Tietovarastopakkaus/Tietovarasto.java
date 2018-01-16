/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tietovarastopakkaus;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author s1601385
 */
public class Tietovarasto {
      private String ajuri;
    private String url;
    private int hiihtokilometrit;
private      int hölkkäkilometrit ;
private      int kävelykilometrit;
private              String luontipaivays;


    public Tietovarasto(String ajuri, String url, int hiihtokilometrit, int hölkkäkilometrit, int kävelykilometrit, String luontipaivays) {
        this.ajuri = ajuri;
        this.url = url;
        this.hiihtokilometrit = hiihtokilometrit;
        this.hölkkäkilometrit = hölkkäkilometrit;
        this.kävelykilometrit = kävelykilometrit;
        this.luontipaivays = luontipaivays;
    }


   
    
   public Tietovarasto() {
        this("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/kuntosuoritukset", "root", "");
    }
    
    public boolean lisaaKuntoilija(Kuntoilija kuntoilija){
        Connection yhteys = null;
        PreparedStatement lisayslause = null;
        
        try{
            // Otetaan yhteys tietokantaan
            yhteys = YhteydenHallinta.avaaYhteys(ajuri, url, kuntoilijatunnus, salasana);
            //jos yhteyttä ei saada, niin palautetaan false
            if(yhteys == null){
                   return false;
            }
            
             
            
            // Määritellään lisäystä varten SQL-lauseet
            String lisaaKayttajaSQL = "insert into kuntoilijat values(?,?,?,?)";
            
            // Valmistellaan SQL-lause tietokantapalvelinta varten
            
            lisayslause = yhteys.prepareStatement(lisaaKayttajaSQL);
            
            lisayslause.setInt(1, kuntoilija.getHiihtokilometrit());
            lisayslause.setInt(2, kuntoilija.getHölkkäkilometrit());
            lisayslause.setInt(3, kuntoilija.getKävelykilometrit());

            lisayslause.setString(8, kuntoilija.getLuontipaivays());
            // Suoritetaan palvelimella SQL-lause
            return lisayslause.executeUpdate() > 0;
        }catch(Exception ex){
            // Jos tuli virhe, niin hypätään tänne
            ex.getMessage();
            return false;
        }finally{
           // Suljetaan yhteysx tietokantaa
           YhteydenHallinta.suljeLause(lisayslause);
           YhteydenHallinta.suljeYhteys(yhteys);
        }    
    }
    
 
    
}

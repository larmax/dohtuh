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
    
    // Yhteysmuuttujat
    private String ajuri;
    private String url;
    private String kayttajatunnus;
    private String salasana;

    public Tietovarasto(String ajuri, String url, String kayttajatunnus, String salasana) {
        this.ajuri = ajuri;
        this.url = url;
        this.kayttajatunnus = kayttajatunnus;
        this.salasana = salasana;
    }
    
   public Tietovarasto() {
        this("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/ahven", "root", "");
    }
    
    public boolean lisaaKayttaja(Kayttaja kayttaja){
        Connection yhteys = null;
        PreparedStatement lisayslause = null;
        
        try{
            // Otetaan yhteys tietokantaan
            yhteys = YhteydenHallinta.avaaYhteys(ajuri, url, kayttajatunnus, salasana);
            //jos yhteyttä ei saada, niin palautetaan false
            if(yhteys == null){
                   return false;
            }
            
             
            
            // Määritellään lisäystä varten SQL-lauseet
            String lisaaKayttajaSQL = "insert into kayttajat values(?,?,?)";
            
            // Valmistellaan SQL-lause tietokantapalvelinta varten
            
            lisayslause = yhteys.prepareStatement(lisaaKayttajaSQL);
            
            lisayslause.setInt(1, kayttaja.getKayttajaID());
            lisayslause.setString(2, kayttaja.getEtunimi());
            lisayslause.setString(3, kayttaja.getSukunimi());
            lisayslause.setString(4, kayttaja.getEmail());
            lisayslause.setString(5, kayttaja.getKayttajaTunnus());
            lisayslause.setString(6, kayttaja.getSalasana());
            lisayslause.setString(7, kayttaja.getPuhelin());
            lisayslause.setString(8, kayttaja.getLuontipaivays());
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
    
    public boolean lisaaAloite(Aloite aloite){
        Connection yhteys = null;
        PreparedStatement lisayslause = null;
        
        try{
            // Otetaan yhteys tietokantaan
            yhteys = YhteydenHallinta.avaaYhteys(ajuri, url, kayttajatunnus, salasana);
            //jos yhteyttä ei saada, niin palautetaan false
            if(yhteys == null){
                return false;
            }
            
            // Määritellään lisäystä varten SQL-lauseet
            String lisaaKayttajaSQL = "insert into aloitteet values(?,?,?,?,?)";
            
            // Valmistellaan SQL-lause tietokantapalvelinta varten
            
            lisayslause = yhteys.prepareStatement(lisaaKayttajaSQL);
            
            lisayslause.setInt(1, aloite.getAloiteID());
            lisayslause.setString(2, aloite.getAloitenimi());
            lisayslause.setString(3, aloite.getAloitekuvaus());
            lisayslause.setString(4, aloite.getPvm());
            lisayslause.setInt(5, aloite.getKayttajaID());
            
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
    public boolean lisaaToimenpide(Toimenpide toimenpide){
         Connection yhteys = null;
        PreparedStatement lisayslause = null;

        try {
            // Otetaan yhteys tietokantaan
            yhteys = YhteydenHallinta.avaaYhteys(ajuri, url, kayttajatunnus, salasana);
            //jos yhteyttä ei saada, niin palautetaan false
            if (yhteys == null) {
                return false;
            }

            //Määritellään lisäystä varten SQL-lauseet
            String lisaaToimenpideSQL = "insert into toimenpiteet values(?,?,?,?,?)";

            //Valmistellaan SQL-lause tietokantapalvelinta varten
            lisayslause = yhteys.prepareStatement(lisaaToimenpideSQL);

            lisayslause.setInt(1, toimenpide.getToimenpideID());
            lisayslause.setString(2, toimenpide.getKuvaus());
            lisayslause.setString(3, toimenpide.getPvm());
            lisayslause.setString(4, toimenpide.getKayttajaID());
            lisayslause.setString(5, toimenpide.getAloiteID());

            //Seuoritetaan palvelimella SQL-lause
            return lisayslause.executeUpdate() > 0;

        } catch (SQLException ex) {
            //Jos tuli virhe niin hypätään tänne
            ex.printStackTrace();
            return false;
        } finally {
            //Suljetaan yhteys tietokantaan
            YhteydenHallinta.suljeLause(lisayslause);
            YhteydenHallinta.suljeYhteys(yhteys);
        }
    }
}

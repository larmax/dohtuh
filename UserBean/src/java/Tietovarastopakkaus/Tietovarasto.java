/*
 * To change this license header, choose License Headers in Project Properties. 
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tietovarastopakkaus;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import register.UserBean;

/**
 *
 * @author s1601385
 */
public class Tietovarasto {
    
    // Yhteysmuuttujat
    private String ajuri;
    private String url;
    private String kayttajanimi;
    private String salasana;

    public Tietovarasto(String ajuri, String url, String kayttajatunnus, String salasana) {
        this.ajuri = ajuri;
        this.url = url;
        this.kayttajanimi = kayttajatunnus;
        this.salasana = salasana;
    }
    
    public Tietovarasto(){
        this("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/ahven", "root", "");
    }
    
 
    
    public boolean lisaaKayttaja(UserBean kayttaja){
        Connection yhteys = null;
        PreparedStatement lisayslause = null;
        
        try{
            // Otetaan yhteys tietokantaan
            yhteys = YhteydenHallinta.avaaYhteys(ajuri, url, kayttajanimi, salasana);
            //jos yhteyttä ei saada, niin palautetaan false
            if(yhteys == null){
                return false;
            }
            
            // Määritellään lisäystä varten SQL-lauseet
            String lisaaKayttajaSQL = "insert into kayttaja values(?,?,?)";
            
            // Valmistellaan SQL-lause tietokantapalvelinta varten
            
            lisayslause = yhteys.prepareStatement(lisaaKayttajaSQL);
            
            lisayslause.setInt(1, kayttaja.getID());

            lisayslause.setString(2, kayttaja.getKayttajanimi());
            lisayslause.setString(3, kayttaja.getSalasana());

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
    public boolean usernameAvailable(String kayttajanimmi) {
        //Määritellään tietokannan käsittelyyn tarvittavat oliomuuttujat
        Connection yhteys = null;
        PreparedStatement hakulause = null;
        ResultSet tulosjoukko = null;
        try {
            //Avataan tietokantayhteys
            yhteys = YhteydenHallinta.avaaYhteys(ajuri, url, kayttajanimi, salasana);
            //tarkistetaan onko yhteys tietokantaan olemassa
            if (yhteys == null) {
                return false;
            }
            //Määritellään SQL-lause, jolla haetaan kaikki aloitteet
            String haeKaikkiSql = "SELECT * FROM kayttaja WHERE Kayttajanimi=?";
            //Suoritetaan tietohaku
            hakulause = yhteys.prepareStatement(haeKaikkiSql);
            hakulause.setString(1, kayttajanimmi);
            tulosjoukko = hakulause.executeQuery();
            if (tulosjoukko.next()) {
                return false;
            } else {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            YhteydenHallinta.suljeTulosjoukko(tulosjoukko);
            YhteydenHallinta.suljeLause(hakulause);
            YhteydenHallinta.suljeYhteys(yhteys);
        }
    }
}

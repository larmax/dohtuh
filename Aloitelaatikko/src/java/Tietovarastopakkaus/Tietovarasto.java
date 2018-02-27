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
        this("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/aloitelaatikko", "root", "");
    }

    public boolean lisaaKayttaja(Kayttaja kayttaja) {
        Connection yhteys = null;
        PreparedStatement lisayslause = null;

        try {
            // Otetaan yhteys tietokantaan
            yhteys = YhteydenHallinta.avaaYhteys(ajuri, url, kayttajatunnus, salasana);
            System.out.println("Yhteys avattu: " + url);
            //jos yhteyttä ei saada, niin palautetaan false
            if (yhteys == null) {
                System.out.println("Tietokantayhteyttä ei saatu avattua");
                return false;
            }

            // Määritellään lisäystä varten SQL-lauseet
            String lisaaKayttajaSQL = "insert into kayttajat values(?,?,?,?,?,?,?,?)";

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
        } catch (Exception ex) {
            // Jos tuli virhe, niin hypätään tänne
            System.out.println(ex.getMessage());
            return false;
        } finally {
            // Suljetaan yhteysx tietokantaa
            YhteydenHallinta.suljeLause(lisayslause);
            YhteydenHallinta.suljeYhteys(yhteys);
        }
    }

    public boolean lisaaAloite(Aloite aloite) {
        Connection yhteys = null;
        PreparedStatement lisayslause = null;

        try {
            // Otetaan yhteys tietokantaan
            yhteys = YhteydenHallinta.avaaYhteys(ajuri, url, kayttajatunnus, salasana);
            //jos yhteyttä ei saada, niin palautetaan false
            if (yhteys == null) {
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
        } catch (Exception ex) {
            // Jos tuli virhe, niin hypätään tänne
            ex.getMessage();
            return false;
        } finally {
            // Suljetaan yhteysx tietokantaa
            YhteydenHallinta.suljeLause(lisayslause);
            YhteydenHallinta.suljeYhteys(yhteys);
        }
    }

    public boolean lisaaToimenpide(Toimenpide toimenpide) {
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
            lisayslause.setInt(4, toimenpide.getKayttajaID());
            lisayslause.setInt(5, toimenpide.getAloiteID());

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

    public Kayttaja login(String kayttajatunnus, String salasana) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Kayttaja> haeKaikkiKayttajat() {
        // Luodaan lista käyttäjistä
        List<Kayttaja> kayttajat = new ArrayList<>();
        // Määritellään tietokannan käsittelyyn tarvittavat oliomuuttujat
        Connection yhteys = null;
        PreparedStatement hakulause = null;
        ResultSet tulosjoukko = null;
        try {
            // Avataan tietokantayhteys
            yhteys = YhteydenHallinta.avaaYhteys(ajuri, url, kayttajatunnus, salasana);
            // Tarkistetaan onko yhteys tietokantaan olemassa
            if (yhteys != null) {
                // Määritellään SQL-lause, jolla haetaan kaikki käyttäjät
                String haeKaikkiSql = "select * from kayttajat";
                // Suoritetaan tietokantahaku
                hakulause = yhteys.prepareStatement(haeKaikkiSql);
                // Talletetaan kaikki käyttäjät oliomuuttujaan tulosjoukko
                tulosjoukko = hakulause.executeQuery();
            }
            // Luodaan lista käyttäjistä
            while (tulosjoukko.next()) {

                int kayttajaID = tulosjoukko.getInt("kayttajaID");
                String etunimi = tulosjoukko.getString("etunimi");
                String sukunimi = tulosjoukko.getString("sukunimi");
                String email = tulosjoukko.getString("email");
                String kayttajatunnus = tulosjoukko.getString("kayttajatunnus");
                String salasana = tulosjoukko.getString("salasana");
                String puhelin = tulosjoukko.getString("puhelin");
                String luontipaivays = tulosjoukko.getString("luontipaivays");
//                int ryhmaID = tulosjoukko.getInt("ryhmaID");

                // Lisätään Kayttaja-olio listaan kayttajat
                kayttajat.add(new Kayttaja(kayttajaID, etunimi, sukunimi, email, kayttajatunnus, salasana, puhelin, luontipaivays));

            }
        } catch (SQLException e) {
            System.out.println("Virhettä pukkaa!" + e.getMessage());
            return null;
        } finally {
            // Suljetaan yhteydet
            YhteydenHallinta.suljeTulosjoukko(tulosjoukko);
            YhteydenHallinta.suljeLause(hakulause);
            YhteydenHallinta.suljeYhteys(yhteys);
        }
        // Palautetaan lista käyttäjistä
        return kayttajat;
    }

    public List<Aloite> haeKaikkiAloitteet() {
        // Luodaan lista käyttäjistä
        List<Aloite> aloitteet = new ArrayList<>();
        // Määritellään tietokannan käsittelyyn tarvittavat oliomuuttujat
        Connection yhteys = null;
        PreparedStatement hakulause = null;
        ResultSet tulosjoukko = null;
        try {
            // Avataan tietokantayhteys
            yhteys = YhteydenHallinta.avaaYhteys(ajuri, url, kayttajatunnus, salasana);
            // Tarkistetaan onko yhteys tietokantaan olemassa
            if (yhteys != null) {
                // Määritellään SQL-lause, jolla haetaan kaikki käyttäjät
                String haeKaikkiSql = "select * from aloitteet";
                // Suoritetaan tietokantahaku
                hakulause = yhteys.prepareStatement(haeKaikkiSql);
                // Talletetaan kaikki käyttäjät oliomuuttujaan tulosjoukko
                tulosjoukko = hakulause.executeQuery();
            }
            // Luodaan lista käyttäjistä
            while (tulosjoukko.next()) {

                int kayttajaID = tulosjoukko.getInt("kayttajaID");
                int aloiteID = tulosjoukko.getInt("aloiteID");
                String aloitenimi = tulosjoukko.getString("aloitenimi");
                String aloitekuvaus = tulosjoukko.getString("aloitekuvaus");
                String pvm = tulosjoukko.getString("pvm");

                // Lisätään Kayttaja-olio listaan kayttajat
                aloitteet.add(new Aloite(aloiteID, aloitenimi, aloitekuvaus, pvm, kayttajaID));

            }
        } catch (SQLException e) {
            System.out.println("Virhettä pukkaa!" + e.getMessage());
            return null;
        } finally {
            // Suljetaan yhteydet
            YhteydenHallinta.suljeTulosjoukko(tulosjoukko);
            YhteydenHallinta.suljeLause(hakulause);
            YhteydenHallinta.suljeYhteys(yhteys);
        }
        // Palautetaan lista käyttäjistä
        return aloitteet;
    }
    public void poistaKayttaja(int id){
                Connection yhteys = null;
        PreparedStatement poistolause = null;

        try {
            // Otetaan yhteys tietokantaan
            yhteys = YhteydenHallinta.avaaYhteys(ajuri, url, kayttajatunnus, salasana);
            System.out.println("Yhteys avattu: " + url);
            //jos yhteyttä ei saada, niin palautetaan false
            if (yhteys == null) {
                System.out.println("Tietokantayhteyttä ei saatu avattua");
            
            }

            // Määritellään lisäystä varten SQL-lauseet
            String poistaKayttajaSQL = "UPDATE Kayttajat" +
"SET kayttajanimi = 'poistettu', etunimi = 'poistettu', sukunimi = 'poistettu',email = 'poistettu', email = 'poistettu', salasana 'poistettu'" +
"WHERE kayttajaID = ?;";

            // Valmistellaan SQL-lause tietokantapalvelinta varten
            poistolause = yhteys.prepareStatement(poistaKayttajaSQL);

            poistolause.setInt(1, kayttaja.getKayttajaID());
            
    
          } catch (Exception ex) {
            // Jos tuli virhe, niin hypätään tänne
            System.out.println(ex.getMessage());
            
        } finally {
            // Suljetaan yhteysx tietokantaa
            YhteydenHallinta.suljeLause(poistolause);
            YhteydenHallinta.suljeYhteys(yhteys);
        }
}

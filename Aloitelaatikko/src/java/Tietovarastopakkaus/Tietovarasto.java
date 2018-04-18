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
    Enum Aktiivinen;

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
            String lisaaKayttajaSQL = "insert into kayttajat (kayttajaID, etunimi, sukunimi, email, kayttajatunnus, salasana, puhelin, luontipaivays, ryhmaID, Aktiivinen) values(?,?,?,?,?,?,?,?,?,?)";

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
            lisayslause.setInt(9, kayttaja.getRyhmaID());
            lisayslause.setString(10, "Aktiivinen");
            // Suoritetaan palvelimella SQL-lause
                return lisayslause.executeUpdate() > 0;
        } catch (SQLException ex) {
            // Jos tuli virhe, niin hypätään tänne
                 System.out.println("Virhettä Pukkaa");
            ex.printStackTrace();
           
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
            String lisaaAloiteSQL = "insert into aloitteet values(?,?,?,?,?)";

            // Valmistellaan SQL-lause tietokantapalvelinta varten
            lisayslause = yhteys.prepareStatement(lisaaAloiteSQL);

            lisayslause.setInt(1, aloite.getAloiteID());
            lisayslause.setString(2, aloite.getAloitenimi());
            lisayslause.setString(3, aloite.getAloitekuvaus());
            lisayslause.setString(4, aloite.getPvm());
            lisayslause.setInt(5, aloite.getKayttajaID());

            // Suoritetaan palvelimella SQL-lause
            return lisayslause.executeUpdate() > 0;
        } catch (Exception ex) {
            // Jos tuli virhe, niin hypätään tänne
                   System.out.println("Virhettä Pukkaa");
            ex.getMessage();
      
            ex.printStackTrace();
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
            }else{

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
            }
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
        throw new UnsupportedOperationException("login ei oo valmis."); //To change body of generated methods, choose Tools | Templates.
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
                int ryhmaID = tulosjoukko.getInt("ryhmaID");
                String aktiivinen = tulosjoukko.getString("aktiivinen");

                // Lisätään Kayttaja-olio listaan kayttajat
                kayttajat.add(new Kayttaja(kayttajaID, etunimi, sukunimi, email, kayttajatunnus, salasana, puhelin, luontipaivays, ryhmaID, aktiivinen));

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

    public enum Aktiivinen {
        Aktiivinen,
        Poistettu
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

    public void poistaKayttaja(int id) {
        Connection yhteys = null;
        PreparedStatement poistolause = null;
        System.out.println("Käyttäjä: " + id);
        try {
            // Otetaan yhteys tietokantaan
            yhteys = YhteydenHallinta.avaaYhteys(ajuri, url, kayttajatunnus, salasana);
            System.out.println("Yhteys avattu: " + url);

            //jos yhteyttä ei saada, niin palautetaan false
            if (yhteys == null) {
                System.out.println("Tietokantayhteyttä ei saatu avattua");

            }

            // Määritellään lisäystä varten SQL-lauseet
            String poistaKayttajaSQL = "UPDATE kayttajat "
                    + "SET Aktiivinen = \"Poistettu\""
                    + "WHERE kayttajaID = ?;";

            System.out.println(poistaKayttajaSQL);

            // Valmistellaan SQL-lause tietokantapalvelinta varten
            poistolause = yhteys.prepareStatement(poistaKayttajaSQL);

            poistolause.setInt(1, id);
            System.out.println(poistolause.executeUpdate() + " riviä poistettu");

        } catch (SQLException ex) {
            // Jos tuli virhe, niin hypätään tänne
            ex.printStackTrace();

        } finally {
            // Suljetaan yhteysx tietokantaa
            YhteydenHallinta.suljeLause(poistolause);
            YhteydenHallinta.suljeYhteys(yhteys);
        }
    }
    public void muokkaaAloitetta(Aloite aloite) {
        // Luodaan lista käyttäjistä
        List<Aloite> aloitteet = new ArrayList<>();
        // Määritellään tietokannan käsittelyyn tarvittavat oliomuuttujat
        Connection yhteys = null;
        PreparedStatement lisayslause = null;
        ResultSet tulosjoukko = null;
        
      
        
        try {
            // Avataan tietokantayhteys
            yhteys = YhteydenHallinta.avaaYhteys(ajuri, url, kayttajatunnus, salasana);
            // Tarkistetaan onko yhteys tietokantaan olemassa
            if (yhteys != null) {
                 lisayslause.setInt(3, aloite.getAloiteID());
                 lisayslause.setString(3, aloite.getAloitenimi());
                  lisayslause.setString(3, aloite.getAloitekuvaus());
                  int aloiteID = aloite.getAloiteID();
                  String aloitenimi = aloite.getAloitenimi();
                  String aloitekuvaus = aloite.getAloitekuvaus();
                // Määritellään SQL-lause, jolla haetaan kaikki käyttäjät
                String muokkaaAloitettaSQL = "UPDATE aloitteet SET alotekuvaus = "+aloitekuvaus+", Aloitenimi= "+aloitenimi+" WHERE aloiteID = "+aloiteID+";";
                // Suoritetaan tietokantahaku
                lisayslause = yhteys.prepareStatement(muokkaaAloitettaSQL);
                
                // Talletetaan kaikki käyttäjät oliomuuttujaan tulosjoukko
                tulosjoukko = lisayslause.executeQuery();
            }
           
        } catch (SQLException e) {
            System.out.println("Virhettä pukkaa!" + e.getMessage());
           
        } finally {
            // Suljetaan yhteydet
            YhteydenHallinta.suljeTulosjoukko(tulosjoukko);
            YhteydenHallinta.suljeLause(lisayslause);
            YhteydenHallinta.suljeYhteys(yhteys);
        }
      
        
    }
    public Aloite haeAloite(int aloiteID) {
      
      
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
                String haeKaikkiSql = "select * WHERE aloiteID = ? from aloitteet";
                // Suoritetaan tietokantahaku
                hakulause = yhteys.prepareStatement(haeKaikkiSql);
                hakulause.setInt(1,aloiteID);
                // Talletetaan kaikki käyttäjät oliomuuttujaan tulosjoukko
                tulosjoukko = hakulause.executeQuery();
            }
            // Luodaan lista käyttäjistä
          
            int kayttajaID = tulosjoukko.getInt("kayttajaID");
               
                String aloitenimi = tulosjoukko.getString("aloitenimi");
                String aloitekuvaus = tulosjoukko.getString("aloitekuvaus");
                 String pvm = tulosjoukko.getString("pvm");
            
                Aloite aloite = new Aloite(aloiteID, aloitenimi, aloitekuvaus, pvm, kayttajaID );
                return aloite;
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
        
    }
}

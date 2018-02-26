/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tietovarastopakkaus;

/**
 *
 * @author s1601385
 */
public class Toimenpide {
    
    
    private int toimenpideID;
    private String kuvaus;
    private String pvm;
    private int kayttajaID;
    private int aloiteID;

    public Toimenpide(int toimenpideID, String kuvaus, String pvm, int kayttajaID, int aloiteID) {
        this.kuvaus = kuvaus;
        this.pvm = pvm;
        this.kayttajaID = kayttajaID;
        this.aloiteID = aloiteID;
        this.toimenpideID = toimenpideID;
    }

    public String getKuvaus() {
        return kuvaus;
    }

    public String getPvm() {
        return pvm;
    }

    public int getKayttajaID() {
        return kayttajaID;
    }

    public int getAloiteID() {
        return aloiteID;
    }
    
    public int getToimenpideID() {
        return toimenpideID;
    }
    
}
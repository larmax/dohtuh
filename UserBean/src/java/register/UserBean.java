/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package register;

import java.beans.*;
import java.io.Serializable;

/**
 *
 * @author s1601402
 */
public class UserBean implements Serializable {

    private String kayttajanimi;
    private String salasana;
    private int KayttajaID;


    public UserBean() {

    }

    /**
     * @return the kayttajaNimi
     */
    public String getKayttajanimi() {
        return kayttajanimi;
    }

    /**
     * @param kayttajaNimi the kayttajaNimi to set
     */
    public void setKayttjanimi(String kayttajanimi) {
        this.kayttajanimi = kayttajanimi;
    }

    /**
     * @return the salasana
     */
    public String getSalasana() {
        return salasana;
    }

    /**
     * @param password the salasana to set
     */
    public void setSalasana(String salasana) {
        this.salasana = salasana;
    }

    /**
     * @return the KayttajaID
     */
    public int getID() {
        return KayttajaID;
    }

    /**
     * @param email the KayttajaID to set
     */
    public void setID(int email) {
        this.KayttajaID = email;
    }


}

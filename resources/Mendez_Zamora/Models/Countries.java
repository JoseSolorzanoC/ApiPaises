/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author aleja
 */
public class Countries {
    int countryid;
    String name_country, flag_country, capital_country;
    char state_country, condereg_country;
    double coordinate_alt_country, coordinate_lat_country;

    public Countries(int countryid, String name_country, String flag_country, String capital_country, char state_country, char condereg_country, double coordinate_alt_country, double coordinate_lat_country) {
        this.countryid = countryid;
        this.name_country = name_country;
        this.flag_country = flag_country;
        this.capital_country = capital_country;
        this.state_country = state_country;
        this.condereg_country = condereg_country;
        this.coordinate_alt_country = coordinate_alt_country;
        this.coordinate_lat_country = coordinate_lat_country;
    }

    public Countries() {
    }

    public int getCountryid() {
        return countryid;
    }

    public void setCountryid(int countryid) {
        this.countryid = countryid;
    }

    public String getName_country() {
        return name_country;
    }

    public void setName_country(String name_country) {
        this.name_country = name_country;
    }

    public String getFlag_country() {
        return flag_country;
    }

    public void setFlag_country(String flag_country) {
        this.flag_country = flag_country;
    }

    public String getCapital_country() {
        return capital_country;
    }

    public void setCapital_country(String capital_country) {
        this.capital_country = capital_country;
    }

    public char getState_country() {
        return state_country;
    }

    public void setState_country(char state_country) {
        this.state_country = state_country;
    }

    public char getCondereg_country() {
        return condereg_country;
    }

    public void setCondereg_country(char condereg_country) {
        this.condereg_country = condereg_country;
    }

    public double getCoordinate_alt_country() {
        return coordinate_alt_country;
    }

    public void setCoordinate_alt_country(double coordinate_alt_country) {
        this.coordinate_alt_country = coordinate_alt_country;
    }

    public double getCoordinate_lat_country() {
        return coordinate_lat_country;
    }

    public void setCoordinate_lat_country(double coordinate_lat_country) {
        this.coordinate_lat_country = coordinate_lat_country;
    }
    
    

   
    
    
    
    
    
    
    
}

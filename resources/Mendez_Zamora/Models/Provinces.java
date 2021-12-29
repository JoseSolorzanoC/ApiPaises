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
public class Provinces {
    int provinceid, tbcountries_countryid;
    double coordinate_alt_province, coordinate_lat_province;
    String name_province, flag_province, capital_province, codereg_province, state_province;

    public int getProvinceid() {
        return provinceid;
    }

    public void setProvinceid(int provinceid) {
        this.provinceid = provinceid;
    }

    public int getTbcountries_countryid() {
        return tbcountries_countryid;
    }

    public void setTbcountries_countryid(int tbcountries_countryid) {
        this.tbcountries_countryid = tbcountries_countryid;
    }

    public double getCoordinate_alt_province() {
        return coordinate_alt_province;
    }

    public void setCoordinate_alt_province(double coordinate_alt_province) {
        this.coordinate_alt_province = coordinate_alt_province;
    }

    public double getCoordinate_lat_province() {
        return coordinate_lat_province;
    }

    public void setCoordinate_lat_province(double coordinate_lat_province) {
        this.coordinate_lat_province = coordinate_lat_province;
    }

    public String getName_province() {
        return name_province;
    }

    public void setName_province(String name_province) {
        this.name_province = name_province;
    }

    public String getFlag_province() {
        return flag_province;
    }

    public void setFlag_province(String flag_province) {
        this.flag_province = flag_province;
    }

    public String getCapital_province() {
        return capital_province;
    }

    public void setCapital_province(String capital_province) {
        this.capital_province = capital_province;
    }

    public String getCodereg_province() {
        return codereg_province;
    }

    public void setCodereg_province(String codereg_province) {
        this.codereg_province = codereg_province;
    }

    public String getState_province() {
        return state_province;
    }

    public void setState_province(String state_province) {
        this.state_province = state_province;
    }

    public Provinces(int provinceid, int tbcountries_countryid, double coordinate_alt_province, double coordinate_lat_province, String name_province, String flag_province, String capital_province, String codereg_province, String state_province) {
        this.provinceid = provinceid;
        this.tbcountries_countryid = tbcountries_countryid;
        this.coordinate_alt_province = coordinate_alt_province;
        this.coordinate_lat_province = coordinate_lat_province;
        this.name_province = name_province;
        this.flag_province = flag_province;
        this.capital_province = capital_province;
        this.codereg_province = codereg_province;
        this.state_province = state_province;
    }

    public Provinces() {
    }
    
    
    
    
    
}

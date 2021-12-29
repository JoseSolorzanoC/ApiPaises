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
public class City {
    int cityid, tbprovinces_provinceid;
    String name_city, flag_city, cabecera_city;
    char condereg_city, state_city;
    double coordinate_alt_city, coordinate_lat_city;

    public City(int cityid, int tbprovinces_provinceid, String name_city, String flag_city, String cabecera_city, char condereg_city, char state_city, double coordinate_alt_city, double coordinate_lat_city) {
        this.cityid = cityid;
        this.tbprovinces_provinceid = tbprovinces_provinceid;
        this.name_city = name_city;
        this.flag_city = flag_city;
        this.cabecera_city = cabecera_city;
        this.condereg_city = condereg_city;
        this.state_city = state_city;
        this.coordinate_alt_city = coordinate_alt_city;
        this.coordinate_lat_city = coordinate_lat_city;
    }

    public City() {
    }

    public int getCityid() {
        return cityid;
    }

    public void setCityid(int cityid) {
        this.cityid = cityid;
    }

    public int getTbprovinces_provinceid() {
        return tbprovinces_provinceid;
    }

    public void setTbprovinces_provinceid(int tbprovinces_provinceid) {
        this.tbprovinces_provinceid = tbprovinces_provinceid;
    }

    public String getName_city() {
        return name_city;
    }

    public void setName_city(String name_city) {
        this.name_city = name_city;
    }

    public String getFlag_city() {
        return flag_city;
    }

    public void setFlag_city(String flag_city) {
        this.flag_city = flag_city;
    }

    public String getCabecera_city() {
        return cabecera_city;
    }

    public void setCabecera_city(String cabecera_city) {
        this.cabecera_city = cabecera_city;
    }

    public char getCondereg_city() {
        return condereg_city;
    }

    public void setCondereg_city(char condereg_city) {
        this.condereg_city = condereg_city;
    }

    public char getState_city() {
        return state_city;
    }

    public void setState_city(char state_city) {
        this.state_city = state_city;
    }

    public double getCoordinate_alt_city() {
        return coordinate_alt_city;
    }

    public void setCoordinate_alt_city(double coordinate_alt_city) {
        this.coordinate_alt_city = coordinate_alt_city;
    }

    public double getCoordinate_lat_city() {
        return coordinate_lat_city;
    }

    public void setCoordinate_lat_city(double coordinate_lat_city) {
        this.coordinate_lat_city = coordinate_lat_city;
    }
    
    
    
}

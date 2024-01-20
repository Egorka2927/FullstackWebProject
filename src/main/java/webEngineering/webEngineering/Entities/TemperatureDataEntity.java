package webEngineering.webEngineering.Entities;

import jakarta.persistence.*;

import java.util.Objects;

/**
 * Database entity for storing temperature data
 */
@Entity
@Table(name = "temperature_data", schema = "co2_gge", catalog = "")
public class TemperatureDataEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "country")
    private String country;
    @Basic
    @Column(name = "year")
    private Integer year;
    @Basic
    @Column(name = "iso_code")
    private String isoCode;
    @Basic
    @Column(name = "share_of_temperature_change_from_ghg")
    private Double shareOfTemperatureChangeFromGhg;
    @Basic
    @Column(name = "temperature_change_from_ch4")
    private Double temperatureChangeFromCh4;
    @Basic
    @Column(name = "temperature_change_from_co2")
    private Double temperatureChangeFromCo2;
    @Basic
    @Column(name = "temperature_change_from_ghg")
    private Double temperatureChangeFromGhg;
    @Basic
    @Column(name = "temperature_change_from_n2o")
    private Double temperatureChangeFromN2O;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getIsoCode() {
        return isoCode;
    }

    public void setIsoCode(String isoCode) {
        this.isoCode = isoCode;
    }

    public Double getShareOfTemperatureChangeFromGhg() {
        return shareOfTemperatureChangeFromGhg;
    }

    public void setShareOfTemperatureChangeFromGhg(Double shareOfTemperatureChangeFromGhg) {
        this.shareOfTemperatureChangeFromGhg = shareOfTemperatureChangeFromGhg;
    }

    public Double getTemperatureChangeFromCh4() {
        return temperatureChangeFromCh4;
    }

    public void setTemperatureChangeFromCh4(Double temperatureChangeFromCh4) {
        this.temperatureChangeFromCh4 = temperatureChangeFromCh4;
    }

    public Double getTemperatureChangeFromCo2() {
        return temperatureChangeFromCo2;
    }

    public void setTemperatureChangeFromCo2(Double temperatureChangeFromCo2) {
        this.temperatureChangeFromCo2 = temperatureChangeFromCo2;
    }

    public Double getTemperatureChangeFromGhg() {
        return temperatureChangeFromGhg;
    }

    public void setTemperatureChangeFromGhg(Double temperatureChangeFromGhg) {
        this.temperatureChangeFromGhg = temperatureChangeFromGhg;
    }

    public Double getTemperatureChangeFromN2O() {
        return temperatureChangeFromN2O;
    }

    public void setTemperatureChangeFromN2O(Double temperatureChangeFromN2O) {
        this.temperatureChangeFromN2O = temperatureChangeFromN2O;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * Method for comparison with the objects
     * @param o The object
     * @return True or false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TemperatureDataEntity that = (TemperatureDataEntity) o;
        return year == that.year && id == that.id && Objects.equals(country, that.country) && Objects.equals(isoCode, that.isoCode) && Objects.equals(shareOfTemperatureChangeFromGhg, that.shareOfTemperatureChangeFromGhg) && Objects.equals(temperatureChangeFromCh4, that.temperatureChangeFromCh4) && Objects.equals(temperatureChangeFromCo2, that.temperatureChangeFromCo2) && Objects.equals(temperatureChangeFromGhg, that.temperatureChangeFromGhg) && Objects.equals(temperatureChangeFromN2O, that.temperatureChangeFromN2O);
    }

    /**
     * Method to see the hashcode of the object
     * @return The hashcode
     */
    @Override
    public int hashCode() {
        return Objects.hash(country, year, isoCode, shareOfTemperatureChangeFromGhg, temperatureChangeFromCh4, temperatureChangeFromCo2, temperatureChangeFromGhg, temperatureChangeFromN2O, id);
    }
}

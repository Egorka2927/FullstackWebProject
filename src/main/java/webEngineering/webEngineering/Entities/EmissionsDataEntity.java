package webEngineering.webEngineering.Entities;

import jakarta.persistence.*;

import java.util.Objects;

/**
 * Database entity for storing emissions data
 */
@Entity
@Table(name = "emissions_data", schema = "co2_gge", catalog = "")
public class EmissionsDataEntity {
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
    @Column(name = "co2")
    private Double co2;
    @Basic
    @Column(name = "methane")
    private Double methane;
    @Basic
    @Column(name = "nitrous_oxide")
    private Double nitrousOxide;
    @Basic
    @Column(name = "total_ghg")
    private Double totalGhg;

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

    public Double getCo2() {
        return co2;
    }

    public void setCo2(Double co2) {
        this.co2 = co2;
    }

    public Double getMethane() {
        return methane;
    }

    public void setMethane(Double methane) {
        this.methane = methane;
    }

    public Double getNitrousOxide() {
        return nitrousOxide;
    }

    public void setNitrousOxide(Double nitrousOxide) {
        this.nitrousOxide = nitrousOxide;
    }

    public Double getTotalGhg() {
        return totalGhg;
    }

    public void setTotalGhg(Double totalGhg) {
        this.totalGhg = totalGhg;
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
        EmissionsDataEntity that = (EmissionsDataEntity) o;
        return year == that.year && id == that.id && Objects.equals(country, that.country) && Objects.equals(isoCode, that.isoCode) && Objects.equals(co2, that.co2) && Objects.equals(methane, that.methane) && Objects.equals(nitrousOxide, that.nitrousOxide) && Objects.equals(totalGhg, that.totalGhg);
    }

    /**
     * Method to see the hashcode of the object
     * @return The hashcode
     */
    @Override
    public int hashCode() {
        return Objects.hash(country, year, isoCode, co2, methane, nitrousOxide, totalGhg, id);
    }
}

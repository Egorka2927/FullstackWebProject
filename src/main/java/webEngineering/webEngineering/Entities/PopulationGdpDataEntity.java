package webEngineering.webEngineering.Entities;

import jakarta.persistence.*;

import java.util.Objects;

/**
 * Database entity for storing population and gdp data
 */
@Entity
@Table(name = "population_gdp_data", schema = "co2_gge", catalog = "")
public class PopulationGdpDataEntity {
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
    @Column(name = "population")
    private Long population;
    @Basic
    @Column(name = "gdp")
    private Double gdp;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getIsoCode() {
        return isoCode;
    }

    public void setIsoCode(String isoCode) {
        this.isoCode = isoCode;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    public Double getGdp() {
        return gdp;
    }

    public void setGdp(Double gdp) {
        this.gdp = gdp;
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
        PopulationGdpDataEntity that = (PopulationGdpDataEntity) o;
        return id == that.id && Objects.equals(country, that.country) && Objects.equals(year, that.year) && Objects.equals(isoCode, that.isoCode) && Objects.equals(population, that.population) && Objects.equals(gdp, that.gdp);
    }

    /**
     * Method to see the hashcode of the object
     * @return The hashcode
     */
    @Override
    public int hashCode() {
        return Objects.hash(country, year, isoCode, population, gdp, id);
    }
}

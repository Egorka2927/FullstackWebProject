package webEngineering.webEngineering.Entities;

import jakarta.persistence.*;

import java.util.Objects;

/**
 * Database entity for storing energy data
 */
@Entity
@Table(name = "energy_data", schema = "co2_gge", catalog = "")
public class EnergyDataEntity {
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
    private String population;
    @Basic
    @Column(name = "energy_per_capita")
    private Double energyPerCapita;
    @Basic
    @Column(name = "energy_per_gdp")
    private Double energyPerGdp;

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

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public Double getEnergyPerCapita() {
        return energyPerCapita;
    }

    public void setEnergyPerCapita(Double energyPerCapita) {
        this.energyPerCapita = energyPerCapita;
    }

    public Double getEnergyPerGdp() {
        return energyPerGdp;
    }

    public void setEnergyPerGdp(Double energyPerGdp) {
        this.energyPerGdp = energyPerGdp;
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
        EnergyDataEntity that = (EnergyDataEntity) o;
        return year == that.year && id == that.id && Objects.equals(country, that.country) && Objects.equals(isoCode, that.isoCode) && Objects.equals(population, that.population) && Objects.equals(energyPerCapita, that.energyPerCapita) && Objects.equals(energyPerGdp, that.energyPerGdp);
    }

    /**
     * Method to see the hashcode of the object
     * @return The hashcode
     */
    @Override
    public int hashCode() {
        return Objects.hash(country, year, isoCode, population, energyPerCapita, energyPerGdp, id);
    }
}

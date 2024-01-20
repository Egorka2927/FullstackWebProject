package webEngineering.webEngineering.Models;

/**
 * The model that stores the name of the
 * country, the year and the energy data
 */
public class EnergyCountryModel {
    private String country;
    private Integer year;
    private Double energyPerCapita;
    private Double energyPerGdp;

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
}

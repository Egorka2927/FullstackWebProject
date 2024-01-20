package webEngineering.webEngineering.Models;

import lombok.NoArgsConstructor;

/**
 * The model that stores country's name,
 * year, population and gdp
 */
@NoArgsConstructor
public class CountryModel {
    private String country;
    private Integer year;
    private Long population;
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
}

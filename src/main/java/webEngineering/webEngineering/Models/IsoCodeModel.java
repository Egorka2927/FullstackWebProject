package webEngineering.webEngineering.Models;

import lombok.NoArgsConstructor;

/**
 * The model that stores country's iso-code,
 * year, population and gdp
 */
@NoArgsConstructor
public class IsoCodeModel {
    private String isoCode;
    private Integer year;
    private Long population;
    private Double gdp;

    public String getIsoCode() {
        return isoCode;
    }

    public void setIsoCode(String isoCode) {
        this.isoCode = isoCode;
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

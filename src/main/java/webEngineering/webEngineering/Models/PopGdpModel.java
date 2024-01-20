package webEngineering.webEngineering.Models;

import lombok.NoArgsConstructor;
import webEngineering.webEngineering.Entities.PopulationGdpDataEntity;

/**
 * The model that stores
 * population and gdp information
 */
@NoArgsConstructor
public class PopGdpModel {
    private Long population;
    private Double gdp;

    /**
     * The method to convert the PopulationGdpDataEntity
     * object into the model object
     * @param entity The PopulationGdpDataEntity object
     * @return The model object
     */
    public static PopGdpModel toModel(PopulationGdpDataEntity entity) {
        PopGdpModel model = new PopGdpModel();
        model.setPopulation(entity.getPopulation());
        model.setGdp(entity.getGdp());
        return model;
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

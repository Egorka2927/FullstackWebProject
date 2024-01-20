package webEngineering.webEngineering.Models;

import webEngineering.webEngineering.Entities.EnergyDataEntity;
import webEngineering.webEngineering.Entities.PopulationGdpDataEntity;

/**
 * The model that represents only the country's id
 */
public class CountryIdModel {
    private Integer id;

    /**
     * The method to convert PopulationGdpDataEntity object into a model object
     * @param entity The object of the entity
     * @return The model object
     */
    public static CountryIdModel popGdpToModel(PopulationGdpDataEntity entity) {
        CountryIdModel model = new CountryIdModel();
        model.setId(entity.getId());
        return model;
    }

    public static CountryIdModel energyToModel(EnergyDataEntity entity) {
        CountryIdModel model = new CountryIdModel();
        model.setId(entity.getId());
        return model;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

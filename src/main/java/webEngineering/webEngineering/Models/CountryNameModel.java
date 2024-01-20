package webEngineering.webEngineering.Models;

import webEngineering.webEngineering.Entities.TemperatureDataEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * The model that stores only the name of the country
 */
public class CountryNameModel {
    private String country;

    /**
     * The method to convert TemperatureDataEntity object into a model object
     * @param entity The TemperatureDataEntity object
     * @return The model object
     */
    public static CountryNameModel toModel(TemperatureDataEntity entity) {
        CountryNameModel model = new CountryNameModel();
        model.setCountry(entity.getCountry());
        return model;
    }

    /**
     * The method to convert the list of TemperatureDataEntity
     * objects into a list of model objects
     * @param listEntities The list of TemperatureDataEntity objects
     * @return The list of model objects
     */
    public static List<CountryNameModel> toListModels(List<TemperatureDataEntity> listEntities) {
        List<CountryNameModel> listModels = new ArrayList<>();
        for (TemperatureDataEntity e : listEntities) {
            listModels.add(CountryNameModel.toModel(e));
        }
        return listModels;
    }
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}

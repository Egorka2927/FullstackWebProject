package webEngineering.webEngineering.Models;

import webEngineering.webEngineering.Entities.TemperatureDataEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * The model that stores the temperature data
 */
public class TemperatureModel {
    private String continent;
    private Double shareOfTemperatureChangeFromGhg;
    private Double temperatureChangeFromCh4;
    private Double temperatureChangeFromCo2;
    private Double temperatureChangeFromGhg;
    private Double temperatureChangeFromN2O;

    /**
     * The method to convert the TemperatureDataEntity
     * object into the model object
     * @param entity The TemperatureDataEntity object
     * @return The model object
     */
    public static TemperatureModel toModel(TemperatureDataEntity entity) {
        TemperatureModel model = new TemperatureModel();
        model.setContinent(entity.getCountry());
        model.setShareOfTemperatureChangeFromGhg(entity.getShareOfTemperatureChangeFromGhg());
        model.setTemperatureChangeFromCh4(entity.getTemperatureChangeFromCh4());
        model.setTemperatureChangeFromCo2(entity.getTemperatureChangeFromCo2());
        model.setTemperatureChangeFromGhg(entity.getTemperatureChangeFromGhg());
        model.setTemperatureChangeFromN2O(entity.getTemperatureChangeFromN2O());
        return model;
    }

    /**
     * The method to convert the list of TemperatureDataEntity
     * objects into the list of model objects
     * @param listEntities The list of TemperatureDataEntity objects
     * @return The list of model objects
     */
    public static List<TemperatureModel> toListModels(List<TemperatureDataEntity> listEntities) {
        List<TemperatureModel> listModels = new ArrayList<>();
        for (TemperatureDataEntity e : listEntities) {
            listModels.add(TemperatureModel.toModel(e));
        }
        return listModels;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
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
}

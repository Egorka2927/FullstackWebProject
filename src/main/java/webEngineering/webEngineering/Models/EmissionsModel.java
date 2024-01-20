package webEngineering.webEngineering.Models;

import lombok.NoArgsConstructor;
import webEngineering.webEngineering.Entities.EmissionsDataEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * The model that stores information
 * about the emissions data
 */
@NoArgsConstructor
public class EmissionsModel {
    private Double co2;
    private Double methane;
    private Double nitrousOxide;
    private Double totalGhg;

    /**
     * The method to convert the EmissionsDataEntity object into a model object
     * @param entity The EmissionsDataEntity object
     * @return The model object
     */
    public static EmissionsModel toModel(EmissionsDataEntity entity) {
        EmissionsModel model = new EmissionsModel();
        model.setCo2(entity.getCo2());
        model.setMethane(entity.getMethane());
        model.setNitrousOxide(entity.getNitrousOxide());
        model.setTotalGhg(entity.getTotalGhg());
        return model;
    }

    /**
     * The method to convert the list of EmissionsDataEntity
     * objects into the list of model objects
     * @param listEntities The list of EmissionsDataEntity objects
     * @return The list of model objects
     */
    public static List<EmissionsModel> toListModels(List<EmissionsDataEntity> listEntities) {
        List<EmissionsModel> listModels = new ArrayList<>();
        for (EmissionsDataEntity e : listEntities) {
            EmissionsModel emissionsModel = EmissionsModel.toModel(e);
            listModels.add(emissionsModel);
        }
        return listModels;
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
}

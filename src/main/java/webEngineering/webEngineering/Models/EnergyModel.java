package webEngineering.webEngineering.Models;

import webEngineering.webEngineering.Entities.EnergyDataEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * The model that stores information
 * about the energy data
 */
public class EnergyModel {
    private Double energyPerCapita;
    private Double energyPerGdp;

    /**
     * The method to convert the EnergyDataEntity
     * object into a model object
     * @param entity The EnergyDataEntity object
     * @return The model object
     */
    public static EnergyModel toModel(EnergyDataEntity entity) {
        EnergyModel model = new EnergyModel();
        model.setEnergyPerCapita(entity.getEnergyPerCapita());
        model.setEnergyPerGdp(entity.getEnergyPerGdp());
        return model;
    }

    /**
     * The method to convert the list of EnergyDataEntity
     * objects into a list of model objects
     * @param listEntities The list of EnergyDataEntity objects
     * @return The list of model objects
     */
    public static List<EnergyModel> toListModels(List<EnergyDataEntity> listEntities) {
        List<EnergyModel> listModels = new ArrayList<>();
        for (EnergyDataEntity e : listEntities) {
            listModels.add(EnergyModel.toModel(e));
        }
        return listModels;
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

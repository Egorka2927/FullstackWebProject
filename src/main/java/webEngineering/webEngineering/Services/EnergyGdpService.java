package webEngineering.webEngineering.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import webEngineering.webEngineering.Entities.EnergyDataEntity;
import webEngineering.webEngineering.Entities.PopulationGdpDataEntity;
import webEngineering.webEngineering.Exceptions.DataAlreadyExistsException;
import webEngineering.webEngineering.Exceptions.NoResultException;
import webEngineering.webEngineering.Models.*;
import webEngineering.webEngineering.Repositories.EnergyDataRepository;
import webEngineering.webEngineering.Util.CsvConverter;
import webEngineering.webEngineering.Util.JsonConverter;

import java.util.List;

/**
 * Service for energy controller.
 * Contains all the logic for energy data.
 */
@Service
public class EnergyGdpService {
    private EnergyDataRepository energyDataRepository;

    @Autowired
    public void setEnergyDataRepository(EnergyDataRepository energyDataRepository) {
        this.energyDataRepository = energyDataRepository;
    }

    /**
     * Method to retrieve energy data in a given year and displayed in batches.
     * @param year Given year.
     * @param batchSize Size of selected batch.
     * @param batchNumber Number of selected batch.
     * @param format Either JSON or CSV.
     * @return A String containing the data fetched.
     * @throws NoResultException If no data is found with the specified conditions.
     */
    public String showEnergy(Integer year, Integer batchSize,
                                        Integer batchNumber, String format) throws NoResultException {
        List<EnergyDataEntity> response = energyDataRepository.retrieveEnergy(year, PageRequest.of(batchNumber, batchSize));

        if (response == null) {
            throw new NoResultException("No result");
        }

        List<EnergyModel> models = EnergyModel.toListModels(response);
        if (format != null && format.equals("CSV")) {
            return CsvConverter.listToCsv(models, EnergyModel.class);
        }
        return JsonConverter.listToJson(models);
    }

    /**
     * Method to create energy data for a selected country and year.
     * @param country The name of the country.
     * @param year The year.
     * @param energyPerCapita The energy per capita.
     * @param energyPerGdp The energy per gdp.
     * @param format Either JSON or CSV.
     * @return The id of the newly created data.
     * @throws DataAlreadyExistsException If the data already exists in the database.
     */
    public String postEnergyByCountry(String country, Integer year, Double energyPerCapita,
                                      Double energyPerGdp, String format) throws DataAlreadyExistsException{
        if (energyDataRepository.findEnergyDataEntityByCountryAndYear(country, year) != null) {
            throw new DataAlreadyExistsException("Data already exists");
        }

        energyDataRepository.createEnergyByCountry(country, year, energyPerCapita, energyPerGdp);
        EnergyDataEntity response = energyDataRepository.findEnergyDataEntityByCountryAndYear(country, year);
        CountryIdModel model = CountryIdModel.energyToModel(response);

        if (format != null && format.equals("CSV")) {
            return CsvConverter.toCsv(model);
        }
        return JsonConverter.toJson(model);
    }

    /**
     * The method to delete the energy data for a selected country and year.
     * @param country The name of the country.
     * @param year The year.
     * @param format Either JSON or CSV.
     * @return The message string.
     * @throws NoResultException If no data is found with the specified conditions.
     */
    public String deleteEnergyByCountry(String country, Integer year, String format) throws NoResultException {
        if (energyDataRepository.findEnergyDataEntityByCountryAndYear(country, year) == null) {
            throw new NoResultException("No result");
        }

        energyDataRepository.deleteEnergyByCountry(country, year);

        MessageModel messageModel = new MessageModel("Data successfully removed");

        if (format != null && format.equals("CSV")) {
            return CsvConverter.toCsv(messageModel);
        }

        return JsonConverter.toJson(messageModel);
    }

    /**
     * The method to update the energy data for a selected country name.
     * @param country The name of the country.
     * @param year The year.
     * @param energyPerCapita The energy per capita.
     * @param energyPerGdp The energy per gdp.
     * @param format Either JSON or CSV.
     * @return The updated energy data for a selected country and year.
     * @throws NoResultException If no data is found with the specified conditions.
     */
    public String putByCountry(String country, Integer year, Double energyPerCapita,
                               Double energyPerGdp, String format) throws NoResultException {
        if (energyDataRepository.findEnergyDataEntityByCountryAndYear(country, year) == null) {
            throw new NoResultException("No result");
        }

        energyDataRepository.updateEnergyByCountry(country, year, energyPerCapita, energyPerGdp);

        EnergyModel model = new EnergyModel();

        model.setEnergyPerCapita(energyPerCapita);
        model.setEnergyPerGdp(energyPerGdp);

        if (format != null && format.equals("CSV")) {
            return CsvConverter.toCsv(model);
        }

        return JsonConverter.toJson(model);
    }
}

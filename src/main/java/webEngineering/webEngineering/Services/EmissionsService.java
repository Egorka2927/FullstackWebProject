package webEngineering.webEngineering.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webEngineering.webEngineering.Entities.EmissionsDataEntity;
import webEngineering.webEngineering.Exceptions.NoResultException;
import webEngineering.webEngineering.Models.EmissionsModel;
import webEngineering.webEngineering.Repositories.EmissionsDataRepository;
import webEngineering.webEngineering.Util.CsvConverter;
import webEngineering.webEngineering.Util.JsonConverter;

import java.util.List;

/**
 * Service for emissions controller.
 * Contains all the logic for emissions data.
 */
@Service
public class EmissionsService {
    private EmissionsDataRepository emissionsDataRepository;

    @Autowired
    public void setEmissionsDataRepository(EmissionsDataRepository emissionsDataRepository) {
        this.emissionsDataRepository = emissionsDataRepository;
    }

    /**
     * Method to get emissions data for a given country.
     * @param country Given country.
     * @param format Either JSON or CSV.
     * @return A String containing the data fetched.
     * @throws NoResultException If no data is found with the specified conditions.
     */
    public String showEmissionsCountry(String country, String format) throws NoResultException {
        List<EmissionsDataEntity> response = emissionsDataRepository.findEmissionsDataEntityByCountry(country);

        if (response == null) {
            throw new NoResultException("No result");
        }

        List<EmissionsModel> models = EmissionsModel.toListModels(response);

        if (format != null && format.equals("CSV")) {
            return CsvConverter.listToCsv(models, EmissionsModel.class);
        }
        return JsonConverter.listToJson(models);
    }

    /**
     * Method to get emissions data for a given iso code.
     * @param isoCode Given iso code.
     * @param format Either JSON or CSV.
     * @return A String containing the data fetched.
     * @throws NoResultException If no data is found with the specified conditions.
     */
    public String showEmissionsIsoCode(String isoCode,String format) throws NoResultException {
        List<EmissionsDataEntity> response = emissionsDataRepository.findEmissionsDataEntityByIsoCode(isoCode);

        if (response == null) {
            throw new NoResultException("No result");
        }

        List<EmissionsModel> models = EmissionsModel.toListModels(response);

        if (format != null && format.equals("CSV")) {
            return CsvConverter.listToCsv(models, EmissionsModel.class);
        }
        return JsonConverter.listToJson(models);
    }

    /**
     * Method to get emissions data for a given country and year.
     * @param country Given country.
     * @param year Given year.
     * @param format Either JSON or CSV.
     * @return A String containing the data fetched.
     * @throws NoResultException If no data is found with the specified conditions.
     */
    public String showEmissionsCountryYear(String country, Integer year, String format) throws NoResultException {
        List<EmissionsDataEntity> response = emissionsDataRepository.findEmissionsDataEntityByCountryAndYearGreaterThan(country, year);

        if (response == null) {
            throw new NoResultException("No result");
        }

        List<EmissionsModel> models = EmissionsModel.toListModels(response);

        if (format != null && format.equals("CSV")) {
            return CsvConverter.listToCsv(models, EmissionsModel.class);
        }
        return JsonConverter.listToJson(models);
    }

    /**
     * Method to get emissions data for a given iso code and year.
     * @param isoCode Given iso code.
     * @param year Given year.
     * @param format Either JSON or CSV.
     * @return A String containing the data fetched.
     * @throws NoResultException If no data is found with the specified conditions.
     */
    public String showEmissionsIsoCodeYear(String isoCode, Integer year, String format) throws NoResultException {
        List<EmissionsDataEntity> response = emissionsDataRepository.findEmissionsDataEntityByIsoCodeAndYearGreaterThan(isoCode, year);

        if (response == null) {
            throw new NoResultException("No result");
        }

        List<EmissionsModel> models = EmissionsModel.toListModels(response);

        if (format != null && format.equals("CSV")) {
            return CsvConverter.listToCsv(models, EmissionsModel.class);
        }
        return JsonConverter.listToJson(models);
    }
}

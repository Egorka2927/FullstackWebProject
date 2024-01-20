package webEngineering.webEngineering.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webEngineering.webEngineering.Entities.TemperatureDataEntity;
import webEngineering.webEngineering.Exceptions.NoResultException;
import webEngineering.webEngineering.Models.TemperatureModel;
import webEngineering.webEngineering.Repositories.TemperatureDataRepository;
import webEngineering.webEngineering.Util.CsvConverter;
import webEngineering.webEngineering.Util.JsonConverter;

import java.util.Arrays;
import java.util.List;

/**
 * Service for temperature controller.
 * Contains all the logic for temperature data.
 */
@Service
public class TemperatureService {
    private TemperatureDataRepository temperatureDataRepository;

    private final List<String> continents = Arrays.asList("Africa", "Antarctica", "Asia", "Europe", "Oceania", "North America", "South America");

    @Autowired
    public void setTemperatureDataRepository(TemperatureDataRepository temperatureDataRepository) {
        this.temperatureDataRepository = temperatureDataRepository;
    }

    /**
     * Method to retrieve temperature data for all continents.
     * @param format Either JSON or CSV.
     * @return A String containing the data fetched.
     * @throws NoResultException If no data is found with the specified conditions.
     */
    public String showTemperature(String format) throws NoResultException {

        List<TemperatureDataEntity> response = temperatureDataRepository.findTemperatureDataEntityByCountryIn(continents);

        if (response == null) {
            throw new NoResultException("No result");
        }

        List<TemperatureModel> models = TemperatureModel.toListModels(response);

        if (format != null && format.equals("CSV")) {
            String csv = CsvConverter.listToCsv(models, TemperatureModel.class);
            return csv;
        }
        return JsonConverter.listToJson(models);
    }

    /**
     * Method to retrieve temperature data in a given year.
     * @param year Given year.
     * @param format Either JSON or CSV.
     * @return A String containing the data fetched.
     * @throws NoResultException If no data is found with the specified conditions.
     */
    public String showTemperatureYear(Integer year, String format) throws NoResultException {

        List<TemperatureDataEntity> response = temperatureDataRepository.findTemperatureDataEntityByCountryInAndYearGreaterThan(continents, year);

        if (response == null) {
            throw new NoResultException("No result");
        }

        List<TemperatureModel> models = TemperatureModel.toListModels(response);

        if (format != null && format.equals("CSV")) {
            String csv = CsvConverter.listToCsv(models, TemperatureModel.class);
            return csv;
        }
        return JsonConverter.listToJson(models);
    }
}

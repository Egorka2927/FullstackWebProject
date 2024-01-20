package webEngineering.webEngineering.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import webEngineering.webEngineering.Entities.TemperatureDataEntity;
import webEngineering.webEngineering.Exceptions.NoResultException;
import webEngineering.webEngineering.Models.CountryNameModel;
import webEngineering.webEngineering.Models.EmissionsModel;
import webEngineering.webEngineering.Repositories.TemperatureDataRepository;
import webEngineering.webEngineering.Util.CsvConverter;
import webEngineering.webEngineering.Util.JsonConverter;

import java.util.List;

/**
 * The service for countries controller.
 * Contains all the logic for countries data.
 */
@Service
public class CountriesService {
    private TemperatureDataRepository temperatureDataRepository;

    @Autowired
    public void setTemperatureDataRepository(TemperatureDataRepository temperatureDataRepository) {
        this.temperatureDataRepository = temperatureDataRepository;
    }

    /**
     * Method to get countries data in a given year range.
     * @param option Filter for Top or Bottom countries.
     * @param years Year range (last N years).
     * @param numberCountries How many countries.
     * @param format Either JSON or CSV.
     * @return A String containing the data fetched.
     * @throws NoResultException If no data is found with the specified conditions.
     */
    public String chooseOptionYears(String option, Integer years,
                                                    Integer numberCountries, String format) throws NoResultException {
        List<TemperatureDataEntity> response = temperatureDataRepository.retrieveContributionTopYears(years,
                PageRequest.of(0, numberCountries));
        List<CountryNameModel> models = CountryNameModel.toListModels(response);

        if (option.equals("TOP")) {
            response = temperatureDataRepository.retrieveContributionTopYears(years,
                    PageRequest.of(0, numberCountries));

            if (response == null) {
                throw new NoResultException("No result");
            }

            if (format != null && format.equals("CSV")) {
                return CsvConverter.listToCsv(models, CountryNameModel.class);
            }
            return JsonConverter.listToJson(models);

        } else if (option.equals("BOTTOM")) {
            response = temperatureDataRepository.retrieveContributionBottomYears(years,
                    PageRequest.of(0, numberCountries));

            if (response == null) {
                throw new NoResultException("No result");
            }

            models = CountryNameModel.toListModels(response);

            if (format != null && format.equals("CSV")) {
                return CsvConverter.listToCsv(models, CountryNameModel.class);
            }
            return JsonConverter.listToJson(models);
        }

        return JsonConverter.listToJson(models);
    }

    /**
     * Method to get countries data in a given year.
     * @param option Filter for Top or Bottom countries.
     * @param year Given year.
     * @param numberCountries How many countries.
     * @param format Either JSON or CSV.
     * @return A String containing the data fetched.
     * @throws NoResultException If no data is found with the specified conditions.
     */
    public String chooseOptionYear(String option,
                                                   Integer year,
                                                   Integer numberCountries, String format) throws NoResultException {
        List<TemperatureDataEntity> response = temperatureDataRepository.retrieveContributionTopYear(year,
                PageRequest.of(0, numberCountries));
        List<CountryNameModel> models = CountryNameModel.toListModels(response);

        if (option.equals("TOP")) {
            response = temperatureDataRepository.retrieveContributionTopYear(year,
                    PageRequest.of(0, numberCountries));

            if (response == null) {
                throw new NoResultException("No result");
            }

            if (format != null && format.equals("CSV")) {
                return CsvConverter.listToCsv(models, CountryNameModel.class);
            }
            return JsonConverter.listToJson(models);

        } else if (option.equals("BOTTOM")) {
            response = temperatureDataRepository.retrieveContributionBottomYear(year,
                    PageRequest.of(0, numberCountries));

            if (response == null) {
                throw new NoResultException("No result");
            }

            models = CountryNameModel.toListModels(response);

            if (format != null && format.equals("CSV")) {
                return CsvConverter.listToCsv(models, CountryNameModel.class);
            }
            return JsonConverter.listToJson(models);
        }

        return JsonConverter.listToJson(models);
    }
}

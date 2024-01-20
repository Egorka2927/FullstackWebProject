package webEngineering.webEngineering.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webEngineering.webEngineering.Entities.PopulationGdpDataEntity;
import webEngineering.webEngineering.Exceptions.DataAlreadyExistsException;
import webEngineering.webEngineering.Exceptions.NoResultException;
import webEngineering.webEngineering.Models.CountryIdModel;
import webEngineering.webEngineering.Models.ExceptionModel;
import webEngineering.webEngineering.Models.MessageModel;
import webEngineering.webEngineering.Models.PopGdpModel;
import webEngineering.webEngineering.Repositories.PopulationGdpRepository;
import webEngineering.webEngineering.Util.CsvConverter;
import webEngineering.webEngineering.Util.JsonConverter;

import java.time.LocalDateTime;

/**
 * Service for population and gdp controller.
 * Contains all the logic for population and gdp data.
 */
@Service
public class PopGdpCountryService {
    private PopulationGdpRepository populationGdpRepository;

    @Autowired
    public void setPopulationGdpRepository(PopulationGdpRepository populationGdpRepository) {
        this.populationGdpRepository = populationGdpRepository;
    }

    /**
     * GET method to retrieve population and gdp data for a given country in a given year.
     * @param country Given country.
     * @param year Given year.
     * @param format Either JSON or CSV.
     * @return A String containing the data fetched.
     * @throws NoResultException If no data is found with the specified conditions.
     */
    public String showByCountry(String country, Integer year, String format) throws NoResultException {
        PopulationGdpDataEntity response = populationGdpRepository.findPopulationGdpDataEntityByCountryAndYear(country, year);

        if (response == null) {
            throw new NoResultException("No result");
        }

        PopGdpModel model = PopGdpModel.toModel(response);

        if (format != null && format.equals("CSV")) {
            return CsvConverter.toCsv(model);
        }
        return JsonConverter.toJson(model);
    }

    /**
     * Method to post population and gdp data for a selected country and year.
     * @param country Selected country.
     * @param year Selected year.
     * @param population Population number.
     * @param gdp Gdp number.
     * @param format Either JSON or CSV.
     * @return A String containing the data created.
     * @throws DataAlreadyExistsException If data already exits in the database.
     */
    public String postByCountry(String country, Integer year, Long population, Double gdp, String format) throws DataAlreadyExistsException {
        if (populationGdpRepository.findPopulationGdpDataEntityByCountryAndYear(country, year) != null) {
            throw new DataAlreadyExistsException("Data already exists");
        }

        populationGdpRepository.createPopGdpByCountry(country, year, population, gdp);
        PopulationGdpDataEntity response = populationGdpRepository.findPopulationGdpDataEntityByCountryAndYear(country, year);
        CountryIdModel model = CountryIdModel.popGdpToModel(response);

        if (format != null && format.equals("CSV")) {
            return CsvConverter.toCsv(model);
        }
        return JsonConverter.toJson(model);
    }

    /**
     * Method to delete population and gdp data for a selected country and year.
     * @param country Selected country.
     * @param year Selected year.
     * @param format Either JSON or CSV.
     * @return A String containing the data created.
     * @throws NoResultException If no data is found with the specified conditions.
     */
    public String deleteByCountry(String country, Integer year, String format) throws NoResultException {
        if (populationGdpRepository.findPopulationGdpDataEntityByCountryAndYear(country, year) == null) {
            throw new NoResultException("No result");
        }

        populationGdpRepository.deletePopGdpByCountry(country, year);

        MessageModel messageModel = new MessageModel("Data successfully removed");

        if (format != null && format.equals("CSV")) {
            return CsvConverter.toCsv(messageModel);
        }

        return JsonConverter.toJson(messageModel);
    }

    /**
     * Method to update population and gdp data for a selected country and year.
     * @param country Selected country.
     * @param year Selected year.
     * @param population New population number.
     * @param gdp New gdp number.
     * @param format Either JSON or CSV.
     * @return A String containing the data created.
     * @throws NoResultException If no data is found with the specified conditions.
     */
    public String putByCountry(String country, Integer year, Long population, Double gdp, String format) throws NoResultException {
        if (populationGdpRepository.findPopulationGdpDataEntityByCountryAndYear(country, year) == null) {
            throw new NoResultException("No result");
        }

        populationGdpRepository.updatePopGdpByCountry(country, year, population, gdp);

        PopGdpModel model = new PopGdpModel();

        model.setPopulation(population);
        model.setGdp(gdp);

        if (format != null && format.equals("CSV")) {
            return CsvConverter.toCsv(model);
        }

        return JsonConverter.toJson(model);
    }

    /**
     * Method to retrieve population and gdp data for a given iso code and year.
     * @param isoCode Given iso code.
     * @param year Given year.
     * @param format Either JSON or CSV.
     * @return A String containing the data created.
     * @throws NoResultException If no data is found with the specified conditions.
     */
    public String showByIsoCode(String isoCode, Integer year, String format) throws NoResultException {
        PopulationGdpDataEntity response = populationGdpRepository.findPopulationGdpDataEntityByIsoCodeAndYear(isoCode, year);

        if (response == null) {
            throw new NoResultException("No result");
        }

        PopGdpModel model = PopGdpModel.toModel(response);

        if (format != null && format.equals("CSV")) {
            return CsvConverter.toCsv(model);
        }
        return JsonConverter.toJson(model);
    }

    /**
     * Method to post population and gdp data for a selected iso code and year.
     * @param isoCode Selected iso code.
     * @param year Selected year.
     * @param population Population number.
     * @param gdp Gdp number.
     * @param format Either JSON or CSV.
     * @return A String containing the data created.
     * @throws DataAlreadyExistsException If data already exits in the database.
     */
    public String postByIsoCode(String isoCode, Integer year, Long population, Double gdp,String format) throws DataAlreadyExistsException {
        if (populationGdpRepository.findPopulationGdpDataEntityByIsoCodeAndYear(isoCode, year) != null) {
            ExceptionModel exceptionModel = new ExceptionModel(LocalDateTime.now().toString(), 409, "Conflict", "Data already exists", "/countries/iso_code/population_gdp_code");
            if (format != null && format.equals("CSV")) {
                throw new DataAlreadyExistsException(CsvConverter.toCsv(exceptionModel));
            }
            throw new DataAlreadyExistsException(JsonConverter.toJson(exceptionModel));
        }

        populationGdpRepository.createPopGdpByIsoCode(isoCode, year, population, gdp);
        PopulationGdpDataEntity response = populationGdpRepository.findPopulationGdpDataEntityByIsoCodeAndYear(isoCode, year);
        CountryIdModel model = CountryIdModel.popGdpToModel(response);

        if (format != null && format.equals("CSV")) {
            return CsvConverter.toCsv(model);
        }
        return JsonConverter.toJson(model);
    }

    /**
     * Method to delete population and gdp data for a selected iso code and year.
     * @param isoCode Selected iso code.
     * @param year Selected year.
     * @param format Either JSON or CSV.
     * @return A String containing the data created.
     * @throws NoResultException If no data is found with the specified conditions.
     */
    public String deleteByIsoCode(String isoCode, Integer year, String format) throws NoResultException {
        if (populationGdpRepository.findPopulationGdpDataEntityByIsoCodeAndYear(isoCode, year) == null) {
            throw new NoResultException("No result");
        }

        populationGdpRepository.deletePopGdpByIsoCode(isoCode, year);

        MessageModel messageModel = new MessageModel("Data successfully removed");

        if (format != null && format.equals("CSV")) {
            return CsvConverter.toCsv(messageModel);
        }

        return JsonConverter.toJson(messageModel);
    }

    /**
     * Method to update population and gdp data for a selected iso code and year.
     * @param isoCode Selected iso code.
     * @param year Selected year.
     * @param population New population number.
     * @param gdp New gdp number.
     * @param format Either JSON or CSV.
     * @return A String containing the data created.
     * @throws NoResultException If no data is found with the specified conditions.
     */
    public String putByIsoCode(String isoCode, Integer year, Long population, Double gdp, String format) throws NoResultException {
        if (populationGdpRepository.findPopulationGdpDataEntityByIsoCodeAndYear(isoCode, year) == null) {
            throw new NoResultException("No result");
        }

        populationGdpRepository.updatePopGdpByIsoCode(isoCode, year, population, gdp);

        PopGdpModel model = new PopGdpModel();

        model.setPopulation(population);
        model.setGdp(gdp);

        if (format != null && format.equals("CSV")) {
            return CsvConverter.toCsv(model);
        }

        return JsonConverter.toJson(model);
    }
}

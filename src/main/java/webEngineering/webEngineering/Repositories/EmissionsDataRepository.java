package webEngineering.webEngineering.Repositories;

import org.springframework.data.repository.CrudRepository;
import webEngineering.webEngineering.Entities.EmissionsDataEntity;

import java.util.List;

/**
 * The repository for the manipulation of the emissions data
 */
public interface EmissionsDataRepository extends CrudRepository<EmissionsDataEntity, Integer> {

    /**
     * The method to retrieve the emissions data
     * in the database by the country name
     * @param country The name of the country
     * @return The EmissionsDataEntity object
     */
    List<EmissionsDataEntity> findEmissionsDataEntityByCountry(String country);

    /**
     * The method to retrieve the emissions data
     * in the database by the country name
     * @param isoCode The iso code of the country
     * @return The EmissionsDataEntity object
     */
    List<EmissionsDataEntity> findEmissionsDataEntityByIsoCode(String isoCode);

    /**
     * The method to retrieve the filtered
     * emissions data by country name and year
     * @param country The name of the country
     * @param year The year
     * @return The EmissionsDataEntity object
     */
    List<EmissionsDataEntity> findEmissionsDataEntityByCountryAndYearGreaterThan(String country, Integer year);

    /**
     * The method to retrieve filtered emissions
     * data by iso code and year
     * @param isoCode The iso code of the country
     * @param year The year
     * @return The EmissionsDataEntity object
     */
    List<EmissionsDataEntity> findEmissionsDataEntityByIsoCodeAndYearGreaterThan(String isoCode, Integer year);
}
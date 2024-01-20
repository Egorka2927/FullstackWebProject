package webEngineering.webEngineering.Repositories;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import webEngineering.webEngineering.Entities.PopulationGdpDataEntity;

/**
 * The repository for the manipulation of the emissions data
 */
@Repository
public interface PopulationGdpRepository extends CrudRepository<PopulationGdpDataEntity, Integer> {
    /**
     * The method to retrieve population and
     * gdp data by the country name and the year
     * @param country The name of the country
     * @param year The year
     * @return The PopulationGdpDataEntity object
     */
    PopulationGdpDataEntity findPopulationGdpDataEntityByCountryAndYear(String country, Integer year);

    /**
     * The method to retrieve population and
     * gdp data by the iso code and the year
     * @param isoCode The iso code of the country
     * @param year The year
     * @return The PopulationGdpDataEntity object
     */
    PopulationGdpDataEntity findPopulationGdpDataEntityByIsoCodeAndYear(String isoCode, Integer year);

    /**
     * The method to add new population and gdp
     * data into the database using the name of
     * the country and the year
     * @param country The name of the country
     * @param year The year
     * @param population The population
     * @param gdp The gdp
     */
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO population_gdp_data (country, year, population, gdp)" +
            " VALUES (:country, :year, :population, :gdp)", nativeQuery = true)
    void createPopGdpByCountry(@Param("country") String country,
                               @Param("year") Integer year,
                               @Param("population") Long population,
                               @Param("gdp") Double gdp);

    /**
     * The method to add new population and gdp
     * data into the database using the iso code of
     * the country and the year
     * @param isoCode The iso code of the country
     * @param year The year
     * @param population The population
     * @param gdp The gdp
     */
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO population_gdp_data (iso_code, year, population, gdp)" +
            " VALUES (:isoCode, :year, :population, :gdp)", nativeQuery = true)
    void createPopGdpByIsoCode(@Param("isoCode") String isoCode,
                               @Param("year") Integer year,
                               @Param("population") Long population,
                               @Param("gdp") Double gdp);

    /**
     * The method to update population and gdp
     * data in the database using the name of
     * the country and the year
     * @param country The name of the country
     * @param year The year
     * @param population The population
     * @param gdp The gdp
     */
    @Modifying
    @Transactional
    @Query(value = "UPDATE population_gdp_data" +
            " SET population = :population, gdp = :gdp" +
            " WHERE country = :country AND year = :year", nativeQuery = true)
    void updatePopGdpByCountry(@Param("country") String country,
                               @Param("year") Integer year,
                               @Param("population") Long population,
                               @Param("gdp") Double gdp);
    /**
     * The method to update population and gdp
     * data in the database using the iso code of
     * the country and the year
     * @param isoCode The iso code of the country
     * @param year The year
     * @param population The population
     * @param gdp The gdp
     */
    @Modifying
    @Transactional
    @Query(value = "UPDATE population_gdp_data" +
            " SET population = :population, gdp = :gdp" +
            " WHERE iso_code = :isoCode AND year = :year", nativeQuery = true)
    void updatePopGdpByIsoCode(@Param("isoCode") String isoCode,
                               @Param("year") Integer year,
                               @Param("population") Long population,
                               @Param("gdp") Double gdp);

    /**
     * The method to delete population and
     * gdp data by the country name and the year
     * @param country The name of the country
     * @param year The year
     */
    @Modifying
    @Transactional
    @Query(value = "UPDATE population_gdp_data" +
            " SET population = null, gdp = null" +
            " WHERE country = :country AND year = :year", nativeQuery = true)
    void deletePopGdpByCountry(@Param("country") String country,
                               @Param("year") Integer year);

    /**
     * The method to delete population and
     * gdp data by the iso code of the country and the year
     * @param isoCode The iso code of the country
     * @param year The year
     */
    @Modifying
    @Transactional
    @Query(value = "UPDATE population_gdp_data" +
            " SET population = null, gdp = null" +
            " WHERE iso_code = :isoCode AND year = :year", nativeQuery = true)
    void deletePopGdpByIsoCode(@Param("isoCode") String isoCode,
                               @Param("year") Integer year);
}

package webEngineering.webEngineering.Repositories;

import jakarta.transaction.Transactional;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import webEngineering.webEngineering.Entities.EnergyDataEntity;

import java.util.List;

/**
 * The repository for the manipulation of the emissions data.
 */
@Repository
public interface EnergyDataRepository extends CrudRepository<EnergyDataEntity, Integer> {

    EnergyDataEntity findEnergyDataEntityByCountryAndYear(String country, Integer year);

    /**
     * The method to retrieve the energy data.
     * @param year The year.
     * @param pageable The pagination.
     * @return The EnergyDataEntity object.
     */
    @Query(value = "SELECT e FROM EnergyDataEntity e" +
            " WHERE e.year = :year" +
            " ORDER BY e.population ASC")
    List<EnergyDataEntity> retrieveEnergy(@Param("year") Integer year,
                                          Pageable pageable);

    /**
     * The method to create the energy data for a selected country and year.
     * @param country The name of the country.
     * @param year The year.
     * @param energyPerCapita The energy per capita.
     * @param energyPerGdp The energy per gdp.
     */
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO energy_data (country, year, energy_per_capita, energy_per_gdp)" +
            " VALUES (:country, :year, :energyPerCapita, :energyPerGdp)", nativeQuery = true)
    void createEnergyByCountry(@Param("country") String country,
                               @Param("year") Integer year,
                               @Param("energyPerCapita") Double energyPerCapita,
                               @Param("energyPerGdp") Double energyPerGdp);

    /**
     * The method to update the energy data for a selected country and year.
     * @param country The name of the country.
     * @param year The year.
     * @param energyPerCapita The energy per capita.
     * @param energyPerGdp The energy per gdp
     */
    @Modifying
    @Transactional
    @Query(value = "UPDATE energy_data" +
            " SET energy_per_capita = :energyPerCapita, energy_per_gdp = :energyPerGdp" +
            " WHERE country = :country AND year = :year", nativeQuery = true)
    void updateEnergyByCountry(@Param("country") String country,
                               @Param("year") Integer year,
                               @Param("energyPerCapita") Double energyPerCapita,
                               @Param("energyPerGdp") Double energyPerGdp);

    /**
     * The method to delete the energy data for a selected country and year.
     * @param country The name of the country.
     * @param year The year.
     */
    @Modifying
    @Transactional
    @Query(value = "UPDATE energy_data" +
            " SET energy_per_capita = null, energy_per_gdp = null" +
            " WHERE country = :country AND year = :year", nativeQuery = true)
    void deleteEnergyByCountry(@Param("country") String country,
                               @Param("year") Integer year);
}

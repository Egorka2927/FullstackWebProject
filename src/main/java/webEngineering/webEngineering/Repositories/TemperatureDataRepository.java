package webEngineering.webEngineering.Repositories;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import webEngineering.webEngineering.Entities.TemperatureDataEntity;

import java.util.List;

/**
 * The repository for the manipulation of the temperature data
 */
@Repository
public interface TemperatureDataRepository extends CrudRepository<TemperatureDataEntity, Integer> {

    /**
     * The method to retrieve the temperature data
     * in all the continents
     * @param continents The list of continents
     * @return The TemperatureDataEntity object
     */
    List<TemperatureDataEntity> findTemperatureDataEntityByCountryIn(List<String> continents);

    /**
     * The method to retrieve the temperature data filtered
     * by the year in all the continents
     * @param continents The list of continents
     * @param year The year
     * @return The TemperatureDataEntity object
     */
    List<TemperatureDataEntity> findTemperatureDataEntityByCountryInAndYearGreaterThan(List<String> continents,
                                                                                          Integer year);

    /**
     * The method to retrieve the temperature
     * data filtered by the contribution in a year (bottom)
     * @param year The year
     * @param pageable The pagination
     * @return The TemperatureDataEntity object
     */
    @Query("SELECT t FROM TemperatureDataEntity t" +
            " WHERE t.year = :year AND t.shareOfTemperatureChangeFromGhg IS NOT NULL" +
            " ORDER BY t.shareOfTemperatureChangeFromGhg ASC")
    List<TemperatureDataEntity> retrieveContributionBottomYear(@Param("year") Integer year, Pageable pageable);

    /**
     * The method to retrieve the temperature
     * data filtered by the contribution in a year (top)
     * @param year The year
     * @param pageable The pagination
     * @return The TemperatureDataEntity object
     */
    @Query("SELECT t FROM TemperatureDataEntity t" +
            " WHERE t.year = :year AND t.shareOfTemperatureChangeFromGhg IS NOT NULL" +
            " ORDER BY t.shareOfTemperatureChangeFromGhg DESC")
    List<TemperatureDataEntity> retrieveContributionTopYear(@Param("year") Integer year, Pageable pageable);

    /**
     * The method to retrieve the temperature
     * data filtered by the contribution in a
     * number of years (top)
     * @param years The number of years
     * @param pageable The pagination
     * @return The TemperatureDataEntity object
     */
    @Query("SELECT t FROM TemperatureDataEntity t" +
            " WHERE t.year BETWEEN YEAR(CURDATE()) - :years AND YEAR(CURDATE())" +
            " AND t.shareOfTemperatureChangeFromGhg IS NOT NULL" +
            " ORDER BY t.shareOfTemperatureChangeFromGhg DESC")
    List<TemperatureDataEntity> retrieveContributionTopYears(@Param("years") Integer years, Pageable pageable);

    /**
     * The method to retrieve the temperature
     * data filtered by the contribution in a
     * number of years (bottom)
     * @param years The number of years
     * @param pageable The pagination
     * @return The TemperatureDataEntity object
     */
    @Query("SELECT t FROM TemperatureDataEntity t" +
            " WHERE t.year BETWEEN YEAR(CURDATE()) - :years AND YEAR(CURDATE())" +
            " AND t.shareOfTemperatureChangeFromGhg IS NOT NULL" +
            " ORDER BY t.shareOfTemperatureChangeFromGhg ASC")
    List<TemperatureDataEntity> retrieveContributionBottomYears(@Param("years") Integer years, Pageable pageable);
}

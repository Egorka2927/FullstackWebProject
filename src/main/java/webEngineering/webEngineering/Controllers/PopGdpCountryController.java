package webEngineering.webEngineering.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import webEngineering.webEngineering.Exceptions.DataAlreadyExistsException;
import webEngineering.webEngineering.Exceptions.NoResultException;
import webEngineering.webEngineering.Models.*;
import webEngineering.webEngineering.Services.PopGdpCountryService;

/**
 * Controller for population and gdp related data.
 * Used to get, post, put and delete data described in functionality 1 from REQ1.
 */
@CrossOrigin("http://localhost:3000")
@RestController
public class PopGdpCountryController {
    private PopGdpCountryService popGdpCountryService;

    @Autowired
    public void setPopGdpCountryService(PopGdpCountryService popGdpCountryService) {
        this.popGdpCountryService = popGdpCountryService;
    }

    /**
     * GET method to retrieve population and gdp data for a given country in a given year.
     * @param country Given country.
     * @param year Given year.
     * @param format Either JSON or CSV.
     * @return Response entity with body type String.
     */
    @GetMapping(value = "/countries/{country}/{year}/population-gdp-name")
    public ResponseEntity<String> showDataByCountry(@PathVariable String country,
                                                         @PathVariable Integer year,
                                                         @RequestParam(required = false) String format) {
        try {
            return ResponseEntity.ok(popGdpCountryService.showByCountry(country, year, format));
        } catch (NoResultException e) {
            return ResponseEntity.noContent().build();
        }
    }

    /**
     * POST method to create population and gdp data for a selected country and year.
     * @param model Model where all data is stored.
     * @param format Either JSON or CSV.
     * @return Response entity with body type String.
     */
    @PostMapping(value = "/countries/country/population-gdp-name")
    public ResponseEntity<String> postDataByCountry(@RequestBody CountryModel model,
                                                    @RequestParam(required = false) String format) {
        try {
            return ResponseEntity.ok(popGdpCountryService.postByCountry(model.getCountry(), model.getYear(),
                    model.getPopulation(), model.getGdp(), format));
        } catch (DataAlreadyExistsException e) {
            throw new ResponseStatusException(409, e.getMessage(), e);
        }
    }

    /**
     * DELETE method to remove population and gdp data for a selected country and year.
     * @param country Selected country.
     * @param year Selected year.
     * @param format Either JSON or CSV.
     * @return Response entity with body type String.
     */
    @DeleteMapping("/countries/{country}/{year}/population-gdp-name")
    public ResponseEntity<String> deleteDataByCountry(@PathVariable String country,
                                                            @PathVariable Integer year,
                                                            @RequestParam(required = false) String format) {
        try {
            return ResponseEntity.ok(popGdpCountryService.deleteByCountry(country, year, format));
        } catch (NoResultException e) {
            return ResponseEntity.noContent().build();
        }
    }

    /**
     * PUT method to update population and gdp data for a selected country and year.
     * @param country Selected country.
     * @param year Selected year.
     * @param model Model where all data is stored.
     * @param format Either JSON or CSV.
     * @return Response entity with body type String.
     */
    @PutMapping("/countries/{country}/{year}/population-gdp-name")
    public ResponseEntity<String> updateDataByCountry(@PathVariable String country,
                                                           @PathVariable Integer year,
                                                           @RequestBody PopGdpModel model,
                                                           @RequestParam(required = false) String format) {
        try {
            return ResponseEntity.ok(popGdpCountryService.putByCountry(country, year, model.getPopulation(),
                    model.getGdp(), format));
        } catch (NoResultException e) {
            return ResponseEntity.noContent().build();
        }
    }

    /**
     * GET method to retrieve population and gdp data for a given iso code and year.
     * @param isoCode Given iso code.
     * @param year Given year.
     * @param format Either JSON or CSV.
     * @return Response entity with body type String.
     */
    @GetMapping("/countries/{iso_code}/{year}/population-gdp-code")
    public ResponseEntity<String> showDataByIsoCode(@PathVariable(name = "iso_code") String isoCode,
                                                         @PathVariable Integer year,
                                                         @RequestParam(required = false) String format) {
        try {
            return ResponseEntity.ok(popGdpCountryService.showByIsoCode(isoCode, year, format));
        } catch (NoResultException e) {
            return ResponseEntity.noContent().build();
        }
    }

    /**
     * POST method to create population and gdp data for a selected iso code and year.
     * @param model Model where all data is stored.
     * @param format Either JSON or CSV.
     * @return Response entity with body type String.
     */
    @PostMapping(value = "/countries/iso-code/population-gdp-code")
    public ResponseEntity<String> postDataByIsoCode(@RequestBody IsoCodeModel model,
                                                    @RequestParam(required = false) String format) {
        try {
            return ResponseEntity.ok(popGdpCountryService.postByIsoCode(model.getIsoCode(), model.getYear(),
                    model.getPopulation(), model.getGdp(), format));
        } catch (DataAlreadyExistsException e) {
            throw new ResponseStatusException(409, e.getMessage(), e);
        }
    }

    /**
     * DELETE method to remove population and gdp data for a selected iso code and year.
     * @param isoCode Selected iso code.
     * @param year Selected year.
     * @param format Either JSON or CSV.
     * @return Response entity with body type String.
     */
    @DeleteMapping("/countries/{iso_code}/{year}/population-gdp-code")
    public ResponseEntity<String> deleteDataByIsoCode(@PathVariable(name = "iso_code") String isoCode,
                                                            @PathVariable Integer year,
                                                            @RequestParam(required = false) String format) {
        try {
            return ResponseEntity.ok(popGdpCountryService.deleteByIsoCode(isoCode, year, format));
        } catch (NoResultException e) {
            return ResponseEntity.noContent().build();
        }
    }

    /**
     * PUT method to update population and gdp data for a selected iso code and year.
     * @param isoCode Selected iso code.
     * @param year Selected year.
     * @param model Model where all data is stored.
     * @param format Either JSON or CSV.
     * @return Response entity with body type String.
     */
    @PutMapping("/countries/{iso_code}/{year}/population-gdp-code")
    public ResponseEntity<String> updateDataByIsoCode(@PathVariable(name = "iso_code") String isoCode,
                                                           @PathVariable Integer year,
                                                           @RequestBody PopGdpModel model,
                                                           @RequestParam(required = false) String format) {
        try {
            return ResponseEntity.ok(popGdpCountryService.putByIsoCode(isoCode, year, model.getPopulation(), model.getGdp(), format));
        } catch (NoResultException e) {
            return ResponseEntity.noContent().build();
        }
    }
}
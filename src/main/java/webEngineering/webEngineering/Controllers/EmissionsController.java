package webEngineering.webEngineering.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import webEngineering.webEngineering.Exceptions.NoResultException;
import webEngineering.webEngineering.Services.EmissionsService;

/**
 * Controller for emissions related data.
 * Used to get data described in functionality 2 from REQ1.
 */
@CrossOrigin("http://localhost:3000")
@RestController
public class EmissionsController {

    private EmissionsService emissionsService;

    @Autowired
    public void setEmissionsService(EmissionsService emissionsService) {
        this.emissionsService = emissionsService;
    }

    /**
     * GET method to retrieve emissions data for a given country.
     * @param country Given country.
     * @param format Either JSON or CSV.
     * @return Response entity with body type String.
     */
    @GetMapping(value = "/countries/{country}/emissions-name")
    public ResponseEntity<String> showEmissionsDataCountry(@PathVariable String country,
                                                                         @RequestParam(required = false) String format) {
        try {
            return ResponseEntity.ok(emissionsService.showEmissionsCountry(country, format));
        } catch(NoResultException e) {
            return ResponseEntity.noContent().build();
        }
    }

    /**
     * GET method to retrieve emissions data for a given iso code.
     * @param isoCode Given iso code.
     * @param format Either JSON or CSV.
     * @return Response entity with body type String.
     */
    @GetMapping("/countries/{iso_code}/emissions-code")
    public ResponseEntity<String> showEmissionsDataIsoCode(@PathVariable(name = "iso_code") String isoCode,
                                                                         @RequestParam(required = false) String format) {
        try {
            return ResponseEntity.ok(emissionsService.showEmissionsIsoCode(isoCode, format));
        } catch(NoResultException e) {
            return ResponseEntity.noContent().build();
        }
    }

    /**
     * GET method to retrieve emissions data for a given country and year and later.
     * @param country Given country.
     * @param year Given year.
     * @param format Either JSON or CSV.
     * @return Response entity with body type String.
     */
    @GetMapping("/countries/{country}/{year}/emissions-name")
    public ResponseEntity<String> showEmissionsDataCountryYear(@PathVariable String country,
                                                                             @PathVariable Integer year,
                                                                             @RequestParam(required = false) String format) {
        try {
            return ResponseEntity.ok(emissionsService.showEmissionsCountryYear(country, year, format));
        } catch(NoResultException e) {
            return ResponseEntity.noContent().build();
        }
    }

    /**
     * GET method to retrieve emissions data for a given iso code and year and later.
     * @param isoCode Given iso code.
     * @param year Given year.
     * @param format Either JSON or CSV.
     * @return Response entity with body type String.
     */
    @GetMapping("/countries/{iso_code}/{year}/emissions-code")
    public ResponseEntity<String> showEmissionsDataIsoCodeYear(@PathVariable(name = "iso_code") String isoCode,
                                                                             @PathVariable Integer year,
                                                                             @RequestParam(required = false) String format) {
        try {
            return ResponseEntity.ok(emissionsService.showEmissionsIsoCodeYear(isoCode, year, format));
        } catch(NoResultException e) {
            return ResponseEntity.noContent().build();
        }
    }
}

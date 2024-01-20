package webEngineering.webEngineering.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.*;
import webEngineering.webEngineering.Exceptions.NoResultException;
import webEngineering.webEngineering.Services.CountriesService;

/**
 * Controller for country names data.
 * Used to retrieve data for functionality 5 from REQ1.
 */
@CrossOrigin("http://localhost:3000")
@RestController
public class CountriesController {
    private CountriesService countriesService;

    @Autowired
    public void setCountriesService(CountriesService countriesService) {
        this.countriesService = countriesService;
    }

    /**
     * GET method to retrieve countries data in a given year range.
     * @param numberCountries How many countries.
     * @param years Year range (last N years).
     * @param filter Filter for Top or Bottom countries.
     * @param format Either JSON or CSV.
     * @return Response entity with body type String.
     */
    @GetMapping("/countries/names")
    public ResponseEntity<String> showCountriesLastYears(@RequestParam(name = "number_countries") Integer numberCountries,
                                                                         @RequestParam Integer years,
                                                                         @RequestParam String filter,
                                                                         @RequestParam(required = false) String format) {
        try {
            return ResponseEntity.ok(countriesService.chooseOptionYears(filter, years, numberCountries, format));
        } catch (NoResultException e) {
            return ResponseEntity.noContent().build();
        }
    }

    /**
     * GET method to retrieve countries data in a given year.
     * @param numberCountries How many countries.
     * @param year Given year.
     * @param filter Filter for Top or Bottom countries.
     * @param format Either JSON or CSV.
     * @return Response entity with body type String.
     */
    @GetMapping("/countries/{year}/names")
    public ResponseEntity<String> showCountriesYear(@RequestParam(name = "number_countries") Integer numberCountries,
                                                                    @PathVariable Integer year,
                                                                    @RequestParam String filter,
                                                                    @RequestParam(required = false) String format) {
        try {
            return ResponseEntity.ok(countriesService.chooseOptionYear(filter, year, numberCountries, format));
        } catch (NoResultException e) {
            return ResponseEntity.noContent().build();
        }
    }
}

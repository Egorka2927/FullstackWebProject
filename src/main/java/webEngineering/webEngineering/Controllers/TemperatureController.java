package webEngineering.webEngineering.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import webEngineering.webEngineering.Exceptions.NoResultException;
import webEngineering.webEngineering.Services.TemperatureService;

/**
 * Controller for temperature related data.
 * Used to retrieve data for functionality 3 in REQ1.
 */
@CrossOrigin("http://localhost:3000")
@RestController
public class TemperatureController {
    private TemperatureService temperatureService;

    @Autowired
    public void setTemperatureService(TemperatureService temperatureService) {
        this.temperatureService = temperatureService;
    }

    /**
     * GET method to retrieve temperature data for all continents.
     * @param format Either JSON or CSV.
     * @return Response entity with body type String.
     */
    @GetMapping("/continents/temperature")
    public ResponseEntity<String> showTemperatureData(@RequestParam(required = false) String format) {
        try {
            return ResponseEntity.ok(temperatureService.showTemperature(format));
        } catch(NoResultException e) {
            return ResponseEntity.noContent().build();
        }
    }

    /**
     * GET method to retrieve temperature data in a given year and later.
     * @param year Given year.
     * @param format Either JSON or CSV.
     * @return Response entity with body type String.
     */
    @GetMapping("/continents/{year}/temperature")
    public ResponseEntity<String> showTemperatureDataYear(@PathVariable Integer year,
                                                                          @RequestParam(required = false) String format) {
        try {
            return ResponseEntity.ok(temperatureService.showTemperatureYear(year, format));
        } catch(NoResultException e) {
            return ResponseEntity.noContent().build();
        }
    }
}

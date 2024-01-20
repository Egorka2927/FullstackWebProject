package webEngineering.webEngineering.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import webEngineering.webEngineering.Exceptions.DataAlreadyExistsException;
import webEngineering.webEngineering.Exceptions.NoResultException;
import webEngineering.webEngineering.Models.EnergyCountryModel;
import webEngineering.webEngineering.Models.EnergyModel;
import webEngineering.webEngineering.Services.EnergyGdpService;

/**
 * Controller for energy related data.
 * Used to get data described in functionality 4 from REQ1.
 */
@CrossOrigin("http://localhost:3000")
@RestController
public class EnergyGdpController {
    private EnergyGdpService energyGdpService;

    @Autowired
    public void setEnergyGdpService(EnergyGdpService energyGdpService) {
        this.energyGdpService = energyGdpService;
    }

    /**
     * GET method to retrieve energy data in a given year and displayed in batches.
     * @param year Given year.
     * @param batchSize Size of selected batch.
     * @param batchNumber Number of batch displayed.
     * @param format Either JSON or CSV.
     * @return Response entity with body type String.
     */
    @GetMapping("/countries/{year}/energy")
    public ResponseEntity<String> showEnergyData(@PathVariable Integer year,
                                                 @RequestParam(name = "batch_size") Integer batchSize,
                                                 @RequestParam(name = "batch_number") Integer batchNumber,
                                                 @RequestParam(required = false) String format) {
        try {
            return ResponseEntity.ok(energyGdpService.showEnergy(year, batchSize, batchNumber, format));
        } catch (NoResultException e) {
            return ResponseEntity.noContent().build();
        }
    }

    /**
     * POST method to create energy data for a selected country name and year.
     * @param model The model where all the data is stored.
     * @param format Either JSON or CSV.
     * @return Response entity with body type String.
     */
    @PostMapping("/countries/country/energy")
    public ResponseEntity<String> postEnergyDataByCountry(@RequestBody EnergyCountryModel model,
                                                          @RequestParam(required = false) String format) {
        try {
            return ResponseEntity.ok(energyGdpService.postEnergyByCountry(model.getCountry(), model.getYear(),
                    model.getEnergyPerCapita(), model.getEnergyPerGdp(), format));
        } catch (DataAlreadyExistsException e) {
            throw new ResponseStatusException(409, e.getMessage(), e);
        }
    }

    /**
     * DELETE method to delete energy data for a selected country name and year.
     * @param country The name of the country.
     * @param year The year.
     * @param format Either JSON or CSV.
     * @return Response entity with body type string.
     */
    @DeleteMapping("/countries/{country}/{year}/energy")
    public ResponseEntity<String> deleteEnergyDataByCountry(@PathVariable String country,
                                                            @PathVariable Integer year,
                                                            @RequestParam(required = false) String format) {
        try {
            return ResponseEntity.ok(energyGdpService.deleteEnergyByCountry(country, year, format));
        } catch (NoResultException e) {
            return ResponseEntity.noContent().build();
        }
    }

    /**
     * PUT method to update energy data for a selected country name and year.
     * @param country The name of the country.
     * @param year The year.
     * @param model The model where all the data is stored.
     * @param format Either JSON or CSV.
     * @return Response entity with body type string.
     */
    @PutMapping("/countries/{country}/{year}/energy")
    public ResponseEntity<String> updateDataByCountry(@PathVariable String country,
                                                      @PathVariable Integer year,
                                                      @RequestBody EnergyModel model,
                                                      @RequestParam(required = false) String format) {
        try {
            return ResponseEntity.ok(energyGdpService.putByCountry(country, year, model.getEnergyPerCapita(),
                    model.getEnergyPerGdp(), format));
        } catch (NoResultException e) {
            return ResponseEntity.noContent().build();
        }
    }
}

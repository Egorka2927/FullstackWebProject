package webEngineering.webEngineering.Controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import webEngineering.webEngineering.Models.ExceptionModel;
import webEngineering.webEngineering.Util.CsvConverter;
import webEngineering.webEngineering.Util.JsonConverter;

import java.util.Map;

/**
 * Controller used to generalize errors.
 */
@RestController
public class RestErrorController extends AbstractErrorController {

    public RestErrorController(ErrorAttributes errorAttributes) {
        super(errorAttributes);
    }

    /**
     * Method to handle a specific error and generalize it.
     * @param format Either JSON or CSV.
     * @param request Error received.
     * @return A String containing information about the error.
     */
    @RequestMapping(value = "/error")
    public String handleError(@RequestParam(required = false) String format, HttpServletRequest request) {
        Map<String, Object> errorAttributes = super.getErrorAttributes(request,
                ErrorAttributeOptions.defaults().including(ErrorAttributeOptions.Include.MESSAGE));
        ExceptionModel model = new ExceptionModel(errorAttributes.get("timestamp").toString(),
                errorAttributes.get("status"),
                errorAttributes.get("error"),
                errorAttributes.get("message"),
                errorAttributes.get("path"));
        if (format != null && format.equals("CSV")) {
            return CsvConverter.toCsv(model);
        }
        return JsonConverter.toJson(model);
    }
}

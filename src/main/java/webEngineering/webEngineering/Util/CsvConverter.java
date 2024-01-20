package webEngineering.webEngineering.Util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.util.List;

/**
 * The CSV converter
 */
public class CsvConverter {
    /**
     * @param object The object to be converted
     * @return The CSV formatted string
     */
    public static String toCsv(Object object) {
        CsvMapper csvMapper = new CsvMapper();
        CsvSchema csvSchema = csvMapper.schemaFor(object.getClass()).withHeader();
        String csv;
        try {
            csv = csvMapper.writer(csvSchema).writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return csv;
    }

    /**
     * @param objects The list of objects
     * @param objectClass The class of the object
     * @param <T> The class name
     * @return The CSV formatted string
     */
    public static <T> String listToCsv(List<T> objects, Class objectClass) {
        CsvMapper csvMapper = new CsvMapper();
        CsvSchema csvSchema = csvMapper.schemaFor(objectClass).withHeader();
        String csv;
        try {
            csv = csvMapper.writer(csvSchema).writeValueAsString(objects);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return csv;
    }
}

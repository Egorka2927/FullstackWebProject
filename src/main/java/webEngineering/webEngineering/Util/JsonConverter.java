package webEngineering.webEngineering.Util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;

import java.util.List;

/**
 * This JSON converter
 */
public class JsonConverter {
    /**
     * @param object The object to be converted
     * @return The JSON formatted string
     */
    public static String toJson(Object object) {
        JsonMapper jsonMapper = new JsonMapper();
        String json;

        try {
            json = jsonMapper.writeValueAsString(object);
        } catch(JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return json;
    }

    /**
     * @param objects The list of objects
     * @param <T> The class name
     * @return The JSON formatted string
     */
    public static <T> String listToJson(List<T> objects) {
        JsonMapper jsonMapper = new JsonMapper();
        String json;

        try {
            json = jsonMapper.writeValueAsString(objects);
        } catch(JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return json;
    }
}

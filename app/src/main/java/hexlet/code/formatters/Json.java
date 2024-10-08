package hexlet.code.formatters;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;

public class Json {

    public static String format(List<Map<String, Object>> diff) throws Exception {
        return new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(diff);
    }
}

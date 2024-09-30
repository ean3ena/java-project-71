package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class Plain {

    public static String format(List<Map<String, Object>> diff) {

        StringBuilder result = new StringBuilder();

        for (var elem : diff) {
            var status = (String) elem.get("status");
            var key = elem.get("key");

            switch (status) {
                case "added" -> result.append("Property '").append(key)
                        .append("' was added with value: ")
                        .append(getTextByValue(elem.get("value"))).append("\n");
                case "deleted" -> result.append("Property '").append(key)
                        .append("' was removed").append("\n");
                case "changed" -> result.append("Property '").append(key)
                        .append("' was updated. From ")
                        .append(getTextByValue(elem.get("value1"))).append(" to ")
                        .append(getTextByValue(elem.get("value2"))).append("\n");
                default -> { }
            }
        }
        return result.substring(0, result.length() - 1);
    }

    private static String getTextByValue(Object obj) {

        if (obj == null) {
            return "null";
        }
        if (obj instanceof String) {
            return "'" + obj + "'";
        }
        if (obj instanceof Boolean || obj instanceof Number) {
            return obj.toString();
        }
        return "[complex value]";
    }
}

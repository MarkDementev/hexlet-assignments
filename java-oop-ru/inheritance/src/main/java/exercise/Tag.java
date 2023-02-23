package exercise;

import java.util.stream.Collectors;
import java.util.Map;

// BEGIN
public class Tag {
    private final String tagName;
    private final Map<String, String> tagAttributes;

    public Tag(String tagName, Map<String, String> tagAttributes) {
        this.tagName = tagName;
        this.tagAttributes = tagAttributes;
    }

    public String getTagName() {
        return tagName;
    }

    public String tagToString() {
        StringBuilder toStringBuilder = new StringBuilder("<" + tagName);

        for (Map.Entry<String, String> element : tagAttributes.entrySet()) {
            toStringBuilder.append(" ")
                    .append(element.getKey()).append("=\"")
                    .append(element.getValue()).append("\"");
        }
        return toStringBuilder.append(">").toString();
    }
}
// END

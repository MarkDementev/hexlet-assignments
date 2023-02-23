package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag {
    private final String tagBody;
    private final List<Tag> childrenList;

    public PairedTag(String tagName, Map<String, String> tagAttributes, String tagBody, List<Tag> childrenList) {
        super(tagName, tagAttributes);
        this.tagBody = tagBody;
        this.childrenList = childrenList;
    }

    @Override
    public String toString() {
        StringBuilder toStringBuilder = new StringBuilder(tagToString() + tagBody);

        for (Tag child : childrenList) {
            toStringBuilder.append(child.tagToString());
        }
        return toStringBuilder.append("</").append(getTagName()).append(">").toString();
    }
}
// END

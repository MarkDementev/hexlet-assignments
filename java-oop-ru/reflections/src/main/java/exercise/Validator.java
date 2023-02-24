package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// BEGIN
public class Validator {
    public static List<String> validate(Address address) {
        Field[] addressFields = address.getClass().getDeclaredFields();
        List<String> notValidatedFields = new ArrayList<>();

        for (Field field : addressFields) {
            String fieldValue = null;
            NotNull fieldAnnotation = field.getAnnotation(NotNull.class);

            try {
                field.setAccessible(true);
                fieldValue = (String) field.get(address);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

            if (fieldAnnotation != null && fieldValue == null) {
                notValidatedFields.add(field.getName());
            }
        }
        return notValidatedFields;
    }

    public static Map<String, List<String>> advancedValidate(Address address) {
        Map<String, List<String>> notValidatedFields = new HashMap<>();
        Field[] addressFields = address.getClass().getDeclaredFields();

        for (Field field : addressFields) {
            NotNull notNullAnnotation = field.getAnnotation(NotNull.class);
            MinLength minLengthAnnotation = field.getAnnotation(MinLength.class);
            String fieldValue = null;
            int fieldValueLength = 0;
            String notValidatedFieldName = field.getName();

            try {
                field.setAccessible(true);
                fieldValue = (String) field.get(address);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

            if (notNullAnnotation != null
                    && fieldValue == null) {
                notValidatedFields.put(notValidatedFieldName, List.of("can not be null"));
            } else if (notNullAnnotation != null
                    && minLengthAnnotation != null
                    && fieldValueLength < minLengthAnnotation.minLength()) {
                notValidatedFields.put(notValidatedFieldName, List.of("length less than 3"));
            }
        }
        return notValidatedFields;
    }
}
// END

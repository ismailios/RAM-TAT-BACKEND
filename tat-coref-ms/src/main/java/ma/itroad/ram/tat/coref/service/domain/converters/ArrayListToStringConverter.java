package ma.itroad.ram.tat.coref.service.domain.converters;

import org.apache.commons.lang.StringUtils;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Converter
public class ArrayListToStringConverter implements AttributeConverter<List<String>,String> {
    private static final String SEPARATOR = "|||";
    @Override
    public String convertToDatabaseColumn(List<String> attribute) {
        return attribute == null ? null : StringUtils.join(attribute,",");

    }

    @Override
    public List<String> convertToEntityAttribute(String dbData) {
        if (StringUtils.isBlank(dbData))
            return Collections.emptyList();

        try (Stream<String> stream = Arrays.stream(dbData.split(","))) {
            return stream.collect(Collectors.toList());
        }
    }
}

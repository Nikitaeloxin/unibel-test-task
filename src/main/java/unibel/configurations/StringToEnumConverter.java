package unibel.configurations;

import org.springframework.core.convert.converter.Converter;

import unibel.models.ContactType;

public class StringToEnumConverter implements Converter<String, ContactType> {

	@Override
    public ContactType convert(String source) {
        return ContactType.valueOf(source.toUpperCase());
    }

}

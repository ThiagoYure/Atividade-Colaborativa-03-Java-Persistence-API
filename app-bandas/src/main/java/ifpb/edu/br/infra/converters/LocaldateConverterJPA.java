package ifpb.edu.br.infra.converters;

import ifpb.edu.br.domain.CPF;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Date;
import java.time.LocalDate;

@Converter(autoApply = false)
public class LocaldateConverterJPA implements AttributeConverter<LocalDate, Date> {


    @Override
    public Date convertToDatabaseColumn(LocalDate localDate) {
        if(localDate == null){
            return null;
        }
        return Date.valueOf(localDate);
    }

    @Override
    public LocalDate convertToEntityAttribute(Date date) {
        if(date == null){
            return null;
        }
        return date.toLocalDate();
    }
}

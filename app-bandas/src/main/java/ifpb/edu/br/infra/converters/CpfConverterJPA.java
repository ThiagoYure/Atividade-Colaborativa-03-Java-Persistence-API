package ifpb.edu.br.infra.converters;

import ifpb.edu.br.domain.CPF;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class CpfConverterJPA implements AttributeConverter<CPF,String> {
    @Override
    public String convertToDatabaseColumn(CPF cpf) {
        if(cpf == null){
            return null;
        }
        return cpf.getNumero();
    }

    @Override
    public CPF convertToEntityAttribute(String s) {
        if(s == null){
            return null;
        }
        CPF cpf = new CPF(s);
        return cpf;
    }
}

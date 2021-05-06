package ifpb.edu.br.infra.converters;

import ifpb.edu.br.domain.CPF;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Named
@FacesConverter(value = "converterLocaldate")
public class LocalDateConverterFaces implements Converter, Serializable {
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        if(s != null && s.trim().length() > 0 ){
            return LocalDate.parse(s);
        }else{
            System.out.println("Erro palavra vazia");
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        if(o == null){
            return null;
        }
        return o.toString();
    }
}

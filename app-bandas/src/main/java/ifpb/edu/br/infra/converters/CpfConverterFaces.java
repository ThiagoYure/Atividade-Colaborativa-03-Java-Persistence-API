package ifpb.edu.br.infra.converters;

import ifpb.edu.br.domain.CPF;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "cpf.converter")
public class CpfConverterFaces implements Converter {
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        if(s == null){
            return null;
        }
        CPF cpf = new CPF(s);
        return cpf;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        if(o == null){
            return null;
        }
        CPF cpf = (CPF) o;
        return cpf.cpfFormatado();
    }
}

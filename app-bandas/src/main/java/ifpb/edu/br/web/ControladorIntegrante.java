package ifpb.edu.br.web;

import ifpb.edu.br.infra.IntegranteManager;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class ControladorIntegrante implements Serializable {

    @EJB
    private IntegranteManager manager;
}

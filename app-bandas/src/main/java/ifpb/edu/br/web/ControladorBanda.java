package ifpb.edu.br.web;

import ifpb.edu.br.infra.BandaManager;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class ControladorBanda implements Serializable {

    @EJB
    private BandaManager manager;
}

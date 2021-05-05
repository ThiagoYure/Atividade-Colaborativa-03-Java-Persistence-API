package ifpb.edu.br.web;

import ifpb.edu.br.infra.GerenteManager;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class ControladorGerente implements Serializable {

    @EJB
    private GerenteManager manager;
}

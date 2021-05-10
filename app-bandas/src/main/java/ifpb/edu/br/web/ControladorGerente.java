package ifpb.edu.br.web;

import ifpb.edu.br.domain.Gerente;
import ifpb.edu.br.domain.Integrante;
import ifpb.edu.br.infra.GerenteManager;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class ControladorGerente implements Serializable {

    @EJB
    private GerenteManager manager = new GerenteManager();
    private Gerente gerente = new Gerente();

    public String novoGerente(){
        if(this.gerente != null){
            this.manager.novo(this.gerente);
            this.gerente = new Gerente();
        }else{
            System.out.println("erro");
        }
        return null;
    }

    public String atualizarGerente(){
        if(this.gerente != null){
            this.manager.atualizar(this.gerente);
            this.gerente = new Gerente();
        }else{
            System.out.println("erro");
        }
        return null;
    }

    public String atualizarGerenteLocal(Gerente novo){
        this.gerente = novo;
        return "edicaoGerente";
    }

    public String excluirGerente(Gerente gerente){
        if(gerente != null){
            manager.excluir(gerente);
        }else{
            System.out.println("erro");
        }
        this.gerente = new Gerente();
        return null;
    }

    public List<Gerente> buscaTodosGerentes(){
        return manager.todos();
    }

    public Gerente getGerente() {
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }
}

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
    private GerenteManager manager;
    private Gerente gerente;

    public String novoIntegrante(){
        if(this.gerente != null){
            manager.novo(this.gerente);
        }else{
            System.out.println("erro");
        }
        return null;
    }

    public String atualizarIntegrante(){
        if(this.gerente != null){
            manager.atualizar(this.gerente);
        }else{
            System.out.println("erro");
        }
        return null;
    }

    public String atualizarIntegranteLocal(Gerente novo){
        this.gerente = novo;
        return "atualizacaoGerente";
    }

    public String excluirIntegrante(Gerente gerente){
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

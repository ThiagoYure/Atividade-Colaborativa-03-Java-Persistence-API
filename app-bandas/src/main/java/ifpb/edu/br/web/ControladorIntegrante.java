package ifpb.edu.br.web;

import ifpb.edu.br.domain.CPF;
import ifpb.edu.br.domain.Gerente;
import ifpb.edu.br.domain.Integrante;
import ifpb.edu.br.infra.IntegranteManager;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class ControladorIntegrante implements Serializable {

    @EJB
    private IntegranteManager manager;
    private Integrante integrante = new Integrante();
    private Integrante integrantePesquisado = new Integrante();

    public String novoIntegrante(){
        System.out.println(this.integrante.toString());
        if(this.integrante != null){
            manager.novo(this.integrante);
            this.integrante = new Integrante();
        }else{
            System.out.println("erro");
        }
        return null;
    }

    public String atualizarIntegrante(){
        if(this.integrante != null){
            manager.atualizar(this.integrante);
            this.integrante = new Integrante();
        }else{
            System.out.println("erro");
        }
        return null;
    }

    public String atualizarIntegranteLocal(Integrante novo){
        this.integrante = novo;
        return "atualizacaoIntegrante";
    }

    public String excluirIntegrante(Integrante integrante){
        if(integrante != null){
            this.manager.excluir(integrante);
            this.integrantePesquisado.setId(0);
        }else{
            System.out.println("erro");
        }
        this.integrante = new Integrante();
        return null;
    }

    public List<Integrante> buscaTodosIntegrantes(){
        System.out.println(manager.todos());
        return manager.todos();
    }

    public List<Integrante> buscaIntegrantesPorDataNascimento(){
        return manager.buscaPorIntervaloNascimento();
    }

    public Integrante buscaIntegrantePorCPF(){
        integrantePesquisado.setId(1);
        return null;
    }

    public Integrante buscaIntegranteCPF(){
        return manager.buscaPorCpf(integrantePesquisado.getCpf());
    }

    public Integrante getIntegrante() {
        return integrante;
    }

    public void setIntegrante(Integrante integrante) {
        this.integrante = integrante;
    }

    public Integrante getIntegrantePesquisado() {
        return integrantePesquisado;
    }

    public void setIntegrantePesquisado(Integrante integrantePesquisado) {
        this.integrantePesquisado = integrantePesquisado;
    }
}

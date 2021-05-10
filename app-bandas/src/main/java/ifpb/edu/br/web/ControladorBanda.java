package ifpb.edu.br.web;

import ifpb.edu.br.domain.Banda;
import ifpb.edu.br.domain.Gerente;
import ifpb.edu.br.domain.Integrante;
import ifpb.edu.br.infra.BandaManager;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@SessionScoped
public class ControladorBanda implements Serializable {

    @EJB
    private BandaManager manager;
    private Banda banda = new Banda();
    private Gerente gerente = new Gerente();
    private Banda bandaPesquisada = new Banda();

    public String novaBanda () {
        System.out.println(this.banda.toString());
        if(this.banda != null){
            manager.novo(this.banda);
            this.banda = new Banda();
        }else{
            System.out.println("erro");
        }
        return null;
    }

    public String atualizarBanda () {
        if(this.banda != null){
            manager.atualizar(this.banda);
            this.banda = new Banda();
        }else{
            System.out.println("erro");
        }
        return null;
    }

    public String atualizarBandaLocal (Banda nova) {
        this.banda = nova;
        return "atualizacaoBanda";
    }

    public String excluirBanda () {
        if(banda != null){
            this.manager.excluir(banda);
            this.bandaPesquisada.setId(0);
        }else{
            System.out.println("erro");
        }
        this.banda = new Banda();
        return null;
    }

    public List<Banda> buscaTodasBandas(){
        System.out.println(manager.todas());
        return manager.todas();
    }

    public String addIntegrante(Integrante integrante){
        List<Integrante> integranteList;
        if (banda.getIntegrantes()==null){
            integranteList = new ArrayList<>();
        }else{
            integranteList = banda.getIntegrantes();

        }
        integranteList.add(integrante);
        banda.setIntegrantes(integranteList);
        return null;
    }
    public String addGerente(Gerente target){
        this.gerente = target;
        System.out.println(target);
        banda.setGerente(target);
        return null;
    }

    public List<Banda> buscarPorLocalDeOrigem(){
        return (List<Banda>) manager.buscarPorLocalDeOrigem(bandaPesquisada.getLocalDeOrigem());
    }

    public Banda getBanda() {
        return banda;
    }

    public Gerente getGerente() {
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }

    public void setBanda(Banda banda) {
        this.banda = banda;
    }

    public Banda getBandaPesquisada() {
        return bandaPesquisada;
    }

    public void setBandaPesquisada(Banda bandaPesquisada) {
        this.bandaPesquisada = bandaPesquisada;
    }
}

package ifpb.edu.br.infra;

import ifpb.edu.br.domain.Gerente;
import ifpb.edu.br.domain.Integrante;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class GerenteManager {

    @PersistenceContext(unitName = "Postgres")
    private EntityManager em;

    public void novo(Gerente gerente){
        em.persist(gerente);
    }

    public List<Gerente> todos(){
        return null;
    }

    public void atualizar(Gerente gerente){
        em.merge(gerente);
    }

    public void excluir(Gerente gerente){
        em.remove(gerente);
    }
}

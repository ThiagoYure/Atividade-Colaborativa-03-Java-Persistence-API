package ifpb.edu.br.infra;

import ifpb.edu.br.domain.Gerente;
import ifpb.edu.br.domain.Integrante;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class GerenteManager {

    @PersistenceContext(unitName = "default")
    private EntityManager em;

    public void novo(Gerente gerente){
        em.persist(gerente);
    }

    public List<Gerente> todos(){
        String jpql = "SELECT g FROM Gerente g";
        TypedQuery<Gerente> query = em.createQuery(jpql, Gerente.class);
        List<Gerente> resultList = query.getResultList();
        return resultList;
    }

    public void atualizar(Gerente gerente){
        em.merge(gerente);
    }

    public void excluir(Gerente gerente){
        em.remove(em.find(Gerente.class,gerente.getId()));
    }

}

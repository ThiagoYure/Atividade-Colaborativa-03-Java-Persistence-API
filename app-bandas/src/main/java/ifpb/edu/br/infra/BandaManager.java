package ifpb.edu.br.infra;


import ifpb.edu.br.domain.Banda;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class BandaManager {

    @PersistenceContext(unitName = "default")
    private EntityManager em;

    public void novo(Banda nova) {
        em.persist(nova);
    }

    public List<Banda> todas (){
        String jpql = "SELECT b FROM Banda b";
        TypedQuery<Banda> query = em.createQuery(jpql, Banda.class);
        List<Banda> resultList = query.getResultList();
        return resultList;
    }

    public void atualizar (Banda banda) {
        em.merge(banda);
    }

    public void excluir (Banda banda) {
        em.remove(em.find(Banda.class, banda.getId()));
    }

    public List<Banda> buscarPorLocalDeOrigem (String localDeOrigem) {
        String jpql = "SELECT b FROM Banda b WHERE b.localDeOrigem = :localDeOrigem";
        TypedQuery<Banda> query = em.createQuery(jpql, Banda.class);
        query.setParameter("localDeOrigem", localDeOrigem);
        List<Banda> banda = query.getResultList();
        return banda;
    }

}

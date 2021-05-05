package ifpb.edu.br.infra;

import ifpb.edu.br.domain.Integrante;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Stateless
public class IntegranteManager {

    @PersistenceContext(unitName = "Postgres")
    private EntityManager em;

    public void novo(Integrante integrante){
        em.persist(integrante);
    }

    public List<Integrante> todos(){
        String jpql = "SELECT i FROM Integrante i";
        TypedQuery<Integrante> query = em.createQuery(jpql, Integrante.class);
        List<Integrante> resultList = query.getResultList();
        return resultList;
    }

    public void atualizar(Integrante integrante){
        em.merge(integrante);
    }

    public void excluir(Integrante integrante){
        em.remove(integrante);
    }

    public Integrante buscaPorCpf(String cpf){
        String jpql = "SELECT i FROM Integrante i WHERE i.cpf = :cpf";
        TypedQuery<Integrante> query = em.createQuery(jpql, Integrante.class);
        query.setParameter("cpf", cpf);
        Integrante integrante = query.getSingleResult();
        return integrante;
    }

    public List<Integrante> buscaPorIntervaloNascimento(){
        String jpql = "SELECT i FROM Integrante i WHERE i.dataDeNascimento BETWEEN :dataInicial AND :dataFinal";
        TypedQuery<Integrante> query = em.createQuery(jpql, Integrante.class);
        //query.setParameter("dataInicial", new java.util.Date(2000,1,1), TemporalType.DATE);
        //query.setParameter("dataFinal", new java.util.Date(2016,4,20), TemporalType.DATE);
        query.setParameter("dataInicial", LocalDate.now());
        query.setParameter("dataFinal", LocalDate.now());
        List<Integrante> resultList = query.getResultList();
        return resultList;
    }
}

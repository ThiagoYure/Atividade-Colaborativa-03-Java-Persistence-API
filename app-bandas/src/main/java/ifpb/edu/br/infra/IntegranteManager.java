package ifpb.edu.br.infra;

import ifpb.edu.br.domain.CPF;
import ifpb.edu.br.domain.Integrante;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Stateless
public class IntegranteManager {

    @PersistenceContext(unitName = "default")
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
        em.remove(em.find(Integrante.class,integrante.getId()));
    }

    public Integrante buscaPorCpf(CPF cpf){
        String jpql = "SELECT i FROM Integrante i WHERE i.cpf = :cpf";
        TypedQuery<Integrante> query = em.createQuery(jpql, Integrante.class);
        query.setParameter("cpf", cpf);
        Integrante integrante = query.getResultList().get(0);
        return integrante;
    }

    public List<Integrante> buscaPorIntervaloNascimento(){
        String jpql = "SELECT i FROM Integrante i WHERE i.dataDeNascimento >= :dataInicial AND i.dataDeNascimento <= :dataFinal";
        TypedQuery<Integrante> query = em.createQuery(jpql, Integrante.class);
        query.setParameter("dataInicial", LocalDate.of(2000, 1, 1));
        query.setParameter("dataFinal", LocalDate.of(2016, 4, 20));
        List<Integrante> resultList = query.getResultList();
        return resultList;
    }
}

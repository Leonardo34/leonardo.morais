package br.com.crescer.aula4;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class RunHibernate {
    public static void main(String[] args) {
        final EntityManagerFactory emf;
        emf = Persistence.createEntityManagerFactory("localPU");
        final EntityManager em;
        em = emf.createEntityManager();
        
        Session session = em.unwrap(Session.class);
        Criteria criteria = session.createCriteria(Cliente.class);
        criteria.add(Restrictions.like("nmPessoa", "Leonardo10"));
        List<Cliente> clientes = criteria.list();
        System.out.println(clientes.get(0).getNmPessoa());
    }
}

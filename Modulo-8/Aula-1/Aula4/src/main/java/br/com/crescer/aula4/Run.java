/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula4;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author leonardo.morais
 */
public class Run {
    public static void main(String[] args) {
        final EntityManagerFactory emf;
        emf = Persistence.createEntityManagerFactory("localPU");
        final EntityManager em;
        em = emf.createEntityManager();
        em.getTransaction().begin();      
        for (int i = 0; i < 100; i++) {
            Cliente cliente = new Cliente();
            cliente.setNmPessoa("Leonardo" + i);
            em.persist(cliente);
        }
        em.getTransaction().commit();
        
        Cliente cliente = em.find(Cliente.class, 1L);
        System.out.println(cliente.getNmPessoa());
        cliente.setNmPessoa("Teste");
    }
}

package br.com.alura.jpa.testes;

import br.com.alura.jpa.modelo.Conta;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AlteraSaldoContaMurilo {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
        EntityManager em = emf.createEntityManager();

        Conta contaMurilo = em.find(Conta.class, 1L);
        em.getTransaction().begin();
        contaMurilo.setSaldo(200.0);
        em.getTransaction().commit();
    }
}

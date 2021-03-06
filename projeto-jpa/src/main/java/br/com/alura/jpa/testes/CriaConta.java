package br.com.alura.jpa.testes;

import br.com.alura.jpa.modelo.Conta;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CriaConta {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
        EntityManager em = emf.createEntityManager();

        Conta conta = new Conta();
        conta.setTitular("Santos");
        conta.setAgencia(1234);
        conta.setNumero(7412);
        conta.setSaldo(200.0);

        em.getTransaction().begin();
        em.persist(conta);
        em.getTransaction().commit();
    }
}

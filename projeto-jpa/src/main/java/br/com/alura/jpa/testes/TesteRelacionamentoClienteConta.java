package br.com.alura.jpa.testes;

import br.com.alura.jpa.modelo.Cliente;
import br.com.alura.jpa.modelo.Conta;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TesteRelacionamentoClienteConta {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
        EntityManager em = emf.createEntityManager();

        Conta conta = new Conta();
        conta.setId(3L);

        Cliente cliente = new Cliente();
        cliente.setNome("Murilo");
        cliente.setEndereco("Rua de Terra, 1");
        cliente.setProfissao("Teacher");
        cliente.setConta(conta);

        em.getTransaction().begin();

        em.persist(cliente);
        em.getTransaction().commit();
        em.close();

    }

}

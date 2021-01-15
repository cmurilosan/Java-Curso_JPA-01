package br.com.alura.jpa.testes;

import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;

import javax.persistence.*;
import java.util.List;

public class TesteJPQL {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
        EntityManager em = emf.createEntityManager();

        String jpql = "select m from Movimentacao m where m.conta = :pConta";

        Conta conta = new Conta();
        conta.setId(1L);
        TypedQuery<Movimentacao> query = em.createQuery(jpql, Movimentacao.class);
        query.setParameter("pConta", conta);

        List<Movimentacao> resultList = query.getResultList();

        for (Movimentacao movimentacao :
                resultList) {
            System.out.println("Descrição: " + movimentacao.getDescricao());
            System.out.println("Tipo: " + movimentacao.getTipoMovimentacao());
        }
    }
}

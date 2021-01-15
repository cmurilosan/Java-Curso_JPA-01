package br.com.alura.jpa.testes;

import br.com.alura.jpa.modelo.Categoria;
import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class TesteJPQLMovimentacaoDeUmaCategoria {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
        EntityManager em = emf.createEntityManager();

        String jpql = "select m from Movimentacao m join m.categoria c where c = :pCategoria";

        Categoria categoria = new Categoria();
        categoria.setId(1L);
        TypedQuery<Movimentacao> query = em.createQuery(jpql, Movimentacao.class);
        query.setParameter("pCategoria", categoria);

        List<Movimentacao> movimentacoes = query.getResultList();

        for (Movimentacao movimentacao :
                movimentacoes) {
            System.out.println("Categorias: " + movimentacao.getCategoria());
            System.out.println("Descrição: " + movimentacao.getDescricao());
            System.out.println("Valor: " + movimentacao.getValor());
            System.out.println("Tipo: " + movimentacao.getTipoMovimentacao());
        }
    }
}

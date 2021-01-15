package br.com.alura.jpa.testes;

import br.com.alura.jpa.modelo.Conta;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TesteSQL {

    public static void main(String[] args) throws SQLException {

        Connection cnt = DriverManager.getConnection(
                "jdbc:mysql://localhost/alura_jpa?useTimezone=true&serverTimezone=UTC",
                "root", "groove10");
        String sql = "select * from Conta";

        PreparedStatement ps = cnt.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        List<Conta> contas = new ArrayList<>();
        while (rs.next()) {
            Conta conta = new Conta();
            conta.setTitular(rs.getString("titular"));
            conta.setAgencia(rs.getInt("agencia"));
            conta.setNumero(rs.getInt("numero"));
            conta.setSaldo(rs.getDouble("saldo"));

            contas.add(conta);
        }

        for (Conta conta :
                contas) {
            System.out.println("Titular: " + conta.getTitular());
            System.out.println("Agencia " + conta.getAgencia());
            System.out.println("Numero " + conta.getNumero());
            System.out.println("Saldo " + conta.getSaldo());
            System.out.println("=================================");
            System.out.println("=================================");
        }
    }
}

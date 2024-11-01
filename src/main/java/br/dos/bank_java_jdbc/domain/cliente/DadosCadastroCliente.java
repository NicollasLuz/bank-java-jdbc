package br.dos.bank_java_jdbc.domain.cliente;

import java.time.LocalDate;

public class DadosCadastroCliente {
    public String nome;
    public String cpf;
    public String email;

    public DadosCadastroCliente(String nome, String cpf, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }
}

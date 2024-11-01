package br.dos.bank_java_jdbc.domain.cliente;

import java.time.LocalDate;
import java.util.Objects;

public class Cliente {

    private String nome;
    private String cpf;
    private String email;

    public Cliente(DadosCadastroCliente dados) {
        this.nome = dados.nome;
        this.cpf = dados.cpf;
        this.email = dados.email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return this.cpf.equals(cliente.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.cpf);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + this.nome + '\'' +
                ", cpf='" + this.cpf + '\'' +
                ", email='" + this.email + '\'' +
                '}';
    }

    public String getNome() {
        return this.nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public String getEmail() {
        return this.email;
    }

}


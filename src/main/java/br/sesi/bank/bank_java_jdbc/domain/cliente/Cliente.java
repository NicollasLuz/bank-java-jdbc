package br.sesi.bank.bank_java_jdbc.domain.cliente;

public class Cliente {
    String nome, email, cpf;

    public Cliente(DadosCadastroCliente dados){

    }

    public String getNome(){

        return nome;
    }

    public String getCpf(){

        return cpf;
    }

    public String getEmail(){

        return email;
    }

    @Override
    public boolean equals(Object obj) {

        return super.equals(obj);
    }

    @Override
    public int hashCode() {

        return super.hashCode();
    }
}

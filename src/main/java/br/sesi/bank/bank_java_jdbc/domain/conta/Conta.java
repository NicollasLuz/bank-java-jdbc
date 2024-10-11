package br.sesi.bank.bank_java_jdbc.domain.conta;

import br.sesi.bank.bank_java_jdbc.domain.cliente.Cliente;

import java.math.BigDecimal;

public class Conta {
    Integer numero;
    BigDecimal valor;
    Cliente titular;
    BigDecimal zero;

    Conta(Integer numero, BigDecimal valor, Cliente titular) {
        this.numero = numero;
        this.valor = valor;
        this.titular = titular;
    }

    public boolean possuiSaldo(BigDecimal valor){
        return !(valor.compareTo(BigDecimal.ZERO) <= 0.0);
    }

    public void sacar(BigDecimal valor){

    }

    public void depositar(BigDecimal valor){

    }

    public Integer getNumero(){
        return numero;
    }

    public Cliente getTitular() {
        return titular;
    }

    public BigDecimal getSaldo(){
        return valor;
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

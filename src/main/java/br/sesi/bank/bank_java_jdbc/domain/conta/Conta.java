package br.sesi.bank.bank_java_jdbc.domain.conta;

import br.sesi.bank.bank_java_jdbc.domain.cliente.Cliente;

import java.math.BigDecimal;
import java.util.Objects;

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
        return this.valor.compareTo(BigDecimal.ZERO) > 0;

    }

    public void sacar(BigDecimal valor){
        this.valor = this.valor.subtract(valor);
    }

    public void depositar(BigDecimal valor){
        this.valor = this.valor.add(valor);
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conta conta = (Conta) o;
        return numero.equals(conta.numero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero);
    }

    @Override
    public String toString() {
        return "Conta[" +
                "numero=" + numero +
                ", saldo=" + valor +
                ", titular=" + titular +
                ']';
    }


}

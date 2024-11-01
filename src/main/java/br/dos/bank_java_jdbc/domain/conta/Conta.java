package br.dos.bank_java_jdbc.domain.conta;

import br.dos.bank_java_jdbc.domain.cliente.Cliente;

import java.math.BigDecimal;
import java.util.Objects;

public class Conta {

    private Integer numero;
    private BigDecimal saldo;
    private Cliente titular;

    public Conta(Integer numero, BigDecimal saldo, Cliente titular) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = BigDecimal.ZERO;
    }

    public boolean possuiSaldo() {
        return this.saldo.compareTo(BigDecimal.ZERO) != 0;
    }

    public void sacar(BigDecimal valor) {
        this.saldo = this.saldo.subtract(valor);
    }

    public void depositar(BigDecimal valor) {
        this.saldo = this.saldo.add(valor);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conta conta = (Conta) o;
        return this.numero.equals(conta.numero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.numero);
    }

    @Override
    public String toString() {
        return "Conta{" +
                "numero='" + this.numero + '\'' +
                ", saldo=" + this.saldo +
                ", titular=" + this.titular +
                '}';
    }

    public Integer getNumero() {
        return this.numero;
    }

    public BigDecimal getSaldo() {
        return this.saldo;
    }

    public Cliente getTitular() {
        return this.titular;
    }
}


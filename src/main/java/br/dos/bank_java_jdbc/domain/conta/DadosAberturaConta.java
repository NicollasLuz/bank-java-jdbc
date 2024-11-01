package br.dos.bank_java_jdbc.domain.conta;

import br.dos.bank_java_jdbc.domain.cliente.DadosCadastroCliente;

public class DadosAberturaConta {
    public Integer numero;
    public DadosCadastroCliente dadosCliente;

    public DadosAberturaConta(Integer numero, DadosCadastroCliente dadosCliente) {
        this.numero = numero;
        this.dadosCliente = dadosCliente;
    }
}


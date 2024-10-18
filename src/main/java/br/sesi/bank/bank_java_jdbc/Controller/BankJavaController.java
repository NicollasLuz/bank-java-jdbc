package br.sesi.bank.bank_java_jdbc.controller;

import br.sesi.bank.bank_java_jdbc.domain.cliente.DadosCadastroCliente;
import br.sesi.bank.bank_java_jdbc.domain.conta.DadosAberturaConta;
import br.sesi.bank.bank_java_jdbc.exceptions.RegraDeNegocioException;
import br.sesi.bank.bank_java_jdbc.service.ContaService;

import java.sql.SQLException;
import java.util.Scanner;

public class BankJavaController {
    public ContaService service;
    public Scanner teclado;

    public BankJavaController() {
        this.service = new ContaService();
        this.teclado = new Scanner(System.in).useDelimiter("\n");
    }

    public static void main(String[] args) throws SQLException {
        BankJavaController controller = new BankJavaController();
        controller.start();
    }

    public void start() throws SQLException {
        Scanner teclado = new Scanner(System.in).useDelimiter("\n");

        var opcao = exibirMenu();
        while (opcao != 8) {
            try {
                switch (opcao) {
                    case 1:
                        listarContas();
                        break;
                    case 2:
                        abrirConta();
                        break;
                    case 3:
                        encerrarConta();
                        break;
                    case 4:
                        consultarSaldo();
                    case 5:
                        realizarSaque();
                        break;
                    case 6:
                        realizarDeposito();
                        break;
//                    case 7:
//                        realizarTranseferencia();
//                        break;
                }
            } catch (RegraDeNegocioException e) {
                System.out.println("Erro" + e.getMessage());
                System.out.println("Pressione qualquer tecla e dê ENTER para voltar ao menu principal.");
                teclado.next();
            }
            opcao = exibirMenu();
        }
        System.out.println("Finalizando a aplicação.");
    }

    private int exibirMenu() {
        System.out.println("""
                BYTEBANK - ESCOLHA UMA OPÇÃO
                1 - Listar contas abertas
                2 - Abertura de conta
                3 - Encerrramento de conta
                4 - Consultar saldo em uma conta
                5 - Realizar saque em uma conta
                6 - Realizar depósito em uma conta
                7 - Realizar uma transferência
                8 - Sair
                """);
        return teclado.nextInt();
    }

    public void listarContas() {
        System.out.println("Contas cadastradas: ");
        var contas = service.listarContasAbertas();
        contas.stream().forEach(System.out::println);

        System.out.println("Pressione qualquer tecla e dê ENTER para voltar ao menu principal.");
        teclado.next();
    }

    public void abrirConta() {
        System.out.println("Digite o número da sua conta: ");
        var numeroDaConta = teclado.nextInt();

        System.out.println("Digite o nome do cliente: ");
        var nome = teclado.next();

        System.out.println("Digite o cpf do cliente: ");
        var cpf = teclado.next();

        System.out.println("Digite o email do cliente: ");
        var email = teclado.next();

        service.abrir(new DadosAberturaConta(numeroDaConta, new DadosCadastroCliente(nome, cpf, email)));

        System.out.println("Conta aberta com sucesso!");
        System.out.println("Pressione qualquer tecla e dê ENTER para voltar ao menu principal.");
        teclado.next();
    }

    public void encerrarConta() {
        System.out.println("Digite o número da conta: ");
        var numeroDaConta = teclado.nextInt();

        service.encerrar(numeroDaConta);

        System.out.println("Conta encerradda com sucesso!");
        System.out.println("Pressione qualquer tecla e dê ENTER para voltar ao menu principal.");
        teclado.next();
    }

    public void consultarSaldo() {
        System.out.println("Digite o número da conta:");
        var numeroDaConta = teclado.nextInt();
        var saldo = service.consultarSaldo(numeroDaConta);
        System.out.println("Saldo da conta: " +saldo);

        System.out.println(("Pressione qualquer tecla e dê ENTER para voltar ao menu principal."));
        teclado.next();
    }

    public void realizarSaque() {
        System.out.println("Digite o número da conta: ");
        var numeroDaConta = teclado.nextInt();

        System.out.println("Digite o valoer do saque: ");
        var valor = teclado.nextBigDecimal();

        service.realizarSaque(numeroDaConta, valor);
        System.out.println("Saque realizado!");
        System.out.println(("Pressione qualquer tecla e dê ENTER para voltar ao menu principal."));
        teclado.next();
    }

    public void realizarDeposito() {
        System.out.println("Digite o número da conta");
        var numeroDaConta = teclado.nextInt();

        System.out.println("Digite o valor do depósito: ");
        var valor = teclado.nextBigDecimal();

        service.realizarDeposito(numeroDaConta, valor);

        System.out.println("Depósito realizado com sucesso!");
        System.out.println(("Pressione qualquer tecla e dê ENTER para voltar ao menu principal."));
        teclado.next();
    }

    /*public void realizarTranseferencia() {
        System.out.println("Digite o número da conta de ORIGEM: ");
        int numeroContaOrigem = teclado.nextInt();
        System.out.println("Digite o número da conta de DESTINO: ");
        int numeroContaDestino = teclado.nextInt();
        System.out.println("Informe o valor a ser transferido: ");
        BigDecimal valor = teclado.nextBigDecimal();

        this.service.realizaTransferencia(numeroContaOrigem, numeroContaDestino, valor);
        System.out.println("Transferência realizada com sucesso!");
        System.out.println(("Pressione qualquer tecla e dê ENTER para voltar ao menu principal."));
        teclado.next();
    }*/

}
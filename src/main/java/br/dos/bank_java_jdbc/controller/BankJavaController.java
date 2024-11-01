package br.dos.bank_java_jdbc.controller;

import br.dos.bank_java_jdbc.domain.cliente.DadosCadastroCliente;
import br.dos.bank_java_jdbc.domain.conta.Conta;
import br.dos.bank_java_jdbc.domain.conta.DadosAberturaConta;
import br.dos.bank_java_jdbc.exceptions.RegraDeNegocioException;
import br.dos.bank_java_jdbc.service.ContaService;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.Set;

public class BankJavaController {
    private ContaService service;
    private Scanner teclado;

    public BankJavaController() {
        this.service = new ContaService();
        this.teclado = new Scanner(System.in).useDelimiter("\n");
    }
    public static void main(String[] args) throws SQLException {
        BankJavaController controller = new BankJavaController();
        controller.start();
    }
    public void start() throws SQLException {
        var opcao = exibirMenu();
        while (opcao != 7) {
            try {
                switch (opcao) {
                    case 1:
                        this.listarContas();
                        break;
                    case 2:
                        this.abrirConta();
                        break;
                    case 3:
                        this.encerrarConta();
                        break;
                    case 4:
                        this.consultarSaldo();
                        break;
                    case 5:
                        this.realizarSaque();
                        break;
                    case 6:
                        this.realizarDeposito();
                        break;
                }
            } catch (RegraDeNegocioException e) {
                System.out.println("Erro: " +e.getMessage());
                System.out.println("Pressione qualquer tecla e de ENTER para voltar ao menu");
                this.teclado.next();
            }
            opcao = exibirMenu();
        }

        System.out.println("Finalizando a aplicação.");
    }
    private int exibirMenu() {
        System.out.println("""
                BYTEBANK - ESCOLHA UMA OPÇÃO:
                1 - Listar contas abertas
                2 - Abertura de conta
                3 - Encerramento de conta
                4 - Consultar saldo de uma conta
                5 - Realizar saque em uma conta
                6 - Realizar depósito em uma conta
                7 - Sair
                """);
        return this.teclado.nextInt();
    }

    private void listarContas() {
        System.out.println("Contas cadastradas:");
        Set<Conta> contas = this.service.listarContasAbertas();
        contas.stream().forEach(System.out::println);

        System.out.println("Pressione qualquer tecla e de ENTER para voltar ao menu principal");
        this.teclado.next();
    }

    private void abrirConta() {
        System.out.println("Digite o número da conta:");
        int numeroDaConta = this.teclado.nextInt();

        System.out.println("Digite o nome do cliente:");
        String nome = this.teclado.next();

        System.out.println("Digite o cpf do cliente:");
        String cpf = this.teclado.next();

        System.out.println("Digite o email do cliente:");
        String email = this.teclado.next();

        this.service.abrir(new DadosAberturaConta(numeroDaConta, new DadosCadastroCliente(nome, cpf, email)));

        System.out.println("Conta aberta com sucesso!");
        System.out.println("Pressione qualquer tecla e de ENTER para voltar ao menu principal");
        this.teclado.next();
    }

    private void encerrarConta() {
        System.out.println("Digite o número da conta:");
        var numeroDaConta = this.teclado.nextInt();

        this.service.encerrar(numeroDaConta);

        System.out.println("Conta encerrada com sucesso!");
        System.out.println("Pressione qualquer tecla e de ENTER para voltar ao menu principal");
        this.teclado.next();
    }

    private void consultarSaldo() {
        System.out.println("Digite o número da conta:");
        int numeroDaConta = this.teclado.nextInt();
        BigDecimal saldo = this.service.consultarSaldo(numeroDaConta);
        System.out.println("Saldo da conta: " +saldo);

        System.out.println("Pressione qualquer tecla e de ENTER para voltar ao menu principal");
        this.teclado.next();
    }

    private void realizarSaque() {
        System.out.println("Digite o número da conta:");
        int numeroDaConta = this.teclado.nextInt();

        System.out.println("Digite o valor do saque:");
        BigDecimal valor = this.teclado.nextBigDecimal();

        this.service.realizarSaque(numeroDaConta, valor);
        System.out.println("Saque realizado com sucesso!");
        System.out.println("Pressione qualquer tecla e de ENTER para voltar ao menu principal");
        this.teclado.next();
    }

    private void realizarDeposito() {
        System.out.println("Digite o número da conta:");
        int numeroDaConta = this.teclado.nextInt();

        System.out.println("Digite o valor do depósito:");
        BigDecimal valor = this.teclado.nextBigDecimal();

        this.service.realizarDeposito(numeroDaConta, valor);

        System.out.println("Depósito realizado com sucesso!");
        System.out.println("Pressione qualquer tecla e de ENTER para voltar ao menu principal");
        this.teclado.next();
    }

    private void realizarTransferencia(){
        System.out.println("Digite o número da conta de origem:");
        int numeroContaOrigem = teclado.nextInt();
        System.out.println("Digite o número da conta de Destino:");
        int numeroContaDestino = teclado.nextInt();
        System.out.println("Informe o valor a ser transferido:");
        BigDecimal valor = teclado.nextBigDecimal();


    }
}
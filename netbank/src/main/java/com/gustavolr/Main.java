package com.gustavolr;

import com.gustavolr.banco.Banco;
import com.gustavolr.cliente.Cliente;
import com.gustavolr.conta.Conta;
import com.gustavolr.conta.ContaCorrente;
import com.gustavolr.conta.ContaPoupanca;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Banco banco = Banco.getInstance();

        Cliente daniel = new Cliente("Daniel", "1392231213", (byte) 15);
        Cliente joao = new Cliente("Joao", "53911255213", (byte) 15);

        Conta cc = new ContaCorrente(daniel, 4.0);
        Conta poupanca = new ContaPoupanca(joao, 3.0);

        banco.registrarConta(cc);
        banco.registrarConta(poupanca);

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("=== Menu do Banco ===");
            System.out.println("1. Visualizar contas");
            System.out.println("2. Realizar transferência");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println(banco.listarUsuarios());
                    break;
                case 2:
                    System.out.print("Informe o valor a ser transferido de CC para Poupança: ");
                    double valor = scanner.nextDouble();
                    scanner.nextLine();

                    banco.fazerTransferencia(cc, poupanca, valor);
                    System.out.println("Transferência realizada com sucesso!");
                    break;
                case 3:
                    exit = true;
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();
    }
}
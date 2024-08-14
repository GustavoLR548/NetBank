package com.gustavolr;

import com.gustavolr.banco.Banco;
import com.gustavolr.cliente.Cliente;
import com.gustavolr.conta.Conta;
import com.gustavolr.conta.ContaCorrente;
import com.gustavolr.conta.ContaPoupanca;

public class Main {
    public static void main(String[] args) {

        var banco = new Banco();

		Cliente daniel = new Cliente("Daniel","1392231213",(byte)15);
		Cliente joao = new Cliente("Joao","53911255213",(byte)15);
		
		Conta cc = new ContaCorrente(123,3,50.0,daniel,4.0);
		Conta poupanca = new ContaPoupanca(123,3,50.0, joao, 3.0);

        banco.registrarConta(cc);
        banco.registrarConta(poupanca);

        banco.fazerTransferencia(cc, poupanca, 33);
		
		System.out.println(cc);
		System.out.println(poupanca);

        System.out.println(banco);
    }
}
package com.gustavolr.conta;

import com.gustavolr.cliente.Cliente;
import com.gustavolr.factory.CredencialFactory;

import lombok.Data;

@Data
public class Conta {
    
    private static final double SALDO_INICIAL = 1000;

    protected double saldo;
    protected Credenciais credenciais;
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        credenciais = CredencialFactory.generateRandom();
        this.cliente = cliente;
        this.saldo = SALDO_INICIAL;
    }

    public boolean ehPossivelSacar(double valor) {
        return valor > 0 && saldo >= valor;
    }

    public boolean sacar(double valor) {
        if (ehPossivelSacar(valor)) {
            saldo -= valor;
            return true;
        } else {
            return false;
        }
    }

    public void depositar(double valor) {
        saldo += valor;
    }
}

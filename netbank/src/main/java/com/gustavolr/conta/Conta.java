package com.gustavolr.conta;

import com.gustavolr.cliente.Cliente;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Conta {
    
    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    public boolean ehPossivelSacar(double valor) {
        if (valor > 0 && saldo >= valor) {
            return true;
        } else {
            return false;
        }        
    }

    public boolean sacar(double valor) {
        if (valor > 0 && saldo >= valor) {
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

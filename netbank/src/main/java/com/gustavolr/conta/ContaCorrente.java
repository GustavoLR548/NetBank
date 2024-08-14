package com.gustavolr.conta;

import com.gustavolr.cliente.Cliente;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ContaCorrente extends Conta{
    private double limiteChequeEspecial;

    public ContaCorrente(int agencia, int numero, double saldo, Cliente cliente, double limiteChequeEspecial) {
        super(agencia,numero,saldo,cliente);
        this.limiteChequeEspecial = limiteChequeEspecial;
    }

    @Override
    public boolean ehPossivelSacar(double valor) {
        if (valor > 0 && saldo + limiteChequeEspecial >= valor) {
            saldo -= valor;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean sacar(double valor) {
        if (valor > 0 && saldo + limiteChequeEspecial >= valor) {
            saldo -= valor;
            return true;
        } else {
            System.out.println("Saldo insuficiente, mesmo com cheque especial.");
            return false;
        }
    }

    @Override
    public String toString() {
        return "ContaCorrente [agencia=" + agencia + ", limiteChequeEspecial=" + limiteChequeEspecial + ", numero="
                + numero + ", saldo=" + saldo + ", cliente=" + cliente + "]";
    }
}

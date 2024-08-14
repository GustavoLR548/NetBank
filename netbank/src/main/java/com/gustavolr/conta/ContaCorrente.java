package com.gustavolr.conta;

import com.gustavolr.cliente.Cliente;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ContaCorrente extends Conta{
    private double limiteChequeEspecial;

    public ContaCorrente(Cliente cliente, 
                         double limiteChequeEspecial) {

        super(cliente);
        this.limiteChequeEspecial = limiteChequeEspecial;
    }

    @Override
    public boolean ehPossivelSacar(double valor) {
        return valor > 0 && saldo + limiteChequeEspecial >= valor;
    }

    @Override
    public boolean sacar(double valor) {
        if (ehPossivelSacar(valor)) {
            saldo -= valor;
            return true;
        } else {
            System.out.println("Saldo insuficiente, mesmo com cheque especial.");
            return false;
        }
    }

    @Override
    public String toString() {
        return "ContaCorrente [saldo=" + saldo + ", limiteChequeEspecial=" + limiteChequeEspecial + ", credenciais="
                + credenciais + ", cliente=" + cliente + "]";
    }
}

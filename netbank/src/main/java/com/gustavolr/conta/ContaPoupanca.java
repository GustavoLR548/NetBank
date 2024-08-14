package com.gustavolr.conta;

import com.gustavolr.cliente.Cliente;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@RequiredArgsConstructor
public class ContaPoupanca extends Conta {
    
    double taxaRendimento;

    public ContaPoupanca(int agencia, int numero, double saldo, Cliente cliente, double taxaRendimento) {
        super(agencia,numero,saldo,cliente);
        this.taxaRendimento = taxaRendimento;
    }

    public void atualizarSaldo() {
        saldo += saldo * taxaRendimento;
    }

    @Override
    public String toString() {
        return "ContaPoupanca [agencia=" + agencia + ", numero=" + numero + ", saldo=" + saldo + ", cliente=" + cliente
                + ", taxaRendimento=" + taxaRendimento + "]";
    }
}

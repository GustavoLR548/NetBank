package com.gustavolr.conta;

import com.gustavolr.cliente.Cliente;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ContaPoupanca extends Conta {
    
    double taxaRendimento;

    public ContaPoupanca(Cliente cliente, 
                         double taxaRendimento) {

        super(cliente);
        this.taxaRendimento = taxaRendimento;
    }

    public void atualizarSaldo() {
        saldo += saldo * taxaRendimento;
    }

    @Override
    public String toString() {
        return "ContaPoupanca [saldo=" + saldo + ", credenciais=" + credenciais + ", cliente=" + cliente
                + ", taxaRendimento=" + taxaRendimento + "]";
    }
}

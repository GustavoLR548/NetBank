package com.gustavolr.banco;

import java.util.ArrayList;
import java.util.List;

import com.gustavolr.conta.Conta;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@EqualsAndHashCode
@Getter
@ToString
public class Banco {
    
    final String name = "NextBank";
    final List<Conta> contas = new ArrayList<>();

    public boolean registrarConta(Conta c) {
        return contas.add(c);
    }

    public boolean removerConta(Conta c) {
        return contas.remove(c);
    }

    public String listarUsuarios() {
        return contas.toString();
    }

    public boolean fazerTransferencia(Conta remetente, Conta destino, double valor) {

        if (!contas.contains(remetente) || !contas.contains(destino) ) {
            return false;
        }

        if (!remetente.ehPossivelSacar(valor)) {
            return false;
        } 

        remetente.sacar(valor);
        destino.depositar(valor);

        return true;
    }
}

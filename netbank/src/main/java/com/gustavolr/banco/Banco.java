package com.gustavolr.banco;

import java.util.ArrayList;
import java.util.List;

import com.gustavolr.conta.Conta;
import com.gustavolr.conta.Credenciais;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@EqualsAndHashCode
@Getter
@ToString
public class Banco {
    
    private static Banco instance;

    final String name;
    final List<Conta> contas;

    public static Banco getInstance() {
        if (instance == null) 
            instance = new Banco();

        return instance;
    }

    Banco() {
        contas = new ArrayList<>();
        name = "NextBank";
    }


    public boolean registrarConta(Conta c) {
        return contas.add(c);
    }

    public boolean removerConta(Conta c) {
        return contas.remove(c);
    }

    public String listarUsuarios() {
        return contas.toString();
    }

    public Conta encontrarUsuario(Credenciais credenciais) {

        Conta encontrada = null;

        for (Conta c : contas) 
            if (c.getCredenciais() == credenciais) 
                encontrada = c;
            

        return encontrada;
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

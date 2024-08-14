package com.gustavolr.recibo;

import com.gustavolr.conta.Conta;

import lombok.Value;

@Value
public class ReciboTransferencia {
    
    Conta remetente;
    Conta destino;
    double valor;

    @Override
    public String toString() {
        return "===== Recibo de transferencia Bancaria =====\n[remetente=" + remetente + ", destino=" + destino + ", valor=" + valor + "]";
    }
    
}

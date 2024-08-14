package com.gustavolr.conta;

import lombok.Value;

@Value
public class Credenciais {

    public static final int TAMANHO_AGENCIA = 4;
    public static final int TAMANHO_NUMERO = 9;
    
    protected String agencia;
    protected String numero;
}

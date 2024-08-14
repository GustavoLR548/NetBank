package com.gustavolr.factory;

import com.gustavolr.conta.Credenciais;
import java.util.Random;

public class CredencialFactory {

    public static Credenciais generateRandom() {
        Random random = new Random();

        StringBuilder agenciaBuilder = new StringBuilder();
        for (int i = 0; i < Credenciais.TAMANHO_AGENCIA; i++) 
            agenciaBuilder.append(random.nextInt(10));  
        
        String agencia = agenciaBuilder.toString();

        StringBuilder numeroBuilder = new StringBuilder();

        for (int i = 0; i < Credenciais.TAMANHO_NUMERO; i++) 
            numeroBuilder.append(random.nextInt(10));
        
        String numero = numeroBuilder.toString();

        return new Credenciais(agencia, numero);
    }    
}

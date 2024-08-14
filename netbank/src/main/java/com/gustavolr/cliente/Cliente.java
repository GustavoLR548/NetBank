package com.gustavolr.cliente;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Cliente {
    
    String nome;
    String cpf;
    byte idade;
}

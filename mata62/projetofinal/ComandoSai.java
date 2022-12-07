package com.mata62.projetofinal;

import com.mata62.projetofinal.Comando;

import java.util.List;

public class ComandoSai implements Comando {

    @Override
    public void execute(List<String> args) {
        System.exit(0);
    }
}

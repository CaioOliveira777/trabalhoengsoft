package com.mata62.projetofinal.ihc.comandos;

import java.util.List;

public class ComandoSai implements Comando {

    @Override
    public void execute(List<String> args) {
        System.exit(0);
    }
}

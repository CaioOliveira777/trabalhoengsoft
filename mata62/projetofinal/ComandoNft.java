package com.mata62.projetofinal;

import java.util.List;

public class ComandoNft implements Comando {
    @Override
    public void execute(List<String> args) {
        Biblioteca biblioteca = Biblioteca.obterInstancia();

        int idUsuario = Integer.parseInt(args.get(1));

        biblioteca.nftObservador(idUsuario);
    }
}

package com.mata62.projetofinal;

import java.util.List;

public class ComandoLiv implements Comando {

    @Override
    public void execute(List<String> args) {
        Biblioteca biblioteca = Biblioteca.obterInstancia();

        int idLivro = Integer.parseInt(args.get(1));
        
        biblioteca.exibirDadosLivro(idLivro);
    }
}

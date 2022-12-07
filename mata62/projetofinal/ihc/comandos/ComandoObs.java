package com.mata62.projetofinal.ihc.comandos;

import com.mata62.projetofinal.biblioteca.Biblioteca;

import java.util.List;

public class ComandoObs implements Comando{

    @Override
    public void execute(List<String> args) {
        Biblioteca biblioteca = Biblioteca.obterInstancia();

        int idUsuario = Integer.parseInt(args.get(1));
        int idLivro = Integer.parseInt(args.get(2));

        biblioteca.addObservador(idUsuario, idLivro);
    }
}

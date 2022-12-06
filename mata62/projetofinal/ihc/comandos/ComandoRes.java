package com.mata62.projetofinal.ihc.comandos;

import java.util.List;
import com.mata62.projetofinal.biblioteca.Biblioteca;

public class ComandoRes implements Comando {

    @Override
    public void execute(List<String> args) {
        Biblioteca biblioteca = Biblioteca.obterInstancia();

        int idUsuario = Integer.parseInt(args.get(1));
        int idLivro = Integer.parseInt(args.get(2));
        
        biblioteca.reservar(idUsuario, idLivro);
    }
}


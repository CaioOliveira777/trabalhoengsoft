package com.mata62.projetofinal;

import java.util.List;

public class ComandoDev implements Comando {

    @Override
    public void execute(List<String> args) {
        Biblioteca biblioteca = Biblioteca.obterInstancia();

        int idUsuario = Integer.parseInt(args.get(1));
        int idLivro = Integer.parseInt(args.get(2));
        
        biblioteca.devolver(idUsuario, idLivro);
    }
    
}
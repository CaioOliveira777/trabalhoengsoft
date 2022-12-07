package com.mata62.projetofinal.observer;

import com.mata62.projetofinal.biblioteca.livros.Livro;

public interface Observer {

    public void update();
    public int totalDeNotificacoes();
}

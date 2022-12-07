package com.mata62.projetofinal.observador;

import com.mata62.projetofinal.biblioteca.livros.Livro;

public interface Notificar {
    public void addObservador(Observador obs);
    public void notificar(Livro livro);
}

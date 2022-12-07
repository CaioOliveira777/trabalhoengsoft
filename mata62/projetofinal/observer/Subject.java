package com.mata62.projetofinal.observer;

import com.mata62.projetofinal.biblioteca.livros.Livro;

public interface Subject {
    public void addObserver(Observer obs);
    public void notifyAll(Livro livro);
}

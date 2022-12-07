package com.mata62.projetofinal;

public interface Notificar {
    public void addObservador(Observador obs);
    public void notificar(Livro livro);
}

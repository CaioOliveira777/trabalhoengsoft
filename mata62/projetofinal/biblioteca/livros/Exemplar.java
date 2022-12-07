package com.mata62.projetofinal.biblioteca.livros;

import com.mata62.projetofinal.biblioteca.controles.Emprestimo;

public class Exemplar {
    private int id;
    private Emprestimo emprestimo;
    private Livro livro;

    public Exemplar(int id, Livro livro) {
        this.id = id;
        this.livro = livro;
    }

    public int getId() {
        return id;
    }

    public Emprestimo getEmprestimo() {
        return emprestimo;
    }

    public void setEmprestimo(Emprestimo emprestimo) {
        this.emprestimo = emprestimo;
    }

    public Livro getLivro() {
        return livro;
    }
}

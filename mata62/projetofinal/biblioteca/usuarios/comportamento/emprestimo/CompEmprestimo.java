package com.mata62.projetofinal.biblioteca.usuarios.comportamento.emprestimo;

import com.mata62.projetofinal.biblioteca.usuarios.Usuario;
import com.mata62.projetofinal.biblioteca.livros.Livro;

public interface CompEmprestimo {
    public boolean podePegar(Usuario usuario, Livro livro);
}

package com.mata62.projetofinal.biblioteca.usuarios.comportamento.emprestimo;

import com.mata62.projetofinal.biblioteca.livros.Livro;
import com.mata62.projetofinal.biblioteca.usuarios.Usuario;

public class EmpProfessor implements CompEmprestimo{

    @Override
    public boolean podePegar(Usuario usuario, Livro livro) {
        if (!usuario.estaDevedor()){
            return true;
        }else {
            System.out.println("NAO FOI POSSIVEL EMPRESTAR O LIVRO: " + livro.getTitulo() + " PARA O: " + usuario.getNome() + " ,POIS USUÁRIO É DEVEDOR");
            return false;
        }
    }
}

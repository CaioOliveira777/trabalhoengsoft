package com.mata62.projetofinal.biblioteca.usuarios.comportamento.emprestimo;

import com.mata62.projetofinal.biblioteca.livros.Livro;
import com.mata62.projetofinal.biblioteca.usuarios.Usuario;

public class EmpAlunoPosGraduacao implements CompEmprestimo{

    @Override
    public boolean podePegar(Usuario usuario, Livro livro) {
        if (!usuario.estaDevedor()){
            if(usuario.getQuantidadeEmprestimosAtivo() < usuario.getLimiteEmprestimos()){
                if(!usuario.emprestimoAtivoPeloLivro(livro)){
                    if(livro.getQuantidadeExemplaresDisponiveis() > livro.getQuantidadeReservas()){
                        return true;
                    }else{
                        if (usuario.emprestimoAtivoPeloLivro(livro)){
                            return true;
                        }else{
                            System.out.println("NAO FOI POSSIVEL EMPRESTAR O LIVRO: " + livro.getTitulo() + " PARA O: " + usuario.getNome() + " ,POIS TODOS OS EXEMPLARES JA ESTAO RESERVADOS");
                            return false;
                        }
                    }
                }else{
                    System.out.println("NAO FOI POSSIVEL EMPRESTAR O LIVRO: " + livro.getTitulo() + " PARA O: " + usuario.getNome() + " ,POIS ELE JA PEGOU UM EXEMPLAR EMPRESTADO");
                    return false;
                }
            }else{
                System.out.println("NAO FOI POSSIVEL EMPRESTAR O LIVRO: " + livro.getTitulo() + " PARA O: " + usuario.getNome() + " ,POIS ELE JA PEGOU MUITOS LIVROS");
                return false;
            }
        }else{
            System.out.println("NAO FOI POSSIVEL EMPRESTAR O LIVRO: " + livro.getTitulo() + " PARA O: " + usuario.getNome() + " ,POIS USUÁRIO É DEVEDOR");
            return false;
        }
    }
}

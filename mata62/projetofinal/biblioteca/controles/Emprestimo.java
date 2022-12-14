package com.mata62.projetofinal.biblioteca.controles;

import java.time.LocalDate;

import com.mata62.projetofinal.biblioteca.livros.Exemplar;
import com.mata62.projetofinal.biblioteca.usuarios.Usuario;


public class Emprestimo {
    Usuario usuario;
    Exemplar exemplar;
    boolean ativo;
    LocalDate dataEmprestimo;
    LocalDate dataDevolucao;


    public Emprestimo(Usuario usuario, Exemplar exemplar){
        this.usuario = usuario;
        this.exemplar = exemplar;
        this.dataEmprestimo = LocalDate.now();
        this.ativo = true;
    }


    public Usuario getUsuario() {
        return usuario;
    }

    public Exemplar getExemplar() {
        return exemplar;
    }

    public boolean estaAtivo() {
        return ativo;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }
    
    public LocalDate dataDevolucaoEsperada(){
        return dataEmprestimo.plusDays(usuario.getLimiteDiasEmprestimo());
    }

    public void devolver() {
        dataDevolucao = LocalDate.now();
        ativo = false;
    }
}

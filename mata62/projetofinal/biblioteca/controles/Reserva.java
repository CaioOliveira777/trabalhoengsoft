package com.mata62.projetofinal.biblioteca.controles;

import com.mata62.projetofinal.biblioteca.usuarios.Usuario;
import com.mata62.projetofinal.biblioteca.livros.Livro;

import java.time.LocalDate;

public class Reserva {
    Usuario usuario;
    Livro livro;
    LocalDate dataFechamento;
    LocalDate dataReserva;

    public Reserva(
        Usuario usuario, Livro livro
    ){
        this.usuario = usuario;
        this.livro = livro;
        this.dataFechamento = null;
        this.dataReserva = LocalDate.now();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Livro getLivro() {
        return livro;
    }

    public LocalDate getDataReserva() {
        return dataReserva;
    }

    public LocalDate getDataFechamento() {
        return dataFechamento;
    }

    public boolean estaAtiva(){
        if (dataFechamento == null){
            return true;
        }
        return false;
    }

    public void cancelarReserva(){
        dataFechamento = LocalDate.now();
    }
}

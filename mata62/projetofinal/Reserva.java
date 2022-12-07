package com.mata62.projetofinal;

import com.mata62.projetofinal.Usuario;
import com.mata62.projetofinal.Livro;

import java.time.LocalDate;

public class Reserva {
    private Usuario usuario;
    private Livro livro;
    private LocalDate dataFechamento;
    private LocalDate dataReserva;

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

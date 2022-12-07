package com.mata62.projetofinal.biblioteca.usuarios;

import java.util.ArrayList;

import com.mata62.projetofinal.biblioteca.usuarios.comportamento.emprestimo.EmpProfessor;
import com.mata62.projetofinal.biblioteca.controles.Emprestimo;
import com.mata62.projetofinal.biblioteca.controles.Reserva;
import com.mata62.projetofinal.observador.Observador;

public class Professor extends Usuario implements Observador {
    private int contador;
    public Professor(int id, String nome){
        this.comportamentoEmprestimo = new EmpProfessor();
        this.id = id;
        this.nome = nome;
        this.emprestimos = new ArrayList<Emprestimo>();
        this.reservas = new ArrayList<Reserva>();
        this.limiteDiasEmprestimo = 7;
        this.limiteReservas = 3;
        this.contador =0;
    }

    @Override
    public void atualizar() {
        contador++;
        System.out.println("VOCE ESTA SENDO NOTIFICADO(A) DE UMA NOVA RESERVA");
    }

    @Override
    public int totalDeNotificacoes() {
        return contador;
    }
}

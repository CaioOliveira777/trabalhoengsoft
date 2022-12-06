package com.mata62.projetofinal.biblioteca.usuarios;

import java.util.ArrayList;
import com.mata62.projetofinal.biblioteca.usuarios.comportamento.emprestimo.EmpProfessor;
import com.mata62.projetofinal.biblioteca.controles.Emprestimo;
import com.mata62.projetofinal.biblioteca.controles.Reserva;

public class Professor extends Usuario{
    public Professor(int id, String nome){
        this.comportamentoEmprestimo = new EmpProfessor();
        this.id = id;
        this.nome = nome;
        this.emprestimos = new ArrayList<Emprestimo>();
        this.reservas = new ArrayList<Reserva>();

        this.limiteDiasEmprestimo = 7;
        this.limiteReservas = 3;
    }
}

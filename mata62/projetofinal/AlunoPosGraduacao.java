package com.mata62.projetofinal;

import java.util.ArrayList;

public class AlunoPosGraduacao extends Usuario {
    public AlunoPosGraduacao(int id, String nome){
        this.comportamentoEmprestimo = new EmpAlunoPosGraduacao();
        this.id = id;
        this.nome = nome;
        this.emprestimos = new ArrayList<Emprestimo>();
        this.reservas = new ArrayList<Reserva>();
        this.limiteDiasEmprestimo = 4;
        this.limiteEmprestimos = 4;
        this.limiteReservas = 3;
    }
}

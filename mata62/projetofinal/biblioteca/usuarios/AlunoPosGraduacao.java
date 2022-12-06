package com.mata62.projetofinal.biblioteca.usuarios;

import java.util.ArrayList;
import com.mata62.projetofinal.biblioteca.usuarios.comportamento.emprestimo.EmpAlunoPosGraduacao;
import com.mata62.projetofinal.biblioteca.controles.Emprestimo;
import com.mata62.projetofinal.biblioteca.controles.Reserva;

public class AlunoPosGraduacao extends Usuario{
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

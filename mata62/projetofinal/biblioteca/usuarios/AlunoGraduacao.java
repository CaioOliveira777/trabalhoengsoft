package com.mata62.projetofinal.biblioteca.usuarios;

import java.util.ArrayList;
import com.mata62.projetofinal.biblioteca.usuarios.comportamento.emprestimo.EmpAlunoGraduacao;
import com.mata62.projetofinal.biblioteca.controles.Emprestimo;
import com.mata62.projetofinal.biblioteca.controles.Reserva;

public class AlunoGraduacao extends Usuario{
    public AlunoGraduacao(int id, String nome){
        this.comportamentoEmprestimo = new EmpAlunoGraduacao();
        this.id = id;
        this.nome = nome;
        this.emprestimos = new ArrayList<Emprestimo>();
        this.reservas = new ArrayList<Reserva>();
        this.limiteDiasEmprestimo = 3;
        this.limiteEmprestimos = 3;
        this.limiteReservas = 3;
    }
}

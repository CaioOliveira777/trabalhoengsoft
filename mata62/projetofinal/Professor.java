package com.mata62.projetofinal;

import java.util.ArrayList;

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

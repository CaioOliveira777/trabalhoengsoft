package com.mata62.projetofinal;

import java.time.LocalDate;
import java.util.List;

public abstract class Usuario {
    protected CompEmprestimo comportamentoEmprestimo;

    protected int id;
    String nome;

    protected int limiteDiasEmprestimo;
    protected int limiteReservas;
    protected int limiteEmprestimos;

    protected List<Emprestimo> emprestimos;
    protected List<Reserva> reservas;


    public int getLimiteEmprestimos() {
        return limiteEmprestimos;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getLimiteDiasEmprestimo() {
        return limiteDiasEmprestimo;
    }

    public int getQuantidadeReservas(){
        return reservas.size();
    }

    public boolean podePegarEmprestado(Livro livro) {
		return this.comportamentoEmprestimo.podePegar(this, livro);
	}

    public boolean podeReservar() {
		if(getQuantidadeReservas() < limiteReservas){
            return true;
        }
        System.out.println("RESERVA NAO REALIZADA. O USUARIO: " + getNome() + " JA ATINGIU O LIMITE DE :" + getQuantidadeReservas() + " RESERVAS.");
        return false;
	}

    public void adicionarEmprestimo(Emprestimo emprestimo) {
        emprestimos.add(emprestimo);
    }

    public void adicionarReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public boolean estaDevedor(){
        for (Emprestimo emprestimo: emprestimos) {
            if (!emprestimo.estaAtivo()) {
                if (LocalDate.now().isAfter(emprestimo.dataDevolucaoEsperada())){
                    return true;
                }
            }
        }
        return false;
    }

    public Reserva getReservaAtivaPeloLivro(Livro livro) {
        for (Reserva reserva : reservas) {
            if ((reserva.estaAtiva()) && (reserva.getLivro() == livro)){
                return reserva;
            }
        }
        return null;
    }

    public int getQuantidadeEmprestimosAtivo() {
        int contadorEmprestimosAtivos = 0;
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.estaAtivo()) {
                contadorEmprestimosAtivos ++;
            }
        }
        return contadorEmprestimosAtivos;
    }

    public boolean emprestimoAtivoPeloLivro(Livro livro) {
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.estaAtivo()){
                if (emprestimo.getExemplar().getLivro() == livro){
                    return true;
                }
            }
        }
        return false;
    }

    public Emprestimo emprestimoPeloLivro(Livro livro) {
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.estaAtivo()){
                if (emprestimo.getExemplar().getLivro() == livro){
                    return emprestimo;
                }
            }
        }
        return null;
    }

    public void exibirDadosUsuario() {
        int quantidadeEmprestimos = emprestimos.size();
        int quantidadeReservas = reservas.size();

        System.out.println("NOME: " + nome);
        System.out.println("EMPRESTIMOS: " + quantidadeEmprestimos);
        
        for (Emprestimo emprestimo : emprestimos) {
            String titulo = emprestimo.getExemplar().getLivro().getTitulo();
            String dataEmprestimo = emprestimo.getDataEmprestimo().toString();
            boolean estado = emprestimo.estaAtivo();

            LocalDate dataDevolucao = emprestimo.getDataDevolucao();
            LocalDate dataDevolucaoEsperada = emprestimo.dataDevolucaoEsperada();

            String estadoTxt;
            String devolucaoTxt;
            if (estado) {
                estadoTxt = "ABERTO";
            }else{
                estadoTxt = "FECHADO";
            }

            if (dataDevolucao != null) {
                devolucaoTxt = " - DATA DEVOLUCAO: " + dataDevolucao.toString();
            } else
                devolucaoTxt =  " - DATA ESPERADA DEVOLUCAO: " + dataDevolucaoEsperada.toString();

            System.out.println("TITULO: " + titulo + " - ESTADO: " + estadoTxt + " - DATA EMPRESTIMO: "+ dataEmprestimo + devolucaoTxt);
        }
        
        System.out.println("RESERVAS: " + quantidadeReservas);
        if (quantidadeReservas > 0) {
            for (Reserva reserva : reservas) {
                String titulo = reserva.getLivro().getTitulo();
                String dataReserva = reserva.getDataReserva().toString();
                LocalDate dataFechamento = reserva.getDataFechamento();
                String dataFechamentoTxt = "";

                if (dataFechamento != null){
                    dataFechamentoTxt = dataFechamento.toString();
                }
                System.out.println("TÍTULO: " + titulo + " - DATA SOLICITAÇÃO: "+ dataReserva + " - DATA FECHAMENTO: " + dataFechamentoTxt);
            }
        
		}
    }
}

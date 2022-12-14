package com.mata62.projetofinal.biblioteca.livros;

import java.util.ArrayList;

import com.mata62.projetofinal.biblioteca.usuarios.Usuario;
import com.mata62.projetofinal.biblioteca.controles.Emprestimo;
import com.mata62.projetofinal.biblioteca.controles.Reserva;


public class Livro {
    int id;
    String anoLancamento;
    String autores;
    String editora;
    String edicao;
    String titulo;

    ArrayList<Exemplar> exemplares;
    ArrayList<Reserva> reservas;

    public Livro(int id, String anoLancamento, String autores,
     String editora, String edicao, int numeroExemplares, String titulo){
        this.id = id;
        this.anoLancamento = anoLancamento;
        this.autores = autores;
        this.editora = editora;
        this.edicao = edicao;
        this.exemplares = new ArrayList<Exemplar>();
        for (int i = 0; i <= numeroExemplares; i++) {
            Exemplar exemplar = new Exemplar(i, this);
            this.exemplares.add(exemplar);
        }
        this.titulo = titulo;
        this.reservas = new ArrayList<Reserva>();
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void adicionarReserva(Reserva r) {
        reservas.add(r);
    }

    public int getQuantidadeReservas() {
        return reservas.size();
    }

    public ArrayList<Exemplar> getExemplaresDisponiveis(){
        ArrayList<Exemplar> exemplaresDisponives = new ArrayList<Exemplar>();
        
        for (Exemplar exemplar : exemplares) {
            if(exemplar.getEmprestimo() == null){
                exemplaresDisponives.add(exemplar);
            } else if (!exemplar.getEmprestimo().estaAtivo()){
                exemplaresDisponives.add(exemplar);
            }
        }
        return exemplaresDisponives;
    }

    public ArrayList<Exemplar> getExemplaresIndisponiveis(){
        ArrayList<Exemplar> exemplaresIndisponives = new ArrayList<Exemplar>();
        
        for (Exemplar exemplar : exemplares) {
            if(exemplar.getEmprestimo() != null){
                if (exemplar.getEmprestimo().estaAtivo()){
                    exemplaresIndisponives.add(exemplar);
                }
            }  
        }
        return exemplaresIndisponives;
    }

    
    public boolean podeSerEmprestado() {
        if (this.getExemplaresDisponiveis().size() > 0){
            return true;
        }
        return false;
    }

    public Exemplar getExemplarParaEmprestar() {
        return this.getExemplaresDisponiveis().get(0);
    }

    public int getQuantidadeExemplaresDisponiveis() {
        int i = 0;
        for (Exemplar exemplar : exemplares) {
            if(exemplar.getEmprestimo() == null){
                i ++;
            } else if (!exemplar.getEmprestimo().estaAtivo()){
                i ++;
            }
        }
        return i;
    }

    public boolean estaEmprestadoParaUsuario(Usuario usuario){
        for (Exemplar exemplar : this.getExemplaresIndisponiveis()){
            if(exemplar.getEmprestimo().getUsuario() == usuario){
                return true;
            }
        }
        return false;
    }

    public ArrayList<Reserva> obterReservasAtivas(){
        ArrayList<Reserva> reservasAtivas = new ArrayList<Reserva>();
        for (Reserva reserva : reservas) {
            if (reserva.estaAtiva()){
                reservasAtivas.add(reserva);
            }
        }
        return reservasAtivas;
    }

    public void exibirDadosLivro(){
        System.out.println("TITULO: " + titulo);
        int quantidadeReservas = this.obterReservasAtivas().size();
        System.out.println("QUANTIDADE RESERVAS: " + this.obterReservasAtivas().size());
        if (quantidadeReservas > 0){
            for (Reserva reserva : this.obterReservasAtivas()){
                System.out.println("RESERVA REALIZADA POR: " + reserva.getUsuario().getNome());
            }
        }
        System.out.println("EXEMPLARES DISPONIVEIS: ");
        for (Exemplar exemplar : getExemplaresDisponiveis()){
            System.out.println(exemplar.getId());
        }
        System.out.println("EXEMPLARES EMPRESTADOS: ");
        for (Exemplar exemplar : getExemplaresIndisponiveis()){
            Emprestimo emprestimo = exemplar.getEmprestimo();
            Usuario usuarioEmprestimo = emprestimo.getUsuario();
            System.out.println(exemplar.getId() + " PARA: " + usuarioEmprestimo.getNome() +
             " DATA EMPRESTIMO: " + emprestimo.getDataEmprestimo() + " DATA DEVOLUCAO ESPERADA: " + 
             emprestimo.dataDevolucaoEsperada());
        }
    }
}
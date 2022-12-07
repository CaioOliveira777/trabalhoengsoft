package com.mata62.projetofinal.biblioteca;

import java.util.ArrayList;

import com.mata62.projetofinal.biblioteca.controles.Emprestimo;
import com.mata62.projetofinal.biblioteca.controles.Reserva;
import com.mata62.projetofinal.biblioteca.livros.Exemplar;
import com.mata62.projetofinal.biblioteca.livros.Livro;
import com.mata62.projetofinal.biblioteca.usuarios.Usuario;
import com.mata62.projetofinal.biblioteca.usuarios.AlunoGraduacao;
import com.mata62.projetofinal.biblioteca.usuarios.AlunoPosGraduacao;
import com.mata62.projetofinal.biblioteca.usuarios.Professor;
import com.mata62.projetofinal.observador.Observador;

public class Biblioteca {
    private static Biblioteca instancia;

    private ArrayList<Usuario> usuarios;
    private ArrayList<Livro> livros;

    private Biblioteca(){
        this.usuarios = new ArrayList<Usuario>();
        this.livros = new ArrayList<Livro>();

        this.inicializarListas();
    }

    public static Biblioteca obterInstancia(){
        if (instancia == null) {
            instancia = new Biblioteca();
        }
        return instancia;
    }

    public void inicializarListas(){
        this.inicializarLivros();
        this.inicializarPessoas();
    }

    public Usuario obterUsuarioPeloId(int id) {
        for (Usuario usuario : usuarios){
            if (usuario.getId() == id) {
                return usuario;
            }
        }
        return null;
    }

    public Livro obterLivroPeloId(int id) {
        for (Livro livro : livros) {
            if (livro.getId() == id) {
                return livro;
            }
        }
        return null;
    }

    public void exibirDadosUsuario(int idUsuario){
        Usuario usuario = obterUsuarioPeloId(idUsuario);
        usuario.exibirDadosUsuario();
    }

    public void exibirDadosLivro(int idLivro){
        Livro livro = obterLivroPeloId(idLivro);
        livro.exibirDadosLivro();
    }

    public void reservar(int idUsuario, int idLivro) {
        Usuario usuario = obterUsuarioPeloId(idUsuario);
        Livro livro = obterLivroPeloId(idLivro);

        if (usuario.podeReservar()) {
            Reserva reserva = new Reserva(usuario, livro);
            usuario.adicionarReserva(reserva);
            livro.adicionarReserva(reserva);
            System.out.println("LIVRO: "+ livro.getTitulo() + " - RESERVADO COM SUCESSO PARA: " + usuario.getNome());
        }
    }



    public void emprestar(int idUsuario, int idLivro) {
        Usuario usuario = obterUsuarioPeloId(idUsuario);
        Livro livro = obterLivroPeloId(idLivro);

        if (usuario.podePegarEmprestado(livro)){
            if (livro.podeSerEmprestado()){
                Reserva reserva = usuario.getReservaAtivaPeloLivro(livro);
                if (reserva != null){
                    reserva.cancelarReserva();
                }
                Exemplar exemplar = livro.getExemplarParaEmprestar();
                Emprestimo emprestimo = new Emprestimo(usuario, exemplar);
                exemplar.setEmprestimo(emprestimo);
                usuario.adicionarEmprestimo(emprestimo);
                System.out.println("LIVRO: "+ livro.getTitulo() + " - EMPRESTADO COM SUCESSO PARA: " + usuario.getNome());
            }
        }
    }

    public void devolver(int idUsuario, int idLivro) {
        Usuario usuario = obterUsuarioPeloId(idUsuario);
        Livro livro = obterLivroPeloId(idLivro);

        Emprestimo emprestimo = usuario.emprestimoPeloLivro(livro);

        emprestimo.devolver();
        System.out.println("LIVRO: "+ livro.getTitulo() + " - DEVOLVIDO COM SUCESSO DE: " + usuario.getNome());
    }


    public void inicializarPessoas() {
        Usuario prof = new Professor(100, "Carlos Lucena");
        usuarios.add(prof);

        Usuario grad1 = new AlunoGraduacao(123, "João da Silva");
        usuarios.add(grad1);

        Usuario grad2 = new AlunoGraduacao(789, "Pedro Paulo");
        usuarios.add(grad2);

        Usuario pos = new AlunoPosGraduacao(456, "Luiz Fernando Rodrigues");
        usuarios.add(pos);
	}

    public void inicializarLivros() {
        Livro b1 = new Livro(100, "2000", "Ian Sommervile", "AddisonWesley",
                "6ª", 2, "Engenharia de Software");
        livros.add(b1);

        Livro b2 = new Livro(101, "2000", "Grady Booch, James Rumbaugh, Ivar Jacobson",
                "Campus", "7ª", 1, "UML - Guia do Usuário");
        livros.add(b2);

        Livro b3 = new Livro(200, "2014", "Steve McConnell",
                "Microsoft Press", "2ª", 1, "Code Complete");
        livros.add(b3);

        Livro b4 = new Livro(201, "2002", "Robert Martin", "Prentice Hall",
                "1ª", 1, "Agile SoftwareDevelopment, Principles, Patterns, and Practices");
        livros.add(b4);



        Livro b5 = new Livro(300, "1999", "Martin Fowler",
                "AddisonWesley Professional",  "1ª",  2,
                "Refactoring: Improving the Design of Existing Code");
        livros.add(b5);

        Livro b6 = new Livro(301, "2014", "Norman Fenton, James Bieman", "CRC Press",
                "3ª", 0, "Software Metrics: A Rigorous and Practical Approach");
        livros.add(b6);

        Livro b7 = new Livro(400, "1994", "Erich Gamma, Richard Helm, RalphJohnson, JohnVlissides",
                "AddisonWesley Professional","1ª", 2, "Design Patterns: Elements of Reusable Object-Oriented Software");
        livros.add(b7);

        Livro b8 = new Livro(401, "2003", "Martin Fowler",
                "AddisonWesley Professional", "3ª", 2, "UML Distilled: A Brief Guide to the Standard Object Modeling Language");
        livros.add(b8);
	}

    public void addObservador(int idUsuario, int idLivro){
        obterLivroPeloId(idLivro).addObservador((Observador) obterUsuarioPeloId(idUsuario));
        System.out.println("O USUÁRIO DE ID " + idUsuario + " SERÁ NOTIFICADO");
    }

    public void nftObservador(int idUsuario){
       Observador ob = (Observador) obterUsuarioPeloId(idUsuario);
       System.out.println("TOTAL DE NOTIFICAÇÕES: " + ob.totalDeNotificacoes());
    }
}

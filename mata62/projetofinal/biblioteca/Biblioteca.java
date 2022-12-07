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
		Usuario prof = new Professor(100, "Camilla Cabello");
		usuarios.add(prof);

		Usuario grad1 = new AlunoGraduacao(123, "Carlinhos Brown");
		usuarios.add(grad1);

		Usuario grad2 = new AlunoGraduacao(789, "Xuxa");
		usuarios.add(grad2);

		Usuario pos = new AlunoPosGraduacao(456, "Djavan");
		usuarios.add(pos);
	}

    public void inicializarLivros() {
		Livro b1 = new Livro(100, "2020", "Claudio Santanna", "Saraiva",
				"6ª", 2, "Engenharia de Software");
		livros.add(b1);

		Livro b2 = new Livro(111, "2032", "Petcovic, Neymar, Richarlison",
        "Hexa", "8ª", 1, "O futuro hexa vem aí");
		livros.add(b2);

		Livro b3 = new Livro(213, "2013", "Tiririca",
        "Globo", "3ª", 3, "Ha! Ha! Ha!");
		livros.add(b3);

		Livro b4 = new Livro(290, "2022", "Ronaldo", "Bola de ouro",
        "4ª", 2, "A copa de 2002");
		livros.add(b4);

        Livro b5 = new Livro(300, "1977", "Fulano",
                "Editora Fulano",  "3ª",  3,
                "Fulano é legal");
        livros.add(b5);
		
        Livro b6 = new Livro(329, "2021", "Cicrano",
				"Cicrano Editora",  "89ª",  1,
                "Cicrano é massa");
		livros.add(b6);

		Livro b7 = new Livro(490, "2017", "Pelé", "Campeão",
         "2ª", 0, "Campeão 3 vezes");
		livros.add(b7);

		Livro b8 = new Livro(400, "2000", "Caio O.",
         "Trabalho de eng soft","2ª", 3, "Trabalho de Eng Soft");
		livros.add(b8);

		Livro b9 = new Livro(401, "2013", "Iago O.",
         "Trabalho de Engsoft", "4ª", 3, "Trabalho de Eng Soft");
		livros.add(b9);
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

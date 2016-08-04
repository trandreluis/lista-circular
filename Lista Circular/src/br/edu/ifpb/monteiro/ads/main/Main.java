package br.edu.ifpb.monteiro.ads.main;

import java.util.Scanner;

import br.edu.ifpb.monteiro.ads.execoes.ElementoNaoEncontradoException;
import br.edu.ifpb.monteiro.ads.execoes.ListaCheiaException;
import br.edu.ifpb.monteiro.ads.execoes.ListaVaziaException;
import br.edu.ifpb.monteiro.ads.execoes.PosicaoInvalidaException;
import br.edu.ifpb.monteiro.ads.implementacao.TListaCircular;

public class Main {

	TListaCircular lista = new TListaCircular();
	

	public static void main(String[] args) {

		Main main = new Main();

		while (true) {
			main.menu();
		}

	}

	public void menu() {
		System.out.println();
		System.out.println("MENU");
		System.out.println("1 - INSERIR");
		System.out.println("2 - INSERIR NA POSICAO");
		System.out.println("3 - BUSCAR PELA POSICAO");
		System.out.println("4 - PEGAR POSICAO PELO DADO");
		System.out.println("5 - REMOVER PELO DADO");
		System.out.println("6 - REMOVER PELA POSICAO");
		System.out.println("7 - PEGAR ANTECESSOR");
		System.out.println("8 - PEGAR SUCESSOR");
		System.out.println("9 - VERIFICAR EXISTENCIA");
		System.out.println("10 - IMPRIMIR");
		System.out.println("11 - TAMANHO DA LISTA");
		System.out.println("0 - SAIR");
		Scanner s = new Scanner(System.in);
		int escolha = s.nextInt();

		switch (escolha) {

		case 1:
			inserirNoFim();
			break;
		case 2:
			inserirNaPosicao();
			break;
		case 3:
			buscarPelaPosicao();
			break;
		case 4:
			pegarPosicaoPeloDado();
			break;
		case 5:
			removerPeloDado();
			break;
		case 6:
			removerPelaPosicao();
			break;
		case 7:
			pegarAntecessor();
			break;
		case 8:
			pegaSucessor();
			break;
		case 9:
			verificarExistencia();
			break;
		case 10:
			imprimir();
			break;
		case 11:
			tamnhoDaLista();
			break;
		case 0:
			System.exit(0);

		}
	}

	public void inserirNoFim() {

		Scanner s = new Scanner(System.in);
		System.out.println("Informe o dado: ");
		String dado = s.nextLine();
		
		try {
			lista.inserir(dado);
			System.out.println("Elemento inserido com sucesso!");
		} catch (ListaCheiaException e) {
			//essa excecao nunca sera lancada, pois a lista nunca estara cheia
		}
		
		menu();
	}

	public void inserirNaPosicao() {
		
		Scanner s = new Scanner(System.in);
		System.out.println("Informe o dado: ");
		String dado = s.nextLine();
		System.out.println("Informe a posicao: ");
		int posicao = s.nextInt();
		
		try {
			lista.inserirNaPosicao(dado, posicao);
			System.out.println("Elemento inserido com sucesso!");
		} catch (ListaCheiaException e) {
			//essa excecao nunca sera lancada, pois a lista nunca estara cheia
		} catch (PosicaoInvalidaException e) {
			System.out.println();
			System.out.println("Posicao invalida, a posicao: "+posicao+" nao esta nos limites da lista.");
			System.out.println();
		} catch (ElementoNaoEncontradoException e) {
			//essa excecao nunca sera lancada, pois a sua situacao e testada antes
		} catch (ListaVaziaException e) {
			System.out.println();
			System.out.println("A lista esta vazia");
			System.out.println();
		}
		
		menu();
	}

	public void buscarPelaPosicao() {

		Scanner s = new Scanner(System.in);
		System.out.println("Informe a posicao: ");
		int posicao = s.nextInt();
		
		try {
			System.out.println("Elemento da posicao "+posicao+": "+lista.buscar(posicao));
		} catch (PosicaoInvalidaException e) {
			System.out.println();
			System.out.println("Posicao invalida, a posicao: "+posicao+" nao esta nos limites da lista.");
			System.out.println();
		}
		
		menu();
	}

	public void pegarPosicaoPeloDado() {

		Scanner s = new Scanner(System.in);
		System.out.println("Informe o dado: ");
		String dado = s.nextLine();
		
		try {
			System.out.println("Posicao do elemento "+dado+": "+lista.posicao(dado));
		} catch (ElementoNaoEncontradoException e) {
			System.out.println();
			System.out.println("O elemento: "+dado+" nao existe na colecao.");
			System.out.println();
		}
		
		menu();
	}

	public void removerPeloDado() {

		Scanner s = new Scanner(System.in);
		System.out.println("Informe o dado: ");
		String dado = s.nextLine();
		
			try {
				lista.remover(dado);
				System.out.println("Elemento removido com sucesso!");
			} catch (ElementoNaoEncontradoException e) {
				System.out.println();
				System.out.println("O elemento: "+dado+" nao existe na colecao.");
				System.out.println();
			} catch (ListaVaziaException e) {
				System.out.println();
				System.out.println("A lista esta vazia, não há dados a serem removidos.");
				System.out.println();
			}
		
		menu();
	}

	public void removerPelaPosicao() {

		Scanner s = new Scanner(System.in);
		System.out.println("Informe a posicao: ");
		int posicao = s.nextInt();
		
		try {
			lista.remover(posicao);
			System.out.println("Elemento removido com sucesso!");
		} catch (ElementoNaoEncontradoException e) {
			System.out.println();
		} catch (ListaVaziaException e) {
			
		}
		
		menu();
	}

	public void pegarAntecessor() {
		
		Scanner s = new Scanner(System.in);
		System.out.println("Informe o dado: ");
		String dado = s.nextLine();

		try {
			System.out.println("Antecessor: "+lista.antecessor(dado));
		} catch (ElementoNaoEncontradoException e) {
			System.out.println();
			System.out.println("O elemento: "+dado+" nao possui antecessor ou nao existe na colecao.");
			System.out.println();
		} catch (ListaVaziaException e) {
			System.out.println();
			System.out.println("A lista esta vazia.");
			System.out.println();
		}
		
		menu();
	}

	public void pegaSucessor() {

		Scanner s = new Scanner(System.in);
		System.out.println("Informe o dado: ");
		String dado = s.nextLine();
		
		try {
			System.out.println("Sucessor: "+lista.sucessor(dado));
		} catch (ElementoNaoEncontradoException e) {
			System.out.println();
			System.out.println("O elemento: "+dado+" nao possui sucessor ou nao existe na colecao.");
			System.out.println();
		} catch (ListaVaziaException e) {
			System.out.println();
			System.out.println("A lista esta vazia.");
			System.out.println();
		}
		
		menu();
	}

	public void verificarExistencia() {

		Scanner s = new Scanner(System.in);
		System.out.println("Informe o dado: ");
		String dado = s.nextLine();
		
		if(lista.existe(dado)) {
			System.out.println("O elemento "+dado+" existe na colecao.");			
		}
		
		else {
			System.out.println("O elemento "+dado+" nao existe na colecao.");
		}
		
		menu();
	}

	public void imprimir() {

		System.out.println("IMPRESSAO...");
		try {
			lista.imprimir();
		} catch (ListaVaziaException e) {
			System.out.println("A lista está vazia!");
		}
		System.out.println("FIM IMPRESSAO...");
		
		menu();
	}

	public void tamnhoDaLista() {

		System.out.println("O tamanho da lista é: "+lista.tamanho());
		
		menu();
	}

}

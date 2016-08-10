package br.edu.ifpb.monteiro.ads.implementacao;

import br.edu.ifpb.monteiro.ads.execoes.ElementoNaoEncontradoException;
import br.edu.ifpb.monteiro.ads.execoes.ListaCheiaException;
import br.edu.ifpb.monteiro.ads.execoes.ListaVaziaException;
import br.edu.ifpb.monteiro.ads.execoes.PosicaoInvalidaException;
import br.edu.ifpb.monteiro.ads.metodos.TLista;
import br.edu.ifpb.monteiro.ads.no.TNo;

public class TListaCircular implements TLista {

	TNo inicio;
	int tamanho;

	public TListaCircular() {
		this.inicio = null;
		this.tamanho = 0;
	}

	@Override
	public void inserir(String dado) throws ListaCheiaException {

		TNo novoNo = new TNo(dado);

		if (isVazia()) {
			inicio = novoNo;
		} else {

			if (tamanho() == 1) {
				inicio.proximo = novoNo;
				novoNo.proximo = inicio;
			}

			else {

				TNo aux = inicio;

				while (!aux.proximo.equals(inicio)) {
					aux = aux.proximo;
				}
				aux.proximo = novoNo;
				novoNo.proximo = inicio;
			}
		}
		tamanho++;
	}

	@Override
	public void inserirNaPosicao(String dado, int posicao)
			throws ListaCheiaException, PosicaoInvalidaException, ElementoNaoEncontradoException, ListaVaziaException {

		TNo novoNo = new TNo(dado);

		if (posicao > 1 && tamanho() == 0 || posicao <= 0) {
			throw new PosicaoInvalidaException();
		}

		if (posicao == 1 && tamanho() == 0) {
			inicio = novoNo;
		} 

		else if(posicao == tamanho() + 1) {
			inserir(novoNo.dado);
		}
		else {
				TNo noPosicaoDesejada = buscarTNo(posicao);
				TNo antecessor = antecessorTNo(noPosicaoDesejada.dado);
				
				novoNo.proximo = noPosicaoDesejada;
				antecessor.proximo = novoNo;
				
				if(posicao == 1) {
					inicio = novoNo;					
				}
		}

		tamanho++;
	}

	public TNo buscarTNo(int posicao) throws PosicaoInvalidaException {

		if (posicao <= 0 || posicao > tamanho()) {
			throw new PosicaoInvalidaException();
		}

		TNo aux = inicio;

		for (int i = 1; i < posicao; i++) {
			aux = aux.proximo;
		}

		return aux;
	}

	@Override
	public String buscar(int posicao) throws PosicaoInvalidaException {

		if (posicao <= 0 || posicao > tamanho()) {
			throw new PosicaoInvalidaException();
		}

		TNo aux = inicio;

		for (int i = 1; i < posicao; i++) {
			aux = aux.proximo;
		}

		return aux.dado;
	}

	@Override
	public int posicao(String dado) throws ElementoNaoEncontradoException {

		if (!existe(dado)) {
			throw new ElementoNaoEncontradoException();
		}

		TNo aux = inicio;

		int posicao = 1;

		for (; !aux.dado.equals(dado); posicao++) {
			aux = aux.proximo;
		}

		return posicao;
	}

	@Override
	public void remover(String dado) throws ElementoNaoEncontradoException, ListaVaziaException {

		if (isVazia()) {
			throw new ListaVaziaException();
		}

		if (!existe(dado)) {
			throw new ElementoNaoEncontradoException();
		}

		if(tamanho() == 1) {
			inicio = null;
		}
		
		else if (tamanho() > 1) {
			TNo antecessor = antecessorTNo(dado);
			TNo sucessor = sucessorTNo(dado);

			antecessor.proximo = sucessor;

			if (inicio.dado.equals(dado)) {
				inicio = sucessor;
			}
		}		
		tamanho--;
	}

	@Override
	public void remover(int posicao)
			throws PosicaoInvalidaException, ElementoNaoEncontradoException, ListaVaziaException {

		if (isVazia()) {
			throw new ListaVaziaException();
		}

		if (posicao <= 0 || posicao > tamanho()) {
			throw new PosicaoInvalidaException();
		}

		if (tamanho() > 1) {

			String dado = buscar(posicao);

			TNo antecessor = antecessorTNo(dado);
			TNo sucessor = sucessorTNo(dado);

			antecessor.proximo = sucessor;

			if (inicio.dado.equals(dado)) {
				inicio = sucessor;
			}
		} else {
			inicio = null;
		}
		
		tamanho--;
	}

	public TNo antecessorTNo(String dado) throws ElementoNaoEncontradoException, ListaVaziaException {

		if (isVazia()) {
			throw new ListaVaziaException();
		}

		if (!existe(dado) || tamanho() == 1) {
			throw new ElementoNaoEncontradoException();
		}

		int posicao = posicao(dado);

		if (posicao == 1) {

			TNo aux = inicio;

			while (!aux.proximo.equals(inicio)) {
				aux = aux.proximo;
			}

			return aux;
		}

		else {
			TNo aux = inicio;

			for (int i = 1; i < posicao - 1; i++) {
				aux = aux.proximo;
			}

			return aux;
		}
	}

	@Override
	public String antecessor(String dado) throws ElementoNaoEncontradoException, ListaVaziaException {

		if (isVazia()) {
			throw new ListaVaziaException();
		}

		if (!existe(dado) || tamanho() == 1) {
			throw new ElementoNaoEncontradoException();
		}

		int posicao = posicao(dado);

		if (posicao == 1) {

			TNo aux = inicio;

			while (!aux.proximo.equals(inicio)) {
				aux = aux.proximo;
			}

			return aux.dado;
		}

		else {
			TNo aux = inicio;

			for (int i = 1; i < posicao - 1; i++) {
				aux = aux.proximo;
			}

			return aux.dado;
		}
	}

	public TNo sucessorTNo(String dado) throws ElementoNaoEncontradoException, ListaVaziaException {

		if (isVazia()) {
			throw new ListaVaziaException();
		}

		if (!existe(dado) || tamanho() == 1) {
			throw new ElementoNaoEncontradoException();
		}

		TNo aux = inicio;

		while (!aux.dado.equals(dado)) {
			aux = aux.proximo;
		}

		return aux.proximo;
	}

	@Override
	public String sucessor(String dado) throws ElementoNaoEncontradoException, ListaVaziaException {

		if (isVazia()) {
			throw new ListaVaziaException();
		}

		if (!existe(dado) || tamanho() == 1) {
			throw new ElementoNaoEncontradoException();
		}

		TNo aux = inicio;

		while (!aux.dado.equals(dado)) {
			aux = aux.proximo;
		}

		return aux.proximo.dado;
	}

	@Override
	public boolean existe(String buscar) {

		if (isVazia()) {
			return false;
		}

		TNo aux = inicio;

		for (int i = 0; i < tamanho(); i++) {
			if (aux.dado.equals(buscar)) {
				return true;
			}
			aux = aux.proximo;
		}

		return false;
	}

	@Override
	public void imprimir() throws ListaVaziaException {

		if (isVazia()) {
			throw new ListaVaziaException();
		}

		TNo aux = inicio;

		if (tamanho() == 1) {
			System.out.print(aux.dado + " - ");
		}

		else {
			do {
				System.out.print(aux.dado + " - ");
				aux = aux.proximo;
			} while (!aux.dado.equals(inicio.dado));
		}

	}

	@Override
	public int tamanho() {
		return tamanho;
	}

	@Override
	public boolean isVazia() {
		return this.inicio == null;
	}

}

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

	/**
	 * Implementado...
	 */
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

	/**
	 * Falta implementar
	 */	
	@Override
	public void inserirNaPosicao(String dado, int posicao)
			throws ListaCheiaException, PosicaoInvalidaException, ElementoNaoEncontradoException, ListaVaziaException {
		
	}

	@Override
	public String buscar(int posicao) throws PosicaoInvalidaException {
		
		if(posicao <= 0 || posicao > tamanho()) {
			throw new PosicaoInvalidaException();
		}
		
		TNo aux = inicio;
		
		for(int i = 1; i < posicao; i++) {
			aux = aux.proximo;
		}
		
		return aux.dado;
	}

	/**
	 * Implementado...
	 */
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

		TNo aux = inicio;

		while (!aux.proximo.equals(inicio)) {
			aux = aux.proximo;
		}

		TNo antecessor = antecessorTNo(dado);
		TNo sucessor = sucessorTNo(dado);

		antecessor.proximo = sucessor;

		if (inicio.dado.equals(dado)) {
			inicio = sucessor;
		}

		tamanho--;
	}

	@Override
	public void remover(int posicao) throws ElementoNaoEncontradoException, ListaVaziaException {

	}

	/**
	 * Implementado...
	 */
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

	/**
	 * Implementado...
	 */
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

	/**
	 * Implementado...
	 */
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

	/**
	 * Implementado...
	 */
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

	/**
	 * Implementado...
	 */
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

	/**
	 * Implementado...
	 */
	@Override
	public void imprimir() throws ListaVaziaException {

		if (isVazia()) {
			throw new ListaVaziaException();
		}

		TNo aux = inicio;

		if (tamanho() == 1) {
			System.out.println(aux.dado);
		}

		else {
			do {
				System.out.println(aux.dado);
				aux = aux.proximo;
			} while (!aux.dado.equals(inicio.dado));
		}

	}

	/**
	 * Implementado...
	 */
	@Override
	public int tamanho() {
		return tamanho;
	}

	/**
	 * Implementado...
	 */
	@Override
	public boolean isVazia() {
		return this.inicio == null;
	}

}

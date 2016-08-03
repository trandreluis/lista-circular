package br.edu.ifpb.monteiro.ads.implementacao;

import br.edu.ifpb.monteiro.ads.execoes.ElementoNaoEncontradoException;
import br.edu.ifpb.monteiro.ads.execoes.ListaCheiaException;
import br.edu.ifpb.monteiro.ads.execoes.ListaVaziaException;
import br.edu.ifpb.monteiro.ads.execoes.PosicaoInvalidaException;
import br.edu.ifpb.monteiro.ads.metodos.TLista;
import br.edu.ifpb.monteiro.ads.no.TNo;

public class TListaCircular implements TLista {

	TNo inicio;
	
	@Override
	public void inserirNoFim(String dado) throws ListaCheiaException {
		
		/**
		 * Criacao de novo TNo ainda nao indexado na lista
		 */
		TNo novoNo = new TNo(dado);
		
		if(isVazia()) {
			
			inicio = novoNo;			
		
		}
		else {
			
			TNo aux = inicio;
			
			while(aux.proximo!=null){
				aux = aux.proximo;				
			}
			
			aux.proximo = novoNo;	
			
		}
		
	}

	@Override
	public void inserirNaPosicao(String dado, int posicao) throws ListaCheiaException, PosicaoInvalidaException {
		
		
		
	}

	@Override
	public String buscar(int posicao) throws PosicaoInvalidaException {

		
		return null;
	}

	@Override
	public int posicao(String dado) throws ElementoNaoEncontradoException {
		
		
		return 0;
	}

	@Override
	public void remover(String dado) throws ElementoNaoEncontradoException, ListaVaziaException {

		
		
	}

	@Override
	public void remover(int posicao) throws ElementoNaoEncontradoException, ListaVaziaException {

		
		
	}

	@Override
	public String antecessor(String dado) throws ElementoNaoEncontradoException, ListaVaziaException {

		
		return null;
	}

	@Override
	public String sucessor(String dado) throws ElementoNaoEncontradoException, ListaVaziaException {

		
		return null;
	}

	@Override
	public boolean existe(String buscar) {

		
		return false;
	}

	@Override
	public void imprimir() {

		
		
	}

	@Override
	public int tamanho() {

		
		return 0;
	}

	@Override
	public boolean isVazia() {
		// TODO Auto-generated method stub
		return false;
	}

	
	
}

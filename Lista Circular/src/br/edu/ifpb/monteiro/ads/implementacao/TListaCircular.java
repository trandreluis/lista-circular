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
	public void inserirNoFim(String dado) throws ListaCheiaException {
		
		/**
		 * Criacao de novo TNo ainda nao indexado na lista
		 */
		TNo novoNo = new TNo(dado);
		
		/**
		 * Se vazia, inicialize a lista
		 */
		if(isVazia()) {
			inicio = novoNo;
		}
		else {
			TNo aux = inicio;
			
			for(int i = 1; i < tamanho(); i++) {
				aux = aux.proximo;
			}
			
			novoNo.proximo = inicio;
			aux.proximo = novoNo;
			
		}
		tamanho++;
	}

	/**
	 * Falta concluir...
	 * @throws ListaVaziaException 
	 * @throws ElementoNaoEncontradoException 
	 */
	@Override
	public void inserirNaPosicao(String dado, int posicao) throws ListaCheiaException, PosicaoInvalidaException, ElementoNaoEncontradoException, ListaVaziaException {
		
		if(posicao <= 0 || posicao > tamanho)
			throw new PosicaoInvalidaException();
		
		TNo novoNo = new TNo(dado);
		
		TNo aux = inicio;
		
		for (int i = 1; i < posicao; i++) {
			aux = aux.proximo;
		}
		
		novoNo.proximo = aux;
		TNo antecessor = antecessorTNo(aux.dado);
		antecessor.proximo = novoNo;
		
		if(posicao == 1)
			inicio = novoNo;
		
		tamanho++;
	}

	@Override
	public String buscar(int posicao) throws PosicaoInvalidaException {
		
		if(posicao <= 0 || posicao > tamanho)
			throw new PosicaoInvalidaException();
		
		TNo aux = inicio;
		
		for(int i = 1; i < posicao; i++) {
			aux = aux.proximo;
		}
		
		return aux.dado;
		
	}

	@Override
	public int posicao(String dado) throws ElementoNaoEncontradoException {
		
		TNo aux = inicio;
		
		for(int i = 1; i <= tamanho(); i++) {
			if(aux.dado.equals(dado)) {
				return i;
			}
			aux = aux.proximo;
		}
		
		throw new ElementoNaoEncontradoException();
		
	}

	@Override
	public void remover(String dado) throws ElementoNaoEncontradoException, ListaVaziaException {

		
		
	}

	@Override
	public void remover(int posicao) throws ElementoNaoEncontradoException, ListaVaziaException {

		
		
	}

	@Override
	public String antecessor(String dado) throws ElementoNaoEncontradoException, ListaVaziaException {
		
		if(isVazia())
			throw new ListaVaziaException();
		
		if(!existe(dado))
			throw new ElementoNaoEncontradoException();
		
		TNo aux = inicio;
		
		int posicao = posicao(dado);
		
		for(int i = 0; i < posicao+1; i++) {
			aux = aux.proximo;
		}
		
		System.out.println(aux.dado);
		
		return aux.dado;
	}

	public TNo antecessorTNo(String dado) throws ElementoNaoEncontradoException, ListaVaziaException {
		
		if(isVazia())
			throw new ListaVaziaException();
		
		if(!existe(dado))
			throw new ElementoNaoEncontradoException();
		
		TNo aux = inicio;
		
		int posicao = posicao(dado);
		
		for(int i = 0; i < posicao+1; i++) {
			aux = aux.proximo;
		}
		
		return aux;
	}
	
	public TNo sucessorTNo(String dado) throws ElementoNaoEncontradoException, ListaVaziaException {

		if(isVazia())
			throw new ListaVaziaException();
		
		if(!existe(dado))
			throw new ElementoNaoEncontradoException();
		
		TNo aux = inicio;
		
		int posicao = posicao(dado);
		
		for(int i = 1; i <= posicao; i++) {
			aux = aux.proximo;
		}
		
		return aux;
		
	}
	
	@Override
	public String sucessor(String dado) throws ElementoNaoEncontradoException, ListaVaziaException {

		if(isVazia())
			throw new ListaVaziaException();
		
		if(!existe(dado))
			throw new ElementoNaoEncontradoException();
		
		TNo aux = inicio;
		
		int posicao = posicao(dado);
		
		for(int i = 1; i <= posicao; i++) {
			aux = aux.proximo;
		}
		
		return aux.dado;
		
	}

	@Override
	public boolean existe(String buscar) {

		TNo aux = inicio;
		
		for(int i = 0; i < tamanho(); i++) {
			if(aux.dado.equals(buscar)) {
				return true;
			}
			aux = aux.proximo;
		}
		
		return false;
	}

	@Override
	public void imprimir() {

		TNo aux = inicio;
		
		for(int i = 0; i < tamanho(); i++) {
			System.out.println(aux.dado);
			aux = aux.proximo;
		}
		
	}
	
	public static void main(String[] args) {
		
		TListaCircular lista = new TListaCircular();
		
		try {
			System.out.println("Inserindo...(Andre, luis, s!)");
			lista.inserirNoFim("Andre");
			lista.inserirNoFim("luis");
			lista.inserirNoFim("s!");
			System.out.println("imprimindo...");
			lista.imprimir();
			try {
				System.out.println("Pegando posicao...(s!)");
				System.out.println(lista.posicao("s!"));
				try {
					System.out.println("buscando...(posicao 3)");
					System.out.println(lista.buscar(3));
					System.out.println("Verificando existencia do elemento (s!)");
					System.out.println(lista.existe("s!"));
					try{
						System.out.println("Pegando sucessor de (s!)");
						System.out.println(lista.sucessor("s!"));
						System.out.println("Pegando antecessor de (Andre)");
						lista.antecessor("Andre");
						System.out.println("LISTA ANTES..........");
						lista.imprimir();
						lista.inserirNaPosicao("Novo", 2);
						System.out.println("LISTA DEPOIS.........");
						lista.imprimir();
						
					} catch(Exception e) {
						e.printStackTrace();
					}
				} catch (PosicaoInvalidaException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (ElementoNaoEncontradoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			System.out.println(lista.tamanho);
		} catch (ListaCheiaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

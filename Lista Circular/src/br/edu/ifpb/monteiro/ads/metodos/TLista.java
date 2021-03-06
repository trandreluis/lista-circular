package br.edu.ifpb.monteiro.ads.metodos;

import br.edu.ifpb.monteiro.ads.execoes.ElementoNaoEncontradoException;
import br.edu.ifpb.monteiro.ads.execoes.ListaCheiaException;
import br.edu.ifpb.monteiro.ads.execoes.ListaVaziaException;
import br.edu.ifpb.monteiro.ads.execoes.PosicaoInvalidaException;

public interface TLista {

	public void inserir(String dado) throws ListaCheiaException;
	
	public void inserirNaPosicao(String dado,int posicao) throws ListaCheiaException, PosicaoInvalidaException, ElementoNaoEncontradoException, ListaVaziaException;
	
	public String buscar(int posicao) throws PosicaoInvalidaException;

	public int posicao(String dado) throws ElementoNaoEncontradoException;
	
	public void remover(String dado) throws ElementoNaoEncontradoException, ListaVaziaException;
	
	public void remover(int posicao) throws ElementoNaoEncontradoException, ListaVaziaException, PosicaoInvalidaException;
	
	public String antecessor(String dado) throws ElementoNaoEncontradoException, ListaVaziaException;
	
	public String sucessor(String dado) throws ElementoNaoEncontradoException, ListaVaziaException;

	public boolean existe(String buscar);
	
	public boolean isVazia();

	public void imprimir() throws ListaVaziaException;
	
	public int tamanho();

}

package br.edu.ifpb.monteiro.ads.metodos;

import br.edu.ifpb.monteiro.ads.execoes.ElementoNaoEncontradoException;
import br.edu.ifpb.monteiro.ads.execoes.ListaCheiaException;
import br.edu.ifpb.monteiro.ads.execoes.ListaVaziaException;
import br.edu.ifpb.monteiro.ads.execoes.PosicaoInvalidaException;

public interface TLista {

	//insere no fim
	public void inserir(String dado) throws ListaCheiaException;
	
	//insere na posição
	public void inserir(String dado,int posicao) throws ListaCheiaException, PosicaoInvalidaException;
	
	public int tamanho();

	public void imprimir();
	
	public String buscar(int posicao) throws PosicaoInvalidaException;
	
	public int posicao(String dado) throws ElementoNaoEncontradoException;
	
	public boolean existe(String buscar);
	
	public void remover(String dado) throws ElementoNaoEncontradoException, ListaVaziaException;
	
	public void remover(int posicao) throws ElementoNaoEncontradoException, ListaVaziaException;

	public String antecessor(String dado) throws ElementoNaoEncontradoException, ListaVaziaException;

	public String sucessor(String dado) throws ElementoNaoEncontradoException, ListaVaziaException;
	
}

package br.edu.ifpb.monteiro.ads.no;

public class TNo {

	public String dado;
	public TNo proximo;
	
	public TNo(String dado) {
		this.dado = dado;
	}
	
	public boolean equals(Object noComparado) {
		
		TNo no = (TNo) noComparado;
		
		if(this.dado.equals(no.dado)) {
			return true;
		}
		return false;
	}
	
}

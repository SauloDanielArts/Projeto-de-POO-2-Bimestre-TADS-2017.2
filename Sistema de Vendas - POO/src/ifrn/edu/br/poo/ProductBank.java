package ifrn.edu.br.poo;

import java.util.HashMap;

public class ProductBank {
	private HashMap<String,Produto> itens = new HashMap<String, Produto>();
	
	public boolean setItem(String chave, Produto item) {
		boolean check = false;
        Produto p;
		itens.put(chave, item);
		p = itens.get(chave);
		if(p.equals(item)) {
			check = true;
		}

		return check;
	}
	
	public Produto getItem(String chave) {
		Produto k = itens.get(chave);
		return k;
	}
	
	public boolean apagaItem(String chave) {
		boolean check = false;
		Produto p = null;
		
		itens.put(chave, p);
		if(itens.get(chave) == null) {
			check = true;
		}

		return check;
	}
	
    public void diminuiQtde(String code, int number) {
        Produto p = getItem(code);
        int qtde = p.getQuantidade();
        qtde = qtde - number;
        p.setQuantidade(qtde);
        double value = p.getValor();
        value = value * number;
        p.setValor(value);
    }
}

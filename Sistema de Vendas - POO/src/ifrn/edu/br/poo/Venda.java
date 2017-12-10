package ifrn.edu.br.poo;
import java.util.HashMap;


public class Venda {
   private HashMap<String,Produto> produtos = new HashMap<String,Produto>();
   private double total;
   
   public Venda() {
	   total = 0;
   }
   
   public double getTotal() {
	   return total;
   }
   
   public Produto getVenda(String string) {
	   Produto produto = produtos.get(string);
	   return produto;
   }
   
   public boolean setVenda(String chave, Produto product) {
	   boolean check = false;
       Produto p;
	   produtos.put(chave, product);
	   p = produtos.get(chave);
	   if(p.equals(product)) {
			check = true;
	   }

		return check;
   }
   
   public void calculaTotal(double tot) {
	   this.total = total + tot;
   }
}

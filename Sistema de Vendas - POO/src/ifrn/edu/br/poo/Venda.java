package ifrn.edu.br.poo;

public class Venda {
   private Produto venda[] = new Produto[100];
   private double total;
   private String operador;
   
   public Venda() {
	   total = 0;
	   operador = "Computador";
   }
   
   public double getTotal() {
	   return total;
   }
   
   public String getOperador() {
	   return operador;
   }
   
   public Produto getVenda(int value) {
		   return venda[value];
   }
   
   public void setOperador(String nome) {
	   operador = nome;
   }
   
   public boolean setVenda(Produto product) {
	   boolean check = false;
	   for(int i = 0; i < 100; i++) {
		   if(venda[i] == null) {
			   venda[i] = product;
			   check = true;
			   break;
		   }
	   }
	   return check;
   }
   
   public void calculaTotal(double tot) {
	   this.total = total + tot;
   }
}

package ifrn.edu.br.poo;

public abstract class Produto {
   private String tipo;
   private double value;
   
   public void setTipo(String tip) {
	   tipo = tip;
   }
   
   public void setValue(double valor) {
	   value = valor;
   }
   
   public String getTipo() {
	   return tipo;
   }
   
   public double getValue() {
	   return value;
   }
   
   public abstract double taxa(double a);
  
}
package ifrn.edu.br.poo;

public class Refrigerante extends Produto{
	 private final String tipo[] = {"Coca-Cola", "Pepsi", "Fanta", "Guarana_Antartica"};
	 private final double valor[] = {2.50, 2.70, 2.20, 2.45};
	 private final String code[] = {"3992020", "50010990", "25720158", "1003294045"};
	 private int index;
	 
	 public String getTipo(String number) {
		   for(int i = 0; i < 4; i++) {
			   if(code[i].equals(number)) {
				   index = i;
			   }
		   }
		   
		   return tipo[index];
	   }
	   
	   public double getValue(String number) {
		   for(int i = 0; i < 4; i++) {
			   if(code[i].equals(number)) {
				   index = i;
			   }
		   }
		   
		   return valor[index];
	   }

	@Override
	public double taxa(double a) {
		double result = a * 0.20;
		return result;
	}
}

package ifrn.edu.br.poo;

public class Pao extends Produto{
   private final String tipo[] = {"Center_Massas", "Dunas", "Center_Pao", "Pao_de_Queijo", "Forma"};
   private final double valor[] = {3.99, 2.89, 3.49, 3.69, 3.56};
   private final String code[] = {"45001284", "1003748999", "4481090012", "190002851", "2000358190"};
   private int index;
   
   public String getTipo(String number) {
 	   for(int i = 0; i < 5; i++) {
 		   if(code[i].equals(number)) {
 			   index = i;
 		   }
 	   }
 	   
 	   return tipo[index];
    }
    
    public double getValue(String number) {
 	   for(int i = 0; i < 5; i++) {
 		   if(code[i].equals(number)) {
 			   index = i;
 		   }
 	   }
 	   
 	   return valor[index];
    }

	@Override
	public double taxa(double a) {
		double result = a * 0.02;
		return result;
	}
}
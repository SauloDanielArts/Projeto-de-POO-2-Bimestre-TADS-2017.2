package ifrn.edu.br.poo;

public class Cafe extends Produto{
   private final String tipo[] = {"Bangu", "Sao_Bras", "Santa_Clara", "Marata", "Tres_Fazendas", "Cafe_Brasileiro", "Pilao"};
   private final double valor[] = {3.99, 4.99, 4.99, 4.99, 4.99, 4.99, 5.19}; 
   private final String code[] = {"3991820", "55718291", "44829102", "34918201", "112000129", "110233918", "220011883"};
   private int index;
   
   
   public String getTipo(String number) {
	   for(int i = 0; i < 7; i++) {
		   if(code[i].equals(number)) {
			   index = i;
		   }
	   }
	   
	   return tipo[index];
   }
   
   public double getValue(String number) {
	   for(int i = 0; i < 7; i++) {
		   if(code[i].equals(number)) {
			   index = i;
		   }
	   }
	   
	   return valor[index];
   }


    public double taxa(double a) {
	   double result = a * 0.10;
	   return result;
    }


   
   
   
}

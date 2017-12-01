package ifrn.edu.br.poo;


public class Laticinios extends Produto{
    private final String tipo[] = {"LeiteBom", "Leitissimo", "Itambe", "Camponesa", "Ninho", "Piracanjuba", "Elegê", "Parmalat"};
    private final double[] value = {3.50, 3.99, 3.89, 5.39, 5.20, 3.60, 3.99, 4.89};
    private final String code[] = {"12849001", "99450001982", "350962135", "4410238512", "2011325964", "7500112372", "1644140194", "39402012"};
    private int index;
   
    
    
    public String getTipo(String number) {
 	   for(int i = 0; i < 8; i++) {
 		   if(code[i].equals(number)) {
 			   index = i;
 		   }
 	   }
 	   
 	   return tipo[index];
    }
    
    public double getValue(String number) {
 	   for(int i = 0; i < 8; i++) {
 		   if(code[i].equals(number)) {
 			   index = i;
 		   }
 	   }
 	   
 	   return value[index];
    }

	@Override
	public double taxa(double a) {
		double result = a * 0.05;
		return result;
	}
   
}
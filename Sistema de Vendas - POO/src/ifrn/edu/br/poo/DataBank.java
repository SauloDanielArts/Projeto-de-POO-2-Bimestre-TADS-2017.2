
package ifrn.edu.br.poo;
import java.util.ArrayList;
import java.util.Collection;

public class DataBank {

    private ArrayList <Operador> operator = new ArrayList<Operador>();
    
    
    public void setOperator(Operador t) {
    	operator.add(t);
    }
    

    public boolean searchLogin(Operador a) {
    	boolean check = false;
    	String log = a.getLogin();
    	for(Operador nome : operator) {
    		String string = nome.getLogin();
    		
    		if(string.equals(log)) {
    			check = true;
    		}
    	}
    	
    	return check;
    }
    
    public boolean searchPassword(Operador a) {
    	boolean check = false;
    	String pass = a.getPassword();
    	for(Operador nome : operator) {
            String string = nome.getPassword();
    		if(pass.equals(string)) {
    			check = true;
    		}
    	}
    	
    	return check;
    }
    
    public boolean apagaOperador(String string) {
    	boolean check = false;
    	int i = 0;
    	for(Operador op : operator) {
    		String operador = op.getLogin();
    		i++;
    		if(operador.equals(string)) {
    			op = null;
    		}
    		
    		if(operator.get(i) == null) {
				check = true;	
			}
    	}
    	return check;
    }
}

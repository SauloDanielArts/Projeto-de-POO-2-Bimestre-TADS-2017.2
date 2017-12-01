package ifrn.edu.br.poo;

public class DataBank {
    private String login[] = {"Aline", "Karla", "Eduardo", "Saulo", "Diego", "Paulo", "Celso"};
    private String password[] = {"135829abc", "a45Gj953", "S3592K_23", "45_Fthw128", "12_wyFW_45", "95_94_hFw-ir", "ArN4_83k-N"};
    
    public boolean search_login(String t) {
    	boolean check = false;
    	
    	for(int i = 0; i < 7; i++) {
    		if(login[i].equals(t)) {
    			check = true;
    		}
    	}
    	return check;
    }
    
    public boolean search_password(String b) {
    	boolean check = false;
    	
    	for(int i = 0; i < 7; i++) {
    		if(password[i].equals(b)) {
    			check = true;
    		}
    	}
    	return check;
    }
}

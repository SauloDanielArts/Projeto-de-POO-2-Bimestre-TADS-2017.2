package ifrn.edu.br.poo;

public class Inicio implements Login{
    private String login_operador;
    private String password;
    
    //Métodos construtores
    public Inicio() {
    	login_operador = "FULANO_DE_TAL";
    	password = "0000000-0000";
    }
    
    public Inicio(String a, String b) {
    	login_operador = a;
    	password = b;
    }
	
	public String getPassword() {
		return password;
	}

	@Override
	public String getLogin() {
		return login_operador;
	}

	@Override
	public void setPassword(String a) {
		password = a;
		
	}

	@Override
	public void setLogin(String b) {
		login_operador = b;
	}
    
}

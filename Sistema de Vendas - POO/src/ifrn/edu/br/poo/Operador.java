package ifrn.edu.br.poo;

public class Operador extends Usuario {
	private String login_operador;
    
	
	public String getPassword() {
		return super.password;
	}

	public void setPassword(String a) {
		super.password = a;
		
	}

	public String getLogin() {
		return login_operador;
	}

	public void setLogin(String b) {
		login_operador = b;
	}

}

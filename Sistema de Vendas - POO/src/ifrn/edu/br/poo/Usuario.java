package ifrn.edu.br.poo;

public abstract class Usuario implements Login{
    protected String password;
    protected boolean operador;
    
    Usuario()
    {
    	password = "00000-000";
    	operador = false;
    }
    
    Usuario(String password, boolean operador){
    	this.password = password;
    	this.operador = operador;
    }
	
	@Override
	public abstract String getPassword();

	@Override
	public abstract void setPassword(String a);
	
	public void escolheOperador() {
		operador = true;
	}
	
	public boolean getOperador() {
		return operador;
	}
   
}

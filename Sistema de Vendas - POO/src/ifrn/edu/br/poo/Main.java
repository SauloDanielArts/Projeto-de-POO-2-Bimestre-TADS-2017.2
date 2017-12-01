package ifrn.edu.br.poo;


import ifrn.edu.br.poo.Venda;
import ifrn.edu.br.poo.Cafe;
import ifrn.edu.br.poo.Laticinios;
import ifrn.edu.br.poo.Refrigerante;
import ifrn.edu.br.poo.Pao;
import ifrn.edu.br.poo.Produto;
import java.util.Scanner;
import ifrn.edu.br.poo.Login;
import ifrn.edu.br.poo.Inicio;
import ifrn.edu.br.poo.DataBank;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
	    System.out.println("       Sistema de vendas");
	    System.out.println("\n");
	    
	    //Bloco de instância e criação de objetos
	    Venda v1 = new Venda();
	    Cafe cafe = new Cafe();
	    Refrigerante refri = new Refrigerante();
	    Pao pao = new Pao();
	    Laticinios leite = new Laticinios();
	    Produto prod[] = new Produto[100];
	    boolean check = false;
	    Laticinios milk = new Laticinios();
	    Inicio inicio = new Inicio();
	    
	    //Login no sistema
	    System.out.print("Login: ");
	    String login = scan.next();
	    System.out.println("");
	    System.out.print("Password: ");
	    String password = scan.next();
	    
	    inicio.setLogin(login);
	    inicio.setPassword(password);
	    v1.setOperador(inicio.getLogin());
	    
        boolean checar_Login = checaLogin(login, password);  //Acesso ao banco de dados
	    
        if(checar_Login == true) {	
	    
	    String tipo;
	    double valor, valor_2, valor_total;
	    
	    String codigo = "010101";
	    int i = 0;
	     
	    //Processo de funcionamento do Sistema de Vendas
	    while(!codigo.equals("00000")) {      //O processo para quando recebe o codigo de barras 00000
	        System.out.println("\n         Operador: "+v1.getOperador());
	    	check = false;
	    	System.out.println("\nDigite o codigo de barras: ");
		    codigo = scan.next();
	    	
	    	if(codigo.equals("12849001") | codigo.equals("99450001982") | codigo.equals("350962135") | codigo.equals("4410238512") | codigo.equals("2011325964") | codigo.equals("7500112372") | codigo.equals("1644140194") | codigo.equals("39402012")) {
	    	    tipo = milk.getTipo(codigo);
	    		valor = milk.getValue(codigo);
	    		valor_2 = milk.taxa(valor);
	    		valor_total = valor + valor_2;
	    		
	    		milk.setTipo(tipo);     //Procura item Laticinio e coloca no atributo de Produto
	    	    milk.setValue(valor_total);   //Procura preço Laticinio e coloca no atributo de Produto
	    	    check = v1.setVenda(milk);  //Coloca o produto no registro de vendas
	    	    
	    	    if(check == true) {
	    	    	System.out.println("Registrado com sucesso!");
	    	    } else {
	    	    	System.out.println("Item não registrado!");
	    	    }
	    	    
	    	    prod[i] = v1.getVenda(i);
	    	    v1.calculaTotal(prod[i].getValue());
	    	    
	    	    System.out.println("Venda: "+prod[i].getTipo());          //Registro da venda
	    	    System.out.println("Venda: "+prod[i].getValue());
	    	    System.out.println("Total: "+v1.getTotal());
	    	}
	    	
	    	if(codigo.equals("45001284") | codigo.equals("1003748999") | codigo.equals("4481090012") | codigo.equals("190002851") | codigo.equals("2000358190")) {
	    		tipo = pao.getTipo(codigo);
	    		valor = pao.getValue(codigo);
	    		valor_2 = pao.taxa(valor);
	    		valor_total = valor + valor_2;
	    		
	    		pao.setTipo(tipo);     
	    	    pao.setValue(valor_total);   
	    	    check = v1.setVenda(pao);  //Coloca o produto no registro de vendas
	    	    
	    	    if(check == true) {
	    	    	System.out.println("Registrado com sucesso!");
	    	    } else {
	    	    	System.out.println("Item não registrado!");
	    	    }
	    	    
	    	    prod[i] = v1.getVenda(i);
	    	    v1.calculaTotal(prod[i].getValue());
	    	    
	    	    System.out.println("Venda: "+prod[i].getTipo());          //Registro da venda
	    	    System.out.println("Venda: "+prod[i].getValue());
	    	    System.out.println("Total: "+v1.getTotal());
	    	}
	    	
	    	if(codigo.equals("3992020") | codigo.equals("50010990") | codigo.equals("25720158") | codigo.equals("1003294045")) {
	    		tipo = refri.getTipo(codigo);
	    		valor = refri.getValue(codigo);
	    		valor_2 = refri.taxa(valor);
	    		valor_total = valor + valor_2;
	    		
	    		refri.setTipo(tipo);     
	    	    refri.setValue(valor_total);   
	    	    check = v1.setVenda(refri);  //Coloca o produto no registro de vendas
	    	    
	    	    if(check == true) {
	    	    	System.out.println("Registrado com sucesso!");
	    	    } else {
	    	    	System.out.println("Item não registrado!");
	    	    }
	    	    
	    	    prod[i] = v1.getVenda(i);
	    	    v1.calculaTotal(prod[i].getValue());
	    	    
	    	    System.out.println("Venda: "+prod[i].getTipo());          //Registro da venda
	    	    System.out.println("Venda: "+prod[i].getValue());
	    	    System.out.println("Total: "+v1.getTotal());
	    	}
	    	
	    	if(codigo.equals("3991820") | codigo.equals("55718291") | codigo.equals("44829102") | codigo.equals("34918201") | codigo.equals("112000129") | codigo.equals("110233918") | codigo.equals("220011883")) {
	    		tipo = cafe.getTipo(codigo);
	    		valor = cafe.getValue(codigo);
	    		valor_2 = cafe.taxa(valor);
	    		valor_total = valor + valor_2;
	    		
	    		cafe.setTipo(tipo);     
	    	    cafe.setValue(valor_total);   
	    	    check = v1.setVenda(cafe);  //Coloca o produto no registro de vendas
	    	    
	    	    if(check == true) {
	    	    	System.out.println("Registrado com sucesso!");
	    	    } else {
	    	    	System.out.println("Item não registrado!");
	    	    }
	    	    
	    	    prod[i] = v1.getVenda(i);
	    	    v1.calculaTotal(prod[i].getValue());
	    	    
	    	    System.out.println("Venda: "+prod[i].getTipo());          //Registro da venda
	    	    System.out.println("Venda: "+prod[i].getValue());
	    	    System.out.println("Total: "+v1.getTotal());
	    	}
	    	i++;
	   }
	    
	    System.out.println("\n");
	    System.out.println("Dinheiro: ");
	    double entrada = scan.nextDouble();
	    
	    if(entrada >= v1.getTotal()) {
	    	double troco = (entrada - v1.getTotal());
	    	System.out.println("Troco: "+troco);
	    }
	    
	    System.out.println("\n\n       VOLTE SEMPRE!");
      } else {
    	  System.out.println("Dados do login errados!");
      }
	}
	
	public static boolean checaLogin(String nome, String senha) {
		DataBank db = new DataBank();
		boolean check = false;
		
		for(int i = 0; i < 7; i++) {
			if(db.search_login(nome) & db.search_password(senha)) {
				 check = true;
			}
		}
		
		return check;
	}
	
}

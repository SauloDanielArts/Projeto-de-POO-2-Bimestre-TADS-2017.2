package ifrn.edu.br.poo;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Operador op = new Operador();
    	Produto p = new Produto();
    	DataBank db = new DataBank();
    	ProductBank pb = new ProductBank();
    	Venda sell = new Venda();

		
		ArrayList<Produto> produtos = new ArrayList<Produto>();
		
		int option = -1;
		
		while(option != 0) {
			System.out.println("       Sistema de vendas");
	        System.out.println("\n");
			System.out.println("1 - Login;");
			System.out.println("2 - Configurações do sistema.");
			System.out.println("0 - Sair");
			System.out.println("\n");
			System.out.print("Escolha: ");
			int choice = scan.nextInt();
			
			if(choice == 1) {           //Login
				op.escolheOperador();
		    	
		    	System.out.println("            Sistema de Vendas");
		    	System.out.println("\n");
		    	System.out.print("Login: ");
		    	String log = scan.next();
		    	System.out.println("");
		    	System.out.print("Senha: ");
		    	String password = scan.next();
		    	
		    	op.setLogin(log);
		    	op.setPassword(password);
		    	
		    	boolean check_login = db.searchLogin(op);
		    	boolean check_password = db.searchPassword(op);
		    	
		    	if(check_login & check_password) {
		    	  int choice2 = -1;
		    	  while(choice2 != 3) {
		    		  System.out.println("");
			    		System.out.println("1 - Abrir painel de vendas;");
			    		System.out.println("2 - Procurar item");
			    		System.out.println("3 - Sair");
			    		System.out.println("");
			    		System.out.println("Escolha: ");
			    		choice2 = scan.nextInt();
			    		
			    		if(choice2 == 1) {       //Abrir o painel de vendas
			    			
			    			String code = "010101";
			    			//Consertar este while
			    			while(!code.equals("00000")) {    //O processo para quando recebe o codigo de barras 00000
			    				System.out.println("");
				    			System.out.println("");
				    			System.out.println("            Painel de Vendas");
				    			System.out.println("Operador: "+op.getLogin());
				    			System.out.println("");
				    			System.out.print("\nNº de produtos: ");
				    			int num = scan.nextInt();
				    			System.out.print("Código de Barras: ");
				    			code = scan.next();
				    			if(!code.equals("00000")) {
				    				pb.diminuiQtde(code, num);
					    			p = pb.getItem(code);
					    			boolean checa = sell.setVenda(code, p);
					    			sell.calculaTotal(p.getValor());
					    			
					    			if(checa == true) {
					    				System.out.println("");
					    				System.out.println("Nome: "+p.getNome());
					    				System.out.println("Valor: "+p.getValor());
					    				System.out.println("Qtde: "+p.getQuantidade());
					    				System.out.println("Total: "+sell.getTotal());
					    			} else {
					    				System.out.println("");
					    				System.out.println("Produto não cadastrado!");
					    			}
				    			}
			    			}
			    			
			    			boolean valor_ok = false;
			    		    
			    		    System.out.println("\n");
			    		    System.out.println("Dinheiro: ");
			    		    double entrada = scan.nextDouble();
			    		    
			    		    if(entrada >= sell.getTotal()) {
			    		    	double troco = (entrada - sell.getTotal());
			    		    	System.out.println("Troco: "+troco);
			    		    	valor_ok=true;
			    		      }
			    		    else
	  	    		         {
			    		    	System.out.println("Atenção! Quantidade de dinheioro insuficiente.");
			    		    }
			    		    
			    		    System.out.println("\n\n       VOLTE SEMPRE!");
			    			

			    		} else if(choice2 == 2) {     //Procurar item
			    			
			    			String string = "01110";
			    			while(!string.equals("00000")) {
			    				System.out.println("");
				    		    System.out.println("");
				    			System.out.print("Código de barras: ");
				    			string = scan.next();
				    			p = pb.getItem(string);
				    				
				    			if(p != null) {
				    				System.out.println("");
				    				System.out.println("Nome: "+p.getNome());
				    				System.out.println("Código de barras: "+p.getCode());
				    				System.out.println("Valor: "+p.getValor());
				    				System.out.println("Quantidade: "+p.getQuantidade());
				    				System.out.println("");
				    				System.out.println("");
				    			} else {
				    			    System.out.println("");
				    				System.out.println("Produto não encontrado!");
				    				System.out.println("");
				    				System.out.println("");
				    			}
			    			}
			    			
			    		}
		    	  }	
		    	} else {
		    		System.out.println("");
		    		System.out.println("Senha ou Login errado!");
		    	}

			} else if(choice == 2) {          //Configurações
				Admin ad = new Admin();
		    	ad.operador = false;   //Nenhum objeto da classe Usuário pode ser instanciado para inicializar o construtor e tornar a variavel Operador = false;
		    	
		    	if(ad.operador == false) {
		    		System.out.println("            Sistema de Vendas - Modo Administrador");
		    		System.out.println("\n");
		    		System.out.print("Senha: ");
		    		String senha = scan.next();
		    		
		    		if(senha.equals("SauloDaniel")) {      //Implementar um banco de senhas de administrador no SQLite. Vide Obs1A.
		    			int ret = 0;
		    			
		    			while(ret == 0) {
		    				System.out.println("\n");
		        			System.out.println("1 - Criar contas para Login.");
		        			System.out.println("2 - Cadastrar produtos.");
		        			System.out.println("3 - Apagar produtos.");
		        			System.out.println("4 - Apagar conta.");  //Concertar. Não está funcionando
		        			System.out.println("5 - Sair.");
		        			System.out.println("\n");
		        			System.out.print("Escolha: ");
		        			int choice1 = scan.nextInt();
		        			
		        			if(choice1 == 1) {       //Criação de contas para Login
		                      
		          			  ret = -1;
		        			  while(ret != 0) {
		        				System.out.println("\n");
		          				
		          				System.out.println("        Criação de contas de Login");
		          				System.out.println("\n");
		          				System.out.print("Novo Login: ");
		          				String login = scan.next();
		          				op.setLogin(login);   //Cadastro de login no objeto da classe Operador
		          				System.out.println("");
		          				System.out.print("Senha: ");
		          				senha = scan.next(); //Reutilização de variável
		          				op.setPassword(senha);  //Cadastro de senha no objeto da classe Operador
		          				db.setOperator(op);  //Cadastro do objeto da classe Operador no objeto da classe DataBank
		          				boolean checkLogin, checkPassword = false;
		          				
		          				//Checagem
		          				checkLogin = db.searchLogin(op);     
		          				checkPassword = db.searchPassword(op);
		          				
		          				if(checkLogin & checkPassword) {
		          					System.out.println("Conta cadastrada com sucesso!");
		          				} else {
		          					System.out.println("Conta não cadastrada!");
		          				}
		          				
		          				System.out.println("Deseja adicionar outra conta? 1 - Sim  0 - Não");
		          				System.out.print("\nEscolha: ");
		          				ret = scan.nextInt();
		        			  }
		        			  
		        			} else if(choice1 == 2) {  //Cadastrar produtos
		                        
		        				ret = -1;
		          			    while(ret != 0) {
		          			        System.out.println("\n");
		           				 
		           				    System.out.println("         Cadastro de Produtos");
		           				    System.out.println("\n");
		           				    System.out.println("Nome do produto: ");
		           				    String name = scan.next();
		           				    System.out.println("Código de Barras: ");
		           				    String code = scan.next();
		           				    System.out.println("Valor: ");
		           				    double value = scan.nextDouble();
		           				    System.out.println("Quantidade: ");
		           				    int qtde = scan.nextInt();
		           				    Produto prod = new Produto(code, name, value, qtde);
		           				 
		           				    boolean check = pb.setItem(prod.getCode(), prod);
		           				 
		           				    if(check == true) {
		           					    System.out.println("Produto cadastrado com sucesso!");
		           				    } else {
		           					    System.out.println("Produto não cadastrado!");
		           				    }
		           				    
		           				    System.out.println("Deseja adicionar outro produto? 1 - Sim  0 - Não");
		           				    System.out.print("\nEscolha: ");
		           				    ret = scan.nextInt();
		          			    }
		        				 
		        			} else if(choice1 == 3) {   //Apagar produtos

		        				
		        				ret = -1;
		          			    while(ret != 0) {
		          			    	System.out.println("\n");
		            				System.out.println("\n");
		            				System.out.print("Digite o número do código de barras: ");
		            				String code = scan.next();
		            				boolean check = pb.apagaItem(code);
		            				System.out.println("\n");
		            				
		            				if(check == true) {
		            					System.out.println("Produto apagado.");
		            				} else {
		            					System.out.println("Produto não apagado. Tente novamente");
		            				}
		            				
		            				System.out.println("Deseja apagar outro produto? 1 - Sim  0 - Não");
		           				    System.out.print("\nEscolha: ");
		           				    ret = scan.nextInt();
		          			    }
		        				
		        				
		        			} else if(choice1 == 4) {    //Apagar conta de operador

		        				
		        				ret = -1;
		          			    while(ret != 0) {
		          			    	System.out.println("\n");
		            				System.out.println("\n");
		            				System.out.print("Digite o nome do Login: ");
		            				String login = scan.next();
		            				boolean check = db.apagaOperador(login);
		            				System.out.println("\n");
		            				
		            				if(check == true) {
		            					System.out.println("Produto apagado.");
		            				} else {
		            					System.out.println("Produto não apagado. Tente novamente.");
		            				}
		            				
		            				System.out.println("Deseja apagar outra conta? 1 - Sim  0 - Não");
		           				    System.out.print("\nEscolha: ");
		           				    ret = scan.nextInt();
		          			    }
		          			    
		        			}  else if(choice1 == 5) {
		        				ret = choice;
		        			}
		        		}
		    	    }
		    			
		    		
		    	}
			} else if(choice == 0) {
				option = choice;
			}
		}
	}
}

//OBS1A: Assim como no Sistema Operacional Windows, quando se compra o disco do Sistema, vem um número serial que ativa-o.
//Dessa forma também será o nosso sistema. Onde cada senha é dada para cada pessoa que comprar o sistema para implementar no computador de sua loja.

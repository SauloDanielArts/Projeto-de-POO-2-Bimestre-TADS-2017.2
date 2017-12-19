package ifrn.edu.br.poo;

import java.util.Scanner;

public class Main {

	private static Scanner scan;
	private static Operador operador;
	private static Produto produto;
	private static UserDataBase userDataBase;
	private static ProductDataBase productDataBase;
	private static Venda venda;

	public static void main(String[] args) {

		// interface de entrada de dados
		scan = new Scanner(System.in);

		operador = new Operador();
		produto = new Produto();
		userDataBase = new UserDataBase();
		productDataBase = new ProductDataBase();
		venda = new Venda();

		// variavel de controle de opções do menu
		int opticao = -1;

		do {
			// menu principal
			menuPrincipal();

			// trabamento de erro geral
			try {

				opticao = Integer.parseInt(scan.next());
			} catch (Exception e) {
				System.out.println("\n\n O comando não e valido.");
			}

			switch (opticao) {
			case 0:
				System.out.println("\n\n Programa finalizado.");
				break;

			case 1:

				boolean login_ok = loginUsuario();

				if (login_ok == true) {
					// menu do usuario
					menuUsuario();
				} else {
					System.out.println("\n\n Senha ou Login incoretos!");
				}

				break;

			case 2:

				// menu do administrador
				menuAdministrador();

				break;

			default:
				System.out.println("\n\n Comando adicionado não e valido");
				break;
			}

		} while (opticao != 0);

		// fechado interface de entrada de dados
		scan.close();
	}

	public static void menuPrincipal() {
		System.out.println("\n\n Sistema de vendas");
		System.out.println("\n");
		System.out.println(" 1 - Login");
		System.out.println(" 2 - Configurações do sistema");
		System.out.println(" 0 - Sair");
		System.out.println("\n");
		System.out.print(" Escolha: ");
	}

	public static boolean loginUsuario() {
		operador.escolheOperador();

		System.out.println("\n\n Sistema de Vendas");
		System.out.println("\n");
		System.out.print(" Login: ");
		String log = scan.next();
		System.out.println("");
		System.out.print(" Senha: ");
		String password = scan.next();

		operador.setLogin(log);
		operador.setPassword(password);

		boolean check_login = userDataBase.searchLogin(operador);
		boolean check_password = userDataBase.searchPassword(operador);

		return check_login && check_password;
	}

	public static boolean administradorLogin() {
		return false;
	}

	public static void menuUsuario() {
		int opticao = -1;

		do {

			// menu do usuario
			System.out.println("\n\n Sistema de vendas");
			System.out.println("\n");
			System.out.println(" Menu do Usuario:");
			System.out.println(" 1 - Abrir painel de vendas");
			System.out.println(" 2 - Procurar item");
			System.out.println(" 0 - Sair");
			System.out.println("");
			System.out.println(" Escolha: ");

			opticao = scan.nextInt();

			// Abrir o painel de vendas
			if (opticao == 1) {

				String code = "010101";

				// O processo para quando recebe o codigo de barras 00000
				while (!code.equals("00000")) {
					System.out.println("");
					System.out.println("");
					System.out.println(" Painel de Vendas");
					System.out.println(" Operador: " + operador.getLogin());
					System.out.println("");
					System.out.print("\n N� de produtos: ");

					int num = 0;

					num = scan.nextInt();

					boolean valido = true;
					do {

						scan.nextInt();

						try {

							opticao = Integer.parseInt(scan.next());
						} catch (Exception e) {
							System.out.println("\n\n Numero não e valido");
							valido = false;
						}

					} while (valido == false);

					System.out.print("\n\nC�digo de Barras: ");

					code = scan.next();
					if (!code.equals("00000")) {
						productDataBase.diminuiQtde(code, num);
						produto = productDataBase.getItem(code);
						boolean checa = venda.setVenda(code, produto);
						venda.calculaTotal(produto.getValor());

						if (checa == true) {
							System.out.println("");
							System.out.println("Nome: " + produto.getNome());
							System.out.println("Valor: " + produto.getValor());
							System.out.println("Qtde: " + produto.getQuantidade());
							System.out.println("Total: " + venda.getTotal());
						} else {
							System.out.println("");
							System.out.println("Produto n�o cadastrado!");
						}
					}
				}

				System.out.println("\n");
				System.out.println("Dinheiro: ");
				double entrada = scan.nextDouble();

				if (entrada >= venda.getTotal()) {
					double troco = (entrada - venda.getTotal());
					System.out.println("Troco: " + troco);
				} else {
					System.out.println("Aten��o! Quantidade de dinheioro insuficiente.");
				}

				System.out.println("\n\n       VOLTE SEMPRE!");

			} else if (opticao == 2) { // Procurar item

				String string = "01110";
				while (!string.equals("00000")) {
					System.out.println("");
					System.out.println("");
					System.out.print("C�digo de barras: ");
					string = scan.next();
					produto = productDataBase.getItem(string);

					if (produto != null) {
						System.out.println("");
						System.out.println("Nome: " + produto.getNome());
						System.out.println("C�digo de barras: " + produto.getCode());
						System.out.println("Valor: " + produto.getValor());
						System.out.println("Quantidade: " + produto.getQuantidade());
						System.out.println("");
						System.out.println("");
					} else {
						System.out.println("");
						System.out.println("Produto n�o encontrado!");
						System.out.println("");
						System.out.println("");
					}
				}

			}

		} while (opticao != 0);

	}

	public static void menuAdministrador() {

		Admin ad = new Admin();

		System.out.println(" Sistema de Vendas - Modo Administrador");
		System.out.println("\n");
		System.out.print(" Senha: ");
		String senha = scan.next();

		if (senha.equals("0123456789")) // senha padrão de administrador
		{
			int opticao = -1;

			do {
				System.out.println("\n");
				System.out.println(" 1 - Criar conta para novos usuarios.");
				System.out.println(" 2 - Cadastrar produtos.");
				System.out.println(" 3 - Apagar produtos.");
				System.out.println(" 4 - Apagar conta."); // Concertar. N�o est� funcionando
				System.out.println(" 0 - Sair.");
				System.out.println("\n");
				System.out.print(" Escolha: ");

				try {

					opticao = Integer.parseInt(scan.next());
				} catch (Exception e) {
					System.out.println("\n\n O comando não é valido.");
				}

				switch (opticao) 
				{
				case 0:
					System.out.println("\n\n Modo de administração foi encerado.");
					break;

				case 1: // Cria��o de contas para Login

					opticao = -1;

					do {
						System.out.println("\n");

						System.out.println("        Cria��o de contas de Login");
						System.out.println("\n");
						System.out.print("Novo Login: ");
						String login = scan.next();
						operador.setLogin(login); // Cadastro de login no objeto da classe Operador
						System.out.println("");
						System.out.print("Senha: ");
						senha = scan.next(); // Reutiliza��o de vari�vel
						operador.setPassword(senha); // Cadastro de senha no objeto da classe Operador
						userDataBase.setOperator(operador); // Cadastro do objeto da classe Operador no objeto da classe
															// DataBank
						boolean checkLogin, checkPassword = false;

						// Checagem
						checkLogin = userDataBase.searchLogin(operador);
						checkPassword = userDataBase.searchPassword(operador);

						if (checkLogin & checkPassword) {
							System.out.println("Conta cadastrada com sucesso!");
						} else {
							System.out.println("Conta n�o cadastrada!");
						}

						System.out.println("Deseja adicionar outra conta? 1 - Sim  0 - N�o");
						System.out.print("\nEscolha: ");

						try {
							opticao = Integer.parseInt(scan.next());
						} catch (Exception e) {
							System.out.println("\n\n O comando não é valido.");
						}

					} while (opticao != 0);

					break;

				case 2: // Cadastro de Produtos

					opticao = -1;
					do {
						System.out.println("\n");

						System.out.println(" Cadastro de Produtos");
						System.out.println("\n");
						System.out.println("Nome do produto: ");
						String name = scan.next();
						System.out.println("C�digo de Barras: ");
						String code = scan.next();
						System.out.println("Valor: ");
						double value = scan.nextDouble();
						System.out.println("Quantidade: ");
						int qtde = scan.nextInt();
						Produto prod = new Produto(code, name, value, qtde);

						boolean check = productDataBase.setItem(prod.getCode(), prod);

						if (check == true) {
							System.out.println("Produto cadastrado com sucesso!");
						} else {
							System.out.println("Produto n�o cadastrado!");
						}

						System.out.println("Deseja adicionar outro produto? 1 - Sim  0 - N�o");
						System.out.print("\nEscolha: ");

						try {
							opticao = Integer.parseInt(scan.next());
						} catch (Exception e) {
							System.out.println("\n\n O comando não é valido.");
						}

					} while (opticao != 0);

					break;

				case 3:

					opticao = -1;
					do {
						System.out.println("\n");
						System.out.println("\n");
						System.out.print("Digite o n�mero do c�digo de barras: ");
						String code = scan.next();
						boolean check = productDataBase.apagaItem(code);
						System.out.println("\n");

						if (check == true) {
							System.out.println("Produto apagado.");
						} else {
							System.out.println("Produto n�o apagado. Tente novamente");
						}

						System.out.println("Deseja apagar outro produto? 1 - Sim  0 - N�o");
						System.out.print("\nEscolha: ");

						try {
							opticao = Integer.parseInt(scan.next());
						} catch (Exception e) {
							System.out.println("\n\n O comando não é valido.");
						}

					} while (opticao != 0);

					break;

				case 4: // Apagar conta de operador

					opticao = -1;
					while (opticao != 0) {
						System.out.println("\n");
						System.out.println("\n");
						System.out.print(" Digite o nome do Login: ");
						String login = scan.next();
						boolean check = userDataBase.apagaOperador(login);
						System.out.println("\n");

						if (check == true) {
							System.out.println(" Produto apagado.");
						} else {
							System.out.println(" Produto n�o apagado. Tente novamente.");
						}

						System.out.println(" Deseja apagar outra conta? 1 - Sim  0 - N�o");
						System.out.print("\n Escolha: ");

						try {
							opticao = Integer.parseInt(scan.next());
						} catch (Exception e) {
							System.out.println("\n\n O comando não é valido.");
						}
					}

					break;
				}

			} while (opticao != 0);
		}
	}
}

// criar gera��o de nota fiscal

// OBS1A: Assim como no Sistema Operacional Windows, quando se compra o disco do
// Sistema, vem um n�mero serial que ativa-o.
// Dessa forma tamb�m ser� o nosso sistema. Onde cada senha � dada para cada
// pessoa que comprar o sistema para implementar no computador de sua loja.

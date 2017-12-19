package ifrn.edu.br.poo;

public class Produto {
   
   private String code;
   private String nome;
   private double valor;
   private int quantidade;
   
   Produto()
   {
	   code = "00000000";
	   nome = "VAZIO";
	   valor = 0;
	   quantidade = 0;
   }
   
   Produto(String code, String nome, double valor,int quantidade)
   {
	   this.setCode(code);
	   this.setNome(nome);
	   this.setValor(valor);
	   this.setQuantidade(quantidade);
   }

public String getCode() {
	return code;
}

public void setCode(String code) {
	this.code = code;
}

public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}

public double getValor() {
	return valor;
}

public void setValor(double valor) {
	this.valor = valor;
}

public int getQuantidade() {
	return quantidade;
}

public void setQuantidade(int quantidade) {
	this.quantidade = quantidade;
}
   
  
}
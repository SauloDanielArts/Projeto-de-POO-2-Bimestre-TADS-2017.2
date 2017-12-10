package teste;

import java.io.File;

import com.almworks.sqlite4java.SQLiteConnection;
import com.almworks.sqlite4java.SQLiteException;
import com.almworks.sqlite4java.SQLiteStatement;

public class TesteSQLite{
	  public static SQLiteConnection criarConexao() throws SQLiteException
	  {
	      SQLiteConnection conn = null;
	      conn = new SQLiteConnection(new File("pessoas.db"));
	      conn.open();
	      return conn;
	  }
	  
		public static void criarTabela() {
		      SQLiteConnection conn = null;
		      String SQL = "DROP TABLE IF EXISTS pessoas ;CREATE  TABLE pessoas("
		      + "nome VARCHAR(10),sobrenome VARCHAR(20))";
		      try {
		         conn = criarConexao();
		         conn.exec(SQL);
		      } catch (SQLiteException e) {
		         e.printStackTrace();
		      } finally {
		         conn.dispose();
		      }
		  }
		
		public static void adicionarDados() {
		       SQLiteConnection conn = null;
		       SQLiteStatement stmt = null;
		       String SQL = "INSERT INTO pessoas VALUES (?,?)";
		       try {
		           conn = criarConexao();
		           stmt = conn.prepare(SQL);
		           stmt.bind(1, "Demétrio");
		           stmt.bind(2, "Menezes Neto");
		           stmt.step();
		       } catch (SQLiteException e) {
		           e.printStackTrace();
		       } finally {
		           stmt.dispose();
		           conn.dispose();
		       }
		   }
		
		
		public static void main(String[] args) {

			criarTabela();
			adicionarDados();
			
		}
	  
	  
}
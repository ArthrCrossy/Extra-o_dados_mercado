package teste_bd;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestaConexao {
	
	public static void main(String[] args) throws SQLException {
				
		ConnectionFactory ConnectionFactory = new ConnectionFactory();
		
		Connection connection = ConnectionFactory.recuperarConexao();
		
		System.out.println("Fechando conexão hahahahaha");
		
		connection.close();
		
	}
	
}

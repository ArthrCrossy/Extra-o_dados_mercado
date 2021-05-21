package teste_bd;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionFactory {
	
	public Connection recuperarConexao() throws SQLException {
		
		return DriverManager.getConnection("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC", "root", "Galosk2013@");
		
	}
	
}

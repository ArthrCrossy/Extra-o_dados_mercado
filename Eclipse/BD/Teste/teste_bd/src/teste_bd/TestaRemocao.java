package teste_bd;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


public class TestaRemocao {
	
	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory factory = new ConnectionFactory();
		
		Connection connection = factory.recuperarConexao();
		
		//Statement stm = connection.createStatement();
		
		PreparedStatement stm = connection.prepareStatement("DELETE FROM PRODUTO WHERE ID >= ?");
		
		stm.setInt(1, 11);
		
		stm.execute();
		
		//stm.execute("DELETE FROM PRODUTO WHERE ID > 2");
		
		Integer linhasModificadas = stm.getUpdateCount();
		
		System.out.println("Quantidade de linhas que foram modificadas: " + linhasModificadas);
		
		
		
	}
	
}

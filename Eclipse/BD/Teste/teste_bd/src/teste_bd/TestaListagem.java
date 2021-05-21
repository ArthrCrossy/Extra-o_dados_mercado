package teste_bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaListagem {
	
		public static void main(String[] args) throws SQLException {
		
			
				ConnectionFactory ConnectionFactory = new ConnectionFactory();
				
				Connection connection = ConnectionFactory.recuperarConexao();
				
				
				System.out.println("Fechando conexão hahahahaha");
				
				//Statement stm = con.createStatement();
				
				PreparedStatement stm = connection.prepareStatement("SELECT ID, NOME, DESCRICAO FROM PRODUTO");
				
			
				
				stm.execute();
				
				//stm.execute("SELECT ID, NOME, DESCRICAO FROM PRODUTO");
				
				ResultSet rst = stm.getResultSet();
				
				while(rst.next()) {
					
					Integer id = rst.getInt("ID");
					
					System.out.println(id);
					
					String nome = rst.getString("NOME");
					
					System.out.println(nome);
					
					String descricao = rst.getString("DESCRICAO");
					
					System.out.println(descricao);
					
					
				}
				
				connection.close();
		
			}
	
}

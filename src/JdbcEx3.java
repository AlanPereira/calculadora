import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/* Criando um Banco de Dados
 *
 **/ 
public class JdbcEx3{
	
	
	
	public static void main(String[] arg) {
		
		
		Connection con;
		Statement st;
		
		String url = "jdbc:mysql://localhost:3306/";
		try{
			con=connectDB(url);	
			st = con.createStatement();  
			String SQL = "Create Database Julio";
			st.execute(SQL);
			/*ResultSet rs = st.executeQuery(SQL);
			 while(rs.next())
			 System.out.println(rs.getString(1));*/
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}      
		
		
	}
	
	
	private static Connection connectDB(String url) throws Exception {
		try {
			
			String user, password; 	
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			user="root";password="root";
			return DriverManager.getConnection(url,user, password);
			
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
			
		}    	
		
	}
}


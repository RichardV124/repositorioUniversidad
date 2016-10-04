package co.edu.eam.ingesoft.desarrollo.universidad.persistencia.utlidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AdministradorConexionJDBC {

	public static Connection getConexion() throws SQLException{
		//1.2 conectarse
		//del paquete java.sql
		System.out.println("Conectandose.....");
		//?autoReconnect=true&useSSL=false
	String url= "jdbc:mysql://localhost:3306/universidad";
	String user="root";
	String pass="1234";
	
	Connection con= DriverManager.getConnection(url,user,pass);
	return con;
	}
	
}

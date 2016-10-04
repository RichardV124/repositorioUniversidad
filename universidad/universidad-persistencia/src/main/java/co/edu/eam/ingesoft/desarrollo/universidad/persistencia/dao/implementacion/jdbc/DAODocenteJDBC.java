/**
 * 
 */
package co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.implementacion.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.definiciones.IDAODocente;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades.Docente;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades.Profesion;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.utlidades.AdministradorConexionJDBC;

/**
 * @author RICHARD VANEGAS
 * 
 */
public class DAODocenteJDBC implements IDAODocente {

	/**
	 * Registrar un docente en la Base de datos
	 * 
	 * @param docente, Docente a registrar           
	 */
	public void crear(Docente docente) throws Exception {

		Connection con = AdministradorConexionJDBC.getConexion();

		// Crear consulta de la tabla persona
		String sql = "INSERT INTO tb_persona (cedula_per,apellido_per,correo_per,direccion_per,"
				+ "nombre_per,telefono_per) values(?,?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, docente.getCedula());
		pstmt.setString(2, docente.getApellido());
		pstmt.setString(3, docente.getCorreo());
		pstmt.setString(4, docente.getDireccion());
		pstmt.setString(5, docente.getNombre());
		pstmt.setString(6, docente.getTelefono());

		// Ejecutar consulta de persona
		pstmt.executeUpdate();
		// Crear consulta de la tabla docente
		String sql2 = "INSERT INTO tb_docente(cedula_per,postgrado_doc,profesion_doc) values(?,?,?)";
		pstmt = con.prepareStatement(sql2);
		// Ejecutar consulta de docente
		pstmt.setString(1, docente.getCedula());
		pstmt.setBoolean(2, docente.isPostgrado());
		pstmt.setString(3, docente.getProfesion().getCodigo());
		pstmt.executeUpdate();
		
		String sql3="INSERT INTO tb_profesion(codigo_prof,nombre_prof) values(?,?)";
		pstmt = con.prepareStatement(sql3);
		// Ejecutar consulta de profesion
		pstmt.setString(1, docente.getProfesion().getCodigo());
		pstmt.setString(1, docente.getProfesion().getNombre());
		pstmt.executeUpdate();

		// 3. Cerrar la conexion
		con.close();

	}

	/**
     * Edita un docente en la Base de datos
     *
     * @param d , docente que se va a editar
	 * @throws Exception 
     */
	public void editar(Docente d) throws Exception {
		// TODO Auto-generated method stub
		 
		Connection con = AdministradorConexionJDBC.getConexion();
		String sql="UPDATE tb_persona SET apellido_per=?,correo_per=?,direccion_per=?,"
                + "nombre_per=?,telefono_per=?  WHERE cedula_per=?";
            PreparedStatement pstmt = con.prepareStatement(sql);

            pstmt.setString(6, d.getCedula());
            pstmt.setString(1, d.getApellido());
            pstmt.setString(2, d.getCorreo());
            pstmt.setString(3, d.getDireccion());
            pstmt.setString(4, d.getNombre());
            pstmt.setString(5, d.getTelefono());

            pstmt.executeUpdate();

            String sql2="UPDATE tb_docente SET postgrado_doc=?,profesion_doc=?  WHERE cedula_per=?";
            pstmt = con.prepareStatement(sql2);
            pstmt.setString(3, d.getCedula());
            pstmt.setBoolean(1, d.isPostgrado());
            pstmt.setString(2, d.getProfesion().getCodigo());

            pstmt.executeUpdate();
            con.close();

	}

	/**
	 * Elimina un docente de la base de datos
	  @param cedula, cedula del docente a eliminar 
	 * @throws SQLException 
	 */
	public void eliminar(String cedula) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = AdministradorConexionJDBC.getConexion();
		String sql = "DELETE FROM tb_docente WHERE cedula_per = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, cedula);
		pstmt.executeUpdate();

		String sql2 = "DELETE FROM TB_PERSONA WHERE cedula_per = ?";
		pstmt = con.prepareStatement(sql2);
		pstmt.setString(1, cedula);
		pstmt.executeUpdate();
		System.out.println("Se eliminó");
		con.close();

	}
	
	/**
	 * Busca un docente en la base de datos
	  @param cedula, cedula del docente a buscar
	  @return Docente, el docente que se encontro en la busqueda; o null si el docente no es encontrado 
	 */
	public Docente buscar(String cedula) throws Exception {
		// TODO Auto-generated method stub
		Connection con = AdministradorConexionJDBC.getConexion();
		String sql = "SELECT p.cedula_per,p.nombre_per, p.apellido_per,p.direccion_per,p.telefono_per,p.correo_per,"
				+ "d.postgrado_doc,d.profesion_doc,pr.nombre_prof FROM tb_persona p "
				+ "JOIN tb_docente d ON(p.cedula_per=d.cedula_per) "
				+ "JOIN tb_profesion pr ON(pr.codigo_prof=d.profesion_doc) "
				+ "WHERE p.cedula_per=?;";

		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, cedula);
		// ejecutar consulta
		ResultSet res = pstmt.executeQuery();
		// Hubo un registro...
		if (res.next()) {
			String nombre = res.getString(2);
			String apellido = res.getString(3);
			String direccion = res.getString(4);
			String telefono = res.getString(5);
			String correo = res.getString(6);
			boolean postgrado = res.getBoolean(7);
			String cod_profesion = res.getString(8);
			String nom_profesion = res.getString(9);

			Profesion profesion = new Profesion(cod_profesion, nom_profesion);

			Docente doc = new Docente(cedula, apellido, correo, direccion, nombre, telefono, postgrado, profesion);
			con.close();
			return doc;
		}

		con.close();
		return null;
	}

	public List<Docente> listarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Crea una lista(ArrayList) con las profesiones registradas en la base de datos
	 @return listar, lista de profesiones
	 */
	public ArrayList<Profesion> listarProfesion() throws Exception {

		ArrayList<Profesion> listar = new ArrayList();
		Connection con = AdministradorConexionJDBC.getConexion();
		String sql = "SELECT nombre_prof,codigo_prof FROM tb_profesion;";
		PreparedStatement pstmt = con.prepareStatement(sql);
		// ejecutar consulta
		ResultSet res = pstmt.executeQuery();
		// Hubo un registro...
		while (res.next()) {
			String nombre = res.getString(1);
			String codigo = res.getString(2);
			Profesion prof = new Profesion(codigo, nombre);
			listar.add(prof);
		}
		con.close();
		return listar;
	}
}

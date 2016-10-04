package co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.implementacion.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.definiciones.IDAOEstudiante;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades.Estudiante;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.utlidades.AdministradorConexionJDBC;

public class DAOEstudianteJDBC implements IDAOEstudiante {

	/**
	 * Registrar un estudiante en la Base de datos
	 * 
	 * @param e, Estudiante a registrar           
	 * @throws SQLException
	 */
	public void crear(Estudiante e) throws SQLException {
		Connection con = AdministradorConexionJDBC.getConexion();
		String sql = "INSERT INTO tb_persona"
				+ " (cedula_per,apellido_per,correo_per,direccion_per,"
				+ "nombre_per,telefono_per) values(?,?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, e.getCedula());
		pstmt.setString(2, (e.getApellido()));
		pstmt.setString(3, e.getCorreo());
		pstmt.setString(4, e.getDireccion());
		pstmt.setString(5, e.getNombre());
		pstmt.setString(6, e.getTelefono());
		pstmt.executeUpdate();

		String sql2 = "INSERT INTO tb_estudiante(cedula_per,fechanacimiento_est) values(?,?)";
		pstmt = con.prepareStatement(sql2);
		pstmt.setString(1, e.getCedula());
		java.sql.Date fecha = new java.sql.Date(e.getFechaNacimiento().getTime());
        pstmt.setDate(2, fecha);
		pstmt.executeUpdate();
		System.out.println("Se creo");
		con.close();

	}

	/**
	 * Busca un estudiante por la cedula en la Base de datos
	 * 
	 * @param cedula, cedula del estudiante a buscar  
	 * @return El estudiante si esta, en caso contrario null
	 * @throws SQLException
	 */

	public Estudiante buscar(String cedula) throws SQLException {

		Connection con = AdministradorConexionJDBC.getConexion();
		String sql = "SELECT p.cedula_per,p.apellido_per,p.correo_per,p.direccion_per,"
				+ "p.nombre_per,p.telefono_per,e.fechanacimiento_est FROM tb_persona p, "
				+ "tb_estudiante e WHERE p.cedula_per = e.cedula_per AND p.cedula_per = ? ";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, cedula);

		ResultSet res = pstmt.executeQuery();

		while (res.next()) {
			Estudiante estudiante = new Estudiante();
			estudiante.setCedula(res.getString(1));
			estudiante.setApellido(res.getString(2));
			estudiante.setCorreo(res.getString(3));
			estudiante.setDireccion(res.getString(4));
			estudiante.setNombre(res.getString(5));
			estudiante.setTelefono(res.getString(6));
			estudiante.setFechaNacimiento(res.getDate(7));
			con.close();
			return estudiante;
		}
		con.close();

		return null;
	}

	/**
	 * Edita un estudiante de la Base de datos
	 * 
	 * @param e, estudiante a editar
	 */
	public void editar(Estudiante e) throws SQLException {

		Connection con = AdministradorConexionJDBC.getConexion();
		String sql = "UPDATE tb_persona SET apellido_per=?,correo_per=?,direccion_per=?,"
				+ "nombre_per=?,telefono_per=?  WHERE cedula_per=?";
		PreparedStatement pstmt = con.prepareStatement(sql);

		pstmt.setString(6, e.getCedula());
		pstmt.setString(1, e.getApellido());
		pstmt.setString(2, e.getCorreo());
		pstmt.setString(3, e.getDireccion());
		pstmt.setString(4, e.getNombre());
		pstmt.setString(5, e.getTelefono());

		pstmt.executeUpdate();
		String sql2 = "UPDATE tb_estudiante SET fechanacimiento_est=?  WHERE cedula_per=?";
		pstmt = con.prepareStatement(sql2);
		java.sql.Date fecha = new java.sql.Date(e.getFechaNacimiento().getTime());
        pstmt.setDate(1, fecha);
		pstmt.setString(2, e.getCedula());

		pstmt.executeUpdate();
		System.out.println("Se edito!!");
		con.close();

	}

	public List<Estudiante> listarTodos() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Elimina un Estudiante de la base de datos
	  @param cedula, cedula del estudiante a eliminar
	 */
	public void eliminar(String cedula) throws Exception {
		// TODO Auto-generated method stub
		Connection con = AdministradorConexionJDBC.getConexion();
		String sql = "DELETE FROM tb_Estudiante WHERE cedula_per = ?";
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


}

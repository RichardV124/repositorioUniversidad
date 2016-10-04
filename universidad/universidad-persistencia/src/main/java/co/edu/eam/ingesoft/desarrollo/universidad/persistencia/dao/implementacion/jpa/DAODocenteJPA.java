package co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.implementacion.jpa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.definiciones.IDAODocente;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades.Docente;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades.Profesion;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.utlidades.AdministradorConexionJDBC;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.utlidades.AdministradorEntityManager;

/**
 * Clase responsable del DAO de docente implementacion JPA
 * 
 * @author Richard Vanegas
 * 
 */
public class DAODocenteJPA implements IDAODocente {

	public void crear(Docente docente) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = AdministradorEntityManager.getEntityManager();
		Docente d = buscar(docente.getCedula());
		if (d == null) {
			em.getTransaction().begin();

			em.persist(docente);

			em.getTransaction().commit();
		}
	}

	public void editar(Docente docente) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = AdministradorEntityManager.getEntityManager();
		em.getTransaction().begin();

		em.merge(docente);

		em.getTransaction().commit();

	}

	public void eliminar(String cedula) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = AdministradorEntityManager.getEntityManager();
		em.getTransaction().begin();
		Docente d = buscar(cedula);
		if (d != null) {
			em.remove(d);
		}
		em.getTransaction().commit();
	}

	public Docente buscar(String cedula) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = AdministradorEntityManager.getEntityManager();

		return em.find(Docente.class, cedula);
	}

	public List<Docente> listarTodos() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

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

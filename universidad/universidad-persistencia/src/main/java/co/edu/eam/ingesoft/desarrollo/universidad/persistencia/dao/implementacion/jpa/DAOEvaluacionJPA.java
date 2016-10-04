package co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.implementacion.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.dao.definiciones.IDAOEvaluacion;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades.Curso;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades.Docente;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades.Evaluacion;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.utlidades.AdministradorEntityManager;

public class DAOEvaluacionJPA implements IDAOEvaluacion{


	    public List<Evaluacion> listarPorCurso(Curso curso) throws Exception {
	    	EntityManager em = AdministradorEntityManager.getEntityManager();
	        Query query = em.createNamedQuery(Evaluacion.LISTAR_EVALUACIONES_POR_CURSO);
	        query.setParameter(1, curso.getCodigo());
	        return query.getResultList();
	    }

		public void crear(Evaluacion evaluacion) throws Exception {
			EntityManager em = AdministradorEntityManager.getEntityManager();
			Evaluacion e = buscar(evaluacion.getCodigo());
			if (e == null) {
				em.getTransaction().begin();

				em.persist(evaluacion);

				em.getTransaction().commit();
			}
			
		}


		public void editar(Evaluacion evaluacion) throws Exception {
			EntityManager em = AdministradorEntityManager.getEntityManager();
			em.getTransaction().begin();

			em.merge(evaluacion);

			em.getTransaction().commit();
		}

		public void eliminar(Evaluacion evaluacion) throws Exception {
			// TODO Auto-generated method stub
			EntityManager em = AdministradorEntityManager.getEntityManager();
			em.getTransaction().begin();
			em.remove(evaluacion);
			em.getTransaction().commit();
		}

		public Evaluacion buscar(int codigo) throws Exception {
			EntityManager em = AdministradorEntityManager.getEntityManager();

			return em.find(Evaluacion.class, codigo);
		}


}

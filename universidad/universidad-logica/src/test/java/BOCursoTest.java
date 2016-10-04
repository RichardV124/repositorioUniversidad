import java.nio.channels.AsynchronousServerSocketChannel;

import org.caferrer.testdata.junit.TestDataUtil;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import co.edu.eam.ingesoft.desarrollo.logica.bos.BOAsignatura;
import co.edu.eam.ingesoft.desarrollo.logica.bos.BOCurso;
import co.edu.eam.ingesoft.desarrollo.logica.bos.BODocente;
import co.edu.eam.ingesoft.desarrollo.logica.excepcion.ExcepcionNegocio;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades.Asignatura;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades.Curso;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades.Docente;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades.Profesion;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.entidades.SesionCurso;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.enumeraciones.DiaEnum;
import co.edu.eam.ingesoft.desarrollo.universidad.persistencia.modelo.enumeraciones.TipoAsignaturaEnum;

public class BOCursoTest {

	private BOAsignatura boAsignatura;
	private BODocente boDocente;
	private BOCurso boCurso;

	@BeforeClass
	public static void setUp(){
		TestDataUtil.ejecutarSQL("sqlTest/BOCursoTest-add.sql");
	}
	@Test
	public void crearCursoTest() {
		boAsignatura = new BOAsignatura();
		boDocente = new BODocente();
		boCurso = new BOCurso();

		try {
		Asignatura a = new Asignatura();
		a.setCodigo("1");
		a.setNombre("Calculo");
		a.setNumeroCreditos(2);
		a.setSemestre(3);
		a.setTipo(TipoAsignaturaEnum.PRACTICA);

		boAsignatura.crear(a);

		Docente d = new Docente();
		d.setApellido("Vanegas");
		d.setCedula("1");
		d.setCorreo("elcorreo@");
		d.setDireccion("calle veinte");
		d.setNombre("Richard");
		d.setPostgrado(true);
		Profesion p = new Profesion();
		p.setCodigo("1");
		p.setNombre("Quimico");
		d.setProfesion(p);
		d.setTelefono("21312312");

		
			boDocente.crear(d);

			Curso c = new Curso();
			c.setAsignatura(a);
			c.setDocente(d);
			c.setCodigo("1");

			boCurso.crear(c);

			Curso cur = boCurso.buscar("1");
			Assert.assertEquals(c.getCodigo(), cur.getCodigo());
			//Assert.assertNotNull(cur);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}

	}

	@Test
	public void crearSesionCurso(){
		try{
		SesionCurso sesion = new SesionCurso();
		sesion.setDia(DiaEnum.DOMINGO);
					Curso c = boCurso.buscar("1");
		sesion.setCurso(c);
		sesion.setHoraFinal(9);
		sesion.setHoraInicio(8);
		Assert.assertEquals(sesion.getCurso().getCodigo(), c.getCodigo());
		}catch(ExcepcionNegocio e){
			System.out.println(e.getMessage());
		}catch(Exception e){
			System.out.println("Hubo un error");
		}
	}
//	 @AfterClass
//	 public static void setDown() {
//	 TestDataUtil.ejecutarSQL("sqlTest/BOCursoTest-del.sql");
//	 }

}

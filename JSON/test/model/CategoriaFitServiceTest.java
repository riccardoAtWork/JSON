package model;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CategoriaFitServiceTest {

	private Socio socio;
	private CategoriaFit categoria;
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("TennisJpa");

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		socio = new Socio("via stretta", "paperopoli", "paolino", "00000000", "paperino", "111111", "M");
		categoria = new CategoriaFit("7777", "4.6", socio);
		socio.setCategoria(categoria);
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.persist(socio);
		em.getTransaction().commit();

	}

	@After
	public void tearDown() throws Exception {
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
	
	   // Socio found = em.find(Socio.class, socio.getId());
		Socio found = em.merge(socio);
		em.remove(found);
		em.getTransaction().commit();
	}

	@Test
	public void removeCategory() {
		EntityManager em = factory.createEntityManager();
		Socio found = em.merge(socio);
		assertNotNull(found.getCategoria());
		em.close();
		CategoriaFitService service = new CategoriaFitService();
		service.removeCat(socio.getId());
		em = factory.createEntityManager();
		found = em.find(Socio.class, found.getId()); 
		assertNull(found.getCategoria());
		em.close();
	}

}

package model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class SocioService {
	
	private SocioService(){}
	private static SocioService uniqueService = new SocioService();
	
	public static SocioService getInstance() {
		return uniqueService;
	}

  // ======================================
  // =             Attributes             =
  // ======================================

  private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("TennisJpa");
//  private EntityManager em = emf.createEntityManager();
  //private EntityTransaction tx = em.getTransaction();

  // ======================================
  // =           Public Methods           =
  // ======================================

  

	public Socio findSocio(int id) {
		EntityManager em = emf.createEntityManager();
		try {
			return em.find(Socio.class, (long) id);
		} finally {
			if (em!=null)
				em.close();
		}		
	}


}
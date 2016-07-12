package model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CategoriaFitService {

	// ======================================
	// = Attributes =
	// ======================================

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("TennisJpa");
	private EntityManager em = emf.createEntityManager();
	private EntityTransaction tx = em.getTransaction();

	// ======================================
	// = Public Methods =
	// ======================================

	public CategoriaFit createCat(String nTessera, String classifica, Socio socio) {
		CategoriaFit cat = new CategoriaFit();

		cat.setClassifica(classifica);
		cat.setNTessera(nTessera);
		cat.setSocio(socio);

		tx.begin();
		em.persist(cat);
		tx.commit();
		return cat;
	}

	public void removeCat(Socio socio) {
		CategoriaFit cat = em.find(CategoriaFit.class, socio);
		if (cat != null) {
			tx.begin();
			// socio
			em.remove(cat);
			tx.commit();
		}
	}

	public void removeCat(long idSocio) {
		EntityManager manager = emf.createEntityManager();
		try {
			manager.getTransaction().begin();
			Socio s = manager.find(Socio.class, idSocio);
			CategoriaFit cate = s.getCategoria();
			s.setCategoria(null);
			//manager.remove(cate);
			manager.getTransaction().commit();
		} finally {
			manager.close();
		}

	}

	public CategoriaFit findCat(String nTssera) {
		return em.find(CategoriaFit.class, nTssera);
	}

	public String findFromId(int id) {
		return (String) em.createNamedQuery("CategoriaFit.findFromId").setParameter("idsocio", id).getSingleResult();
	}

	// public CategoriaFit findCatbyIdSocio(int idSocio) {
	//
	// Query myQuery2 = em.createQuery("SELECT distinct p.* FROM CategoriaFit c
	// where p.businessAccount.id=:userID");
	//
	// return em.find(CategoriaFit.class, nTssera);
	// }

}
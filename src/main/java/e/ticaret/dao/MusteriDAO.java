package e.ticaret.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import e.ticaret.models.Musteri;

public class MusteriDAO implements IDAO<Musteri> {

	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistenceUnitName");
	private static EntityManager manager = factory.createEntityManager();
	
	private MusteriDAO() {}
	
	private static MusteriDAO dao;
	
	public static MusteriDAO getInstance() {
		
		if(dao == null) {
			dao = new MusteriDAO();
		}
		
		return dao;
	}
	
	@Override
	public List<Musteri> liste() {
		Query q = manager.createNamedQuery("Musteri.hepsi");
		return q.getResultList();
		
	}

	@Override
	public Musteri idIleGetir(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void ekle(Musteri obj) {
		
		
		manager.getTransaction().begin();
		
		manager.persist(obj);
		
		manager.getTransaction().commit();
		
	}

	@Override
	public void guncelle(Musteri obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sil(long id) {
		// TODO Auto-generated method stub
		
	}

	public long giris(String email, String sifre) {
		
		Query namedQuery = manager.createNamedQuery("Musteri.giris");
		namedQuery.setParameter("email", email);
		namedQuery.setParameter("sifre", sifre);
		
		return (long)namedQuery.getSingleResult();
	}
	
	
	
}

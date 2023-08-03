package e.ticaret.blo;

import e.ticaret.dao.MusteriDAO;
import e.ticaret.models.Musteri;

public class MusteriBLO {
	
	MusteriDAO dao = MusteriDAO.getInstance();
	
	public boolean giris(String email, String sifre) {
		
		long count = dao.giris(email, sifre);
		

		return count == 1;
		
	}

	public void kaydet(Musteri yeniMusteri) {
		dao.ekle(yeniMusteri);
		
	}

}

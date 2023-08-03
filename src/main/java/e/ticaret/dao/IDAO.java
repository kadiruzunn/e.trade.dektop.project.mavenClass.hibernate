package e.ticaret.dao;

import java.util.List;

public interface IDAO<T> {
	
	List<T> liste();
	T idIleGetir(long id);
	void ekle(T obj);
	void guncelle(T obj);
	void sil(long id);

}

package e.ticaret.models;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="urunler")
public class Urun  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private String ad;
	private String barkod;
	private BigDecimal fiyat;	
	
	//private List<Urun> urunler
	@ManyToMany(mappedBy="urunler")
	private List<Musteri> musteriler;
	public List<Musteri> getMusteriler() {
		return musteriler;
	}

	public void setMusteriler(List<Musteri> musteriler) {
		this.musteriler = musteriler;
	}

	public Urun() {
		// TODO Auto-generated constructor stub
	}

	public Urun(String ad, String barkod, BigDecimal fiyat) {
		
		this.ad = ad;
		this.barkod = barkod;
		this.fiyat = fiyat;
	}

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public String getBarkod() {
		return barkod;
	}

	public void setBarkod(String barkod) {
		this.barkod = barkod;
	}

	public BigDecimal getFiyat() {
		return fiyat;
	}

	public void setFiyat(BigDecimal fiyat) {
		this.fiyat = fiyat;
	}

}

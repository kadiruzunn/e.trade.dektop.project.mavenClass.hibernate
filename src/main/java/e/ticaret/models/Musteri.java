package e.ticaret.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "musteriler")
@NamedQueries({
		@NamedQuery(name = "Musteri.giris", query = "select count(m) from Musteri m where m.eMail = :email and m.sifre= :sifre"),
		@NamedQuery(name = "Musteri.hepsi", query = "select m from Musteri m") })
public class Musteri implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "e_mail", unique = true)
	private String eMail;
	private String ad;
	private String soyad;
	private LocalDate dogumTarihi;
	private String sifre;
	
	@ManyToMany
	@JoinTable( name = "musteri_urunleri", 
	joinColumns = @JoinColumn(name = "musteri_id"),	 
	inverseJoinColumns = @JoinColumn(name = "urun_id"))
	private List<Urun> urunler = new ArrayList<>();
	
	public List<Urun> getUrunler() {
		return urunler;
	}

	public void setUrunler(List<Urun> urunler) {
		this.urunler = urunler;
	}

	
	@OneToMany(mappedBy = "musteri", cascade = CascadeType.ALL)
	private List<Adres> adresler = new ArrayList<>(); 
	
	
	public List<Adres> getAdresler() {
		return adresler;
	}

	public void setAdresler(List<Adres> adresler) {
		this.adresler = adresler;
	}

	@OneToOne(cascade = CascadeType.ALL)
	private KrediKarti kart;

	public KrediKarti getKart() {
		return kart;
	}

	public void setKart(KrediKarti kart) {
		this.kart = kart;
	}

	public Musteri() {
	}

	public Musteri(String eMail, String ad, String soyad, LocalDate dogumTarihi, String sifre) {
		super();
		this.eMail = eMail;
		this.ad = ad;
		this.soyad = soyad;
		this.dogumTarihi = dogumTarihi;
		this.sifre = sifre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public String getSoyad() {
		return soyad;
	}

	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}

	public LocalDate getDogumTarihi() {
		return dogumTarihi;
	}

	public void setDogumTarihi(LocalDate dogumTarihi) {
		this.dogumTarihi = dogumTarihi;
	}

	public String getSifre() {
		return sifre;
	}

	public void setSifre(String sifre) {
		this.sifre = sifre;
	}

	@Override
	public String toString() {
		return "Musteri [id=" + id + ", eMail=" + eMail + ", ad=" + ad + ", soyad=" + soyad + ", dogumTarihi="
				+ dogumTarihi + "]";
	}

}

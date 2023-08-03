package e.ticaret.models;

import javax.persistence.*;

@Entity
public class Adres {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String sokak;
	private String mah;
	private String cadde;
	private String kapiNo;
	private short daireNo;
	private String ilce;
	private String sehir;
	
	@ManyToOne
	@JoinColumn(name="musteriler_id")
	private Musteri musteri;
	
	
	public Musteri getMusteri() {
		return musteri;
	}

	public void setMusteri(Musteri musteri) {
		this.musteri = musteri;
	}

	public String getIlce() {
		return ilce;
	}

	public void setIlce(String ilce) {
		this.ilce = ilce;
	}

	public String getSehir() {
		return sehir;
	}

	public void setSehir(String sehir) {
		this.sehir = sehir;
	}

	public Adres() {} 

	public Adres(String sokak, String mah, String cadde, String kapiNo, short daireNo) {
		super();
		this.sokak = sokak;
		this.mah = mah;
		this.cadde = cadde;
		this.kapiNo = kapiNo;
		this.daireNo = daireNo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSokak() {
		return sokak;
	}

	public void setSokak(String sokak) {
		this.sokak = sokak;
	}

	public String getMah() {
		return mah;
	}

	public void setMah(String mah) {
		this.mah = mah;
	}

	public String getCadde() {
		return cadde;
	}

	public void setCadde(String cadde) {
		this.cadde = cadde;
	}

	public String getKapiNo() {
		return kapiNo;
	}

	public void setKapiNo(String kapiNo) {
		this.kapiNo = kapiNo;
	}

	public short getDaireNo() {
		return daireNo;
	}

	public void setDaireNo(short daireNo) {
		this.daireNo = daireNo;
	}
	
	
	
	
	
	

}

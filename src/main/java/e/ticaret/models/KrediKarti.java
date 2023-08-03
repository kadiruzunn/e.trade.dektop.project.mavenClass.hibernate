package e.ticaret.models;

import javax.persistence.*;

@Entity
public class KrediKarti {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String kartNo;
	
	private String sonKullanmaAy;
	private String sonKullanmaYil;
	// private KrediKarti kart;
	@OneToOne(mappedBy ="kart", fetch=FetchType.LAZY)
	private Musteri musteri;
	
	public Musteri getMusteri() {
		return musteri;
	}

	public void setMusteri(Musteri musteri) {
		this.musteri = musteri;
	}

	private int CVV;
	
	public KrediKarti() {
		
	}

	public KrediKarti(String kartNo, String sonKullanmaAy, String sonKullanmaYil, int cVV) {
		super();
		this.kartNo = kartNo;
		this.sonKullanmaAy = sonKullanmaAy;
		this.sonKullanmaYil = sonKullanmaYil;
		CVV = cVV;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getKartNo() {
		return kartNo;
	}

	public void setKartNo(String kartNo) {
		this.kartNo = kartNo;
	}

	public String getSonKullanmaAy() {
		return sonKullanmaAy;
	}

	public void setSonKullanmaAy(String sonKullanmaAy) {
		this.sonKullanmaAy = sonKullanmaAy;
	}

	public String getSonKullanmaYil() {
		return sonKullanmaYil;
	}

	public void setSonKullanmaYil(String sonKullanmaYil) {
		this.sonKullanmaYil = sonKullanmaYil;
	}

	public int getCVV() {
		return CVV;
	}

	public void setCVV(int cVV) {
		CVV = cVV;
	}
	
	
	

}

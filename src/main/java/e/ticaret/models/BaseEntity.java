package e.ticaret.models;

import java.time.LocalDateTime;


public class BaseEntity {
	
	public BaseEntity() {
		
	}
	
	public BaseEntity(LocalDateTime eklenmeZamani, String ekleyenKullanici, LocalDateTime sonGuncellemeZamani,
			String sonGuncelleyenKullanici, byte durum, boolean aktif) {
		this.eklenmeZamani = eklenmeZamani;
		this.ekleyenKullanici = ekleyenKullanici;
		this.sonGuncellemeZamani = sonGuncellemeZamani;
		this.sonGuncelleyenKullanici = sonGuncelleyenKullanici;
		this.durum = durum;
		this.aktif = aktif;
	}



	private int id;

	public LocalDateTime getEklenmeZamani() {
		return eklenmeZamani;
	}

	public void setEklenmeZamani(LocalDateTime eklenmeZamani) {
		this.eklenmeZamani = eklenmeZamani;
	}

	public String getEkleyenKullanici() {
		return ekleyenKullanici;
	}

	public void setEkleyenKullanici(String ekleyenKullanici) {
		this.ekleyenKullanici = ekleyenKullanici;
	}

	public LocalDateTime getSonGuncellemeZamani() {
		return sonGuncellemeZamani;
	}

	public void setSonGuncellemeZamani(LocalDateTime sonGuncellemeZamani) {
		this.sonGuncellemeZamani = sonGuncellemeZamani;
	}

	public String getSonGuncelleyenKullanici() {
		return sonGuncelleyenKullanici;
	}

	public void setSonGuncelleyenKullanici(String sonGuncelleyenKullanici) {
		this.sonGuncelleyenKullanici = sonGuncelleyenKullanici;
	}

	public byte getDurum() {
		return durum;
	}

	public void setDurum(byte durum) {
		this.durum = durum;
	}

	public boolean isAktif() {
		return aktif;
	}

	public void setAktif(boolean aktif) {
		this.aktif = aktif;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	private LocalDateTime eklenmeZamani;
	private String ekleyenKullanici;
	private LocalDateTime sonGuncellemeZamani;
	private String sonGuncelleyenKullanici;
	private byte durum; // �art de�il
	private boolean aktif;
	
}

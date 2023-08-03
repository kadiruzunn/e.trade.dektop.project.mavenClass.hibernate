package e.ticaret.ui;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import e.ticaret.models.Adres;
import e.ticaret.models.KrediKarti;
import e.ticaret.models.Musteri;
import e.ticaret.models.Urun;

public class TestCreate {
	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistenceUnitName");
		EntityManager manager = factory.createEntityManager();

		Musteri musteri_1 = new Musteri("ali@gmail.com", "Ali", "Veli", LocalDate.parse("2000-02-03"), "123456");


		KrediKarti kart = new KrediKarti();
		kart.setCVV(111);
		kart.setKartNo("1234 4567 8974");
		kart.setSonKullanmaAy("01");
		kart.setSonKullanmaYil("2025");

		Adres adres_1 = new Adres("sokak", "mah", "cadde", "35B", (short) 4);
		Adres adres_2 = new Adres("sokak2", "mah2", "cadde2", "235B", (short) 8);

		musteri_1.setKart(kart);

		Urun u1 = new Urun("pc", "123242", BigDecimal.valueOf(1000.98));
		Urun u2 = new Urun("laptop", "9987466", BigDecimal.valueOf(25691.12));

		musteri_1.setUrunler(Arrays.asList(u1, u2));

		u1.setMusteriler(Arrays.asList(musteri_1));
		u2.setMusteriler(Arrays.asList(musteri_1));

		musteri_1.setAdresler(Arrays.asList(adres_1, adres_2));

		manager.getTransaction().begin();

		manager.persist(u1);
		manager.persist(u2);

		manager.persist(musteri_1); 

		adres_1.setMusteri(musteri_1);
		adres_2.setMusteri(musteri_1);

		manager.getTransaction().commit();

		Musteri oMusteri = manager.find(Musteri.class, 1);
		System.out.println(oMusteri);

		oMusteri.setSifre("987654");

		manager.getTransaction().begin();

		manager.getTransaction().commit();

		System.out.println(oMusteri);

		Musteri aMusteri = manager.getReference(Musteri.class, 1);

		Scanner input = new Scanner(System.in);

		System.out.println("email : ");

		String email = input.next();

		System.out.println("�ifre : ");

		String sifre = input.next();

		Query namedQuery = manager.createNamedQuery("Musteri.giris");
		namedQuery.setParameter("email", email);
		namedQuery.setParameter("sifre", sifre);

		long musteriCount = (long) namedQuery.getSingleResult();

		if (musteriCount == 1) {
			System.out.println("ho� geldiniz");
		} else if (musteriCount != 1) {
			System.out.println("e-mail ve/veya �ifre hatal�!");
		}

	}

	private static void satinAl(KrediKarti kart) {
		System.out.println(kart.getKartNo());

		System.out.println(kart.getMusteri());
	}
}

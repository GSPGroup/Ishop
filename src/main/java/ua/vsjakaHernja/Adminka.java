/*package ua.vsjakaHernja;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ua.entity.Hdd;
import ua.entity.Komputer;
import ua.entity.OpticalDrive;
import ua.entity.Ram;
import ua.entity.TypeProcessor;
import ua.entity.VideoAdapter;
import ua.entity.—oreProcessor;

public class Adminka {
	private final static Scanner SC = new Scanner(System.in);

	public void menu() {

		boolean isRun = true;

		while (isRun) {
			System.out.println("Enter 1 to add zapchast");
			System.out.println("Enter 2 to add computer");
			System.out.println("Enter 0 to nazad");

			switch (SC.nextInt()) {
			case 1: {

				boolean isRun1 = true;

				while (isRun1) {
					System.out.println("Enter 1 to add —oreProcessor");
					System.out.println("Enter 2 to add Hdd");
					System.out.println("Enter 3 to add Ram");
					System.out.println("Enter 4 to add TypeProcessor");
					System.out.println("Enter 5 to add VideoAdapter");
					System.out.println("Enter 0 to nazad");

					switch (SC.nextInt()) {
					case 1: {
						add—oreProcessor();
						break;
					}
					case 2: {
						addHdd();
						break;
					}
					case 3: {
						addRam();
						break;
					}
					case 4: {
						addTypeProcessor();
						break;
					}
					case 5: {
						addVideoAdapter();
						break;
					}
					case 0: {
						isRun = false;
						break;
					}
					default: {
						System.out.println("“Ë ¯Ó „ÓÌ≥¯ ‚‚Ë‰Ë Ì‡Ï‡Î¸ÌÓ!!!");
						break;
					}
					}
				}
				break;
			}
			case 2: {
				addComp();
				break;
			}
			case 0: {
				isRun = false;
				break;
			}
			default: {
				System.out.println("“Ë ¯Ó „ÓÌ≥¯ ‚‚Ë‰Ë Ì‡Ï‡Î¸ÌÓ!!!");
				System.out.println();
				break;
			}
			}
		}
	}

	public static —oreProcessor add—oreProcessor() {

		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("primary");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();

		System.out.println("Enter core processor");
		—oreProcessor coreprocessor = new —oreProcessor();
		coreprocessor.setCore(SC.nextInt());
		em.persist(coreprocessor);

		em.getTransaction().commit();
		em.close();
		factory.close();
		return coreprocessor;

	}

	public static Hdd addHdd() {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("primary");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();

		System.out.println("Enter Hdd GB");
		Hdd hdd = new Hdd();
		hdd.setHddGb(SC.nextInt());
		em.persist(hdd);

		em.getTransaction().commit();
		em.close();
		factory.close();
		return hdd;
	}

	public static Ram addRam() {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("primary");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();

		System.out.println("Enter Ram GB");
		Ram ram = new Ram();
		ram.setRamGb(SC.nextInt());
		em.persist(ram);

		em.getTransaction().commit();
		em.close();
		factory.close();
		return ram;

	}

	public static TypeProcessor addTypeProcessor() {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("primary");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();

		System.out.println("Enter Type Processor");
		TypeProcessor typeprocessor = new TypeProcessor();
		typeprocessor.setName(SC.next());
		em.persist(typeprocessor);

		em.getTransaction().commit();
		em.close();
		factory.close();
		return typeprocessor;

	}

	public static VideoAdapter addVideoAdapter() {

		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("primary");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();

		System.out.println("Enter Video Adapter");
		VideoAdapter videoadapter = new VideoAdapter();
		videoadapter.setName(SC.next());
		em.persist(videoadapter);
		em.getTransaction().commit();
		em.close();
		factory.close();
		return videoadapter;

	}

	public static void addComp() {

		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("primary");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();

		Komputer komputer222 = new Komputer();
//		System.out.println("Enter core processor");
//		—oreProcessor coreprocessor = new —oreProcessor();
//		coreprocessor.setCore(SC.nextInt());
//		komputer222.setCoreprocessor(coreprocessor);
//		em.persist(coreprocessor);

		System.out.println("Enter Hdd GB");
		Hdd hdd = new Hdd();
		hdd.setHddGb(SC.nextInt());
		komputer222.setHdd(hdd);
		em.persist(hdd);

		System.out.println("Enter Ram GB");
		Ram ram = new Ram();
		ram.setRamGb(SC.nextInt());
		komputer222.setRam(ram);
		em.persist(ram);

//		System.out.println("Enter Type Processor");
//		TypeProcessor typeprocessor = new TypeProcessor();
//		typeprocessor.setName(SC.next());
//		komputer222.setTypeprocessor(typeprocessor);
//		em.persist(typeprocessor);

		System.out.println("Enter Video Adapter");
		VideoAdapter videoadapter = new VideoAdapter();
		videoadapter.setName(SC.next());
		komputer222.setVideoadapter(videoadapter);
		em.persist(videoadapter);



		System.out.println("Enter price komputer$");
		komputer222.setPrice(SC.nextInt());
		em.persist(komputer222);

		em.getTransaction().commit();
		em.close();
		factory.close();

	}

}
*/
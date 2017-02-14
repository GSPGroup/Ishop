/*package ua.vsjakaHernja;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ua.entity.VideoAdapter;

public class FilterSql {

	private final static Scanner SC = new Scanner(System.in);

	public void menu() {

		boolean isRun = true;

		while (isRun) {
			System.out.println("Enter 1 to вибірка всієї таблиці");
			System.out.println("Enter 2 to вибірка тільки строчки в якої ід =1  ");
			System.out.println("Enter 3 to вибірка рядків в яких назва починається на NVIDIA% ");
			System.out.println("Enter 4 to вибірка рядків в яких назва починається на NVIDIA% і тільки строчки в якої ід =1 ");
			System.out.println("Enter 5 to вибірка рядків в яких назва починається на NVIDIA% і тільки строчки в якої ід =1,2,4");
			System.out.println("Enter 6 to посортувати по алфавіту і вивести з 3 по 4 рядки  ");
			System.out.println("Enter 7 to вибрати або AMD% і ід=7, 2, 4 або  NVIDIA% і ід=7, 4, 5");
			System.out.println("Enter 8 to вивести з бази з 2 по 5 рядок ");
			System.out.println("Enter 0 to nazad");

			switch (SC.nextInt()) {
			case 1: {
				Enter1();
				break;
			}
			case 2: {
				Enter2();
				break;
			}
			case 3: {
				Enter3();
				break;
			}
			case 4: {
				Enter4();
				break;
			}
			case 5: {
				Enter5();
				break;
			}
			case 6: {
				Enter6();
				break;
			}
			case 7: {
				Enter7();
				break;
			}
			case 8: {
				Enter8();
				break;
			}
			case 0: {
				isRun = false;
				break;
			}
			default: {
				System.out.println("Ти шо гоніш ввиди нармально!!!");
				System.out.println();
				break;
			}
			}
		}
	}

	public void Enter1() {

		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("primary");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();

		List<VideoAdapter> videoadapters = em.createQuery(
				"SELECT t FROM VideoAdapter t", VideoAdapter.class)
				.getResultList();
		for (VideoAdapter va : videoadapters) {
			System.out.println(va.getId() + " " + va.getName());
		}

		em.getTransaction().commit();
		em.close();
		factory.close();
	}
	

	public void Enter2() {

		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("primary");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();

		List<VideoAdapter> videoadapters = em
				.createQuery(
						"SELECT t FROM VideoAdapter  " + "t where t.id=:id",
						VideoAdapter.class).setParameter("id", 1)
				.getResultList();
		for (VideoAdapter va : videoadapters) {
			System.out.println(va.getId() + " " + va.getName());
		}

		em.getTransaction().commit();
		em.close();
		factory.close();
	}

	public void Enter3() {

		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("primary");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();

		List<VideoAdapter> videoadapters = em
				.createQuery(
						"SELECT t FROM VideoAdapter  t where t.name like :name",
						VideoAdapter.class).setParameter("name", "NVIDIA%")
				.getResultList();
		for (VideoAdapter va : videoadapters) {
			System.out.println(va.getId() + " " + va.getName());
		}

		em.getTransaction().commit();
		em.close();
		factory.close();
	}

	public void Enter4() {

		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("primary");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();

		List<VideoAdapter> videoadapters = em
				.createQuery(
						"SELECT t FROM VideoAdapter  t where (t.name like :name and t.id=:id) ",
						VideoAdapter.class).setParameter("name", "NVIDIA%")
				.setParameter("id", 1).getResultList();
		for (VideoAdapter va : videoadapters) {
			System.out.println(va.getId() + " " + va.getName());
		}

		em.getTransaction().commit();
		em.close();
		factory.close();
	}
	
	public void Enter5() {

		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("primary");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();

		List<VideoAdapter> videoadapters = em
				.createQuery(
						"SELECT t FROM VideoAdapter  t where (t.name like :name and t.id in (:id)) ",
						VideoAdapter.class).setParameter("name", "NVIDIA%")
				.setParameter("id", Arrays.asList(1, 2, 4)).getResultList();
		for (VideoAdapter va : videoadapters) {
			System.out.println(va.getId() + " " + va.getName());
		}

		em.getTransaction().commit();
		em.close();
		factory.close();
	}
	
	public void Enter6() {

		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("primary");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();

		List<VideoAdapter> videoadapters = em
				.createQuery(
						"SELECT t FROM VideoAdapter t order by t.name asc ",
						VideoAdapter.class).setFirstResult(3).setMaxResults(4)
				.getResultList();
		for (VideoAdapter va : videoadapters) {
			System.out.println(va.getId() + " " + va.getName());
		}

		em.getTransaction().commit();
		em.close();
		factory.close();
	}
	
	public void Enter7() {

		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("primary");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();

		List<VideoAdapter> videoadapters = em
				.createQuery(
						"SELECT t FROM VideoAdapter  t where "
						+ "(t.name like :name and t.id in (:id) )or "
						+ "(t.name like :name1 and t.id in (:id1) ) ",
						VideoAdapter.class).setParameter("name", "AMD%")
				.setParameter("id", Arrays.asList(7, 2, 4))
				.setParameter("name1", "NVIDIA%")
				.setParameter("id1", Arrays.asList(7, 4, 5)).getResultList();
		for (VideoAdapter va : videoadapters) {
			System.out.println(va.getId() + " " + va.getName());
		}

		em.getTransaction().commit();
		em.close();
		factory.close();
	}
	
	public void Enter8() {

		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("primary");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();

		List<VideoAdapter> videoadapters = em.createQuery(
				"SELECT t FROM VideoAdapter  t where t between 2 and 5   ",
				VideoAdapter.class).getResultList();
		for (VideoAdapter va : videoadapters) {
			System.out.println(va.getId() + " " + va.getName());
		}

		em.getTransaction().commit();
		em.close();
		factory.close();
	}

 
}
*/
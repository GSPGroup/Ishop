/*package ua.vsjakaHernja;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import ua.entity.Komputer;
import ua.entity.VideoAdapter;
import ua.entity.СoreProcessor;

public class NewSqlZaputu {

	private final static Scanner SC = new Scanner(System.in);

	public void menu() {

		boolean isRun = true;

		while (isRun) {
			System.out.println("Enter 1 to вибірка всієї таблиці");
			System.out
					.println("Enter 2 to вибірка тільки строчки в якої ід =1  ");
			System.out
					.println("Enter 3 to вибірка рядків в яких назва починається на NVIDIA% ");
			System.out
					.println("Enter 4 to вибірка рядків в яких назва починається на NVIDIA% і тільки строчки в якої ід =1 ");
			
			System.out.println("Enter 5 to компютери");
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

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<VideoAdapter> cq = cb.createQuery(VideoAdapter.class);
		Root<VideoAdapter> root = cq.from(VideoAdapter.class);
		cq.select(root);

		Predicate eq = cb.equal(root.get("id"), 3); // вибрати одне
													// значення
		// select * from recept
		// where id_recept=1;
		cq.where(eq); // обовязкове поле where
		List<VideoAdapter> va = em.createQuery(cq).getResultList();
		for (VideoAdapter videoAdapter : va) {
			System.out.println(videoAdapter.getName());
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

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<VideoAdapter> cq = cb.createQuery(VideoAdapter.class);
		Root<VideoAdapter> root = cq.from(VideoAdapter.class);
		cq.select(root);

		Predicate in = root.get("id").in(Arrays.asList(2, 4)); // вибрати
																// декілька
																// значеннь
																// select * from
																// recept where
																// chas in (30,
																// 40 , 120);
		cq.where(in); // обовязкове поле where
		List<VideoAdapter> va = em.createQuery(cq).getResultList();
		for (VideoAdapter videoAdapter : va) {
			System.out.println(videoAdapter.getName());
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

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<VideoAdapter> cq = cb.createQuery(VideoAdapter.class);
		Root<VideoAdapter> root = cq.from(VideoAdapter.class);
		cq.select(root);

		Expression<Integer> exp = root.get("id");
		Predicate be = cb.between(exp, 3, 6); // вибірка по id які мають
												// значення від 4 до 10 select *
												// from recept where id_recept
												// between 4 and 10;
		cq.where(be); // обовязкове поле where
		List<VideoAdapter> va = em.createQuery(cq).getResultList();
		for (VideoAdapter videoAdapter : va) {
			System.out.println(videoAdapter.getName());
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

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Komputer> cq = cb.createQuery(Komputer.class);
		Root<Komputer> root = cq.from(Komputer.class);
		cq.select(root);

		Join<Komputer, СoreProcessor> kompcore = root.join("coreprocessor");
		Expression<Integer> exp = kompcore.get("core");
		Predicate ko = cb.greaterThan(exp, 7);
		cq.where(ko);

		List<Komputer> kom = em.createQuery(cq).getResultList();
		for (Komputer komputer : kom) {
			System.out.println(komputer.getId());
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

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Komputer> cq = cb.createQuery(Komputer.class);
		Root<Komputer> root = cq.from(Komputer.class);
		cq.select(root);

//		Join<Komputer, Procesor> kompcore = root.join("procesor");
		// Expression<Integer> exp = kompcore.get("coreprocessor");
		// Path<Object> exp1 = kompcore.get("typeprocessor");

		// Predicate ko = cb.greaterThan(exp, 7);
		// cq.where(ko);

		List<Komputer> kom = em.createQuery(cq).getResultList();
		for (Komputer komputer : kom) {
			System.out.println(komputer.getId() + "  "
					+ komputer.getProcessor().getCoreprocessor().getCore()
					+ "  "
					+ komputer.getProcessor().getTypeprocessor().getName()+ "  "
					+ komputer.getPrice()
					);
		}

		em.getTransaction().commit();
		em.close();
		factory.close();

	}

}*/
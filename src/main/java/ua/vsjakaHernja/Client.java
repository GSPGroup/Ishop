/*package ua.vsjakaHernja;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ua.entity.Hdd;
import ua.entity.Komputer;
import ua.entity.Processor;
import ua.entity.Ram;
import ua.entity.TypeProcessor;
import ua.entity.User;
import ua.entity.VideoAdapter;
import ua.entity.ÑoreProcessor;

public class Client {
	private final static Scanner SC = new Scanner(System.in);

	// private final static Korzina KORZINA = new Korzina();

	public void menuclienta() {

		boolean isRun2 = true;

		while (isRun2) {
			System.out.println("Enter 1 to add user");
			System.out.println("Enter 2 to vier user");
			System.out.println("Enter 3 to pokazatu zapchasti");

			System.out.println("Enter 0 to nazad");

			switch (SC.nextInt()) {
			case 1: {
				addname();
				break;
			}
			case 2: {
				PokazayuUser();
				break;
			}
			case 3: {
				boolean isRun = true;

				while (isRun) {
					System.out.println("Enter 1 to pokazatu CoreProcessor");
					System.out.println("Enter 2 to pokazatu Hdd");
					System.out.println("Enter 3 to pokazatu Ram");
					System.out.println("Enter 4 to pokazatu TypeProcessor");
					System.out.println("Enter 5 to pokazatu VideoAdapter");
					System.out.println("Enter 6 to pokazatu PokazayuProcesoru");
					System.out.println("Enter 0 to nazad");
					
					switch (SC.nextInt()) {
					case 1: {
						PokazayuCoreProcessor1();
						break;
					}
					case 2: {
						PokazayuHdd1();
						break;
					}
					case 3: {
						PokazaytuRam1();
						break;
					}
					case 4: {
						PokazayuTypeProcessor1();
						break;
					}
					case 5: {
						PokazatuVideoAdapter1();
						break;
					}
					case 6: {
						PokazayuProcesoru();
						break;
					}
					case 0: {
						isRun = false;
						break;
					}
					default: {
						System.out.println("Òè øî ãîí³ø ââèäè íàðìàëüíî!!!");
						System.out.println();
						break;
					}
					}
				}
				break;
			}

			default: {
				isRun2 = false;
				break;
			}
			}
		}
	}

	public void PokazayuCoreProcessor1() {// good
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("primary");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();

		List<ÑoreProcessor> coreprocessors = em.createQuery(
				"SELECT w FROM ÑoreProcessor w", ÑoreProcessor.class)
				.getResultList();
		for (ÑoreProcessor coreproc : coreprocessors) {
			System.out.println(coreproc.getId() + " " + coreproc.getCore());
		}

		em.getTransaction().commit();
		em.close();
		factory.close();

	}

	public void PokazayuProcesoru() {// good
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("primary");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();

		List<Processor> processors = em.createQuery("SELECT w FROM Procesor w",
				Processor.class).getResultList();
		for (Processor proc : processors) {
			System.out.println(proc.getId() + " " + proc.getCoreprocessor()
					+ " " + proc.getTypeprocessor());
		}

		em.getTransaction().commit();
		em.close();
		factory.close();

	}

	public void PokazayuHdd1() {// good
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("primary");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();

		List<Hdd> hdds = em.createQuery("SELECT q FROM Hdd q", Hdd.class)
				.getResultList();
		for (Hdd hdidi : hdds) {
			System.out.println(hdidi.getId() + " " + hdidi.getHddGb());
		}

		em.getTransaction().commit();
		em.close();
		factory.close();

	}

	public void PokazaytuRam1() {// good
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("primary");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();

		List<Ram> rams = em.createQuery("SELECT e FROM Ram e", Ram.class)
				.getResultList();
		for (Ram rami : rams) {
			System.out.println(rami.getId() + " " + rami.getRamGb());
		}

		em.getTransaction().commit();
		em.close();
		factory.close();

	}

	public void PokazayuTypeProcessor1() {// good
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("primary");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin(); // êîíåêòèòèñü äî áàçè

		List<TypeProcessor> typeprocecors = em.createQuery(
				"SELECT r FROM TypeProcessor r", TypeProcessor.class)
				.getResultList();
		for (TypeProcessor tp : typeprocecors) {
			System.out.println(tp.getId() + " " + tp.getName());
		}

		em.getTransaction().commit();
		em.close();
		factory.close(); // ðîç³ðâàòè çâÿçîê ç áàçîþ

	}

	public void PokazatuVideoAdapter1() {// good
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

	public void PokazayuKomputeru1() {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("primary");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();

		List<Komputer> komputers = em.createQuery("SELECT y FROM Komputer y",
				Komputer.class).getResultList();
		for (Komputer computer : komputers) {
			System.out.println(computer.getId() + " " + computer.getPrice()
					+ " " + computer.getProcessor() + " " + computer.getHdd()
					+ " " + computer.getRam() + " "
					+ computer.getVideoadapter());
		}

		em.getTransaction().commit();
		em.close();
		factory.close();
	}

	public static User addname() {

		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("primary");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();

		System.out.println("Enter your name");
		User user = new User();
		user.setName(SC.next());

		System.out.println("Enter id komputera");

		List<Komputer> kom = em.createQuery("SELECT t FROM Komputer t",
				Komputer.class).getResultList();
		for (Komputer komputer : kom) {
			System.out.println(komputer.getId() + "  "
					+ komputer.getProcessor().getCoreprocessor().getCore()
					+ "  "
					+ komputer.getProcessor().getTypeprocessor().getName()
					+ "  " + komputer.getPrice());
		}
		int a = SC.nextInt();
		user.setKomputer(kom.get(a));

		List<Komputer> komputers = em
				.createQuery("SELECT y FROM Komputer y where y.id=:id",
						Komputer.class).setParameter("id", a).getResultList();
		for (Komputer computer : komputers) {
			System.out.println(a = computer.getPrice());
		}
		user.setPrice(a);
		em.persist(user);
		em.getTransaction().commit();
		em.close();
		factory.close();
		return user;

	}
	
	public void PokazayuUser() {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("primary");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();

		List<User> user = em.createQuery("SELECT y FROM User y",
				User.class).getResultList();
		for (User users : user) {
			System.out.println( users.getName()+ "  " +users.getPrice()+ "Ãðí  " );
			System.out.println( " ïðîöåñîð:  "+ users.getKomputer().getProcessor().getTypeprocessor().getName() + users.getKomputer().getProcessor().getCoreprocessor().getCore()+" ßäåð  " );
			System.out.println( " Â³äåîêàðòà: " + users.getKomputer().getVideoadapter().getName());
			System.out.println( " îïåðàòèâêè " + users.getKomputer().getRam().getRamGb()+" Gb  ");
			System.out.println( " ÕÀÐÄ " + users.getKomputer().getHdd().getHddGb()+" Gb  "+ "  " +users.getKomputer().getHdd().getTypeHdd());
			System.out.println();
		}
		System.out.println();
		em.getTransaction().commit();
		em.close();
		factory.close();
	}

}
*/
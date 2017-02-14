//package ua.vsjakaHernja;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//
//import ua.entity.Hdd;
//import ua.entity.Komputer;
//import ua.entity.OpticalDrive;
//import ua.entity.Processor;
//import ua.entity.Ram;
//import ua.entity.TypeHdd;
//import ua.entity.TypeProcessor;
//import ua.entity.VideoAdapter;
//import ua.entity.СoreProcessor;
//
//public class NapovnenjaBazu {
//
//	public void Nbazu() {
//
//		EntityManagerFactory factory = Persistence
//				.createEntityManagerFactory("primary");
//		EntityManager em = factory.createEntityManager();
//		em.getTransaction().begin();
//
// 
//
//		// початок кількість ядер процесора
//		СoreProcessor coreprocessor = new СoreProcessor();
//		coreprocessor.setCore(2);
//		em.persist(coreprocessor);
//
//		СoreProcessor coreprocessor1 = new СoreProcessor();
//		coreprocessor1.setCore(4);
//		em.persist(coreprocessor1);
//
//		СoreProcessor coreprocessor2 = new СoreProcessor();
//		coreprocessor2.setCore(6);
//		em.persist(coreprocessor2);
//
//		СoreProcessor coreprocessor3 = new СoreProcessor();
//		coreprocessor3.setCore(8);
//		em.persist(coreprocessor3);
//		// кінець кількість ядер процесора
//
//		// початок харда
//		Hdd hdd = new Hdd();
//		hdd.setHddGb(320);
//		hdd.setTypeHdd(TypeHdd.SSD);
//		em.persist(hdd);
//
//		Hdd hdd1 = new Hdd();
//		hdd1.setHddGb(500);
//		hdd1.setTypeHdd(TypeHdd.HDD);
//		em.persist(hdd1);
//
//		Hdd hdd2 = new Hdd();
//		hdd2.setHddGb(1000);
//		hdd2.setTypeHdd(TypeHdd.SSD);
//		em.persist(hdd2);
//
//		Hdd hdd3 = new Hdd();
//		hdd3.setHddGb(2000);
//		hdd3.setTypeHdd(TypeHdd.HDD);
//		em.persist(hdd3);
//
//		Hdd hdd4 = new Hdd();
//		hdd4.setHddGb(3000);
//		hdd4.setTypeHdd(TypeHdd.SSD);
//		em.persist(hdd4);
//		
//		Hdd hdd5 = new Hdd();
//		hdd5.setTypeHdd(TypeHdd.HDD);
//		hdd5.setHddGb(3000);
//		em.persist(hdd5);
//		
//		Hdd hdd6 = new Hdd();
//		hdd6.setTypeHdd(TypeHdd.SSD);
//		hdd6.setHddGb(128);
//		em.persist(hdd6);
//		// кінець харда
//
//
//
//		// кінець оптичного привода
//
//		// початок типу процесора
//		TypeProcessor typeprocessor = new TypeProcessor();
//		typeprocessor.setName("Intel Core i7");
//		em.persist(typeprocessor);
//
//		TypeProcessor typeprocessor1 = new TypeProcessor();
//		typeprocessor1.setName("Intel Core i5");
//		em.persist(typeprocessor1);
//
//		TypeProcessor typeprocessor2 = new TypeProcessor();
//		typeprocessor2.setName("Intel Core i3");
//		em.persist(typeprocessor2);
//
//		TypeProcessor typeprocessor3 = new TypeProcessor();
//		typeprocessor3.setName("Intel Pentium");
//		em.persist(typeprocessor3);
//
//		TypeProcessor typeprocessor4 = new TypeProcessor();
//		typeprocessor4.setName("Intel Celeron");
//		em.persist(typeprocessor4);
//
//		TypeProcessor typeprocessor5 = new TypeProcessor();
//		typeprocessor5.setName("AMD");
//		em.persist(typeprocessor5);
//
//		// кінець типу процесора
//
//		// початок відеоадаптера
//
//		VideoAdapter videoadapter = new VideoAdapter();
//		videoadapter.setName("NVIDIA GeForce GTX TITAN");
//		em.persist(videoadapter);
//
//		VideoAdapter videoadapter1 = new VideoAdapter();
//		videoadapter1.setName("NVIDIA GeForce GTX 1080, 1070");
//		em.persist(videoadapter1);
//
//		VideoAdapter videoadapter2 = new VideoAdapter();
//		videoadapter2.setName("NVIDIA GeForce GTX 980 (Ti), 970");
//		em.persist(videoadapter2);
//
//		VideoAdapter videoadapter3 = new VideoAdapter();
//		videoadapter3.setName("NVIDIA GeForce GTX 960, 760");
//		em.persist(videoadapter3);
//
//		VideoAdapter videoadapter4 = new VideoAdapter();
//		videoadapter4.setName("AMD Radeon Fury (X), Nano");
//		em.persist(videoadapter4);
//
//		VideoAdapter videoadapter5 = new VideoAdapter();
//		videoadapter5.setName("AMD Radeon R9 390 (X), 290 (X)");
//		em.persist(videoadapter5);
//
//		VideoAdapter videoadapter6 = new VideoAdapter();
//		videoadapter6.setName("AMD Radeon R9 380 (X), 280 (X)");
//		em.persist(videoadapter6);
//
//		VideoAdapter videoadapter7 = new VideoAdapter();
//		videoadapter7.setName("NVIDIA Quadro");
//		em.persist(videoadapter7);
//
//		// кінець відеоадаптера
//
//		// початок оперативки
//
//		Ram ram = new Ram();
//		ram.setRamGb(2);
//		em.persist(ram);
//
//		Ram ram1 = new Ram();
//		ram1.setRamGb(4);
//		em.persist(ram1);
//
//		Ram ram2 = new Ram();
//		ram2.setRamGb(8);
//		em.persist(ram2);
//
//		Ram ram3 = new Ram();
//		ram3.setRamGb(16);
//		em.persist(ram3);
//
//		Ram ram4 = new Ram();
//		ram4.setRamGb(32);
//		em.persist(ram4);
//
//		// кінець оперативки
//
//		
//		Processor processor = new Processor();
//		processor.setCoreprocessor(coreprocessor1);
//		processor.setTypeprocessor(typeprocessor5);
//		em.persist(processor);
//		
//		Processor processor1 = new Processor();
//		processor1.setCoreprocessor(coreprocessor2);
//		processor1.setTypeprocessor(typeprocessor2);
//		em.persist(processor1);
//		
//		Processor processor2 = new Processor();
//		processor2.setCoreprocessor(coreprocessor3);
//		processor2.setTypeprocessor(typeprocessor3);
//		em.persist(processor2);
//		
//		Processor processor3 = new Processor();
//		processor3.setCoreprocessor(coreprocessor);
//		processor3.setTypeprocessor(typeprocessor4);
//		em.persist(processor3);
//		// початок цілий компютер
//
//		Komputer komputer1 = new Komputer();
//		komputer1.setProcessor(processor); 
//		komputer1.setHdd(hdd1);
//		komputer1.setOpticaldrive(opticaldrive1);
//		komputer1.setRam(ram1);
//		komputer1.setVideoadapter(videoadapter1);
//		komputer1.setPrice(2000);
//		em.persist(komputer1);
//
//		Komputer komputer2 = new Komputer();
//		komputer2.setHdd(hdd2);
//		komputer2.setOpticaldrive(opticaldrive);
//		komputer2.setRam(ram2);
//		komputer2.setProcessor(processor1);
//		komputer2.setVideoadapter(videoadapter2);
//		komputer2.setPrice(3000);
//		em.persist(komputer2);
//
//		Komputer komputer3 = new Komputer();
//		komputer3.setHdd(hdd3);
//		komputer3.setOpticaldrive(opticaldrive);
//		komputer3.setRam(ram3);
//		komputer3.setProcessor(processor2);
//		komputer3.setVideoadapter(videoadapter3);
//		komputer3.setPrice(4000);
//		em.persist(komputer3);
//
//		Komputer komputer4 = new Komputer();
//		komputer4.setHdd(hdd4);
//		komputer4.setOpticaldrive(opticaldrive1);
//		komputer4.setRam(ram4);
//		komputer4.setProcessor(processor2);;
//		komputer4.setVideoadapter(videoadapter4);
//		komputer4.setPrice(5000);
//		em.persist(komputer4);
//
//		// початок цілий компютер
//
//		// розірвати звязок з базою
//		em.getTransaction().commit();
//		em.close();
//		factory.close();
//	}
//
//}

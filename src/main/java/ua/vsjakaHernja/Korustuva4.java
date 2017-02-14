/*package ua.vsjakaHernja;

import java.util.Scanner;

public class Korustuva4 {
	private final static Scanner SC = new Scanner(System.in);
	private final static Adminka ADMINKA = new Adminka();
	private final static Client CLIENT = new Client();
	private final static FilterSql FILTERSQL = new FilterSql();
	private final static NewSqlZaputu NEWSQLZAPUTU = new NewSqlZaputu();
	private final static NapovnenjaBazu NAPOVNENJABAZU = new NapovnenjaBazu();
	

	public void Korustyvach() {
		
		boolean isRun = true;

		while (isRun) {
			System.out.println("Enter 1 to admin");
			System.out.println("Enter 2 to client");
			System.out.println("Enter 3 to filter");
			System.out.println("Enter 4 to Java SQL zaputu");
			System.out.println("Enter 5 to napovnenja bazu");
			
			System.out.println("Enter 0 to exit");

			switch (SC.nextInt()) {
			case 1: {
				ADMINKA.menu();
				break;
			}
			case 2: {
				CLIENT.menuclienta();
				break;
			}
			case 3: {
				FILTERSQL.menu();
				break;
			}
			case 4: {
				NEWSQLZAPUTU.menu();
				break;
			}
			case 5: {
				NAPOVNENJABAZU.Nbazu();;
				break;
			}
			default: {
				isRun = false;
				break;
			}
			}
		}
	}
}
*/
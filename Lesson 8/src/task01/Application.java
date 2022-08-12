package task01;

import java.util.Scanner;

public class Application {

	static void menu() {
		System.out.println("Enter 1 to check if there is such a month.");
		System.out.println("Enter 2 to display all months with the same time of year.");
		System.out.println("Enter 3 to dispay all months that have the same number of days.");
		System.out.println("Enter 4 to display all months that have fewer days.");
		System.out.println("Enter 5 to display all months that have the most days.");
		System.out.println("Enter 6 to display next season.");
		System.out.println("Enter 7 to display previous season.");
		System.out.println("Enter 8 to display all months that have an even number of days.");
		System.out.println("Enter 9 to display all months that have an odd number of days.");
		System.out.println("Enter 10 to display whether the month entered from the console has an even number of days.");

	}

	public static void main(String[] args) {

		Months[] monthArr = Months.values();
		Seasons[] seasonArr = Seasons.values();
		Scanner sc = new Scanner(System.in);

		while (true) {
			menu();

			switch (sc.next()) {

			case "1": {

				System.out.println("Enter month");
				sc = new Scanner(System.in);
				String month = sc.next().toUpperCase();

				boolean flag = isMonthPresent(monthArr, month);

				if (!flag) {
					System.out.println("Month doesnt exist");
				}
				break;
			}

			case "2": {
				System.out.println("Enter season");
				sc = new Scanner(System.in);
				String month = sc.next().toUpperCase();

				boolean flag = false;

				for (Months m : monthArr) {
					if (m.getSeasons().name().equals(month)) {
						flag = true;
					}
				}

				if (flag) {

					for (Months m2 : monthArr) {
						if (m2.getSeasons().toString().equalsIgnoreCase(month)) {
							System.out.println(m2);
						}
					}
				}
				if (!flag) {
					System.out.println("Season doesn't exist");
				}

				break;
			}

			case "3": {
				System.out.println("Enter number 28 , 30 or 31");
				sc = new Scanner(System.in);
				int m1 = sc.nextInt();

				boolean flag = false;

				for (Months m2 : monthArr) {
					if (m2.getDays() == m1) {
						System.out.println(m2);
						flag = true;
					}
				}
				if (!flag) {
					System.out.println("Month doesn't exist");
				}

				break;
			}

			case "4": {
				System.out.println("All months that have fewer days.");
				for (Months m : monthArr) {
					if (m.getDays() < 31) {
						System.out.println(m + " has " + m.getDays() + " days");
					}
				}
				break;
			}

			case "5": {
				System.out.println("All months that have the most days.");
				for (Months m : monthArr) {
					if (m.getDays() > 30) {
						System.out.println(m + " has " + m.getDays() + " days");
					}
				}
				break;
			}

			case "6": {
				System.out.println("Enter season");
				sc = new Scanner(System.in);
				String season = sc.next().toUpperCase();

				boolean flag = isSeasonPresent(seasonArr, season);

				if (flag) {
					Seasons s = Seasons.valueOf(season);
					int ordinal = s.ordinal();

					if (ordinal == seasonArr.length - 1) {
						ordinal = 0;
						System.out.println(seasonArr[ordinal]);
					} else {
						System.out.println(seasonArr[ordinal + 1]);
					}
				}
				if (!flag) {
					System.out.println("Season doesn't exist");
				}

				break;

			}

			case "7": {
				System.out.println("Enter season");
				sc = new Scanner(System.in);
				String season = sc.next().toUpperCase();

				boolean flag = isSeasonPresent(seasonArr, season);

				if (flag) {
					Seasons s = Seasons.valueOf(season);
					int ordinal = s.ordinal();

					if (ordinal == 0) {
						ordinal = (seasonArr.length - 1);
						System.out.println(seasonArr[ordinal]);
					} else {
						System.out.println(seasonArr[ordinal - 1]);
					}
				}
				if (!flag) {
					System.out.println("Season doesn't exist");
				}

				break;
			}

			case "8": {
				System.out.println("All months that have an even number of days.");
				for (Months m : monthArr) {
					if (m.getDays() % 2 == 0) {
						System.out.println(m + " has " + m.getDays() + " days");
					}

				}
				break;
			}

			case "9": {
				System.out.println("All months that have an odd number of days.");
				for (Months m : monthArr) {
					if (m.getDays() % 2 == 1) {
						System.out.println(m + " has " + m.getDays() + " days");
					}

				}
				break;
			}

			case "10": {
				System.out.println("Enter month");
				sc = new Scanner(System.in);
				String month = sc.next().toUpperCase();

				boolean flag = false;

				for (Months ma : monthArr) {
					if (ma.name().equals(month))
						flag = true;
				}

				if (flag) {
					Months m = Months.valueOf(month);

					if (m.getDays() % 2 == 0) {
						System.out.println(m + " has even number of days");
					} else {
						System.out.println(m + " has odd number of days");
					}
				}
				if (!flag) {
					System.out.println("Month doesn't exist");
				}
			}
			}

		}

	}

	private static boolean isSeasonPresent(Seasons[] seasonArr, String season) {
		boolean flag = false;

		for (Seasons s : seasonArr) {
			if (s.name().equals(season)) {
				flag = true;
			}
		}
		return flag;
	}

	private static boolean isMonthPresent(Months[] mas, String month) {
		boolean flag = false;

		for (Months m : mas) {
			if (m.name().equals(month)) {
				System.out.println("Month exist");
				flag = true;
			}
		}
		return flag;
	}
}
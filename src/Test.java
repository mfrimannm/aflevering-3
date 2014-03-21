import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = 0;
		num = getNumberBetwen(scan, 0, 9);
		System.out.println(num);

	}

	// private static int getNumberBetwen(Scanner scan, int controlLow,
	// int controlHigh) {
	// int num = 5;
	// System.out.println(controlHigh);
	// while (num <= controlHigh && num >= controlLow) {
	// while (!scan.hasNextInt()) {
	// scan.nextLine();
	// System.out.println("Du skal intaste et heltal mellem 1 og 9");
	// }
	// idoi= scan.nextInt();
	// if(idoi>)
	// if (!scan.hasNextInt()) {
	// scan.nextLine();
	// System.out.println("Du skal intaste et heltal mellem 1 og 9");
	// }
	// num = scan.nextInt();
	// }
	// return num;
	// }

	public static int getNumberBetwen(Scanner scan, int controlLow,	int controlHigh) {
		int num = 0;

		System.out.println("Indtaste et heltal mellem 1 og 9");
		while (true) {
			while (!scan.hasNextInt()) {
				scan.nextLine();
				System.out.println("Du skal intaste et heltal mellem 1 og 9");
			}
			num = scan.nextInt();

			if (num >= controlLow && num <= controlHigh) {
				break;
			} else {
				System.out.println("Du skal intaste et heltal mellem 1 og 9");
			}
		}
		return num;
	}
}

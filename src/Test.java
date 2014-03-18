import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = 0;
		num = getNumberBetwen(scan, 0, 9);
		System.out.println(num);
	}
	
		private static int getNumberBetwen(Scanner scan, int controlLow,
				int controlHigh) {
			int num = 5;
			System.out.println(controlHigh);
			while (num < controlHigh && num > controlLow) {
//				while (!scan.hasNextInt()) {
//					scan.nextLine();
//					System.out.println("Du skal intaste et heltal mellem 1 og 9");
//				}
				if (!scan.hasNextInt()) {
					scan.nextLine();
					System.out.println("Du skal intaste et heltal mellem 1 og 9");
				}
			}num = scan.nextInt();

			return num;
		}

}

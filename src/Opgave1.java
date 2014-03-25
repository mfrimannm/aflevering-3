import java.util.Scanner;

public class Opgave1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		long num = 1;
		while (num > 0) {
			System.out.print("Enter integer greater than 1 (0 to terminate): ");
			num = getNumberPositive(scan);
			if (num == 0) {
				System.out.println("Program afsluttet");
				break;
			}
			long timebefore = System.currentTimeMillis();
			String primeFactors = PrimeFactors(num);
			long timeafter = System.currentTimeMillis();
			long timeTaken = timeafter - timebefore;
			double seconds = timeTaken / 1000.0;
			System.out.println(primeFactors);
			System.out.println("It took " + seconds	+ " sec to do the calculation");
		}
		scan.close();
	}

	private static String PrimeFactors(long num) {
		String primeFactors = "";

		if (num == 1) {
			primeFactors = "1 har ingen primfaktorisering";
			return primeFactors;
		}
		long i = 2;
		while (num != 1) {
			if ((num % i) == 0) {
				primeFactors += i;
				num = num / i;
				if (num != 1) {
					primeFactors += ", ";
				}
			} else {
				i++;
				if (i == ((long) Math.sqrt(num) + 1)) {
					primeFactors += num;
					break;
				}
			}
		}
		return "List of prime factors: " + primeFactors;
	}

	private static long getNumberPositive(Scanner scan) {
		long num = 0;
		while (true) {
			while (!scan.hasNextLong()) {
				scan.nextLine();
				System.out.println("Du skal indtaste et positivt heltal mindre end 2^63");
			}
			num = scan.nextLong();
			scan.nextLine(); // clear console
			if (num >= 0) {
				break;
			} else {
				System.out.println("Du skal indtaste et positivt heltal mindre end 2^63");
			}
		}
		return num;
	}
}

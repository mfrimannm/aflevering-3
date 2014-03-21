// denne kunne hvis den skulle være bedre have en liste over alle primtal

import java.sql.Timestamp;
import java.util.Date;
import java.util.Scanner;

public class Opgave1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		long num = 1;
		while (num > 0) {
			System.out.print("Enter integer greater than 1 (0 to terminate): ");
			num = getNumber(scan);
			if (num == 0) {
				System.out.println("Program afsluttet");
				break;
			}
			long timebefore = System.currentTimeMillis();
			String primeFactors = PrimeFactors(num);
			long timeafter = System.currentTimeMillis();
			long timeTaken = timeafter - timebefore;
			double seconds = timeTaken / 1000.00000000000;
			System.out.println("List of prime factors: " + primeFactors);
			System.out.println("It took " + seconds
					+ " sec to do the caluation");
		}
		scan.close();
	}

	private static String PrimeFactors(long num) {
		String primeFactors = "";

		if (num == 1) {
			primeFactors = "1";
			System.out.println(1);
			return primeFactors;
		}
		long i = 2;

		long limitToWhenYouKnowItIsAPrime = (long) Math.sqrt(num);
		// dette er ikke godt da math.sqrt ikke tager long og derfor laver overflow

		while (num != 1) {
			if ((num % i) == 0) {
				primeFactors += i;
				num = num / i;
				if (num != 1) {
					primeFactors += ", ";
				}
			} else {
				i++;
				if (i == limitToWhenYouKnowItIsAPrime) {
					primeFactors += num;
					break;
			}
		}
		}
		return primeFactors;
	}

	private static long getNumber(Scanner scan) {
		long num = -1;
		while (!scan.hasNextLong()) {
			scan.nextLine();
			System.out.println("Du skal intaste et heltal");
		}
		num = scan.nextLong();
		return num;
	}
}

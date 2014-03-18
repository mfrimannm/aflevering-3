// denne kunne hvis den skulle være bedre have en liste over alle primtal

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
			String primeFactors = PrimeFactors(num);
			System.out.println("List of prime factors: " + primeFactors);
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
		while (num != 1) {
			if ((num % i) == 0) {
				primeFactors += i;
				num = num / i;
				if (num != 1) {
					primeFactors += ", ";
				}
			} else {
				i++;
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

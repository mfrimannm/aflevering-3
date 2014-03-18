import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Opgave1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanConsole = new Scanner(System.in);
		int[] primeFactors = PrimeFactors();
		System.out.println(primeFactors.toString());
		scanConsole.close();
	}

	private static int[] PrimeFactors() {
		// TODO Auto-generated method stub
		return null;
	}

	private static int getNumber(Scanner scan) {
		int num = -1;
		while (!scan.hasNextInt()) {
			scan.nextLine();
			System.out.println("Du skal intaste et heltal");
		}
		num = scan.nextInt();

		return num;
	}


	private static void createAndUpdateListWithData() {
		
		modtag liste
		
		lav ny liste med ny data
		
		retuner den ny liste
		
	}

	private static int[] listOfPrimes() throws FileNotFoundException{
		File primz = new File("primz");
		Scanner scanFile = new Scanner(primz);
		while(scanFile.hasNext()){
			
		}
		int[] listOfPrimes = new int[1];
		scanFile.close();
		return listOfPrimes;
	}






}

import java.util.Scanner;

public class Opgave2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int size = 1;
		while (size > 0) {
			System.out.print("Enter size of grid (0 to terminate): ");
			size = getNumberPositive(scan);
			if (size == 0) {
				System.out.println("Program afsluttet");
				break;
			}
			StdDraw.clear();
			randomWalk(size);
		}
		scan.close();
	}

	private static void randomWalk(int size) {
		int min = -size;
		int max = size;
		StdDraw.setXscale(min, max);
		StdDraw.setYscale(min, max);
		System.out.println("Size of grid from (" + min + "," + min + ") to (" + max + "," + max + ")");
		drawGrid(min, max, size);
		
		// starter gang
		StdDraw.setPenColor(StdDraw.BLUE);
		StdDraw.setPenRadius(2.0 / 400.0);
		int x = 0;
		int y = 0;
		int count = 0;
		System.out.println("Beginning random walk");
		StdDraw.point(x, y);
		System.out.println("Position at step " + count + " = (" + x + "," + y + ")");
		while (x <= max && x >= min && y <= max && y >= min) {
			int direction = (int) (Math.random() * 4);
			if (direction == 0) {
				x++;
			} else if (direction == 1) {
				x--;
			} else if (direction == 2) {
				y++;
			} else if (direction == 3) {
				y--;
			}
			count++;
			System.out.println("Position at step " + count + " = (" + x + "," + y + ")");
			StdDraw.point(x, y);
		}
		System.out.println("Total number of steps = " + count);
	}

	private static void drawGrid(int min, int max, int size) {
		// tegner omkres
		StdDraw.setPenRadius(6.0 / 2000);
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.square(0, 0, max + 1);

		// De to for loops tegner de små firkanter.
		if (size < 100) {
			StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
			StdDraw.setPenRadius(2.0 / 2000);

			for (int i = min; i <= max; i++) {
				StdDraw.line(i, max, i, min);
			}
			for (int i = min; i <= max; i++) {
				StdDraw.line(max, i, min, i);
			}
		}
	}

	private static int getNumberPositive(Scanner scan) {
		int num = 0;
		while (true) {
			while (!scan.hasNextInt()) {
				scan.nextLine();
				System.out.println("Du skal indtaste et positivt heltal (maks. 2^31-1)");
			}
			num = scan.nextInt();
			scan.nextLine(); // Så den kun tager en værdi fra consolen af
							 // gangen og ikke bare gemmen resten til næste
							 // omgang
			if (num >= 0) {
				break;
			} else {
				System.out.println("Du skal indtaste et positivt heltal (maks. 2^31-1)");
			}
		}
		return num;
	}
}

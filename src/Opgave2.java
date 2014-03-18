import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;

public class Opgave2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int size = 1;

		while (size > 0) {
			System.out.print("Enter size of grid (0 to terminate): ");
			size = getNumber(scan);
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
		// TODO Auto-generated method stub
		int min = -size;
		int max = size;
		StdDraw.setXscale(min, max);
		StdDraw.setYscale(min, max);
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.setPenRadius(2.0 / 1000);
		StdDraw.square(0, 0, max);
		int x = 0;
		int y = 0;
		System.out.println("Position = (" + x + "," + y + ")");
		int count = 0;
		while (x < max && x > min && y < max && y > min) {
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
			System.out.println("Position = (" + x + "," + y + ")");

			StdDraw.point(x, y);

			count++;
		}
		System.out.println(count);
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

}

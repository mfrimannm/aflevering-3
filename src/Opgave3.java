import java.util.Arrays;
import java.util.Scanner;

public class Opgave3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		startGame(scan);
		System.out.println("and here");

		scan.close();
	}

	private static void startGame(Scanner scan) {
		// TODO Auto-generated method stub
		System.out.print("hvor stor bane ønsker de? ");
		int size = getNumber(scan);
		drawTrack(size);

		// place of car
		int[] xOldAndNewStop = new int[3];
		int[] yOldAndNew = new int[2];

		yOldAndNew[1] = yStartkoordinate(yOldAndNew, size);
		yOldAndNew[0] = yOldAndNew[1];

		runCar(scan, size, xOldAndNewStop, yOldAndNew);
		System.out.println("was here");
	}

	private static int yStartkoordinate(int[] yOldAndNew, int size) {
		// TODO Auto-generated method stub
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.setPenRadius(20.0 / 800);

		int midt = (int) (((double)size / 2) + ((double)size / 4));

		StdDraw.point(0, midt);
		return (int) (midt);
	}

	private static void runCar(Scanner scan, int size, int[] xOldAndNewStop,
			int[] yOldAndNew) {
		// TODO Auto-generated method stub
		int direction = 1;
		// int controlLow = 0;
		// int controlHigh = 9;

		while (direction >= 0) {
			System.out
					.print("Enter integer greater than 0 to choose direction (0 to terminate): ");
			// direction = getNumberBetwen(scan, controlLow, controlHigh);
			direction = getNumber(scan);

			System.out.println(direction + "her");
			if (direction == 0) {
				System.out.println("Program afsluttet");
				break;
			}
			direction = driveCar(direction, size, xOldAndNewStop, yOldAndNew);
			if (direction == 0) {
				System.out.println("Program afsluttet");
				break;
			}
			System.out.println(direction + "måske her");

		}
	}

	private static int driveCar(int direction, int size, int[] xOldAndNewStop,
			int[] yOldAndNew) {
		xOldAndNewStop = getNewKoordinateX(direction, xOldAndNewStop); // arbejder
																		// med x
																		// koordinat
		yOldAndNew = getNewKoordinateY(direction, yOldAndNew); // arbejder med y
																// koordinat

		drawDrivenLine(xOldAndNewStop, yOldAndNew);
		

		xOldAndNewStop[0] = xOldAndNewStop[1];
		yOldAndNew[0] = yOldAndNew[1];

		if (xOldAndNewStop[2] == 1
				|| outOfTrack(xOldAndNewStop[1], yOldAndNew[1], size)) {
			System.out.println("røg ind");
			return direction = 0;
		}
		System.out.println("er her");
		return direction = 1;
	}

	private static int[] getNewKoordinateY(int direction, int[] yOldAndNew) {

		if (direction == 0) {
			return yOldAndNew;
		} else if (direction == 1) {
			yOldAndNew[1]++;
			return yOldAndNew;
		} else if (direction == 2) {
			yOldAndNew[1]--;
			return yOldAndNew;
		} else if (direction == 3) {
			yOldAndNew[1]--;
			return yOldAndNew;
		} else if (direction == 4) {
			return yOldAndNew;
		} else if (direction == 5) {
			return yOldAndNew;
		} else if (direction == 6) {
			return yOldAndNew;
		} else if (direction == 7) {
			yOldAndNew[1]++;
			return yOldAndNew;
		} else if (direction == 8) {
			yOldAndNew[1]++;
			return yOldAndNew;
		} else {
			yOldAndNew[1]++;
			return yOldAndNew;
		}
	}

	private static int[] getNewKoordinateX(int direction, int[] xOldAndNewStop) {

		if (direction == 0) {
			xOldAndNewStop[2] = 1;
			return xOldAndNewStop;
		} else if (direction == 1) {
			xOldAndNewStop[1]--;
			return xOldAndNewStop;
		} else if (direction == 2) {
			return xOldAndNewStop;
		} else if (direction == 3) {
			xOldAndNewStop[1]++;
			return xOldAndNewStop;
		} else if (direction == 4) {
			xOldAndNewStop[1]--;
			return xOldAndNewStop;
		} else if (direction == 5) {
			return xOldAndNewStop;
		} else if (direction == 6) {
			xOldAndNewStop[1]++;
			return xOldAndNewStop;
		} else if (direction == 7) {
			xOldAndNewStop[1]--;
			return xOldAndNewStop;
		} else if (direction == 8) {
			return xOldAndNewStop;
		} else {
			xOldAndNewStop[1]++;
			return xOldAndNewStop;
		}
	}

	private static void drawDrivenLine(int[] xOldAndNewStop, int[] yOldAndNew) {
		StdDraw.setPenRadius(6.0 / 800);
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.line(xOldAndNewStop[0], yOldAndNew[0], xOldAndNewStop[1],
				yOldAndNew[1]);
	}

	private static boolean outOfTrack(int xOld, int yOld, int size) {
		// Tjekker om den er inde eller uden for banen
		// hvis ude retunerer true
		int min = -size;
		int max = size;
		System.out.println(min/2);
		System.out.println(max/2);
		System.out.println(xOld);
		System.out.println(yOld);

		// ydre ring
		if ((xOld <= max && xOld >= min 
				&& yOld <= max && yOld >= min)) {
			return false;
		}
		// indre ring
		if (((xOld >= (max/2)) && (xOld <= (min/2)) 
				|| yOld >= (max/2)) && yOld <= (min/2)){
			return false;

		}
		return true;
	}

	private static void drawTrack(int size) {
		int min = -size;
		int max = size;
		StdDraw.setXscale(min, max);
		StdDraw.setYscale(min, max);
		// tegner omkres
		StdDraw.setPenRadius(6.0 / 800);
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.square(0, 0, max);
		// tegner vejen
		StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
		StdDraw.filledSquare(0, 0, max);
		// tegner inderkreds
		StdDraw.setPenRadius(6.0 / 800);
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.square(0, 0, max / 2);
		// De to for loops tegner de små firkanter.
		StdDraw.setPenRadius(2.0 / 1000);
		StdDraw.setPenColor(StdDraw.BLACK);
		for (int i = min; i <= max; i++) {
			StdDraw.line(i, max, i, min);
		}
		for (int i = min; i <= max; i++) {
			StdDraw.line(max, i, min, i);
		}
		// tegner hvid firkant
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.filledSquare(0, 0, max / 2);
		// tegner start linje
		StdDraw.setPenRadius(6.0 / 800);
		StdDraw.setPenColor(StdDraw.GREEN);
		StdDraw.line(0, max / 2, 0, max);

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

	// private static int getNumberBetwen(Scanner scan, int controlLow,
	// int controlHigh) {
	// int num = 5;
	// System.out.println(controlHigh);
	// while (num < controlHigh && num > controlLow) {
	// while (!scan.hasNextInt()) {
	// scan.nextLine();
	// System.out.println("Du skal intaste et heltal mellem 1 og 9");
	// }
	// num = scan.nextInt();
	// }
	// return num;
	// }
}

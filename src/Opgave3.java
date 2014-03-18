import java.util.Scanner;

public class Opgave3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		startGame(scan);

		scan.close();
	}

	private static void startGame(Scanner scan) {
		// TODO Auto-generated method stub
		System.out.print("hvor stor bane ønsker de? ");
		int size = getNumber(scan);
		drawTrack(size);

		placeCarAndStartRun(scan, size);

	}

	private static void placeCarAndStartRun(Scanner scan, int size) {
		// TODO Auto-generated method stub
		int direction = 1;
		int controlLow = 0;
		int controlHigh = 9;

		while (direction > 0) {
			System.out
					.print("Enter integer greater than 0 to choose direction (0 to terminate): ");
			direction = getNumberBetwen(scan, controlLow, controlHigh);
			if (direction == 0) {
				System.out.println("Program afsluttet");
				break;
			}
			direction = driveCar(direction, size);
		}
	}

	private static int driveCar(int direction, int size) {
		// place of car
		int[] xOldAndNewStop = new int[3];
		int[] yOldAndNew = new int[2];

		xOldAndNewStop[3] = 0; // denne stopper spillet hvis den er 1

		xOldAndNewStop = getNewKoordinateX(direction, xOldAndNewStop); // arbejder
																		// med x
																		// koordinat
		yOldAndNew = getNewKoordinateY(direction, yOldAndNew); // arbejder med y
																// koordinat

		drawDrivenLine(xOldAndNewStop, yOldAndNew);
		
		xOldAndNewStop[0] = xOldAndNewStop[1];
		yOldAndNew[0] = yOldAndNew[1];

		if (xOldAndNewStop[3] == 1
				|| outOfTrack(xOldAndNewStop[1], yOldAndNew[1], size)) {
			return direction = 0;
		}
		return direction = 1;
	}

	private static int[] getNewKoordinateY(int direction, int[] yOldAndNew) {

		if (direction == 0) {
			return yOldAndNew;
		} else if (direction == 1) {
			yOldAndNew[1]--;
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
		StdDraw.line(xOldAndNewStop[0], yOldAndNew[0], xOldAndNewStop[1], yOldAndNew[1]);
	}

	private static boolean outOfTrack(int xOldAndNew, int yOldAndNew, int size) {
		// Tjekker om den er inde eller uden for banen
		// hvis ude retunerer true
		int min = -size;
		int max = size;

		if ((xOldAndNew < max && xOldAndNew > min && yOldAndNew < max && yOldAndNew > min)) {
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

	private static int getNumberBetwen(Scanner scan, int controlLow,
			int controlHigh) {
		int num = 5;
		while (num < controlHigh && num > controlLow) {
			while (!scan.hasNextInt()) {
				scan.nextLine();
				System.out.println("Du skal intaste et heltal mellem 1 og 9");
			}
			num = scan.nextInt();
		}

		return num;
	}
}

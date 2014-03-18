public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StdDraw.setXscale(-1, 1);
		StdDraw.setYscale(-1, 1);
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.filledSquare(0, 0, 1);
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.line(0, 0, 1, 0);
		StdDraw.setPenRadius(1.0 / 200);
		int n = 10;
		for (int i = 0; i < n * 2 * Math.PI; i++) {
			StdDraw.point(Math.cos(i / (double) n), Math.sin(i / (double) n));
		}
	}

}

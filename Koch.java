/** Draws the Koch curve and the the Koch snowflake fractal. */
public class Koch {

	public static void main(String[] args) {

		//// Uncomment the first code block to test the curve function.
		//// Uncomment the second code block to test the snowflake function.
		//// Uncomment only one block in each test, and remember to compile
		//// the class whenever you change the test.

        
		// Tests the curve function:
		// Gets n, x1, y1, x2, y2,
		// and draws a Koch curve of depth n from (x1,y1) to (x2,y2).
		/*curve(Integer.parseInt(args[0]),
			  Double.parseDouble(args[1]), Double.parseDouble(args[2]), 
		      Double.parseDouble(args[3]), Double.parseDouble(args[4]));
		*/

		
		// Tests the snowflake function:
		// Gets n, and draws a Koch snowflake of n edges in the standard canvass.
		snowFlake(Integer.parseInt(args[0]));
		
	}

	/** Gets n, x1, y1, x2, y2,
     *  and draws a Koch curve of depth n from (x1,y1) to (x2,y2). */
	public static void curve(int n, double x1, double y1, double x2, double y2) {
		if (n == 0) {
            StdDraw.line(x1, y1, x2, y2);
            return;
        }
		double ax = (2.0 * x1 + x2) / 3.0;
        double ay = (2.0 * y1 + y2) / 3.0;

        double bx = (x1 + 2.0 * x2) / 3.0;
        double by = (y1 + 2.0 * y2) / 3.0;

		double px= (Math.sqrt(3) / 2.0) * (ay - by) + 0.5 * (ax + bx);
		double py = (Math.sqrt(3) / 2.0) * (bx - ax) + 0.5 * (ay + by);

		curve(n - 1, x1, y1, ax, ay);
        curve(n - 1, ax, ay, px, py);
        curve(n - 1, px, py, bx, by);
        curve(n - 1, bx, by, x2, y2);


		
	}

    /** Gets n, and draws a Koch snowflake of n edges in the standard canvass. */
	public static void snowFlake(int n) {
    StdDraw.setXscale(0, 1);
    StdDraw.setYscale(0, 1);
    StdDraw.clear();

    double L = 0.55;
    double h = Math.sqrt(3) / 2.0 * L;

    double x1 = 0.225, y1 = 0.80;
    double x2 = x1 + L,  y2 = y1;
    double x3 = x1 + L / 2.0, y3 = y1 - h;

    curve(n, x1, y1, x2, y2);
    curve(n, x2, y2, x3, y3);
    curve(n, x3, y3, x1, y1);
}



}

package myPackage;
import java.util.Random;

import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;
import javax.swing.JFrame;

public class Line implements GLEventListener {

	static GLProfile profile = GLProfile.get(GLProfile.GL2);
	static GLCapabilities capabilities = new GLCapabilities(profile);
	// The canvas
	static GLCanvas glcanvas = new GLCanvas(capabilities);

	public static void main(String[] args) {
		// getting the capabilities object of GL2 profile

		Line l = new Line();
		// creating frame
		glcanvas.addGLEventListener(l);
		glcanvas.setSize(600, 400);

		final JFrame frame = new JFrame("straight Line");
		// adding canvas to frame
		frame.getContentPane().add(glcanvas);
		frame.setSize(frame.getContentPane().getPreferredSize());
		frame.setVisible(true);

	}

	public void display(GLAutoDrawable drawable) {
		final GL2 gl = drawable.getGL().getGL2();

		double max = 1.0;
		double min = -1.0;
		// generating out code for 100 random numbers
		for (int count = 0; count < 10; count++) {
			double x0 = randNumb(max, min);
			double y0 = randNumb(max, min);
			double x1 = randNumb(max, min);
			double y1 = randNumb(max, min);
			System.out.println("*** Line "+(count+1)+" ***");
			cohen(x0, y0, x1, y1, gl);
		}

		gl.glColor3f(1.0f, 1.0f, 0.0f); // color white
		drawLine(.55, ymax, -.55, ymax, gl); // drawing ymax
		drawLine(.55, ymin, -.55, ymin, gl); // drawing ymin
		drawLine(xmax, .55, xmax, -.55, gl); // drawing xmax
		drawLine(xmin, .55, xmin, -.55, gl); // drawing xmin

	}

	// method drawLine
	public static void drawLine(double x0, double y0, double x1, double y1, GL2 gl) {
		gl.glBegin(GL2.GL_LINE_LOOP); // loop starts
		gl.glVertex2d(x0, y0);
		gl.glVertex2d(x1, y1);
		gl.glEnd(); // loop ends
	}

	public static void cohen(double x0, double y0, double x1, double y1, GL2 gl) {
		int outcode_0;
		int outcode_1;
		int outcode;

		outcode_0 = make_code(x0, y0);
		outcode_1 = make_code(x1, y1);

		double x = 0.0;
		double y = 0.0;
		while (true) {
			System.out.println("(x0,y0)=(" + x0 + "," + y0 + ") outcode=" + outcode_0);
			System.out.println("(x1,y1)=(" + x1 + "," + y1 + ") outcode=" + outcode_1);
			
			if ((outcode_0 | outcode_1) == 0) { // fully accepted
				System.out.println("fully accepted\n");
				// color will be green
				gl.glColor3f(0f, 1f, 0f);
				drawLine(x0, y0, x1, y1, gl);
				break;
			} else if ((outcode_0 & outcode_1) != 0) { // fully rejected
				System.out.println("fully rejected\n");
				// color will be red
				gl.glColor3f(1f, 0f, 0f);
				drawLine(x0, y0, x1, y1, gl);
				break;
			} else { // partially accepted/rejected
				System.out.println("partially accepted/rejected\n");
				
				if (outcode_0 != 0) {
					outcode = outcode_0;
				} else {
					outcode = outcode_1;
				}

				if ((outcode & TOP) != 0) {
					y = ymax;
					x = x0 + (((y-y0)/(y1-y0)) * (x1-x0));
				} else if ((outcode & BOTTOM) != 0) {
					y = ymin;
					x = x0 + (((y-y0)/(y1-y0)) * (x1-x0));
				} else if ((outcode & RIGHT) != 0) {
					x = xmax;
					y = y0 + (((x-x0)/(x1-x0)) * (y1-y0));
				} else if ((outcode & LEFT) != 0) {
					x = xmin;
					y = y0 + (((x-x0)/(x1-x0)) * (y1-y0));
				}
				
				if (outcode == outcode_0) {
					// color will be red
					gl.glColor3f(1f, 0f, 0f);
					drawLine(x0,y0,x,y,gl);
					x0 = x;
					y0 = y;
					outcode_0 = make_code(x0,y0);
				} else {
					// color will be red
					gl.glColor3f(1f, 0f, 0f);
					drawLine(x1,y1,x,y,gl);
					x1 = x;
					y1 = y;
					outcode_1 = make_code(x1,y1);
				}
			} // end of partially accepted/rejected scope
		} // end of while loop
	} // end of method Cohen Sutherland

	// initializing the range of the window
	public static double ymax = .55;
	public static double ymin = -.55;
	public static double xmax = .55;
	public static double xmin = -.55;

	// equivalent decimal values for binary code
	public static int TOP = 8;
	public static int BOTTOM = 4;
	public static int RIGHT = 2;
	public static int LEFT = 1;

	// method make_code
	public static int make_code(double x, double y) {
		int outcode = 0;
		if (y > ymax) {
			outcode += TOP;
		} else if (y < ymin) {
			outcode += BOTTOM;
		}else if (x > xmax) {
			outcode += RIGHT;
		} else if (x < xmin) {
			outcode += LEFT;
		}
		return outcode;
	} // end of method make_code

	// method randNumb
	public static double randNumb(double max, double min) {
		Random r = new Random();
		return min + (max - min) * r.nextDouble();
	} // end of method

	public void dispose(GLAutoDrawable arg0) {
		// method body
	}

	public void init(GLAutoDrawable drawable) {
		// method body
		// 4. drive the display() in a loop
	}

	public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4) {
		// method body
	}
	// end of main
}// end of classimport javax.media.opengl.GL2;
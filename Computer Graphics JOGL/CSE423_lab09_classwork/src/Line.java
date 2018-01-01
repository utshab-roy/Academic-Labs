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
		glcanvas.setSize(600, 600);

		final JFrame frame = new JFrame("straight Line");
		// adding canvas to frame
		frame.getContentPane().add(glcanvas);
		frame.setSize(frame.getContentPane().getPreferredSize());
		frame.setVisible(true);

	}

	public void display(GLAutoDrawable drawable) {
		final GL2 gl = drawable.getGL().getGL2();
		
		gl.glColor3f(0f, 1f, 0f); // color green
		drawRectangle(-.5, -.35, .5, -.35, .5, .35, -.5, .35, gl);
		
		gl.glColor3f(1f, 1f, 0f); // color yellow
		drawRectangle(-.6, -.8, -.5, -.8, -.5, .35, -.6, .35, gl);

		gl.glColor3f(1f, 0f, 0f); // color red
		drawCircle(0.20, gl);

	}

	// method drawCircle
	public static void drawCircle(double radius, GL2 gl) {
		while (radius > 0) {
			gl.glBegin(GL2.GL_POINTS);
			double x, y, p;
			x = 0;
			y = radius;
			p = (5.0 / 4.0) - radius;
			while (x < y) {
				if (p < 0) {
					p += (2.0 * x) + .001;
				} else {
					p += -(2.0 * y) + (2.0 * x) + .001;
					y = y - .001;
				}
				x = x + .001;
				gl.glVertex2d(x, y);
				gl.glVertex2d(y, x);

				gl.glVertex2d(-x, y);
				gl.glVertex2d(y, -x);

				gl.glVertex2d(-x, -y);
				gl.glVertex2d(-y, -x);

				gl.glVertex2d(x, -y);
				gl.glVertex2d(-y, x);
			}
			gl.glEnd();
			radius -= .001;
		}
	}

	// method drawRectangle
	public static void drawRectangle(double x0, double y0, double x1,
			double y1, double x2, double y2, double x3, double y3, GL2 gl) {
		for (double y = y0; y < y3; y += 0.001) {
			DDALineDraw(x0, y, x1, y, gl);
		}
	}
	
	// DDA line drawing algorithm
	public static void DDALineDraw(double x1, double y1, double x2, double y2,
			GL2 gl) {
		gl.glBegin(GL2.GL_POINTS);// static field
				
		double delx = Math.abs(x2 - x1);
		double dely = Math.abs(y2 - y1);

		double length;
		if (delx >= dely) {
			length = delx;
		} else {
			length = dely;
		}

		double dy = (y2 - y1) / length;
		double dx = (x2 - x1) / length;

		double x = x1;
		double y = y1;

		double d = 0.001;

		double i = 0;
		while (i <= length) {
			gl.glVertex2d(x, y);
			x = x + dx * d;
			y = y + dy * d;
			i = i + 1.0 * d;
		}
		gl.glEnd();
	}

	public void dispose(GLAutoDrawable arg0) {
		// method body
	}

	public void init(GLAutoDrawable drawable) {
		// method body
		// 4. drive the display() in a loop
	}

	public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3,
			int arg4) {
		// method body
	}
	// end of main
}// end of classimport javax.media.opengl.GL2;
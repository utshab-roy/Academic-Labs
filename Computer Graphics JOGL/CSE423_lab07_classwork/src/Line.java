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
		
		// drawing x axis
		gl.glColor3f(1f, 1f, 1f); // color white
		drawLine(1.0, 0.0, -1.0, 0.0, gl);

		// drawing y axis
		gl.glColor3f(1f, 1f, 1f); // color white
		drawLine(0.0, 1.0, 0.0, -1.0, gl);
		
		gl.glBegin(GL2.GL_POINTS);
		double r, x, y, p;

		r = 0.5;
		x = 0;
		y = r;
		p = (5.0 / 4.0) - r;

		while (x < y) {
			if (p < 0) {
				p += (2.0 * x) + .001;
			} else {
				p += -(2.0 * y) + (2.0 * x) + .001;
				y = y - .001;
			}
			x = x + .001;

			gl.glColor3f(1f, 1f, 1f);
			gl.glVertex2d(x, y);
			gl.glVertex2d(y, x);

			gl.glColor3f(1f, 0f, 0f);
			gl.glVertex2d(-x, y);
			gl.glVertex2d(y, -x);

			gl.glColor3f(0f, 1f, 1f);
			gl.glVertex2d(-x, -y);
			gl.glVertex2d(-y, -x);

			gl.glColor3f(0f, 1f, 0f);
			gl.glVertex2d(x, -y);
			gl.glVertex2d(-y, x);

			System.out.println(x + " " + y);
		}
		gl.glEnd();

	}

	// method drawLine starts
	public static void drawLine(double x0, double y0, double x1, double y1,
			GL2 gl) {
		gl.glBegin(GL2.GL_LINE_LOOP);// static field
		gl.glVertex2d(x0, y0);
		gl.glVertex2d(x1, y1);
		gl.glEnd();
	} // method drawLine ends

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
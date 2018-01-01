package myPackage;

import java.io.*;
import java.util.*;

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

		try {
			FileReader in = new FileReader("input.txt");
			BufferedReader br = new BufferedReader(in);
			String line;

			gl.glBegin(GL2.GL_POINTS);// static field
			float x0 = 0f, x1 = 0f, y0 = 0f, y1 = 0f;
			while ((line = br.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(line, " ");

				x0 = Float.parseFloat(st.nextToken(","));
				y0 = Float.parseFloat(st.nextToken(","));
				x1 = Float.parseFloat(st.nextToken(","));
				y1 = Float.parseFloat(st.nextToken(","));

				float slope = (y1 - y0) / (x1 - x0);
				System.out.println("slope :" + slope);

				if (slope == 1.0) {
					if (x1 < x0) {
						float temp = x1;
						x1 = x0;
						x0 = temp;
					}
					gl.glVertex2d(x0 / 100, y0 / 100);
					while (x0 < x1) {
						gl.glVertex2d(x0 / 100, y0 / 100);
						x0 = x0 + .01f;
						y0 = y0 + .01f;
					}
					gl.glVertex2d(x0 / 100, y0 / 100);

				} else if (slope == -1.0) {
					if (x1 < x0) {
						float temp = x1;
						x1 = x0;
						x0 = temp;
					}
					gl.glVertex2d(x0 / 100, y0 / 100);
					while (x0 < x1) {
						gl.glVertex2d(x0 / 100, y0 / 100);
						x0 = x0 + .01f;
						y0 = y0 - .01f;
					}
					gl.glVertex2d(x0 / 100, y0 / 100);
				} else if (slope == 0.0) {
					if (x1 < x0) {
						float temp = x1;
						x1 = x0;
						x0 = temp;
					}
					gl.glVertex2d(x0 / 100, y0 / 100);
					while (x0 < x1) {
						gl.glVertex2d(x0 / 100, y0 / 100);
						x0 = x0 + .01f;
						// y0 = y0 - .01f;
					}
					gl.glVertex2d(x0 / 100, y0 / 100);
				} else if (x0 == x1) {
					if (y1 < y0) {
						float temp = y1;
						y1 = y0;
						y0 = temp;
					}
					gl.glVertex2d(x0 / 100, y0 / 100);
					while (y0 < y1) {
						gl.glVertex2d(x0 / 100, y0 / 100);
						y0 = y0 + .01f;
						// x0 += (slope / 100);
					}
					gl.glVertex2d(x0 / 100, y0 / 100);
				}

				else {
					System.out.println("Invalide slope !");
				}

				// gl.glVertex2d(x0/100,y0/100);
				// System.out.println(line);
				// System.out.println(x0+" "+y0+" "+x1);
			}
			in.close();
			// *************************Slope

		} catch (Exception e) {

			e.printStackTrace();
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

	public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4) {
		// method body
	}
	// end of main
}// end of classimport javax.media.opengl.GL2;

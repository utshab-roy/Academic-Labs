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

			float x0 = 0f, x1 = 0f, y0 = 0f, y1 = 0f;
			int zone = 10;
			while ((line = br.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(line, " ");

				x0 = Float.parseFloat(st.nextToken(","));
				y0 = Float.parseFloat(st.nextToken(","));
				x1 = Float.parseFloat(st.nextToken(","));
				y1 = Float.parseFloat(st.nextToken(","));

				// float slope = (y1 - y0) / (x1 - x0);
				// System.out.println("slope :" + slope);

				float dx = x1 - x0;
				float dy = y1 - y0;

				if (Math.abs(dx) >= (Math.abs(dy))) { // for zone 0,7 and 3,4

					if (dx >= 0 && dy >= 0) {
						zone = 0;
					} else if (dx < 0 && dy >= 0) {
						zone = 3;
					} else if (dx >= 0 && dy < 0) {
						zone = 7;
					} else if (dx < 0 && dy < 0) {
						zone = 4;
					}

				} else { // for zone 1,2 and 5,6
					if (dx >= 0 && dy >= 0) {
						zone = 1;
					} else if (dx < 0 && dy >= 0) {
						zone = 2;
					} else if (dx >= 0 && dy < 0) {
						zone = 6;
					} else if (dx < 0 && dy < 0) {
						zone = 5;
					}
				} // zone has been detected

				System.out.println("Zone: " + zone);

				if (zone == 1 || zone == 2 || zone == 5 || zone == 6) {
					float temp = x0;
					x0 = y0;
					y0 = temp;

					float temp2 = y1;
					y1 = x1;
					x1 = temp2;
				}//swap block end

//				if (zone == 0) {
					gl.glBegin(GL2.GL_POINTS);// static field
					float d = (2 * dy) - dx;
					float dNE = dy - dx;
					float dE = dy;
					// gl.glVertex2d(x0 / 100, y0 / 100);
					while (x0 < x1) {
						if (d < 0) {
							d += dE;
							// x0 = x0 + .01f;
						} else {
							d += dNE;
							y0 = y0 + .01f;
						}
						x0 = x0 + .01f;
						
						ConvBack(x0, y0, zone, drawable);						

//						gl.glColor3f(0f, 1f, 0f);
//						gl.glVertex2d(x0 / 100, y0 / 100);

					} // while loop end
					gl.glEnd();

//				} // zone 0 calculation end & if block end 

			} // end of while loop of file

			in.close();

		} // end of try block
		catch (Exception e) {
			e.printStackTrace();
		}

	}// end of draw method
	
	public void ConvBack(float x, float y, int zone, GLAutoDrawable drawable) {
		if (zone == 0){
			drawPixel(x, y, drawable);			
		}
		else if (zone == 1)
			drawPixel(y, x, drawable);
		else if (zone == 2)
			drawPixel(-y, x, drawable);
		else if (zone == 3)
			drawPixel(-x, y, drawable);
		else if (zone == 4)
			drawPixel(-x, -y, drawable);
		else if (zone == 5)
			drawPixel(-y, -x, drawable);
		else if (zone == 6)
			drawPixel(y, -x, drawable);
		else if (zone == 7)
			drawPixel(x, -y, drawable);
	}// end of ConvBack method
	
	public void drawPixel(float x, float y, GLAutoDrawable drawable){
		final GL2 gl = drawable.getGL().getGL2();
		gl.glBegin(GL2.GL_POINTS);
//		gl.glColor3f(0f, 1f, 0f);
		gl.glVertex2d(x / 100, y / 100);				
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

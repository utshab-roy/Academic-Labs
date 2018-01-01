
import java.util.ArrayList;
import java.util.Stack;

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

		ArrayList<Character> axisList = new ArrayList<Character>();
		ArrayList<Double> angleList = new ArrayList<Double>();
		double newXYZ[][];
		double xc, yc, zc;

		// drawing x axis
		gl.glColor3f(1f, 1f, 1f); // color white
		drawLine(1.0, 0.0, -1.0, 0.0, gl);

		// drawing y axis
		gl.glColor3f(1f, 1f, 1f); // color white
		drawLine(0.0, 1.0, 0.0, -1.0, gl);

		// arrays to hold the original cube
		double x[] = { .1, .6, .6, .1, .3, .8, .8, .3 }; // x0,x1,x2,x3,x4,x5,x6,x7
		double y[] = { .1, .1, .6, .6, .2, .2, .7, .7 }; // y0,y1,y2,y3,y4,y5,y6,y7
		double z[] = { .0, .0, .0, .0, .0, .0, .0, .0 }; // z0,z1,z2,z3,z4,z5,z6,z7

		// drawing the original cube
		gl.glColor3f(1f, 0f, 0f); // color red
		drawCube(x, y, gl);

		// arrays to hold the rotated cube
		double xr[] = new double[8];
		double yr[] = new double[8];
		double zr[] = new double[8];

		// the cube will be rotated in z axis by 180 degree
		axisList.add('z');
		angleList.add(40.0);

		// relative center of the surface with points 0,1,2,3
		xc = .1;
		yc = .1;
		zc = 0;

		// rotating point x0,y0
		newXYZ = rotatePoint(x[0], y[0], z[0], xc, yc, zc, axisList, angleList);
		xr[0] = newXYZ[0][0];
		yr[0] = newXYZ[1][0];
		zr[0] = newXYZ[2][0];
		// rotating point x1,y1
		newXYZ = rotatePoint(x[1], y[1], z[1], xc, yc, zc, axisList, angleList);
		xr[1] = newXYZ[0][0];
		yr[1] = newXYZ[1][0];
		zr[1] = newXYZ[2][0];
		// rotating point x2,y2
		newXYZ = rotatePoint(x[2], y[2], z[2], xc, yc, zc, axisList, angleList);
		xr[2] = newXYZ[0][0];
		yr[2] = newXYZ[1][0];
		zr[2] = newXYZ[2][0];
		// rotating point x3,y3
		newXYZ = rotatePoint(x[3], y[3], z[3], xc, yc, zc, axisList, angleList);
		xr[3] = newXYZ[0][0];
		yr[3] = newXYZ[1][0];
		zr[3] = newXYZ[2][0];

		// relative center of the surface with points 4,5,6,7
		xc = .3;
		yc = .2;
		zc = 0;
		// rotating x4,y4
		newXYZ = rotatePoint(x[4], y[4], z[4], xc, yc, zc, axisList, angleList);
		xr[4] = newXYZ[0][0];
		yr[4] = newXYZ[1][0];
		zr[4] = newXYZ[2][0];
		// rotating x5,y5
		newXYZ = rotatePoint(x[5], y[5], z[5], xc, yc, zc, axisList, angleList);
		xr[5] = newXYZ[0][0];
		yr[5] = newXYZ[1][0];
		zr[5] = newXYZ[2][0];
		// rotating x6,y6
		newXYZ = rotatePoint(x[6], y[6], z[6], xc, yc, zc, axisList, angleList);
		xr[6] = newXYZ[0][0];
		yr[6] = newXYZ[1][0];
		zr[6] = newXYZ[2][0];
		// rotating x7,y7
		newXYZ = rotatePoint(x[7], y[7], z[7], xc, yc, zc, axisList, angleList);
		xr[7] = newXYZ[0][0];
		yr[7] = newXYZ[1][0];
		zr[7] = newXYZ[2][0];
		
		// drawing the rotated cube
		gl.glColor3f(0f, 1f, 0f); // color green
		drawCube(xr, yr, gl);
	}

	// method rotatePoint
	public static double[][] rotatePoint(double x, double y, double z, double xc, double yc, double zc,
			ArrayList<Character> axisList, ArrayList<Double> angleList) {
		Stack<double[][]> st = new Stack<double[][]>();
		// adding the original matrix to the matrix stack
		st.push(newMatrics(4, 1, x, y, z, 1));
		// adding the transferred matrix to the matrix stack
		st.push(transferMatrics(-xc, -yc, -zc));
		// adding the rotation matrixes to the matrix stack
		for (int i = 0; i < angleList.size(); i++) {
			st.push(rotationMatrics(axisList.get(i), angleList.get(i)));
		}
		// adding the re transferred matrix to the matrix stack
		st.push(transferMatrics(xc, yc, zc));
		// returning the rotated output matrix
		return matricsSetMultiplication(st);
	} // end of method rotatePoint

	// method drawCube
	public static void drawCube(double x[], double y[], GL2 gl) {
		drawLine(x[0], y[0], x[1], y[1], gl);
		drawLine(x[1], y[1], x[2], y[2], gl);
		drawLine(x[2], y[2], x[3], y[3], gl);
		drawLine(x[3], y[3], x[0], y[0], gl);

		drawLine(x[4], y[4], x[5], y[5], gl);
		drawLine(x[5], y[5], x[6], y[6], gl);
		drawLine(x[6], y[6], x[7], y[7], gl);
		drawLine(x[7], y[7], x[4], y[4], gl);

		drawLine(x[0], y[0], x[4], y[4], gl);
		drawLine(x[1], y[1], x[5], y[5], gl);
		drawLine(x[2], y[2], x[6], y[6], gl);
		drawLine(x[3], y[3], x[7], y[7], gl);
	} // end of method drawCube

	// method matricsSetMultiplication
	public static double[][] matricsSetMultiplication(Stack<double[][]> st) {
		while (true) {
			double M1[][] = st.pop();
			double M2[][] = st.pop();
			double M1M2[][] = multiply(M1, M2);
			if (st.empty()) {
				st.push(M1M2);
				break;
			} else {
				print(M1M2);
				st.push(M1M2);
			}
		}
		return st.pop();
	} // end of method matricsSetMultiplication

	// method transferMatrics
	public static double[][] transferMatrics(double xc, double yc, double zc) {
		return newMatrics(4, 4, 1, 0, 0, xc, 0, 1, 0, yc, 0, 0, 1, zc, 0, 0, 0, 1);
	} // end of method transferMatrics

	// method rotation matrix
	public static double[][] rotationMatrics(char axis, double angle) {
		angle = Math.toRadians(angle);
		if (axis == 'x') {
			return newMatrics(4, 4, 1, 0, 0, 0, 0, Math.cos(angle), -Math.sin(angle), 0, 0, Math.sin(angle),
					Math.cos(angle), 0, 0, 0, 0, 1);
		} else if (axis == 'y') {
			return newMatrics(4, 4, Math.cos(angle), 0, -Math.sin(angle), 0, 0, 1, 0, 0, Math.sin(angle), 0,
					Math.cos(angle), 0, 0, 0, 0, 1);
		} else { // axis == 'z'
			return newMatrics(4, 4, Math.cos(angle), -Math.sin(angle), 0, 0, Math.sin(angle), Math.cos(angle), 0, 0, 0,
					0, 1, 0, 0, 0, 0, 1);
		}
	} // end of method rotation matrix

	// method createMatrics starts
	public static double[][] newMatrics(int row, int column, double... data) {
		double M[][] = new double[row][column];
		int dataCount = 0;
		for (int rowCount = 0; rowCount < row; rowCount++) {
			for (int columnCount = 0; columnCount < column; columnCount++) {
				M[rowCount][columnCount] = data[dataCount++];
			}
		}
		return M;
	} // end of method createMatrics

	// method matricsMultiplication
	public static double[][] multiply(double A[][], double B[][]) {
		int rowA = A.length;
		int columnA = A[0].length;
		int rowB = B.length;
		int columnB = B[0].length;

		double C[][] = new double[rowA][columnB];
		int rowC = C.length;
		int columnC = C[0].length;

		for (int rowCountC = 0; rowCountC < rowC; rowCountC++) {
			for (int columnCountC = 0; columnCountC < columnC; columnCountC++) {
				for (int columnCountA = 0, rowCountB = 0; columnCountA < columnA; columnCountA++, rowCountB++) {
					C[rowCountC][columnCountC] += A[rowCountC][columnCountA] * B[rowCountB][columnCountC];
				}
			}
		}
		return C;
	} // end of method matricsMultiplication

	// method matricsPrint
	public static void print(double M[][]) {
		int row = M.length;
		int column = M[0].length;
		for (int rowCount = 0; rowCount < row; rowCount++) {
			for (int columnCount = 0; columnCount < column; columnCount++) {
				System.out.print(M[rowCount][columnCount] + "\t");
			}
			System.out.println();
		}
		System.out.println();
	} // end of method matricsPrint

	// method drawLine starts
	public static void drawLine(double x0, double y0, double x1, double y1, GL2 gl) {
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

	public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4) {
		// method body
	}
	// end of main
}// end of classimport javax.media.opengl.GL2;

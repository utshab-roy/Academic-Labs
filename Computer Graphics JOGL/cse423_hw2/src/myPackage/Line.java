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
		
		//**********************************************************
	      BufferedWriter bw = null;
	      try {
	         //Specify the file name and path here
		 File file = new File("C:/Users/Utshab/workspace/cse423_hw2/input.txt");

		 /* This logic will make sure that the file 
		  * gets created if it is not present at the
		  * specified location*/
		  if (!file.exists()) {
		     file.createNewFile();
		  }
		  
			int minX = -99;
			int maxX = 99;
			Random rand = new Random();	

		  FileWriter fw = new FileWriter(file);
		  bw = new BufferedWriter(fw);
		  for (int i = 0; i < 10; i++) {
//			bw.write("hello");
			int x0 = rand.nextInt((maxX - minX) + 1) + minX;
			int y0 = rand.nextInt((maxX - minX) + 1) + minX;
			int x1 = rand.nextInt((maxX - minX) + 1) + minX;
			int y1 = rand.nextInt((maxX - minX) + 1) + minX;
			bw.write(x0+", "+y0+", "+x1+", "+y1);
			bw.newLine();
		  }
	          System.out.println("File written Successfully");

	      }//end of write file try block
	      
	      catch (IOException ioe) {
		   ioe.printStackTrace();
		}
		finally
		{ 
		   try{
		      if(bw!=null)
			 bw.close();
		   }catch(Exception ex){
		       System.out.println("Error in closing the BufferedWriter"+ex);
		    }
		}
		//**********************************************************

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
						
						float myArray[] = ConvBack(x0, y0, zone);						

						if(myArray[2] == 0){
							gl.glColor3f(1f, 0f, 0f);
							gl.glVertex2d(myArray[0] / 100, myArray[1] / 100);
						}else if(myArray[2] == 1){
							gl.glColor3f(1f, 1f, 0f);
							gl.glVertex2d(myArray[0] / 100, myArray[1] / 100);
						}else if(myArray[2] == 2){
							gl.glColor3f(0f, 1f, 0f);
							gl.glVertex2d(myArray[0] / 100, myArray[1] / 100);
						}else if(myArray[2] == 3){
							gl.glColor3f(0f, 1f, 1f);
							gl.glVertex2d(myArray[0] / 100, myArray[1] / 100);
						}else if(myArray[2] == 4){
							gl.glColor3f(0f, 0f, 1f);
							gl.glVertex2d(myArray[0] / 100, myArray[1] / 100);
						}else if(myArray[2] == 5){
							gl.glColor3f(1f, 0f, 1f);
							gl.glVertex2d(myArray[0] / 100, myArray[1] / 100);
						}else if(myArray[2] == 6){
							gl.glColor3f(1f, 1f, 1f);
							gl.glVertex2d(myArray[0] / 100, myArray[1] / 100);
						}else if(myArray[2] == 7){
							gl.glColor3f(.5f, .5f, .5f);
							gl.glVertex2d(myArray[0] / 100, myArray[1] / 100);
						}
						

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
	
	public float[] ConvBack(float x, float y, int zone) {
		float myArray[] = new float[3];
		if (zone == 0){
			myArray[0] = x;
			myArray[1] = y;
			myArray[2] = zone;
		}
		else if (zone == 1){
			myArray[0] = y;
			myArray[1] = x;
			myArray[2] = zone;
		}
		else if (zone == 2){
			myArray[0] = -y;
			myArray[1] = x;
			myArray[2] = zone;
		}
		else if (zone == 3){
			myArray[0] = -x;
			myArray[1] = y;
			myArray[2] = zone;
		}
		else if (zone == 4){
			myArray[0] = -x;
			myArray[1] = -y;
			myArray[2] = zone;
		}
		else if (zone == 5){
			myArray[0] = -y;
			myArray[1] = -x;
			myArray[2] = zone;
		}
		else if (zone == 6){
			myArray[0] = y;
			myArray[1] = -x;
			myArray[2] = zone;
		}
		else if (zone == 7){
			myArray[0] = x;
			myArray[1] = -y;
			myArray[2] = zone;
		}
		return myArray;
	}// end of ConvBack method
	

	

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

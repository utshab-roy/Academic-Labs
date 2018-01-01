

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;
import javax.swing.JFrame;

public class Line implements GLEventListener{
	
	static GLProfile profile = GLProfile.get(GLProfile.GL2);
    static GLCapabilities capabilities = new GLCapabilities(profile);
    // The canvas 
    static GLCanvas glcanvas = new GLCanvas(capabilities);
    
   public static void main(String[] args) {
	      //getting the capabilities object of GL2 profile
	   	  
	      
	      Line l = new Line();
	      //creating frame
	      glcanvas.addGLEventListener(l);
	      glcanvas.setSize(600, 400);
	      
	      final JFrame frame = new JFrame ("straight Line");
	      //adding canvas to frame
	      frame.getContentPane().add(glcanvas);
	      frame.setSize(frame.getContentPane().getPreferredSize());
	      frame.setVisible(true);
	      
	   }
   
   public void display(GLAutoDrawable drawable) {
      final GL2 gl = drawable.getGL().getGL2();
      
      BufferedReader br = null;
      File file = new File("coordinates.txt");
      
      try {
		br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		String line = null;
		gl.glBegin (GL2.GL_POINTS);//static field
		while((line = br.readLine()) != null){		
//			System.out.println(line);
			String token[] = line.split(",");
//			System.out.println(token[0]);
			gl.glVertex2d(Float.parseFloat(token[0]),Float.parseFloat(token[1]));
			gl.glVertex2d(Float.parseFloat(token[0])/2.0,Float.parseFloat(token[1])/2.0);			
		}
		gl.glEnd();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      
       	  
          
//          gl.glVertex2d(0.5f,-0.5f);
//          gl.glVertex2d(-0.5f,0.5f);
//          gl.glVertex2d(-0.5f,-0.5f);
          

   }
   
   public void dispose(GLAutoDrawable arg0) {
      //method body
   }

   
   public void init(GLAutoDrawable drawable) {
      // method body
	   //4. drive the display() in a loop
	    }
   
   public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4) {
      // method body
   }
   //end of main
}//end of classimport javax.media.opengl.GL2;

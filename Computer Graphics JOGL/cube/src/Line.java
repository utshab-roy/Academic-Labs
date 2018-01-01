

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
    static float theta = (float) Math.toRadians(45);
   public static void main(String[] args) {
	      //getting the capabilities object of GL2 profile
	   	  
	      
	      Line l = new Line();
	      //creating frame
	      glcanvas.addGLEventListener(l);
	      glcanvas.setSize(600, 600);
	      
	      final JFrame frame = new JFrame ("straight Line");
	      //adding canvas to frame
	      frame.getContentPane().add(glcanvas);
	      frame.setSize(frame.getContentPane().getPreferredSize());
	      frame.setVisible(true);
	      
	   }
   public void display(GLAutoDrawable drawable) {
      final GL2 gl = drawable.getGL().getGL2();
       	gl.glBegin (GL2.GL_LINES);
       	gl.glColor3f(1f,0f,0f);//static field
     
       	float x1 = -.25f;
       	float x2 = .25f;
       	float x3 = .25f;
       	float x4 = -.25f;
       	float x5 = 0f;
       	float x6 = .5f;
       	float x7 = 0f;
       	float x8 = .5f;
       	
       	float y1 = .25f;
       	float y2 = .25f;
       	float y3 = -.25f;
       	float y4 = -.25f;
       	float y5 = 0f;
       	float y6 = 0f;
       	float y7 = -.5f;
       	float y8 = -.5f;
       	
       	//back
       	gl.glVertex2d(x1,y1);
       	gl.glVertex2d(x2,y2);
       	
       	gl.glVertex2d(x1,y1);
       	gl.glVertex2d(x4,y4);
       	
       	gl.glVertex2d(x4,y4);
       	gl.glVertex2d(x3,y3);
       	
       	gl.glVertex2d(x2,y2);
       	gl.glVertex2d(x3,y3);
       	
       	//front
       	gl.glVertex2d(x5,y5);
       	gl.glVertex2d(x6,y6);
       	
       	gl.glVertex2d(x5,y5);
       	gl.glVertex2d(x7,y7);
       	
       	gl.glVertex2d(x7,y7);
       	gl.glVertex2d(x8,y8);
       	
       	gl.glVertex2d(x6,y6);
       	gl.glVertex2d(x8,y8);
       	
       	
       	//sides
       	
       	gl.glVertex2d(x5,y5);
       	gl.glVertex2d(x1,y1);
       	
       	gl.glVertex2d(x4,y4);
       	gl.glVertex2d(x7,y7);
       	
       	gl.glVertex2d(x3,y3);
       	gl.glVertex2d(x8,y8);
       	
       	gl.glVertex2d(x6,y6);
       	gl.glVertex2d(x2,y2);
       	  
       	float x11 = rotateX(x1, y1);
       	float x22 = rotateX(x2, y2);
       	float x33 = rotateX(x3, y3);
       	float x44 = rotateX(x4, y4);
       	float x55 = rotateX(x5, y5);
       	float x66 = rotateX(x6, y6);
       	float x77 = rotateX(x7, y7);
       	float x88 = rotateX(x8, y8);
       	
       	float y11 = rotateY(x1, y1);
       	float y22 = rotateY(x2, y2);
       	float y33 = rotateY(x3, y3);
       	float y44 = rotateY(x4, y4);
       	float y55 = rotateY(x5, y5);
       	float y66 = rotateY(x6, y6);
       	float y77 = rotateY(x7, y7);
       	float y88 = rotateY(x8, y8);
       	
        gl.glColor3f(0f,1f,0f);
        
        //back
        gl.glVertex2d(x11,y11);
       	gl.glVertex2d(x22,y22);
       	
       	gl.glVertex2d(x11,y11);
       	gl.glVertex2d(x44,y44);

       	gl.glVertex2d(x44,y44);
       	gl.glVertex2d(x33,y33);
       	
       	gl.glVertex2d(x22,y22);
       	gl.glVertex2d(x33,y33);
       	
       	//front
       	gl.glVertex2d(x55,y55);
       	gl.glVertex2d(x66,y66);
       	
       	gl.glVertex2d(x55,y55);
       	gl.glVertex2d(x77,y77);

       	gl.glVertex2d(x77,y77);
       	gl.glVertex2d(x88,y88);
       	
       	gl.glVertex2d(x66,y66);
       	gl.glVertex2d(x88,y88);
        
        //sides
       	gl.glVertex2d(x55,y55);
       	gl.glVertex2d(x11,y11);
       	
       	gl.glVertex2d(x44,y44);
       	gl.glVertex2d(x77,y77);

       	gl.glVertex2d(x33,y33);
       	gl.glVertex2d(x88,y88);
       	
       	gl.glVertex2d(x66,y66);
       	gl.glVertex2d(x22,y22);
          
        gl.glEnd();
          
      
   }
   
   public static float rotateX(float x, float y){
	   x = (float) (x*Math.cos(theta) - y*Math.sin(theta));
	   return x;
   }
   
   public static float rotateY(float x, float y){
	   y = (float) (x*Math.sin(theta) + y*Math.cos(theta));
	   return y;
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
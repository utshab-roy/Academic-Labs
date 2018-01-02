/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab08;

/**
 *
 * @author Utshab
 */
public class Lab08 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LiniarArrayPatient pr = new LiniarArrayPatient();
        
        pr.RegisterPatient("A");
        pr.RegisterPatient("B");
        pr.RegisterPatient("C");
        pr.RegisterPatient("D");
        pr.RegisterPatient("E");
        pr.RegisterPatient("F");
        pr.RegisterPatient("G");
        pr.RegisterPatient("H");
        
        pr.ServePatient();
        pr.ServePatient();
        
        pr.ShowAllPatient();
        
        pr.CanDoctorGoHome();
        
        pr.CancelAll();
        
        pr.ShowAllPatient();
    }
    
}

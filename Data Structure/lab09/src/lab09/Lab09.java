/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab09;

/**
 *
 * @author Utshab
 */
public class Lab09 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Recursion rc = new Recursion();
        //Object[] data = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "h"};
        
        System.out.println("Task 01: "); 
        System.out.println(rc.factorial(5));
        
        System.out.println("Task 02: ");
        rc.febunacci(0,1,10);
        System.out.println();
        
        System.out.println("Task 04: ");
        System.out.println(rc.decimalToBinay(10));
        
        System.out.println("Task 06: ");
        System.out.println(rc.powerCalculation(10, 3));
    }
    
}

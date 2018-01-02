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
public class Recursion {
    public int factorial(int num) {
        if(num<0){
             System.out.print("Invalide number ");
             return num;
        }
        if (num == 0) {
            return 1;
        } else {
            return num * factorial(num - 1);
        }
    }
    
    public void febunacci(int a, int b, int num){
        if (a == 0){
            System.out.print(a + " ");
            System.out.print(b + " ");
        }
        if (num - 2 > 0) {
            int c = a + b;
            System.out.print(c + " ");
            a = b;
            b = c;
            febunacci(a, b, num - 1);
        }
    }
    
    
    public String decimalToBinay(int n) {
        if (n == 0) {
            return "0";
        } else if (n == 1) {
            return "1";
        }
        int bin = (n % 2);
        return decimalToBinay(n / 2) + "" + bin;
    }


    public static int powerCalculation(int e, int p) {
        if (p < 0) {
            throw new IllegalArgumentException("Illegal Power Argument");
        }
        if (p == 0) {
            return 1;
        }
        return e * powerCalculation(e, p - 1);
    }
}

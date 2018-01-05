/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package longestcommonsubsuquence;

/**
 *
 * @author Utshab
 */
import java.util.Scanner;

public class LongestCommonSubsuquence {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        
        String s1 = "ABCDCBA";
        String s2 = "DCBAABC";

        int x = s1.length();
        int y = s2.length();

        vertex[][] ver = new vertex[x + 1][y + 1];
        
//        ver[0][0] = new vertex(1,2);
//        System.out.println(ver[0][0]);
        
        for (int i = 0; i < x + 1; i++) {
            for(int j = 0; j < y +1; j ++){
                ver[i][j] = new vertex(0, 0);
//                System.out.print(ver[i][j].value);
            }           
//            System.out.println();
        }
        
        for (int i = 1; i < x + 1; i++) {
            for(int j = 1; j < y +1; j ++){
                if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                    ver[i][j].value = ver[i - 1][j - 1].value + 1;
//                    System.out.println("Konakuni er value : "+ ver[i - 1][j - 1].value);
//                    System.out.println("Increasing value: ");
                    ver[i][j].direct = 1;          //Konakuni direction er man holo 1 
                }
                else if (ver[i-1][j].value >= ver[i][j-1].value  ){
                    ver[i][j].value = ver[i-1][j].value;
                    ver[i][j].direct = 2;         // Up direction er man holo 2 
                }
                else if (ver[i][j-1].value > ver[i-1][j].value){
                    ver[i][j].value = ver[i][j-1].value;
                    ver[i][j].direct = 3;        // Left direction er man holo 3
                }
            }
        }
        
        for (int i = 0; i < x + 1; i++) {
            for(int j = 0; j < y +1; j ++){
//                ver[i][j] = new vertex(0, -1);
                System.out.print(ver[i][j].value);
            }           
            System.out.println();
        }
        
        printLCS pr = new printLCS(ver, s1, x, y);
        pr.print(ver, s1, x, y);
        

    }
    
}

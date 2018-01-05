/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knapsack;

/**
 *
 * @author Utshab
 */
public class Knapsack {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        System.out.println();
        int maxWeight = 5;
        int[] weight = {2, 1, 3, 2};
        int[] value = {12, 10, 20, 15};
        int item = weight.length;

        Cell[][] P = new Cell[item + 1][maxWeight + 1];

        for (int i = 0; i < item + 1; i++) {
            for (int j = 0; j < maxWeight + 1; j++) {
                P[i][j] = new Cell(0, 0);
//                System.out.print(P[i][j].direct);
            }
        }
        
        for(int j = 1; ){
            
        }

    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashproblem;

import java.util.*;

/**
 *
 * @author Utshab
 */
public class ChainedHash {

    LinkedList<Integer>[] vertex = new LinkedList[11];

    public void chainedTable(int a[], int mod) {
        for (int i = 0; i < a.length; i++) {
            int index = a[i] % mod;
            if (vertex[index] == null) {
                vertex[index] = new LinkedList<Integer>();
                vertex[index].add(a[i]);
//                System.out.println(vertex[index] + " with index num: " + index);
            } else {
                vertex[index].addFirst(a[i]);
//                System.out.println(vertex[index] + " with index num: " + index);
            }
        }

    }
    
    public void printList(){
        System.out.println("Chained Hashing:");
        for (int i = 0; i < vertex.length; i++) {
            if(vertex[i] != null){
                System.out.println(vertex[i] + " with index num: " + i);
            }
        }
    }
}

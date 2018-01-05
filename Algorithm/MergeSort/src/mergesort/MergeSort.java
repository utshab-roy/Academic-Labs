/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mergesort;

/**
 *
 * @author Utshab
 */
public class MergeSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int A[] = {1, 3, 5, 6, 8, 0, 2, 4, 6, 8};
        
        Sorting st = new Sorting();
        System.out.println("Before Sorting :");
        st.print(A);
        System.out.println("After Sorting :");
        A = st.mergeSort(A);
        st.print(A);
    }
    
    
    
}

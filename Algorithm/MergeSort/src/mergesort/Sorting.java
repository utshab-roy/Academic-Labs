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
public class Sorting {
    
    
    public void print(int []a){
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
    
    public int[] mergeSort(int [] a){
        if(a.length <= 1){
            return a;
        }
        
        int midPoint = a.length / 2;
        
        int left[] = new int [midPoint];
        
        int right[];
        if(a.length % 2 == 0){
            right = new int [midPoint];
        }else{
            right = new int [midPoint + 1];
        }
        
        int result[] = new int [a.length];
        
        for (int i = 0; i < midPoint; i++) {
            left[i] = a[i];
        }
        
        int x = 0;
        for (int j = midPoint; j < a.length; j++) {
            if(x < right.length){
            right[x] = a[j];
            x++;
            }
        }
        
        left = mergeSort(left);
        right = mergeSort(right);
        
        result = merge(left, right);
        
        return result;
    }
    
    public int[] merge(int [] left, int [] right){
        int lengthResult = left.length + right.length;
        int result[] = new int[lengthResult];
        
        int indexL = 0;
        int indexR = 0;
        int indexRes = 0;
        
        while(indexL < left.length || indexR < right.length){
            if(indexL < left.length && indexR < right.length){
                if(left[indexL] <= right[indexR]){
                    result[indexRes] = left[indexL];
                    indexL++;
                    indexRes++;
                }else{
                    result[indexRes] = right[indexR];
                    indexR++;
                    indexRes++;
                }
            }
            else if(indexL < left.length){
                result[indexRes] = left[indexL];
                indexL++;
                indexRes++;
            }
            
            else if(indexR < right.length){
                result[indexRes] = right[indexR];
                indexR++;
                indexRes++;
            }
        }
        return result;
    }
}

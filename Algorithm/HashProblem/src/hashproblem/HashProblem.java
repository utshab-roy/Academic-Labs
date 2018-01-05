/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashproblem;

/**
 *
 * @author Utshab
 */
public class HashProblem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        hashing hs = new hashing();
        int array[] = {83,14,29,70,10,55,72};
        String str[] = {"abc", "def","ghi","jkl"};
        int modValue = 11;
        
//        hs.hashTable(array, modValue);
//        hs.printTable();
//        hs.reHashing(modValue);
//        hs.printTable();
//        hs.stringHashTable(str, modValue);
//        hs.printstrTable();
//        hs.searchKey(14, modValue);
        
        ChainedHash ch = new ChainedHash();
        ch.chainedTable(array, modValue);
        ch.printList();
        	
        
//		System.out.printf("");


    }
    
}

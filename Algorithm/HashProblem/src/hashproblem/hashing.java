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

public class hashing {
	int  table[] = new int [11];
	String strTable[] = new String [11];
        
        
        
    public void hashTable(int a[], int mod) {
        for (int i = 0; i < a.length; i++) {
            int x = a[i]%mod;
            if(table[x] == 0){
            	table[x] = a[i];
            }else{
            	for(int j=x; x<table.length; j++ ){
            		if(table[j] == 0){
            			table[j] = a[i];
//            			System.out.println("Table asdsdelement: " + table[j] + "Index :"+j);
            			break;
            		}
            	}
//              hs.printT
            }
//            System.out.println("Table element: " + table[x] + "Index :"+x);
        }
    }
    public void printTable() {
    	for(int i=0; i < table.length; i++){
            if(table[i] != 0)
    		System.out.println(table[i]+" with index number "+i);
    	}
        System.out.println();
    }
    
    public void printstrTable() {
    	for(int i=0; i < strTable.length; i++){
    		System.out.print(strTable[i]+" with index number "+ i);
    	}
        System.out.println();
    }
    
    public void stringHashTable(String a[], int mod){
    	for(int i=0; i < a.length;i++){
    		char ch[];
    		ch = a[i].toCharArray();
    		int xLength = a[i].length();
    		
    		int j, sum;
    		for (sum=0, j=0; j < xLength; j++)
    		sum += ch[j];
    		strTable[sum % mod] = a[i]; 
//    		System.out.print("strtable"+strTable[sum % mod]);   
//    		System.out.print(xLength);
    	}
    }
    
    public void searchKey(int key, int mod){
        int index = key%mod;
        if(table[index] == key){
            System.out.println("Element"+ key + "found at index "+ index);
        }else{
            for(int i = index; i < table.length; i++){
                if(table[i] == key){
                    System.out.println("Element "+ key + " found at index "+ i);
                    break;
                }
            }
        }
    }
    
//    public void searchKey(String key, int mod){
//        char ch[];
//        key.codePointAt()
//    }
    public void reHashing(int mod){
        System.out.println("After Rehashing:");
        int  newTable[] = new int [table.length * 2];
        
         for (int i = 0; i < table.length; i++) {
            int x = table[i]%(mod*2);
            if(newTable[x] == 0){
            	newTable[x] = table[i];
            }else{
            	for(int j=x; x<newTable.length; j++ ){
            		if(newTable[j] == 0){
            			newTable[j] = table[i];
            			break;
            		}
            	}
            }
        }
        table = newTable;
        
    }
    
    
    
}


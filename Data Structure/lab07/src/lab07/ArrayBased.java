/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab07;

/**
 *
 * @author 13101217
 */
public class ArrayBased {
    int size;
    Object data[];
    
    ArrayBased(){
    data = new Object[100];
    int size = 0;
    }
    
    int size(){
        return size;
    }
    
    boolean isEmpty(){
        if(size == 0){
            return true;
        }
        else{
            return false;
        }
    }
    
    void push(Object obj){
        if(size == data.length){
            try {
                throw new StackOverFlowException();
                
            }
            catch(Exception e){
                
            }
        }
        else{
            data[size] = obj;
            size++;
        }
    }
    
    
    Object pop(){
        Object temp = null;
        if(size == 0){
            try {
                throw new StackUnderFlowException();
            }
            catch(Exception e){
                
            }
        }
        else{
            temp = data[size - 1];
            size--;
            return temp;
        }
        return null;
    }
    
    Object peak(){
        Object temp;
        if(size == 0){
            try {
                throw new StackUnderFlowException();
            }
            catch(Exception e){
                
            }
        }else{
            temp = data[size - 1];
            return temp;
        }
        return null;
    }

    private static class StackOverFlowException extends Exception {

        public StackOverFlowException() {
            System.out.println("Stack Over Flow");
        }
    }

    private static class StackUnderFlowException extends Exception {

        public StackUnderFlowException() {
            System.out.println("Stack Under Flow");
        }
    }
}

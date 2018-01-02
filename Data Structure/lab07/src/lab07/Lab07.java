/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab07;
import java.util.*;
/**
 *
 * @author 13101217
 */
public class Lab07 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayBased ab = new ArrayBased();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        
        char ch[] = str.toCharArray();
        
        for(int i =0; i < ch.length; i++){
            if(ch[i] == '[' || ch[i] == '{' || ch[i] == '('){
                ab.push(ch[i]);
            }
            else if(ch[i] == ']' || ch[i] == '}' || ch[i] == ')'){
                Object temp = ab.peak();
                if(ch[i] == ']'){
                    if(((char)temp) != '['){
                        System.out.println("error");
                    }
                    else{
                        Object te = ab.peak();
                    }
                }
                else if(ch[i] == '}'){
                    if(((char)temp) != '{'){
                        System.out.println("error");
                    }
                    else{
                        Object te = ab.peak();
                    }
                }
                
                    else if(ch[i] == ')'){
                    if(((char)temp) != '('){
                        System.out.println("error");
                    }
                    else{
                        Object te = ab.peak();
                    }
                }
            }
        }
        if(!ab.isEmpty()){
            System.out.println("Incorrect");
        }
    }
    
}

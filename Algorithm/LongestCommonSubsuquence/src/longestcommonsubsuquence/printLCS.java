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
public class printLCS {

    printLCS(vertex[][] ver, String s, int x, int y) {
        
    }
 
    public void print(vertex[][] vr, String s, int x, int y){
//        System.out.println("sdsdsd  "+vr[x][y].direct);
        if(x == 0 || y == 0){
            
        }else if(vr[x][y].direct == 1){
            print(vr, s, x-1, y-1);
            System.out.print(s.charAt(x));
        }
        else if(vr[x][y].direct == 2){
            print(vr, s, x-1, y);
//            System.out.println("hello");
        }
        else if(vr[x][y].direct == 3){
            print(vr, s, x, y-1);
//            System.out.println("world");
        }
//        System.out.println(vr[2][6].value);
    }
    
}

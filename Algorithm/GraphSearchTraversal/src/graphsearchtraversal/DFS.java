/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphsearchtraversal;

import java.io.*;
import java.util.*;

/**
 *
 * @author Utshab
 */
public class DFS {

//    public static int[] count (int[][] i) {
//        return null;
//    }
    int[][] matrix;
    vertex vr[];
    int component = 0;

    public int[][] matrix(String S) {
        try {
            FileReader fStream = new FileReader(S);
            BufferedReader br = new BufferedReader(fStream);
            String strLine;
            int x = -1, y = -1;
            boolean flag = false;
            while ((strLine = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(strLine, " ");
                while (st.hasMoreTokens()) {
                    String str = st.nextToken();
//                    System.out.println( str + " str");
                    if (flag == false) {
                        x = Integer.parseInt(str);
                        matrix = new int[x][x];
                        flag = true;
                        break;
                    } else {
                        x = Integer.parseInt(str);

                        y = Integer.parseInt(st.nextToken());

                        matrix[x][y] = 1;
                        matrix[y][x] = 1;
                    }
                    //str = st.nextToken();
                    // System.out.println(str);
                }
//                System.out.println(adjMatrix.length);
            }

        } catch (Exception e) {
            System.out.println("error occured while reading data" + e);
        }
        return matrix;
    }
    
    public void print(){
        for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
    }
    
    public void dfs(){
        int [][]G = matrix;
        
       // INITIALIZATION
        vr = new vertex [G.length];
        for (int i = 0; i < G.length; i++) {
            vr[i].colour = 0;
            vr[i].pi = -1;     
        }
        
        
        for(int i = 0; i < G.length; i++){
           for(int j = 0; j < G[i].length; j++){
               if(G[i][j] == 1){
                   if(vr[i].colour == 0){
                       component++;
                       System.err.println(i);
                        dfs_visit(i);
                    }
               }
               
           }
            
        }
        System.out.println("Component :"+ component);

    }
    public void dfs_visit(int u){
        vr[u].colour = 1;
        for (int i = 0; i < matrix.length; i++) {
            if(matrix[u][i] == 1){
                if(vr[u].colour == 0){
                    vr[i].pi = u;
                    dfs_visit(u);
                }
            }
            
        }
        vr[u].colour = 2;
        
    }
}

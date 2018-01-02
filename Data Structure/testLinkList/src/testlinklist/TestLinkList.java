/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testlinklist;

/**
 *
 * @author Utshab
 */
public class TestLinkList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        CreateNode cr = new CreateNode();
        for (int i = 5; i < 10; i++) {
            cr.AddNode(i);  
        }
        cr.removeList(5);
        cr.ShowList();
    }
}
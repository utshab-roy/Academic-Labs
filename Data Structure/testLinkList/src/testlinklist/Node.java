/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testlinklist;

/**
 *
 * @author Utshab
 */
public class Node {
    // The element that we want to put in the list
    public Object element;
    // The reference to the next node in the list
    public Node next;
    
    /**
     * Creates a new node with given element and next node reference.
     *
     * @param e the element to put in the node
     * @param n the next node in the list, which may be null
     */
    public Node(Object e, Node n) {
        element = e;
        next = n;
    }
}

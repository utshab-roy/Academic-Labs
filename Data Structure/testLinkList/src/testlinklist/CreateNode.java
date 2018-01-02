/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testlinklist;

/**
 *
 * @author Utshab
 */
public class CreateNode {

    Node head = null;
    Node tail = null;
    int size = 0;
  

    public void AddNode(int ob) {
        Node n = new Node(ob, null);
        if (head == null) {
            head = n;
            tail = n;
            size++;
        } else {
            tail.next = n;
            tail = tail.next;
            size++;
        }
    }

    public void removeList(int ob) {
        Node removeNode = null;
        for (Node n = head; n != null; n = n.next) {
            if (ob == n.element) {
                //    Node pred = nodeAt(head, index-1);
                //  System.out.println(pred.element);
                //  System.out.println("h" +head.element);
                removeNode = n;
                break;
            }
        }
        if (removeNode.equals(head)) {
            head = head.next;
        } else {
            Node pred = head;

            while (pred.next != removeNode) {
                pred = pred.next;
            }
            pred.next = pred.next.next;
        }
        removeNode = null;
    }

    public Node nodeAt(Node head, int index) {
        if (index < 0) {
            return null;                    // invalid index.  
        }
        Node n = head;
        for (int i = 0; i < index; i++, n = n.next)
        ;
        return n;
    }

    public void ShowList() {
        for (Node n = head; n != null; n = n.next) {
            System.out.println(n.element);
        }
    }
}

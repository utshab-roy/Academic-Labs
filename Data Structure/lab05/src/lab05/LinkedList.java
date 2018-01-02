/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab05;

/**
 *
 * @author 13101217
 */
public class LinkedList{
  public Node head;
  
  
  /* First Constructor:
   * Creates a linked list using the values from the given array. head will refer
   * to the Node that contains the element from a[0]
   */ 
  public LinkedList(Object [] a){
    // TO DO
      head = new Node(a[0], null);
      Node n = head;
      int i = 1;
      while(i < a.length){
          Node n2 = new Node(a[i], null);
          n.next = n2;
          n = n2;
          i++;
      }
  }
  
  /* Second Constructor:
   * Sets the value of head. head will refer
   * to the given LinkedList
   */
  public LinkedList(Node h){
    // TO DO
      head = h;
  }
  
  
  /* Counts the number of Nodes in the list */
  public int countNode(){
    // TO DO
      Node h = head;
      int count = 0;
      for(; h != null; h = h.next){
          count++;
      }
    return count; // please remove this line!
  }
  
  /* prints the elements in the list */
  public void printList(){
    // TO DO    
      Node h = head;
      for(; h != null; h = h.next){
          if(h.next == null){
              System.out.println(h.element+".");
          }else{
          System.out.print(h.element+", ");
          }
      }
      System.out.println();
  }
  
  // returns the reference of the Node at the given index. For invalid index return null.
  public Node nodeAt(int idx){
    // TO DO
      int i = 0;
      Node h = head;
      for(; h != null; h = h.next){
          if(i == idx){
              return h;
          }
          i++;
      }
    return null; // please remove this line!
  }
  
  
// returns the element of the Node at the given index. For invalid idx return null.
  public Object get(int idx){
    // TO DO
      int i = 0;
      Node h = head;
      for(; h != null; h = h.next){
          if(i == idx){
              return h.element;
          }
          i++;
      }
    return null; // please remove this line!
  }
  
  
  
  /* updates the element of the Node at the given index. 
   * Returns the old element that was replaced. For invalid index return null.
   * parameter: index, new element
   */
  public Object set(int idx, Object elem){
    // TO DO
      int i = 0;
      Node h = head;
      Object old = null;
      for(; h != null; h = h.next){
          if(i == idx){
              old = h.element;
              h.element = elem;
          }
          i++;
      }
    return old; // please remove this line!
  }
  
  
  /* returns the index of the Node containing the given element.
   if the element does not exist in the List, return -1.
   */
  public int indexOf(Object elem){
    // TO DO
      int idx = 0;
      Node h = head;
      for(; h != null; h = h.next){
          if(h.element.equals(elem)){
              return idx;
          }
          idx++;
      }
    return -1; // please remove this line!
  }
  
  // returns true if the element exists in the List, return false otherwise.
  public boolean contains(Object elem){
    // TO DO
      int idx = 0;
      Node h = head;
      for(; h != null; h = h.next){
          if(h.element.equals(elem)){
              return true;
          }
          idx++;
      }
    return false; // please remove this line!
  }
  
  // Makes a duplicate copy of the given List. Returns the reference of the duplicate list.
  public Node copyList(){
    // TO DO
      Node h = head;
      Node x = h;
      Node x2 = x;
      for(; h != null; h = h.next, x = x.next){
          x = h;
      }
      
    return x2; // please remove this line!
  }
  
  // Makes a reversed copy of the given List. Returns the head reference of the reversed list.
  public Node reverseList(){
    // TO DO
      int i = 0;
      Node rev = null;             
          for(Node h = head; h != null; h = h.next){
              Node mn = new Node(h.element, null);
              mn.next = rev;
              rev = mn;
          }
    return rev; // please remove this line!
  }
  
  /* inserts Node containing the given element at the given index
   * Check validity of index.
   */
  public void insert(Object elem, int idx){
    // TO DO
      int count = 0;
      Node temp = new Node(elem, null);
      
      if(idx == 0){
          temp.next = head;
          head = temp;
      }else{
      Node pred = head;
      for(Node h = head; h != null; h = h.next){
          if(count == idx){
              break;
          }
          pred = h;
          count++;
      }
      temp.next = pred.next;
      pred.next = temp;
    }
  }
  
  
  /* removes Node at the given index. returns element of the removed node.
   * Check validity of index. return null if index is invalid.
   */
  public Object remove(int index){
    // TO DO
      int count = 0;
      Node pred = null;
      if(index < 0 || index > countNode()){
          return null;
      }
      else{
          if(index == 0){
              Node temp = head;
              head = head.next;
              return temp.element;
          }
          else{
              for(Node n = head; n != null; n = n.next){
                  if(index == count){
                      pred.next = n.next;
                      return n.element;
                  }
                  pred = n;
                  count++;
              }
          }
      }
    return null; // please remove this line!
  }
  
  // Rotates the list to the left by 1 position.
  public void rotateLeft(){
    // TO DO
      Node temp = head;
      head = head.next;
      Node n = head;
      for(; n.next != null; n = n.next){
          ;
      }
      n.next = temp;
      temp.next = null;
  }
  
  // Rotates the list to the right by 1 position.
  public void rotateRight(){
    // TO DO
      Node pred = null;
      Node tail = head;
      
      while(tail.next != null){
          pred = tail;
          tail = tail.next;
      }
      
      tail.next = head;
      head = tail;
      
      pred.next = null;
  }
  
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cse220lab01;

/**
 *
 * @author Utshab
 */
import java.util.Scanner;
public class BookRecords {

    Scanner sc = new Scanner(System.in);
    int index = 0;
    Book bookArray[] = new Book[3];

    public void AddRecord(String n, String id, String au, String pub) {
        if (index == bookArray.length) {
            resize();
        }
        bookArray[index] = new Book();
        bookArray[index].Name = n;
        bookArray[index].Id = id;
        bookArray[index].Author = au;
        bookArray[index].Publisher = pub;
        index++;
    }

    public void resize() {
        Book temp[] = new Book[index * 2];
        for (int i = 0; i < index; i++) {
            temp[i] = bookArray[i];
        }
        bookArray = temp;
    }

    public void PrintRecord() {
        for (int i = 0; i < index; i++) {
            for (int j = i + 1; j < index; j++) {
                if (bookArray[i].Name.compareToIgnoreCase(bookArray[j].Name) != 0) {
                    if(bookArray[i].Name.compareToIgnoreCase(bookArray[j].Name) > 0){
                    Book temp;
                    temp = bookArray[i];
                    bookArray[i] = bookArray[j];
                    bookArray[j] = temp;
                    }
                } else if (bookArray[i].Id.compareToIgnoreCase(bookArray[j].Id) > 0) {
                    Book temp;
                    temp = bookArray[i];
                    bookArray[i] = bookArray[j];
                    bookArray[j] = temp;

                }
                //System.out.print("");
            }
        }
        for (int i = 0; i < index; i++) {
            System.out.print(bookArray[i].Name + " ");
            System.out.print(bookArray[i].Id + " ");
            System.out.print(bookArray[i].Author + " ");
            System.out.print(bookArray[i].Publisher + " ");
            System.out.println();
        }
    }

    public void DeleteRecord(String id) {
        int k = 0;
        for (int i = 0; i < index; i++) {
            if (bookArray[i].Id == id) {
                k = i;
                break;
            }
        }
        for (int j = k+1; j < index; j++) {
            bookArray[k] = bookArray[j];
        }
        bookArray[index-1] = null;
        index--;

    }
    
    public void EditRecord(String id){
        int k = 0, i = 0;
        for(  i = 0; i < index; i++){
            if(bookArray[i].Id.equals(id)){
                System.out.println("Enter new book name : ");
                bookArray[i].Name = sc.nextLine();
                System.out.println("Enter publisher name: ");
                bookArray[i].Publisher = sc.nextLine();
                break;
            } 
            }
        if(i == index){
                System.out.println("ID "+id+" does not exist");
            
        }
    }
}
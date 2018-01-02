/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cse220lab01;

/**
 *
 * @author Utshab
 */
public class Cse220lab01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BookRecords br = new BookRecords();
        br.AddRecord("AmraAsiTorsathe", "13101234", "Utshab", "Ananprokash");
        br.AddRecord("SpeedTheGoti", "13101230", "Jolil", "MostWelcome");
        br.AddRecord("KotoNodi", "13101217", "Mijan", "Amropaly");

       // br.DeleteRecord("13101217");
        
        br.EditRecord("13101234");
        br.PrintRecord();
        //br.AddRecord("Vujlam na", "131017303", "Anisul", "Somoi");

    }
}

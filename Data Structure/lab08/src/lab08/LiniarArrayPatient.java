/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab08;

/**
 *
 * @author Utshab
 */
public class LiniarArrayPatient {
    
    patient data [];
    int size = 0;
    int id = 01;
    
    static int paCount = 0;
    static int servedP = 0;
    
    int patientLeft = paCount - servedP;
    
    public LiniarArrayPatient() {
        System.out.println("Linear Array : ");
        size = 0;
        data = new patient[10];
    }
    
    public void resize() {
        patient[] temp = new patient[data.length * 2];
        for (int i = 0; i < size; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }
    
    public void RegisterPatient(Object s) {
        if (size == data.length) {
            resize();
        }
        
        size++;
        
        data[size - 1] = new patient();
        data[size - 1].name = (String) s;
        data[size - 1].Id = id++;
        paCount++;
    }
    
    public Object ServePatient() {
        if (size == 0) {
            return null;
        }
        Object obj = data[0];
        for (int i = 0; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[size] = null;
        size--;
        servedP++;
        return obj;
    }

    public void CancelAll() {
          System.out.println("Doctor canceled all appointments.");
        for (int i = 0; i < size; i++) {
            data[i] = null;
           // data[i].Id = 0;
        }
        size = 0;
    }

    public void CanDoctorGoHome() {
        if(size == 0){
            System.out.println("Yes. He can.");
        }else{
            System.out.println("No. He cannot.");
        }
    }
    
    public void ShowAllPatient() {
        int patientLeft = paCount - servedP;
        System.out.println("Total Patient: " + paCount + "     Patient Left: "
                + patientLeft + "     Served Patient: " + servedP + "\n");
        System.out.println("Patient Left :>--- ");
        if(size == 0) System.out.println("Cancelled All");
         patient [] sortList = this.sortedList();                 
        for (int i = 0; i < size; i++) {
            System.out.println("Name: " + sortList[i].name + " - ID: " + sortList[i].Id );
        }
        System.out.print("\n");
    }

    //First Copy, then sort ; otherwise we will lose acctual sequence.
    public patient[] copyData() {
        patient[] temp = new patient[data.length];
        for (int i = 0; i < size; i++) {
            temp[i] = data[i];
        }
        return temp;
    }

    public patient[] sortedList() {
        patient[] ar = this.copyData();
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (ar[i].name.compareToIgnoreCase(ar[j].name) > 0) {
                   patient tmp = ar[i];
                   ar[i] = ar[j];
                   ar[j] = tmp;
                }
            }
        }
        return ar;
    }

}

package com.naveen.learning.modifiers;

public class StudentDetail{


public static void main(String[] args){

    AttendanceLedger ledger = new AttendanceLedger();
    ledger.name = "naveen";
    ledger.gender = "male";
    System.out.println("Name   : " + ledger.name);
    System.out.println("Gender : " + ledger.gender);

}
    
}
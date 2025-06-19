package com.interview.patientmanagementsystem.features.baseview;

public abstract class BaseView {

    protected void exit(){
        System.exit(0);
    }

    protected void inValid(){
        System.out.println("Enter the vaild inputs");
    }


}

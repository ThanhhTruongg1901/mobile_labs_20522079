package com.example.lab02;

public class personal_salary {
    private String fullname;
    private int GrossSalary;

    public personal_salary(){}

    public personal_salary(String fullname, int GrossSalary){
        this.fullname = fullname;
        this.GrossSalary = GrossSalary;
    }

    public double GetSalary (int Gross){
        double temp = Gross + (1 - 0.105);
        if (temp <= 11000000) return temp;
        return 11000000 + (temp - 11000000)*(1-0.05);
    }
}

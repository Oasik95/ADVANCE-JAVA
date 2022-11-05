package com.domain;

public class Employee {

    private String empname;
    private double Yearlysalary;

    private double Monthlysalary;

    private double tax;
    private double nsal;

    private double Monthlytax;
    private double Monthlynsal;


    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public double getYearlysalary() {
        return Yearlysalary;
    }

    public void setYearlysalary(double yearlysalary) {
        Yearlysalary = yearlysalary;
    }



    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getNsal() {
        return nsal;
    }

    public void setNsal(double nsal) {
        this.nsal = nsal;
    }


    public double getMonthlysalary() {
        return Monthlysalary;
    }

    public void setMonthlysalary(double monthlysalary) {
        Monthlysalary = monthlysalary;
    }

    public double getTaxs()
    {
        double localTax=0;
        double remainingSalary=Yearlysalary-300000;
        if(remainingSalary>0){
            if (remainingSalary>=100000){
                localTax=localTax+(100000*5/100);

            }else {
                localTax=localTax+(remainingSalary*5/100);
            }
            remainingSalary=remainingSalary-100000;
        }

        if(remainingSalary>0){
            if (remainingSalary>=300000){
                localTax=localTax+(300000*10/100);

            }else {
                localTax=localTax+(remainingSalary*10/100);
            }
            remainingSalary=remainingSalary-300000;
        }

        if(remainingSalary>0){
            if (remainingSalary>=400000){
                localTax=localTax+(400000*15/100);

            }else {
                localTax=localTax+(remainingSalary*15/100);
            }
            remainingSalary=remainingSalary-400000;
        }

        if(remainingSalary>0){
            if (remainingSalary>=500000){
                localTax=localTax+(500000*20/100);

            }else {
                localTax=localTax+(remainingSalary*20/100);
            }
            remainingSalary=remainingSalary-500000;
        }


        if(remainingSalary>0){
            if (remainingSalary>500000){
                localTax=localTax+(500000*25/100);

            }else {
                localTax=localTax+(remainingSalary*25/100);
            }

        }





        return localTax;
    }

    public double getNetsal()
    {

        return nsal;
    }



    public double getMonthlytax() {
        return Monthlytax;
    }

    public void setMonthlytax(double Monthlytax) {
        this.Monthlytax = Monthlytax;
    }

    public double getMonthlynsal() {
        return Monthlynsal;
    }

    public void setMonthlynsal(double Monthlynsal) {
        this.Monthlynsal = Monthlynsal;
    }

    public double getMonthlytaxs()
    {

        return Monthlytax;
    }

    public double getMonthlyNetsal()
    {

        return Monthlynsal;
    }


}

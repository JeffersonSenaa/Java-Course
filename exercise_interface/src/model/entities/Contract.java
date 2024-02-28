package model.entities;

import java.time.LocalDate;

public class Contract {
    private int number;
    private LocalDate date;
    private double totalValue;
    private Installment installment;

    public Contract(){

    }
    public Contract(int number, LocalDate date, double totalValue) {
        this.number = number;
        this.date = date;
        this.totalValue = totalValue;
    }
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public double getTotalValue() {
        return totalValue;
    }
    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }
    @Override
    public String toString() {
        return "Contract [number=" + number + ", date=" + date + ", totalValue=" + totalValue + "]";
    }
    
}

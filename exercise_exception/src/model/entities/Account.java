package model.entities;

import model.exceptions.DomainException;

public class Account {
    private int number;
    private String holder;
    private float balance;
    private float withdrawLimit;

    public Account(){

    }
    public Account(int number, String holder, float balance, float withdrawLimit) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public String getHolder() {
        return holder;
    }
    public void setHolder(String holder) {
        this.holder = holder;
    }
    public float getBalance() {
        return balance;
    }
    public float getWithdrawLimit() {
        return withdrawLimit;
    }
    public void setWithdrawLimit(float withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }

    public void Deposit(float amount){
        this.balance += amount;
    }
    public void Withdraw(float amount) throws DomainException{
        if(this.balance == 0){
            throw new DomainException("The account has no balance");
        }
        if(this.balance < amount){
            throw new DomainException("The withdrawal amount is greater than the balance");
        }
        if(this.withdrawLimit < amount){
            throw new DomainException("The withdrawal amount is greater than the withdrawal limit");
        }
        this.balance -= amount;
    }
    @Override
    public String toString() {
        return "Account [number=" + number + ", holder=" + holder + ", balance=" + balance + ", withdrawLimit="
                + withdrawLimit + "]";
    }
}

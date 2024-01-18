package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainException;

public class Main {
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        try{
            System.out.println("Enter account data:");
            System.out.print("Number: ");
            int number = sc.nextInt();
            System.out.print("Holder: ");
            sc.nextLine();
            String holder = sc.nextLine();
            System.out.print("Initial balance: ");
            float balance = sc.nextFloat();
            System.out.print("Withdraw limit: ");
            float withdrawLimit = sc.nextFloat();
            System.out.println();

            Account acc = new Account(number, holder, balance, withdrawLimit);

            System.out.print("Enter amount for withdraw: ");
            float amount = sc.nextFloat();

            acc.Withdraw(amount);
            System.out.println(acc);
            sc.close();
        }
        catch(RuntimeException e){
            throw new RuntimeException("Unexpected error");
        }
        catch(DomainException e){
            System.out.println("Error in withdrawal: " + e.getMessage());
        }
    }
}
package model.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {

    private OnlinePaymentService paymentService;

    public void processContract(Contract contract, int months, OnlinePaymentService paymentService){
        LocalDate dueDate = contract.getDate();
        List<Installment> list = new ArrayList<>();

        double installmentValue = contract.getTotalValue()/months;

        for(int i=1; i <= months; i++){
            LocalDate date = dueDate.plusMonths(i);
            double interest = paymentService.interest(installmentValue, i);
            double free = paymentService.paymentFree(installmentValue + interest);
            double quota = installmentValue + interest + free;
            list.add(new Installment(date, quota));
        }
        System.out.println("Parcelas: ");
        for (Installment parcel : list){
            System.out.println(parcel);
        }
    }
}

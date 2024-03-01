package model.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {

    private OnlinePaymentService paymentService;

    public ContractService(OnlinePaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void processContract(Contract contract, int months){
        LocalDate dueDate = contract.getDate();

        double installmentValue = contract.getTotalValue()/months;

        for(int i=1; i <= months; i++){
            LocalDate date = dueDate.plusMonths(i);
            double interest = paymentService.interest(installmentValue, i);
            double free = paymentService.paymentFree(installmentValue + interest);
            double quota = installmentValue + interest + free;
            contract.getInstallment().add(new Installment(date, quota));
        }
    
    }
}

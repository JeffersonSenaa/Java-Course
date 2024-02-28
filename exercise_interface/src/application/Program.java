package application;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.services.ContractService;
import model.services.PaypalService;

public class Program {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Entre com os dados do contrato ");
        System.out.print("Número: ");
        int numContrato = sc.nextInt();
        sc.nextLine();
        System.out.print("Data (dd/MM/yyyy)");
        LocalDate start = LocalDate.parse(sc.nextLine(), fmt);
        System.out.print("Valor do Contrato: ");
        double totalValue = sc.nextDouble();
        sc.nextLine();
        System.out.print("Entre com o número de parcelas: ");
        int amount = sc.nextInt();

        Contract contract = new Contract(numContrato, start, totalValue);

        ContractService service = new ContractService();
        service.processContract(contract, amount, new PaypalService());

        sc.close();
    }
}

package services;

import java.time.LocalDate;

import entities.Contract;
import entities.Installments;

public class ContractService {
	
	public void processContract(Contract contract, Integer months, OnlinePaymentService paymentService) {
		Double amount = contract.getTotalValue();
		Double mensalValue = amount / months;
		
		for (int i = 1; i <= months; i++) {
			LocalDate month = contract.getDate().plusMonths(i);
			Double value = paymentService.paymentFee(paymentService.interest(mensalValue, i));
			contract.getInstallments().add(new Installments(month, value));
		}
	}
}

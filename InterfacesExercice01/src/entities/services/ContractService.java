package entities.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import entities.Contract;
import entities.Installment;

public class ContractService {
	private Contract contract;
	private int numberOfMonths;
		
	private PaymentService paymentService;
	
	public ContractService(Contract contract, int numberOfMonths, PaymentService paymentService) {
		this.contract = contract;
		this.paymentService = paymentService;
		this.numberOfMonths = numberOfMonths;
	}
	
	private LocalDate nextMonthDate (LocalDate date, int months) {
		return date.plusMonths(months);
	}
	
	private void calcInstallments() {
		double partialValue = contract.getTotal() / numberOfMonths;
		double interests;
		double payRate;
		double totalValue;
		
		for(int i=0; i<numberOfMonths; i++) {
			interests = paymentService.interests(partialValue, i+1);
			payRate = paymentService.payRate(partialValue + interests);
			totalValue = partialValue + interests + payRate;
			
			LocalDate date = nextMonthDate(contract.getDate(), i+1);
			Installment installment = new Installment(date, totalValue);
			
			contract.getInstallments().add(installment);
		}
	}
	
	
	public List <Installment> getInstallments(){
		calcInstallments();
		return contract.getInstallments();
	}
	

}

package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Contract {
	private static DateTimeFormatter dataFormat1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	private int number;
	private LocalDate date;
	private double total;
	private List <Installment> installments;

	public Contract(int number, LocalDate date, double total) {
		this.number = number;
		this.date = date;
		this.total = total;
		this.installments = new ArrayList <> ();
	}

	public int getNumber() {
		return number;
	}

	public LocalDate getDate() {
		return date;
	}

	public double getTotal() {
		return total;
	}
	
	public List<Installment> getInstallments() {
		return installments;
	}

	@Override
	public String toString() {
		return "Contract [number=" + number + ", date=" + date.format(dataFormat1) + ", total= "
				+ String.format("%.2f", total) + "]";
	}

}

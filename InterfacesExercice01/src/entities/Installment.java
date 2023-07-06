package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Installment {
	private static DateTimeFormatter dataFormat1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	private LocalDate dueDate;
	private double value;
	
	public Installment() {
	}
	
	public Installment(LocalDate dueDate, double value) {
		this.dueDate = dueDate;
		this.value = value;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public double getValue() {
		return value;
	}

	@Override
	public String toString() {
		return dueDate.format(dataFormat1) + " - " + String.format("%.2f", value) + " €";
	}
	
	

}

package entities;

import java.time.LocalDate;

public class HourContract {
	private LocalDate date;
	private Double valuePerHour;
	private int hours;
	
	public HourContract() {}
	
	public HourContract(LocalDate date, Double valuePerHour, int hours) {
		super();
		this.date = date;
		this.valuePerHour = valuePerHour;
		this.hours = hours;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Double getValuePerHour() {
		return valuePerHour;
	}

	public void setValuePerHour(Double valuePerHour) {
		this.valuePerHour = valuePerHour;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}
	
	public Double totalValue() {
		return hours * valuePerHour;
	}
	

}

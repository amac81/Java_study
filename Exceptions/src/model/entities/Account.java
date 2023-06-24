package model.entities;

import model.exceptions.BusinessException;

public class Account {
	private int number;
	private String holder;
	private Double balance;
	private Double withDrawLimit;

	public Account(int number, String holder, Double balance, Double withDrawLimit) {
		super();
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withDrawLimit = withDrawLimit;
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

	public Double getBalance() {
		return balance;
	}

	public Double getWithDrawLimit() {
		return withDrawLimit;
	}

	public void deposit(Double amount) {
		balance += amount;
	}

	public void withDraw(Double amount) {
		validateWithDraw(amount);
		balance -= amount;
	}

	public void validateWithDraw(Double amount) throws BusinessException {

		if (amount > getWithDrawLimit())
		{
			String errorMsg;
			errorMsg = "WITHDRAW ERROR: The amount " + amount + " exceeds the widraw limit of " + getWithDrawLimit()
					+ ".";

			throw new BusinessException(errorMsg);
		}

		if (amount > getBalance()) {
			throw new BusinessException("WITHDRAW ERROR: Not enough balance.");
		}

	}

}

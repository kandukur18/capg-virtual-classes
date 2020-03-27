package com.capg.pecunia.banking.management.model;

public class Loan {
	private String accountId;
	private int tenure;
	private double amount;
	private double rateOfInterest;
	private String loanStatus;
	private int creditScore;
	private double accountBalance;
	private double emi;
	public Loan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Loan(String accountId, int tenure, double amount, double rateOfInterest, String loanStatus, int creditScore,
			double accountBalance, double emi) {
		super();
		this.accountId = accountId;
		this.tenure = tenure;
		this.amount = amount;
		this.rateOfInterest = rateOfInterest;
		this.loanStatus = loanStatus;
		this.creditScore = creditScore;
		this.accountBalance = accountBalance;
		this.emi = emi;
	}
	@Override
	public String toString() {
		return "Loan [accountId=" + accountId + ", tenure=" + tenure + ", amount=" + amount + ", rateOfInterest="
				+ rateOfInterest + ", loanStatus=" + loanStatus + ", creditScore=" + creditScore + ", accountBalance="
				+ accountBalance + ", emi=" + emi + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(accountBalance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((accountId == null) ? 0 : accountId.hashCode());
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + creditScore;
		temp = Double.doubleToLongBits(emi);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((loanStatus == null) ? 0 : loanStatus.hashCode());
		temp = Double.doubleToLongBits(rateOfInterest);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + tenure;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Loan other = (Loan) obj;
		if (Double.doubleToLongBits(accountBalance) != Double.doubleToLongBits(other.accountBalance))
			return false;
		if (accountId == null) {
			if (other.accountId != null)
				return false;
		} else if (!accountId.equals(other.accountId))
			return false;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (creditScore != other.creditScore)
			return false;
		if (Double.doubleToLongBits(emi) != Double.doubleToLongBits(other.emi))
			return false;
		if (loanStatus == null) {
			if (other.loanStatus != null)
				return false;
		} else if (!loanStatus.equals(other.loanStatus))
			return false;
		if (Double.doubleToLongBits(rateOfInterest) != Double.doubleToLongBits(other.rateOfInterest))
			return false;
		if (tenure != other.tenure)
			return false;
		return true;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public int getTenure() {
		return tenure;
	}
	public void setTenure(int tenure) {
		this.tenure = tenure;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getRateOfInterest() {
		return rateOfInterest;
	}
	public void setRateOfInterest(double rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}
	public String getLoanStatus() {
		return loanStatus;
	}
	public void setLoanStatus(String loanStatus) {
		this.loanStatus = loanStatus;
	}
	public int getCreditScore() {
		return creditScore;
	}
	public void setCreditScore(int creditScore) {
		this.creditScore = creditScore;
	}
	public double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	public double getEmi() {
		return emi;
	}
	public void setEmi(double emi) {
		this.emi = emi;
	}
	


}

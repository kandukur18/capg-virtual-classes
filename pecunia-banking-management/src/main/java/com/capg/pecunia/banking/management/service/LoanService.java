package com.capg.pecunia.banking.management.service;

import java.util.List;

import com.capg.pecunia.banking.management.exception.LoanException;
import com.capg.pecunia.banking.management.model.Loan;

public interface LoanService {
	public Loan addLoanDetails(String accountId, double amount, int tenure, double rateOfInterest, int creditScore ) throws LoanException;
	public String createLoanRequest(Loan loan) throws LoanException;
	public List<Loan> loanRequestList() throws LoanException;
	public List<Loan> loanApprovalList(Loan loan) throws LoanException;
	public boolean validateAmount(double amount);
	public boolean validateTenure(int tenure);
	public boolean validateRateOfInterest(double rateOfInterest);
	public boolean validateCreditScore(int creditScore);
	public String loanApprovalStatus(Loan loan) throws LoanException;
	public double calculateEmiForLoan(Loan loan) throws LoanException;


}

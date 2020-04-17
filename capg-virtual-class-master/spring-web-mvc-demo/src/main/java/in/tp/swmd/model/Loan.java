package in.tp.swmd.model;

public class Loan {
private double principle;
private double rate;
private int time;
private double interest;
public double getPrinciple() {
	return principle;
}
public void setPrinciple(double principle) {
	this.principle = principle;
}
public double getRate() {
	return rate;
}
public void setRate(double rate) {
	this.rate = rate;
}
public int getTime() {
	return time;
}
public void setTime(int time) {
	this.time = time;
}
public double getInterest() {
	return interest;
}
public void setInterest(double interest) {
	this.interest = interest;
}
public Loan(double principle, double rate, int time, double interest) {
	super();
	this.principle = principle;
	this.rate = rate;
	this.time = time;
	this.interest = interest;
}

}

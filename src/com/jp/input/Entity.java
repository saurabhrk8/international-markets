package com.jp.input;

import java.util.Date;

public class Entity {
	
	private String customerName;
	private String typeOfPurchase;
	private double aggredFx;
	private String currency;
	
	private Date instructionDate;
	private Date  settlementDate;
	
	private int units;
	
	private double priceperunit;

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getTypeOfPurchase() {
		return typeOfPurchase;
	}

	public void setTypeOfPurchase(String typeOfPurchase) {
		this.typeOfPurchase = typeOfPurchase;
	}

	public double getAggredFx() {
		return aggredFx;
	}

	public void setAggredFx(double aggredFx) {
		this.aggredFx = aggredFx;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Date getInstructionDate() {
		return instructionDate;
	}

	public void setInstructionDate(Date instructionDate) {
		this.instructionDate = instructionDate;
	}

	public Date getSettlementDate() {
		return settlementDate;
	}

	public void setSettlementDate(Date settlementDate) {
		this.settlementDate = settlementDate;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}

	public double getPriceperunit() {
		return priceperunit;
	}

	public void setPriceperunit(double priceperunit) {
		this.priceperunit = priceperunit;
	}
	
	
	

}

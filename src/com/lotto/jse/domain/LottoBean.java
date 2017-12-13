package com.lotto.jse.domain;

public class LottoBean {
	private String money, number;

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "LottoBean [number=" + number + "]";
	}
	

	


	
	
}

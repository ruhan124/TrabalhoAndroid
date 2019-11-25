package com.ruhan.swapp;

public enum NumOpcao{
	YES("SIM"),
	NO("NÃO");

	private String option;

	NumOpcao(String option) {
		this.option = option;
	}

	public String getOption() {
		return option;
	}
}

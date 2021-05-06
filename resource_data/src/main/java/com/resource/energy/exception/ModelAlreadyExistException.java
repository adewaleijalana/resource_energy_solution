package com.resource.energy.exception;

import lombok.Data;


@Data
public class ModelAlreadyExistException extends RuntimeException {

	private String fieldOrClassName;
	private String argumentSupplied;
	private String errorCode;

	public ModelAlreadyExistException(String fieldOrClassName, String argumentSupplied) {
		super(argumentSupplied);
		this.fieldOrClassName = fieldOrClassName;
		this.argumentSupplied = argumentSupplied;
	}

	public ModelAlreadyExistException(String fieldOrClassName, String argumentSupplied,String errorCode) {
		super(argumentSupplied);
		this.fieldOrClassName = fieldOrClassName;
		this.argumentSupplied = argumentSupplied;
		this.errorCode= errorCode;
	}

	public ModelAlreadyExistException(String argumentSupplied) {
		this.argumentSupplied = argumentSupplied;

	}
}

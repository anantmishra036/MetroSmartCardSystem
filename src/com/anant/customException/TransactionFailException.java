package com.anant.customException;

public class TransactionFailException extends Exception{
	
	public TransactionFailException() {
		super();
	}
	
	public TransactionFailException(String pMessage) {
		super(pMessage);
	}

}

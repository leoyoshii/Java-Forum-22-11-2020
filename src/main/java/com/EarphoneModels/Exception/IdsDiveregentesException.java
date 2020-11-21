package com.EarphoneModels.Exception ;

public class IdsDiveregentesException extends RuntimeException {
  private static final long serialVersionUID = 1L;

	public IdsDiveregentesException(String msg) {
		super(msg);
	}
	public IdsDiveregentesException(String msg, Exception cause){
        super(msg, cause);
  }
}

package com.EarphoneModels.Exception ;

public class RegistroNãoEncontradoException extends RuntimeException {

  private static final long serialVersionUID = 1L;

	public RegistroNãoEncontradoException(String msg) {
		super(msg);
	}
	public RegistroNãoEncontradoException(String msg, Exception cause){
        super(msg, cause);
  }
}

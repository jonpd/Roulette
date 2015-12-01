package roulette.impl;

public class RouletteGameException extends Exception {

	public RouletteGameException() {
		super();
	}

	public RouletteGameException(String message) {
		super(message);
	}

	public RouletteGameException(String message, Throwable cause) {
		super(message, cause);
	}

	public RouletteGameException(Throwable cause) {
		super(cause);
	}

	public RouletteGameException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}

package roulette.impl;

import roulette.IPocket;

public class Pocket implements IPocket {

	private String value;

	public Pocket(String value) {

		this.value = value;
	}

	@Override
	public String getValue() {

		return value;
	}

	@Override
	public boolean isEven() {

		try {

			boolean isEven = Integer.parseInt(value) % 2 == 0;
			return isEven;
		}
		catch (NumberFormatException ex) {

			return false;
		}
	}

	@Override
	public boolean isOdd() {

		try {

			boolean isOdd = Integer.parseInt(value) % 2 != 0;
			return isOdd;
		}
		catch (NumberFormatException ex) {

			return false;
		}
	}

	@Override
	public boolean equals(Object obj) {

		try {

			IPocket otherPocket = (IPocket) obj;
			return this.getValue().equals(otherPocket.getValue());
		}
		catch (ClassCastException ex) {

			return false;
		}
	}

	@Override
	public String toString() {
		return String.valueOf(value);
	}

}

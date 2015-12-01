package roulette.impl;

import java.util.Objects;
import java.util.Random;
import roulette.IBet;
import roulette.ICustomer;
import roulette.IWheel;

public class Customer implements ICustomer {

	private int balance;

	public Customer(int initialBalance) {

		this.balance = initialBalance;
	}

	@Override
	public void placeBet(IBet bet) {

		balance -= bet.getValue();
	}

	@Override
	public void addWinnings(int winnings) {

		balance += winnings;
	}

	@Override
	public int getBalance() {
		return balance;
	}
}

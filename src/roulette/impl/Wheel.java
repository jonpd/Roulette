package roulette.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import roulette.IWheel;
import java.util.Random;
import roulette.IPocket;

public class Wheel implements IWheel {

	private List<IPocket> pocketList = new ArrayList<IPocket>();
	private Random random;

	public Wheel(int pockets) {

		// house special
		pocketList.add(new Pocket("00"));

		for (int i = 0; i < pockets; i++) {

			pocketList.add(new Pocket(String.valueOf(i)));
		}

		random = new Random();
	}

	@Override
	public List<IPocket> getPockets() {

		return pocketList;
	}

	@Override
	public IPocket spin() {

		int randomIndex = random.nextInt(pocketList.size());
		return (Pocket) pocketList.get(randomIndex);
	}

	@Override
	public boolean isValidPocket(IPocket pocket) {

		return pocketList.contains(pocket);
	}
}

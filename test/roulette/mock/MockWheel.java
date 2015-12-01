package roulette.mock;

import java.util.ArrayList;
import java.util.List;
import roulette.IPocket;
import roulette.IWheel;
import roulette.impl.Pocket;

public class MockWheel implements IWheel {

	private List<IPocket> pocketList = new ArrayList<IPocket>();
	private IPocket landedPocket;

	public MockWheel(int chosenPocket, int pockets) {

		landedPocket = new Pocket(String.valueOf(chosenPocket));

		// house special
		pocketList.add(new Pocket("00"));

		for (int i = 0; i < pockets; i++) {

			pocketList.add(new Pocket(String.valueOf(i)));
		}
	}

	@Override
	public List<IPocket> getPockets() {

		return pocketList;
	}

	@Override
	public IPocket spin() {

		return landedPocket;
	}

	@Override
	public boolean isValidPocket(IPocket pocket) {

		return pocketList.contains(pocket);
	}
}

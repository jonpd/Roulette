package roulette;

import java.util.List;
import roulette.impl.Pocket;

public interface IWheel {

	List<IPocket> getPockets();
	IPocket spin();
	boolean isValidPocket(IPocket pocket);
}

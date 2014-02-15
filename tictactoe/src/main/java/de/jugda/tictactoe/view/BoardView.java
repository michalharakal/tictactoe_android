package de.jugda.tictactoe.view;

import tictactoe.core.Coordinate;
import tictactoe.core.Value;

public interface BoardView {

	public void resetAllButtons();
	
	public void showFieldState(Coordinate c, Value v);
}

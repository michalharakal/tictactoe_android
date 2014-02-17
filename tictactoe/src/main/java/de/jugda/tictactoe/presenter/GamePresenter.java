package de.jugda.tictactoe.presenter;

import javax.inject.Inject;

import tictactoe.core.Coordinate;
import tictactoe.core.IBoard;
import tictactoe.core.Value;
import de.jugda.tictactoe.view.BoardView;

public class GamePresenter {

	private BoardView gameView;
	private IBoard board;

	@Inject
	public GamePresenter(BoardView gameView, IBoard board) {
		this.gameView = gameView;
		this.board = board;

	}

	public void setField(Coordinate c) {
		gameView.showFieldState(c, Value.o);
	}

	public void resetBoard() {
		gameView.resetAllButtons();
	}

}

package de.jugda.tictactoe.presenter;

import de.jugda.tictactoe.view.BoardView;
import tictactoe.core.Coordinate;
import tictactoe.core.Value;

public class GamePresenter {

	private BoardView view;	
	private Game game;
	
  public void setField(Coordinate c)
  {
	  // Value probably depends to player in model
	  
	  // Check with game engine, if move is okay
	  
	  // if okay, change state of field in model
	  // and update the view
	  
  }
  
  public void resetBoard()
  {
	  game = new Game(1);
	  view.resetAllButtons();
  }
  
}

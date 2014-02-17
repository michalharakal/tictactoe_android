package de.jugda.tictactoe.modules;

import javax.inject.Singleton;

import tictactoe.core.Board;
import tictactoe.core.IBoard;
import dagger.Module;
import dagger.Provides;
import de.jugda.tictactoe.presenter.GamePresenter;
import de.jugda.tictactoe.view.BoardView;

@Module( injects = { GamePresenter.class })
public class LocalGameModule {

	private final BoardView view;

	public LocalGameModule(BoardView aView) {
		view = aView;

	}

	@Provides
	@Singleton
	BoardView provideView() {
		return view;
	}

	@Singleton
	@Provides
	IBoard provideModel() {
		return new Board();
	}

}

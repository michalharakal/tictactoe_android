package de.jugda.tictactoe;

import java.util.ArrayList;
import java.util.List;

import android.app.Application;
import dagger.ObjectGraph;
import de.jugda.tictactoe.modules.AndroidModule;

public class TicTacToeApplication extends Application {

	private ObjectGraph graph;

	@Override
	public void onCreate() {
		super.onCreate();

		graph = ObjectGraph.create(getModules().toArray());
	}

	protected List<Object> getModules() {
		ArrayList<Object> result = new ArrayList<Object>();
		result.add(new AndroidModule(this));
		return result;
	}

	public void plusModule(Object subTree) {
		graph.plus(subTree);
	}

	public void inject(Object object) {
		graph.inject(object);
	}

	public <T> T get(Class<T> type) {
		return graph.get(type);
	}

}

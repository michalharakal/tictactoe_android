package de.jugda.tictactoe;

import tictactoe.core.Coordinate;
import tictactoe.core.Value;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import dagger.ObjectGraph;
import de.jugda.tictactoe.modules.LocalGameModule;
import de.jugda.tictactoe.presenter.GamePresenter;
import de.jugda.tictactoe.view.BoardView;

public class MainActivity extends Activity implements OnClickListener,
		BoardView {

	private GamePresenter gp;
	private Button button1;
	private Button button2;
	private Button button3;
	private Button button4;
	private Button button5;
	private Button button6;
	private Button button7;
	private Button button8;
	private Button button9;
	private Button buttonRestart;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		ObjectGraph graph = ObjectGraph.create(new LocalGameModule(this));

		gp = graph.get(GamePresenter.class);
		button1 = (Button) findViewById(R.id.button1);
		button1.setOnClickListener(this);

		button2 = (Button) findViewById(R.id.button2);
		button2.setOnClickListener(this);

		button3 = (Button) findViewById(R.id.button3);
		button3.setOnClickListener(this);

		button4 = (Button) findViewById(R.id.button4);
		button4.setOnClickListener(this);

		button5 = (Button) findViewById(R.id.button5);
		button5.setOnClickListener(this);

		button6 = (Button) findViewById(R.id.button6);
		button6.setOnClickListener(this);

		button7 = (Button) findViewById(R.id.button7);
		button7.setOnClickListener(this);

		button8 = (Button) findViewById(R.id.button8);
		button8.setOnClickListener(this);

		button9 = (Button) findViewById(R.id.button9);
		button9.setOnClickListener(this);

		buttonRestart = (Button) findViewById(R.id.buttonRestart);
		buttonRestart.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View view) {

		switch (view.getId()) {
		case R.id.button1:
			gp.setField(Coordinate.A1);
			break;
		case R.id.button2:
			gp.setField(Coordinate.A2);
			break;
		case R.id.button3:
			gp.setField(Coordinate.A3);
			break;
		case R.id.button4:
			gp.setField(Coordinate.B1);
			break;
		case R.id.button5:
			gp.setField(Coordinate.B2);
			break;
		case R.id.button6:
			gp.setField(Coordinate.B3);
			break;
		case R.id.button7:
			gp.setField(Coordinate.C1);
			break;
		case R.id.button8:
			gp.setField(Coordinate.C2);
			break;
		case R.id.button9:
			gp.setField(Coordinate.C3);
			break;
		case R.id.buttonRestart:
			gp.resetBoard();
			break;

		}
	}

	@Override
	public void resetAllButtons() {
		button1.setText(null);
		button2.setText(null);
		button3.setText(null);
		button4.setText(null);
		button5.setText(null);
		button6.setText(null);
		button7.setText(null);
		button8.setText(null);
		button9.setText(null);

		buttonRestart.setEnabled(false);
	}

	@Override
	public void showFieldState(Coordinate c, Value v) {

		if (!buttonRestart.isEnabled())
			buttonRestart.setEnabled(true);

		String buttonText = getString((v == Value.x) ? R.string.field_value_x
				: R.string.filed_value_o);
		Button button = null;

		switch (c) {
		case A1:
			button = button1;
			break;
		case A2:
			button = button2;
			break;
		case A3:
			button = button3;
			break;
		case B1:
			button = button4;
			break;
		case B2:
			button = button5;
			break;
		case B3:
			button = button6;
			break;
		case C1:
			button = button7;
			break;
		case C2:
			button = button8;
			break;
		case C3:
			button = button9;
			break;
		}

		button.setText(buttonText);
	}

}

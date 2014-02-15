package com.github.tictactoe;

import static android.content.Intent.ACTION_MAIN;
import static android.content.Intent.CATEGORY_LAUNCHER;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

public class DemoActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		if (isWrongInstance()) {
			finish();
			return;
		}

		setContentView(R.layout.activity_main);

	}

	/** Inform the view about up events. */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == android.R.id.home) {
			// MainView view = getMainView();
			// return view.onUpPressed();
			return false;
		}

		return super.onOptionsItemSelected(item);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();

		// actionBarOwner.dropView(this);

	}

	/**
	 * Dev tools and the play store (and others?) launch with a different
	 * intent, and so lead to a redundant instance of this activity being
	 * spawned. <a href=
	 * "http://stackoverflow.com/questions/17702202/find-out-whether-the-current-activity-will-be-task-root-eventually-after-pendin"
	 * >Details</a>.
	 */
	private boolean isWrongInstance() {
		if (!isTaskRoot()) {
			Intent intent = getIntent();
			boolean isMainAction = intent.getAction() != null
					&& intent.getAction().equals(ACTION_MAIN);
			return intent.hasCategory(CATEGORY_LAUNCHER) && isMainAction;
		}
		return false;
	}

}

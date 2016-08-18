package com.bignerdranch.android.transitionexample;

import android.os.Bundle;
import android.support.transition.Fade;
import android.support.transition.Scene;
import android.support.transition.TransitionManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;

public class TransitionActivity extends AppCompatActivity {
	private TransitionManager mTransitionManager;
	private Scene mScene1;
	private Scene mScene2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_transition);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
			                           .add(R.id.container, new TransitionFragment())
			                           .commit();
		}
		ViewGroup container = (ViewGroup) findViewById(R.id.container);
		mScene1 = Scene.getSceneForLayout(container, R.layout.fragment_transition_scene_1, this);
		mScene2 = Scene.getSceneForLayout(container, R.layout.fragment_transition_scene_2, this);
		mTransitionManager = new TransitionManager();
		mTransitionManager.setTransition(mScene1, mScene2, new Fade());

	}

	public void goToScene1(View view) {
		mTransitionManager.transitionTo(mScene1);
	}

	public void goToScene2(View view) {
		mTransitionManager.transitionTo(mScene2);
	}

}

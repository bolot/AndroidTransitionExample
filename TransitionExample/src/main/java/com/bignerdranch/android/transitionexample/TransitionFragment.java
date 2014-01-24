package com.bignerdranch.android.transitionexample;

import android.app.Fragment;
import android.os.Bundle;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A placeholder fragment containing a simple view.
 */
public class TransitionFragment extends Fragment {

    public TransitionFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_transition_scene_1, container, false);
        View secondView = inflater.inflate(R.layout.fragment_transition_scene_2, container, false);
        final Scene scene = new Scene(container, (ViewGroup)secondView);
        Button goButton = (Button)rootView.findViewById(R.id.goButton);
        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToScene(scene);
            }
        });
        final Scene originalScene = new Scene(container, (ViewGroup)rootView);
        Button goBackButton = (Button)secondView.findViewById(R.id.goButton);
        goBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToScene(originalScene);
            }
        });
        return rootView;
    }

    private void goToScene(Scene scene) {
        TransitionInflater transitionInflater = TransitionInflater.from(getActivity());
        Transition transition = transitionInflater.inflateTransition(R.transition.slow_auto_transition);
        TransitionManager.go(scene, transition);
    }
}

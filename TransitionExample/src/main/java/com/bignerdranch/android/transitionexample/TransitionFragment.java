package com.bignerdranch.android.transitionexample;

import android.app.Fragment;
import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.Fade;
import android.transition.Scene;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
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
        final Scene scene = Scene.getSceneForLayout(container, R.layout.fragment_transition_scene_2, getActivity());
        Button goButton = (Button)rootView.findViewById(R.id.goButton);
        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToScene(scene);
            }
        });
        return rootView;
    }

    private void goToScene(Scene scene) {
        ChangeBounds changeBounds = new ChangeBounds();
        Fade fadeOut = new Fade(Fade.OUT);
        Fade fadeIn = new Fade(Fade.IN);
        TransitionSet transition = new TransitionSet();
        transition.setOrdering(TransitionSet.ORDERING_SEQUENTIAL);
        transition
                .addTransition(fadeOut)
                .addTransition(changeBounds)
                .addTransition(fadeIn);
        TransitionManager.go(scene, transition);
    }
}

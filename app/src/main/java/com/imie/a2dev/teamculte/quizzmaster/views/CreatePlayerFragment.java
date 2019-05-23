package com.imie.a2dev.teamculte.quizzmaster.views;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.imie.a2dev.teamculte.quizzmaster.R;

/**
 * Fragment managing the player creation.
 */
public class CreatePlayerFragment extends Fragment {
    public CreatePlayerFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_player, container, false);
    }
}

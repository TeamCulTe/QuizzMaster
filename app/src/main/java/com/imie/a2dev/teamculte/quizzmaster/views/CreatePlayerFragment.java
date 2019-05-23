package com.imie.a2dev.teamculte.quizzmaster.views;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.EditText;
import android.widget.TextView;
import com.imie.a2dev.teamculte.quizzmaster.R;
import com.imie.a2dev.teamculte.quizzmaster.entities.dbentities.Player;
import com.imie.a2dev.teamculte.quizzmaster.managers.PlayerDbManager;

/**
 * Fragment managing the player creation.
 */
public class CreatePlayerFragment extends Fragment implements View.OnClickListener {
    /**
     * Stores the player name edit text.
     */
    private EditText editTxtPlayer;

    /**
     * Stores the error text.
     */
    private TextView txtError;
    
    public CreatePlayerFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_create_player, container, false);
        
        this.init(view);
        
        return view;
    }

    @Override
    public void onClick(View view) {
        if (CreatePlayerFragment.this.validateData() && !this.getRealActivity().hasAllPlayers()) {
            Player player = new Player(this.editTxtPlayer.getText().toString());

            new PlayerDbManager(CreatePlayerFragment.this.getContext()).createSQLite(player);

            
            this.getRealActivity().getGame().getPlayers().add(player);
            
            if (this.getRealActivity().hasAllPlayers()) {
                this.getRealActivity().replaceFragment(new CreateQuestionFragment());
            } else {
                this.init(this.getView());
            }
        }
    }

    /**
     * Initializes the fragment's view components.
     * @param view The fragment's view.
     */
    private void init(View view) {
        this.editTxtPlayer = view.findViewById(R.id.editTxtPlayer);
        
        this.editTxtPlayer.setText("");
        
        this.txtError = view.findViewById(R.id.txt_error);
        
        this.txtError.setText("");
        this.txtError.setVisibility(View.INVISIBLE);
        
        String title = String.format(this.getString(R.string.create_player_replacement),
                String.valueOf(this.getRealActivity().getGame().getPlayers().size() + 1));
        
        ((TextView) view.findViewById(R.id.txt_title)).setText(title);
        view.findViewById(R.id.btn_validate).setOnClickListener(this);
    }

    /**
     * Checks the data (availability of the player name).
     * @return True if data are correct else false.
     */
    private boolean validateData() {
        return (new PlayerDbManager(this.getContext()).loadSQLite(this.editTxtPlayer.getText().toString()) == null);
    }

    /**
     * Gets the real activity managing the fragment.
     * @return The activity.
     */
    private InitGameActivity getRealActivity() {
        return (InitGameActivity) this.getActivity();
    }
}

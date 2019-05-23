package com.imie.a2dev.teamculte.quizzmaster.views;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.imie.a2dev.teamculte.quizzmaster.R;

/**
 * Activity managing the create player and question fragments.
 */
public class InitGameActivity extends AppCompatActivity {
    /**
     * Stores the step tag used to get the intent values.
     */
    public static final String STEP = "Step";
    
    /**
     * Stores the create player string used to define the current step.
     */
    public static final String CREATE_PLAYER_STEP = "CreatePlayer";

    /**
     * Stores the create player string used to define the current step.
     */
    public static final String CREATE_QUESTION_STEP = "CreateQuestion";

    /**
     * Stores the create player string used to define the current step.
     */
    public static final String LOAD_PLAYER_STEP = "LoadPlayer";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_init_game);

        Fragment fragment;
        FragmentManager fragmentManager = this.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        
        switch (this.getIntent().getStringExtra(STEP)) {
            case CREATE_PLAYER_STEP:
                fragment = new CreatePlayerFragment();
                
                break;
            case CREATE_QUESTION_STEP:
                fragment = new CreateQuestionFragment();
                
                break;
            case LOAD_PLAYER_STEP:
                fragment = new LoadPlayerFragment();
                
                break;
            default:
                
                return;
        }
        
        fragmentTransaction.replace(R.id.frame_content, fragment);
        fragmentTransaction.commit();
    }
}

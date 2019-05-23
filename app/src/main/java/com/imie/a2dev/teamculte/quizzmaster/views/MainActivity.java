package com.imie.a2dev.teamculte.quizzmaster.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.imie.a2dev.teamculte.quizzmaster.R;

/**
 * Main activity.
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_main);
        this.init();
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        
        switch (view.getId()) {
            case R.id.btn_new_game:
                intent = new Intent(this, InitGameActivity.class);
                intent.putExtra(InitGameActivity.STEP, InitGameActivity.CREATE_PLAYER_STEP);
                
                break;
            
            case R.id.btn_load_player:
                intent = new Intent(this, InitGameActivity.class);
                intent.putExtra(InitGameActivity.STEP, InitGameActivity.LOAD_PLAYER_STEP);
                
                break;
            
            case R.id.btn_settings:
                intent = new Intent(this, SettingsActivity.class);
                
                break;
             
            default:
                return;
        }
        
        this.startActivity(intent);
    }

    /**
     * Initializes the view components.
     */
    private void init() {
        this.findViewById(R.id.btn_new_game).setOnClickListener(this);
        this.findViewById(R.id.btn_load_player).setOnClickListener(this);
        this.findViewById(R.id.btn_settings).setOnClickListener(this);
    }
    
}

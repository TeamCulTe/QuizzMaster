package com.imie.a2dev.teamculte.quizzmaster.managers;

import android.content.Context;

/**
 * Class managing the GameMode entities into the database.
 */
public final class GameModeDbManager extends DbManager {
    /**
     * Full filled constructor initializing the handler attribute and opening the database.
     * @param context The associated context.
     */
    public GameModeDbManager(Context context) {
        super(context);
    }
}

package com.imie.a2dev.teamculte.quizzmaster.managers;

import android.content.Context;

/**
 * Class managing the Game entities into the database.
 */
public final class GameDbManager extends DbManager {
    /**
     * Full filled constructor initializing the handler attribute and opening the database.
     * @param context The associated context.
     */
    public GameDbManager(Context context) {
        super(context);
    }
}

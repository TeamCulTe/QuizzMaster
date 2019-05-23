package com.imie.a2dev.teamculte.quizzmaster.managers;

import android.content.Context;

/**
 * Class managing the Difficulty entities into the database.
 */
public final class DifficultyDbManager extends DbManager {
    /**
     * Full filled constructor initializing the handler attribute and opening the database.
     * @param context The associated context.
     */
    public DifficultyDbManager(Context context) {
        super(context);
    }
}

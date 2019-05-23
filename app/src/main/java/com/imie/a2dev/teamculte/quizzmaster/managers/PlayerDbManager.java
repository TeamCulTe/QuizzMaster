package com.imie.a2dev.teamculte.quizzmaster.managers;

import android.content.Context;

/**
 * Class managing the Player entities into the database.
 */
public final class PlayerDbManager extends DbManager {
    /**
     * Full filled constructor initializing the handler attribute and opening the database.
     * @param context The associated context.
     */
    public PlayerDbManager(Context context) {
        super(context);
    }
}

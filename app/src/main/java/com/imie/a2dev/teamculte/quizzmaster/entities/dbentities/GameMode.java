package com.imie.a2dev.teamculte.quizzmaster.entities.dbentities;

import android.database.Cursor;

import static com.imie.a2dev.teamculte.quizzmaster.schemas.AbstractGameModeDbSchema.ID;
import static com.imie.a2dev.teamculte.quizzmaster.schemas.AbstractGameModeDbSchema.NAME;

/**
 * Enum defining the different game modes (player vs player / player vs IA).
 */
public final class GameMode extends DbEntity {
    /**
     * Stores the game mode name.
     */
    private String name;

    /**
     * Nearly full filled constructor.
     * @param name The name to set.
     */
    public GameMode(String name) {
        this.name = name;
    }

    /**
     * Full filled constructor.
     * @param id The id to set.
     * @param name The name to set.
     */
    public GameMode(int id, String name) {
        super(id);
        this.name = name;
    }

    /**
     * Cursor constructor.
     * @param result The cursor used to set.
     */
    public GameMode(Cursor result) {
        this.init(result, true);
    }

    /**
     * Gets the name attribute.
     * @return The String value of name attribute.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the name attribute.
     * @param newName The new String value to set.
     */
    public void setName(String newName) {
        this.name = newName;
    }

    @Override
    public void init(Cursor result, boolean close) {
        if (result.isBeforeFirst()) {
            result.moveToNext();
        }

        this.id = result.getInt(result.getColumnIndex(ID));
        this.name = result.getString(result.getColumnIndex(NAME));

        if (close) {
            result.close();
        }
    }
}
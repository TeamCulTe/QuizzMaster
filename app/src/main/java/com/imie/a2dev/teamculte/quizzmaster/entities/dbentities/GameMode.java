package com.imie.a2dev.teamculte.quizzmaster.entities.dbentities;

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
    GameMode(String name) {
        this.name = name;
    }

    /**
     * Full filled constructor.
     * @param id The id to set.
     * @param name The name to set.
     */
    GameMode(int id, String name) {
        super(id);
        this.name = name;
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
}
package com.imie.a2dev.teamculte.quizzmaster.entities.dbentities;

/**
 * Clas defining the difficulties of the game.
 */
public final class Difficulty extends DbEntity {
    /**
     * Stores the associated name.
     */
    private String name;

    /**
     * Nearly full filled constructor.
     * @param name The name to set.
     */
    Difficulty(String name) {
        this.name = name;
    }

    /**
     * Full filled constructor.
     * @param id The id to set.
     * @param name The name to set.
     */
    Difficulty(int id, String name) {
        this.id = id;
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
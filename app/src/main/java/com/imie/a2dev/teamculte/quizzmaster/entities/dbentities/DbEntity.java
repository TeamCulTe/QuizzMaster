package com.imie.a2dev.teamculte.quizzmaster.entities.dbentities;

/**
 * Abstract entity extended by all the entities stored into database.
 */
public abstract class DbEntity {
    /**
     * Stores the entity id.
     */
    protected int id;

    /**
     * Default constructor.
     */
    public DbEntity() {
    }

    /**
     * Default constructor.
     */
    public DbEntity(int id) {
        this.id = id;
    }

    /**
     * Gets the id attribute.
     * @return The $field.typeName value of id attribute.
     */
    public long getId() {
        return this.id;
    }

    /**
     * Sets the id attribute.
     * @param newId The new $field.typeName value to set.
     */
    public void setId(int newId) {
        this.id = newId;
    }
}

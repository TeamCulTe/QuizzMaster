package com.imie.a2dev.teamculte.quizzmaster.entities.dbentities;

import android.database.Cursor;
import com.imie.a2dev.teamculte.quizzmaster.entities.Question;

import static com.imie.a2dev.teamculte.quizzmaster.schemas.AbstractGameModeDbSchema.ID;

/**
 * Class defining the playing game.
 */
public final class Game extends DbEntity {
    /**
     * Defines the number of players in the game.
     */
    public static final int PLAYER_NB = 2;

    /**
     * Defines the number of questions in a game.
     */
    public static final int QUESTION_NB = 10;

    /**
     * Stores the mode of the game.
     */
    private GameMode mode;

    /**
     * Stores the players of the game.
     */
    private Player[] players = new Player[PLAYER_NB];

    /**
     * Stores the questions of the game. 
     */
    private Question[] questions = new Question[QUESTION_NB];
    
    /**
     * Default constructor
     */
    public Game() {
    }

    /**
     * Nearly full filled constructor.
     * @param mode The mode to set.
     */
    public Game(GameMode mode) {
        this.mode = mode;
    }

    /**
     * Full filled constructor.
     * @param id The id to set.
     * @param mode The mode to set.
     * @param players The players to set.
     * @param questions the questions to set.
     */
    public Game(int id, GameMode mode, Player[] players, Question[] questions) {
        this.id = id;
        this.mode = mode;
        this.players = players;
        this.questions = questions;
    }

    /**
     * Cursor constructor.
     * @param result The cursor used to set.
     */
    public Game(Cursor result) {
        this.init(result, true);
    }

    /**
     * Gets the mode attribute.
     * @return The GameMode value of mode attribute.
     */
    public GameMode getMode() {
        return this.mode;
    }

    /**
     * Sets the mode attribute.
     * @param newMode The new GameMode value to set.
     */
    public void setMode(GameMode newMode) {
        this.mode = newMode;
    }

    /**
     * Gets the players attribute.
     * @return The Player[] value of players attribute.
     */
    public Player[] getPlayers() {
        return this.players;
    }

    /**
     * Sets the players attribute.
     * @param newPlayers The new Player[] value to set.
     */
    public void setPlayers(Player[] newPlayers) {
        this.players = newPlayers;
    }

    /**
     * Gets the questions attribute.
     * @return The Question[] value of questions attribute.
     */
    public Question[] getQuestions() {
        return this.questions;
    }

    /**
     * Sets the questions attribute.
     * @param newQuestions The new Question[] value to set.
     */
    public void setQuestions(Question[] newQuestions) {
        this.questions = newQuestions;
    }

    @Override
    public void init(Cursor result, boolean close) {
        if (result.isBeforeFirst()) {
            result.moveToNext();
        }

        this.id = result.getInt(result.getColumnIndex(ID));

        if (close) {
            result.close();
        }
    }
}
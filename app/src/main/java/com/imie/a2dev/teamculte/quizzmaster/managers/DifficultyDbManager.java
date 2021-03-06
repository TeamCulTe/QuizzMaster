package com.imie.a2dev.teamculte.quizzmaster.managers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.support.annotation.NonNull;
import android.util.Log;
import com.imie.a2dev.teamculte.quizzmaster.entities.dbentities.Difficulty;

import java.util.ArrayList;
import java.util.List;

import static com.imie.a2dev.teamculte.quizzmaster.schemas.AbstractDifficultyDbSchema.ID;
import static com.imie.a2dev.teamculte.quizzmaster.schemas.AbstractDifficultyDbSchema.NAME;
import static com.imie.a2dev.teamculte.quizzmaster.schemas.AbstractDifficultyDbSchema.TABLE;
import static com.imie.a2dev.teamculte.quizzmaster.utils.TagUtils.SQLITE_TAG;

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
        
        this.table = TABLE;
        this.ids = new String[]{ID};
    }

    /**
     * From a java entity creates the associated entity into the database.
     * @param entity The model to store into the database.
     * @return true if success else false.
     */
    public boolean createSQLite(@NonNull Difficulty entity) {
        try {
            ContentValues data = new ContentValues();

            data.put(NAME, entity.getName());
            
            if (entity.getId() != 0) {
                data.put(this.ids[0], entity.getId());
                this.database.insertOrThrow(this.table, null, data);
            } else {
                entity.setId((int) this.database.insertOrThrow(this.table, null, data));
            }
            
            return true;
        } catch (SQLiteException e) {
            Log.e(SQLITE_TAG, e.getMessage());

            return false;
        }
    }
    
    /**
     * From an id, returns the associated java entity.
     * @param id The id of entity to load from the database.
     * @return The loaded entity if exists else null.
     */
    public Difficulty loadSQLite(int id) {
        Cursor result = this.loadCursorSQLite(id);

        if (result == null || result.getCount() == 0) {
            return null;
        }

        return new Difficulty(result);
    }

    /**
     * From a java entity updates the associated entity into the database.
     * @param entity The model to update into the database.
     * @return true if success else false.
     */
    public boolean updateSQLite(@NonNull Difficulty entity) {
        try {
            ContentValues data = new ContentValues();
            String whereClause = String.format("%s = ?", this.ids[0]);
            String[] whereArgs = new String[]{String.valueOf(entity.getId())};

            data.put(NAME, entity.getName());

            return this.database.update(this.table, data, whereClause, whereArgs) != 0;
        } catch (SQLiteException e) {
            Log.e(SQLITE_TAG, e.getMessage());

            return false;
        }
    }

    /**
     * Query all the entities from database.
     * @return The list of entities loaded.
     */
    public List<Difficulty> queryAllSQLite() {
        Difficulty difficulty;
        List<Difficulty> difficulties = new ArrayList<>();
        Cursor cursor = this.database.rawQuery(String.format(DbManager.QUERY_ALL, this.table), null);
        
        while (cursor.moveToNext()) {
            difficulty = new Difficulty();
            
            difficulty.init(cursor, false);
            difficulties.add(difficulty);
        }
        
        cursor.close();
        
        return difficulties;
    }
}

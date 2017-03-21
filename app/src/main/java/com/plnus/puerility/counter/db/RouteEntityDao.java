package com.plnus.puerility.counter.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.plnus.puerility.counter.model.entity.RouteEntity;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "ROUTE_ENTITY".
*/
public class RouteEntityDao extends AbstractDao<RouteEntity, Long> {

    public static final String TABLENAME = "ROUTE_ENTITY";

    /**
     * Properties of entity RouteEntity.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property StartPlace = new Property(1, String.class, "startPlace", false, "START_PLACE");
        public final static Property ReachPlace = new Property(2, String.class, "reachPlace", false, "REACH_PLACE");
        public final static Property StartTime = new Property(3, String.class, "startTime", false, "START_TIME");
        public final static Property ReachTime = new Property(4, String.class, "reachTime", false, "REACH_TIME");
    }


    public RouteEntityDao(DaoConfig config) {
        super(config);
    }
    
    public RouteEntityDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"ROUTE_ENTITY\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"START_PLACE\" TEXT," + // 1: startPlace
                "\"REACH_PLACE\" TEXT," + // 2: reachPlace
                "\"START_TIME\" TEXT," + // 3: startTime
                "\"REACH_TIME\" TEXT);"); // 4: reachTime
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"ROUTE_ENTITY\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, RouteEntity entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String startPlace = entity.getStartPlace();
        if (startPlace != null) {
            stmt.bindString(2, startPlace);
        }
 
        String reachPlace = entity.getReachPlace();
        if (reachPlace != null) {
            stmt.bindString(3, reachPlace);
        }
 
        String startTime = entity.getStartTime();
        if (startTime != null) {
            stmt.bindString(4, startTime);
        }
 
        String reachTime = entity.getReachTime();
        if (reachTime != null) {
            stmt.bindString(5, reachTime);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, RouteEntity entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String startPlace = entity.getStartPlace();
        if (startPlace != null) {
            stmt.bindString(2, startPlace);
        }
 
        String reachPlace = entity.getReachPlace();
        if (reachPlace != null) {
            stmt.bindString(3, reachPlace);
        }
 
        String startTime = entity.getStartTime();
        if (startTime != null) {
            stmt.bindString(4, startTime);
        }
 
        String reachTime = entity.getReachTime();
        if (reachTime != null) {
            stmt.bindString(5, reachTime);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public RouteEntity readEntity(Cursor cursor, int offset) {
        RouteEntity entity = new RouteEntity( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // startPlace
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // reachPlace
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // startTime
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4) // reachTime
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, RouteEntity entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setStartPlace(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setReachPlace(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setStartTime(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setReachTime(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(RouteEntity entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(RouteEntity entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(RouteEntity entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}

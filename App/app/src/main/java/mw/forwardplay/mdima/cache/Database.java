package mw.forwardplay.mdima.cache;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@android.arch.persistence.room.Database(entities = {GroupEntity.class, LocationEntity.class,
        MonitoredLocationEntity.class, RegionEntity.class, ScheduleEntity.class
}, version = 1, exportSchema = false)
public abstract class Database extends RoomDatabase {
    public static final String DATABASE_NAME = "mdima_local_cache";
    private static Database INSTANCE = null;

    public static Database getInstance(Context context)
    {
        if (INSTANCE==null)
        {
            INSTANCE = Room.databaseBuilder(context, Database.class, DATABASE_NAME).build();
        }
        return INSTANCE;
    }
    public abstract GroupDao groupDao();
    public abstract  LocationDao locationDao();
    public abstract  MonitoredLocationDao monitoredLocationDao();
    public abstract RegionDao regionDao();
    public abstract ScheduleDao scheduleDao();
}

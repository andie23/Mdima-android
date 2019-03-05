package mw.forwardplay.mdima.cache;

import android.arch.persistence.room.RoomDatabase;

@android.arch.persistence.room.Database(entities = {GroupEntity.class, LocationEntity.class,
        MonitoredLocationEntity.class, RegionEntity.class, ScheduleEntity.class
}, version = 1, exportSchema = false)
public abstract class Database extends RoomDatabase {
    public abstract GroupDao groupDao();
    public abstract  LocationDao locationDao();
    public abstract  MonitoredLocationDao monitoredLocationDao();
    public abstract RegionDao regionDao();
    public abstract ScheduleDao scheduleDao();
}

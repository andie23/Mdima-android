package mw.forwardplay.mdima.cache;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverter;
import android.arch.persistence.room.migration.Migration;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@android.arch.persistence.room.Database(entities = {GroupEntity.class, LocationEntity.class,
        MonitoredLocationEntity.class, RegionEntity.class, ScheduleEntity.class, AreaEntity.class
}, version = 3, exportSchema = false)
public abstract class MdimaDatabase extends RoomDatabase {
    public static final String DATABASE_NAME = "mdima_cache";
    private static Context appContext;
    private static MdimaDatabase INSTANCE = null;

    public synchronized static MdimaDatabase getInstance(final Context context)
    {
        appContext = context;
        if (INSTANCE==null)
        {
           INSTANCE = Room.databaseBuilder(context, MdimaDatabase.class, DATABASE_NAME)
                         .allowMainThreadQueries()
                         .build();
        }
        return INSTANCE;
    }
    public abstract AreaDao areaDao();
    public abstract GroupDao groupDao();
    public abstract LocationDao locationDao();
    public abstract MonitoredLocationDao monitoredLocationDao();
    public abstract RegionDao regionDao();
    public abstract ScheduleDao scheduleDao();
}

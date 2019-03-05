package mw.forwardplay.mdima.cache;

import android.arch.persistence.room.Room;
import android.content.Context;

public class DbInstance {
    public static final String DATABASE_NAME = "mdima_local_cache";
    private static Database database = null;

    public static Database getInstance(Context context)
    {
        if (database==null)
        {
            database = Room.databaseBuilder(context, Database.class, DATABASE_NAME).build();
        }
        return database;
    }

}

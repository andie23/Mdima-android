package mw.forwardplay.mdima.cache;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface MonitoredLocationDao {
    @Query("SELECT * FROM monitored_locations")
    public List<MonitoredLocationDao> fetchAll();
    @Query("SELECT * FROM monitored_locations WHERE is_primary=1")
    public MonitoredLocationEntity fetchPrimaryLocation();
}

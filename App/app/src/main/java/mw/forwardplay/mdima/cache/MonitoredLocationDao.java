package mw.forwardplay.mdima.cache;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface MonitoredLocationDao {
    @Query("SELECT * FROM monitored_locations")
    public List<MonitoredLocationEntity> fetchAll();
    @Query("SELECT * FROM monitored_locations WHERE is_primary=1")
    public MonitoredLocationEntity fetchPrimaryLocation();
    @Insert
    public void add(MonitoredLocationEntity monitoredLocationEntity);
    @Update
    public void update(MonitoredLocationEntity monitoredLocationEntity);
    @Delete
    public void delete(MonitoredLocationEntity monitoredLocationEntity);
}

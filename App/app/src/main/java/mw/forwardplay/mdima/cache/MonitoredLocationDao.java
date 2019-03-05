package mw.forwardplay.mdima.cache;

import android.arch.persistence.room.Dao;

import java.util.List;

@Dao
public interface MonitoredLocationDao {
    public List<MonitoredLocationDao> fetchAll();
    public MonitoredLocationEntity fetchPrimaryLocation();
}

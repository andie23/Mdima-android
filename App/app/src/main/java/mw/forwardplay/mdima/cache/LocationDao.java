package mw.forwardplay.mdima.cache;

import android.arch.persistence.room.Dao;

import java.util.List;

@Dao
public interface LocationDao {
    public List<LocationEntity> fetchAll();
    public List<LocationEntity> fetchByRegionId(int regionId);
    public LocationEntity fetchByName(String name);
    public LocationEntity fetchById(int id);
}

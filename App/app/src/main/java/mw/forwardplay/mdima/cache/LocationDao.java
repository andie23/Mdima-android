package mw.forwardplay.mdima.cache;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface LocationDao {
    @Query("SELECT * FROM locations")
    public List<LocationEntity> fetchAll();
    @Query("SELECT * FROM locations WHERE region_id=:regionId")
    public List<LocationEntity> fetchByRegionId(int regionId);
    @Query("SELECT * FROM locations WHERE name=:name")
    public LocationEntity fetchByName(String name);
    @Query("SELECT * FROM locations WHERE id=:id")
    public LocationEntity fetchById(int id);
}

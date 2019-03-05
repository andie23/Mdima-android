package mw.forwardplay.mdima.cache;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface RegionDao {
    @Query("SELECT * FROM region")
    public List<RegionEntity> fetchAll();
    @Query("SELECT * FROM  region WHERE id=:id")
    public RegionEntity fetchById(int id);
    @Query("SELECT * FROM region WHERE name=:name")
    public RegionEntity fetchByName(String name);
}

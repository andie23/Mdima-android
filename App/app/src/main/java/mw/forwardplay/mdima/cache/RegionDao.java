package mw.forwardplay.mdima.cache;

import android.arch.persistence.room.Dao;

import java.util.List;

@Dao
public interface RegionDao {
    public List<RegionEntity> fetchAll();
    public RegionEntity fetchById(int id);
    public RegionEntity fetchByName(String name);
}

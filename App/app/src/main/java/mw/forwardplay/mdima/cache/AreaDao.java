package mw.forwardplay.mdima.cache;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface AreaDao {
    @Query("SELECT * FROM areas")
    public List<AreaEntity> fetchAll();
    @Query("SELECT * FROM areas WHERE location_id=:id")
    public List<AreaEntity> fetchAllByLocationId(int id);
    @Query("SELECT * FROM areas WHERE name LIKE :name")
    public AreaEntity fetchByAreaName(String name);
    @Query("SELECT * FROM areas WHERE id=:id")
    public AreaEntity fetchByAreaId(int id);
    @Insert
    public void add(AreaEntity areaEntity);
    @Update
    public void update(AreaEntity areaEntity);
    @Delete
    public void delete(AreaEntity areaEntity);
}

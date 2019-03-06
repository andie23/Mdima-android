package mw.forwardplay.mdima.cache;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface GroupDao {
    @Query("SELECT * FROM groups")
    public List<GroupEntity> fetchAll();
    @Query("SELECT * FROM groups WHERE name =:groupName")
    public List<GroupEntity> fetchAllByName(String groupName);
    @Query("SELECT * FROM groups WHERE area_id = :areaId")
    public List<GroupEntity> fetchByArea(int areaId);
    @Insert
    public void add(GroupEntity groupEntity);
    @Update
    public void update(GroupEntity groupEntity);
    @Delete
    public void delete(GroupEntity groupEntity);
}

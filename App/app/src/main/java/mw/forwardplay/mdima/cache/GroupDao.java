package mw.forwardplay.mdima.cache;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface GroupDao {
    @Query("SELECT * FROM groups")
    public List<GroupEntity> fetchAll();
    @Query("SELECT * FROM groups WHERE group_name =:groupName")
    public List<GroupEntity> fetchAllByName(String groupName);
    @Query("SELECT * FROM groups WHERE area_id = :areaId")
    public List<GroupEntity> fetchByArea(int areaId);
    @Query("SELECT * FROM groups WHERE id=:id")
    public GroupEntity fetchById(int id);
}

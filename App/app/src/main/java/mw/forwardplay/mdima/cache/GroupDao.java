package mw.forwardplay.mdima.cache;

import android.arch.persistence.room.Dao;

import java.util.List;

@Dao
public interface GroupDao {
    public List<GroupEntity> fetchAll();
    public List<GroupEntity> fetchAllByName(String groupName);
    public List<GroupEntity> fetchByArea(String areaName);
    public GroupEntity fetchById(int id);
}

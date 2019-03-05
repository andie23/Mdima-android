package mw.forwardplay.mdima.cache;

import android.arch.persistence.room.Dao;

import java.util.List;

@Dao
public interface ScheduleDao {
    public List<ScheduleEntity> fetchAllByGroupId(int groupId);
    public List<ScheduleEntity> fetchByDate(Long Date);
    public List<ScheduleEntity> fetchByGroupDate(int groupId, Long date);
    public int countGroupBlackouts(int groupId);
    public int averageGroupDuration(int groupId);
}

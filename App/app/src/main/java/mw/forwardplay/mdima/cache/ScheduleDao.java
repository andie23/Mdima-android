package mw.forwardplay.mdima.cache;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface ScheduleDao {
    @Query("SELECT * FROM schedules WHERE group_id=:groupId")
    public List<ScheduleEntity> fetchAllByGroupId(int groupId);
    @Query("SELECT * FROM schedules WHERE date=:date")
    public List<ScheduleEntity> fetchByDate(Long date);
    @Query("SELECT * FROM schedules WHERE date=:date AND group_id=:groupId")
    public List<ScheduleEntity> fetchByGroupDate(int groupId, Long date);
    @Query("SELECT count(id) FROM schedules WHERE group_id=:groupId")
    public int countGroupBlackouts(int groupId);
    @Query("SELECT avg(duration) FROM schedules WHERE group_id=:groupId")
    public int averageGroupDuration(int groupId);
}

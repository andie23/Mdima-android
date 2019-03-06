package mw.forwardplay.mdima.cache;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface ScheduleDao {
    @Query("SELECT * FROM schedules WHERE group_name=:groupName")
    public List<ScheduleEntity> fetchAllByGroupId(String groupName);
    @Query("SELECT * FROM schedules WHERE date=:date")
    public List<ScheduleEntity> fetchByDate(Long date);
    @Query("SELECT * FROM schedules WHERE date=:date AND group_name=:groupName")
    public List<ScheduleEntity> fetchByGroupDate(String groupName, Long date);
    @Query("SELECT count(id) FROM schedules WHERE group_name=:groupName")
    public int countGroupBlackouts(String groupName);
    @Query("SELECT avg(duration) FROM schedules WHERE group_name=:groupName")
    public int averageGroupDuration(String groupName);
    @Insert
    public void add(ScheduleEntity scheduleEntity);
    @Update
    public void update(ScheduleEntity scheduleEntity);
    @Delete
    public void delete(ScheduleEntity scheduleEntity);
}

package mw.forwardplay.mdima.cache;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "schedules")
public class ScheduleEntity {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "date")
    private long date;
    @ColumnInfo(name = "starting_time")
    private long startingTime;
    @ColumnInfo(name = "finish_time")
    private long finishTime;
    @ColumnInfo(name = "duration")
    private int duration;
    @ColumnInfo(name = "group_id")
    private int groupId;

    public int getId() {
        return id;
    }

    public int getDuration() {
        return duration;
    }

    public int getGroupId() {
        return groupId;
    }

    public long getDate() {
        return date;
    }

    public long getFinishTime() {
        return finishTime;
    }

    public long getStartingTime() {
        return startingTime;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setFinishTime(long finishTime) {
        this.finishTime = finishTime;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public void setStartingTime(long startingTime) {
        this.startingTime = startingTime;
    }
}

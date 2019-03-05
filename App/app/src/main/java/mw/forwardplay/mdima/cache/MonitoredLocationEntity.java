package mw.forwardplay.mdima.cache;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "monitored_locations")
public class MonitoredLocationEntity {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "area_id")
    private int areaId;
    @ColumnInfo(name = "is_primary")
    private boolean isPrimary;

    public int getId() {
        return id;
    }

    public int getAreaId() {
        return areaId;
    }

    public boolean getIsPrimary(){
        return isPrimary;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    public void setIsPrimary(boolean primary) {
        isPrimary = primary;
    }
}

package mw.forwardplay.mdima.cache;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "groups")
public class GroupEntity {
    @PrimaryKey(autoGenerate = true )
    @ColumnInfo(name = "id")
    private int id;
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "area_id")
    private int areaId;

    public int getId() {
        return id;
    }

    public int getAreaId() {
        return areaId;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    public void setName(String name) {
        this.name = name;
    }
}

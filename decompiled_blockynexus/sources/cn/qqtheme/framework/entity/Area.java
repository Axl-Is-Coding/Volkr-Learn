package cn.qqtheme.framework.entity;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public abstract class Area extends JavaBean implements LinkageItem {
    private String areaId;
    private String areaName;

    public Area() {
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Area)) {
            return false;
        }
        Area area = (Area) obj;
        return !TextUtils.isEmpty(this.areaId) ? this.areaId.equals(area.getAreaId()) : this.areaName.equals(area.getAreaName());
    }

    public String getAreaId() {
        return this.areaId;
    }

    public String getAreaName() {
        return this.areaName;
    }

    @Override // cn.qqtheme.framework.entity.LinkageItem
    public Object getId() {
        return this.areaId;
    }

    @Override // cn.qqtheme.framework.entity.WheelItem
    public String getName() {
        return this.areaName;
    }

    public void setAreaId(String str) {
        this.areaId = str;
    }

    public void setAreaName(String str) {
        this.areaName = str;
    }

    @Override // cn.qqtheme.framework.entity.JavaBean
    public String toString() {
        return "areaId=" + this.areaId + ",areaName=" + this.areaName;
    }

    public Area(String str) {
        this.areaName = str;
    }

    public Area(String str, String str2) {
        this.areaId = str;
        this.areaName = str2;
    }
}

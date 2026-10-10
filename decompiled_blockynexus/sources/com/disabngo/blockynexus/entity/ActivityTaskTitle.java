package com.disabngo.blockynexus.entity;

import androidx.databinding.BaseObservable;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ActivityTaskTitle extends BaseObservable implements Serializable {
    private boolean closeRedPoint;
    private String content;
    private List<String> countryList;
    private String dateDesc;
    private long endTime;
    private boolean isEnable = true;
    private boolean isLast;
    private String pic;
    private int position;
    private int status;
    private String titleName;
    private String titleType;

    public String getContent() {
        return this.content;
    }

    public List<String> getCountryList() {
        return this.countryList;
    }

    public String getDateDesc() {
        return this.dateDesc;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public String getPic() {
        return this.pic;
    }

    public int getPosition() {
        return this.position;
    }

    public int getStatus() {
        return this.status;
    }

    public String getTitleName() {
        return this.titleName;
    }

    public String getTitleType() {
        return this.titleType;
    }

    public boolean isCloseRedPoint() {
        return this.closeRedPoint;
    }

    public boolean isEnable() {
        return this.isEnable;
    }

    public boolean isShowDivider() {
        if (this.isEnable) {
            return !this.isLast;
        }
        return false;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setEnable(boolean z) {
        this.isEnable = z;
        notifyChange();
    }

    public void setEndTime(long j) {
        this.endTime = j;
    }

    public void setLast(boolean z) {
        this.isLast = z;
        notifyChange();
    }

    public void setPic(String str) {
        this.pic = str;
    }

    public void setPosition(int i) {
        this.position = i;
    }

    public void setStatus(int i) {
        this.status = i;
        notifyChange();
    }

    public void setTitleName(String str) {
        this.titleName = str;
    }

    public void setTitleType(String str) {
        this.titleType = str;
    }
}

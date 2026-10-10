package com.sandboxol.report.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class NewEventInfoRequest implements Serializable {
    private static final long serialVersionUID = 1010634120321127683L;
    public Long ID;
    private List<NewEvent> eventList;
    private String eventType;
    private String gameId;
    private boolean isUpdate;
    private String platform;
    private int statisticType;
    private long timestamp;

    public NewEventInfoRequest(String str, String str2) {
        this(str, str2, "app", 0, System.currentTimeMillis());
    }

    public void addEvent(NewEvent newEvent) {
        this.eventList.add(newEvent);
    }

    public List<NewEvent> getEventList() {
        return this.eventList;
    }

    public String getEventType() {
        return this.eventType;
    }

    public List<NewEvent> getEvents() {
        return this.eventList;
    }

    public String getGameId() {
        return this.gameId;
    }

    public Long getID() {
        return this.ID;
    }

    public boolean getIsUpdate() {
        return this.isUpdate;
    }

    public String getPlatform() {
        return this.platform;
    }

    public int getStatisticType() {
        return this.statisticType;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public void setEventList(List<NewEvent> list) {
        this.eventList = list;
    }

    public void setEventType(String str) {
        this.eventType = str;
    }

    public void setEvents(List<NewEvent> list) {
        this.eventList = list;
    }

    public void setGameId(String str) {
        this.gameId = str;
    }

    public void setID(Long l) {
        this.ID = l;
    }

    public void setIsUpdate(boolean z) {
        this.isUpdate = z;
    }

    public void setPlatform(String str) {
        this.platform = str;
    }

    public void setStatisticType(int i) {
        this.statisticType = i;
    }

    public void setTimestamp(long j) {
        this.timestamp = j;
    }

    public NewEventInfoRequest(String str, String str2, String str3) {
        this(str, str2, str3, 0, System.currentTimeMillis());
    }

    public NewEventInfoRequest(String str, String str2, String str3, int i) {
        this(str, str2, str3, i, System.currentTimeMillis());
    }

    public NewEventInfoRequest(String str, String str2, String str3, int i, long j) {
        this.eventList = new ArrayList();
        this.eventType = str;
        this.platform = str2;
        this.gameId = str3;
        this.statisticType = i;
        this.timestamp = j;
    }

    public NewEventInfoRequest(Long l, String str, String str2, String str3, int i, long j, boolean z, List<NewEvent> list) {
        this.eventList = new ArrayList();
        this.ID = l;
        this.eventType = str;
        this.platform = str2;
        this.gameId = str3;
        this.statisticType = i;
        this.timestamp = j;
        this.isUpdate = z;
        this.eventList = list;
    }

    public NewEventInfoRequest() {
        this.eventList = new ArrayList();
    }
}

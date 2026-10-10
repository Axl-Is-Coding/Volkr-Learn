package com.sandboxol.report.entity;

import com.sandboxol.center.entity.AccountCenter;
import java.io.Serializable;

/* JADX INFO: loaded from: classes4.dex */
public class EventInfoRequest implements Serializable {
    private static final long serialVersionUID = 1010634120321127684L;
    public Long ID;
    private String data;
    private String event;
    private String eventType;
    private String platform;
    private Long userId;

    public EventInfoRequest(String str) {
        this(str, "behavior", "android", "");
    }

    public String getData() {
        return this.data;
    }

    public String getEvent() {
        return this.event;
    }

    public String getEventType() {
        return this.eventType;
    }

    public Long getID() {
        return this.ID;
    }

    public String getPlatform() {
        return this.platform;
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setData(String str) {
        this.data = str;
    }

    public void setEvent(String str) {
        this.event = str;
    }

    public void setEventType(String str) {
        this.eventType = str;
    }

    public void setID(Long l) {
        this.ID = l;
    }

    public void setPlatform(String str) {
        this.platform = str;
    }

    public void setUserId(Long l) {
        this.userId = l;
    }

    public EventInfoRequest(String str, String str2) {
        this(str, str2, "android", "");
    }

    public EventInfoRequest(String str, String str2, String str3) {
        this(str, str2, str3, "");
    }

    public EventInfoRequest(String str, String str2, String str3, String str4) {
        this(str, str2, str3, str4, AccountCenter.newInstance().userId.get());
    }

    public EventInfoRequest(String str, String str2, String str3, String str4, Long l) {
        this.event = str;
        this.eventType = str2;
        this.platform = str3;
        this.data = str4;
        this.userId = l;
    }

    public EventInfoRequest(Long l, String str, String str2, String str3, String str4, Long l2) {
        this.ID = l;
        this.event = str;
        this.eventType = str2;
        this.platform = str3;
        this.data = str4;
        this.userId = l2;
    }

    public EventInfoRequest() {
    }
}

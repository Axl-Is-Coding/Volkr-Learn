package com.sandboxol.report.entity;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class EventRequest {
    private List<EventInfoRequest> eventRequests;
    private String packageName;

    public EventRequest(List<EventInfoRequest> list, String str) {
        this.eventRequests = list;
        this.packageName = str;
    }

    public List<EventInfoRequest> getEventRequests() {
        return this.eventRequests;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public void setEventRequests(List<EventInfoRequest> list) {
        this.eventRequests = list;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }
}

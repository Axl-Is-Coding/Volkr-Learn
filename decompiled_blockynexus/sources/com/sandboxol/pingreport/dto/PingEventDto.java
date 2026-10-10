package com.sandboxol.pingreport.dto;

import com.sandboxol.pingreport.entity.PingEvent;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class PingEventDto {
    private String packageName;
    private List<PingEvent> pingList;

    public PingEventDto(String str, List<PingEvent> list) {
        this.packageName = str;
        this.pingList = list;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public List<PingEvent> getPingEvents() {
        return this.pingList;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public void setPingEvents(List<PingEvent> list) {
        this.pingList = list;
    }
}

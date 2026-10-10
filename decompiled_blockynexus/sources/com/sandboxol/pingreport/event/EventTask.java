package com.sandboxol.pingreport.event;

/* JADX INFO: loaded from: classes4.dex */
public abstract class EventTask {
    private IEvent iEvent;

    EventTask(IEvent iEvent) {
        this.iEvent = iEvent;
    }

    public void onReport(String str, int i) {
        if (this.iEvent.isCanReport()) {
            onReportImpl(str, i);
        }
    }

    abstract void onReportImpl(String str, int i);
}

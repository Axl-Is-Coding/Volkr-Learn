package com.sandboxol.pingreport.event;

import android.database.sqlite.SQLiteDatabaseLockedException;
import com.sandboxol.pingreport.helper.PingEventHelper;

/* JADX INFO: loaded from: classes4.dex */
public class PingEventTask extends EventTask {
    public PingEventTask(IEvent iEvent) {
        super(iEvent);
    }

    @Override // com.sandboxol.pingreport.event.EventTask
    void onReportImpl(String str, int i) {
        try {
            PingEventHelper.newInstance().insertPingEvent(str, i);
        } catch (SQLiteDatabaseLockedException e2) {
            e2.printStackTrace();
        }
    }
}

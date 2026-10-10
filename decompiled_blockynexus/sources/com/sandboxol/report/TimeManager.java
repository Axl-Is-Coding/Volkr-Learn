package com.sandboxol.report;

import com.sandboxol.center.router.moduleInfo.report.ReportEvent;
import com.sandboxol.center.router.moduleInfo.report.ReportEventType;
import com.sandboxol.report.entity.EventInfoRequest;

/* JADX INFO: loaded from: classes4.dex */
public class TimeManager {
    private static long lastStepTime;

    public static boolean insertExecuteTime(EventInfoRequest eventInfoRequest) {
        String eventType = eventInfoRequest.getEventType();
        String event = eventInfoRequest.getEvent();
        if (event == null || eventType == null) {
            return false;
        }
        if (!eventType.contains(ReportEventType.GAME_INTER_BASE)) {
            return true;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = (event.contains("new_click_enter_game_") || event.contains("new_home_game_") || event.contains(ReportEvent.NEW_CLICK_ENTER_GAME_Hall_BASE)) ? 0L : jCurrentTimeMillis - lastStepTime;
        lastStepTime = jCurrentTimeMillis;
        eventInfoRequest.setData(j + "");
        return true;
    }
}

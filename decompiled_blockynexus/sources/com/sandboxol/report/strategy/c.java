package com.sandboxol.report.strategy;

import com.sandboxol.center.router.moduleInfo.report.NewReportEvent;
import com.sandboxol.report.entity.NewEvent;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: IReportStrategy.java */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class c {
    public static int a(IReportStrategy iReportStrategy) {
        return 0;
    }

    public static void a(IReportStrategy _this, NewEvent newEvent) {
        Integer num = IReportStrategy.eventAppWeight.get(newEvent.getEvent());
        if (num != null) {
            newEvent.setWeight(num.intValue());
            return;
        }
        for (Map.Entry<String, Integer> entry : IReportStrategy.eventGameWeight.entrySet()) {
            if (newEvent.getEvent().contains(entry.getKey())) {
                newEvent.setWeight(entry.getValue().intValue());
                return;
            }
        }
    }

    public static void a(IReportStrategy iReportStrategy, List list) {
    }

    public static void b(IReportStrategy _this) {
        IReportStrategy.eventAppWeight.put(NewReportEvent.APP_START, 1);
        IReportStrategy.eventAppWeight.put("home_startapp", 2);
        IReportStrategy.eventAppWeight.put("home_view", 3);
        IReportStrategy.eventAppWeight.put("home_game", 4);
        IReportStrategy.eventAppWeight.put("click_enter_game", 5);
        IReportStrategy.eventAppWeight.put(NewReportEvent.GAME_START, 6);
        IReportStrategy.eventAppWeight.put(NewReportEvent.GAME_ENTER_SUCCESS, 7);
        IReportStrategy.eventAppWeight.put("new_app_start", 8);
        IReportStrategy.eventAppWeight.put("new_home_startapp", 9);
        IReportStrategy.eventAppWeight.put("new_home_view", 10);
        IReportStrategy.eventAppWeight.put("new_loginpage_buildwin", 11);
        IReportStrategy.eventAppWeight.put("new_useroage_suc", 12);
        IReportStrategy.eventAppWeight.put(NewReportEvent.NEW_HOME_GAME, 13);
        IReportStrategy.eventAppWeight.put(NewReportEvent.NEW_CLICK_ENTER_GAME, 14);
        IReportStrategy.eventAppWeight.put(NewReportEvent.NEW_GAME_START, 15);
        IReportStrategy.eventAppWeight.put(NewReportEvent.NEW_GAME_ENTER_SUCCESS, 16);
        IReportStrategy.eventGameWeight.put("new_home_game_", 17);
        IReportStrategy.eventGameWeight.put("new_click_enter_game_", 18);
        IReportStrategy.eventGameWeight.put("new_game_release_", 19);
        IReportStrategy.eventGameWeight.put("new_game_MD5_", 20);
        IReportStrategy.eventGameWeight.put("new_connect_dispatch_success_", 21);
        IReportStrategy.eventGameWeight.put("new_game_enter_success_", 22);
    }
}

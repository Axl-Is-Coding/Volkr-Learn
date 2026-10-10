package com.sandboxol.report.strategy;

import com.sandboxol.report.entity.NewEvent;
import com.sandboxol.report.entity.NewEventInfoRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public interface IReportStrategy {
    public static final String GAMEID_APP = "app";
    public static final String KEY_NEW_EVENT = "new_event";
    public static final int LENGHT_START_APP = 7;
    public static final int LENGHT_START_GAME_NUM = 6;
    public static final int LENGHT_START_NEW_APP = 9;
    public static final int LENGTH_START_GAME_FREQUENCY = 6;
    public static final String PLATFORM_APP = "app_funnel";
    public static final String PLATFORM_GAME = "game_funnel";
    public static final int WEIGHT_END_APP = 7;
    public static final int WEIGHT_END_GAME_FREQUENCY = 22;
    public static final int WEIGHT_END_GAME_NUM = 22;
    public static final int WEIGHT_END_NEW_APP = 16;
    public static final int WEIGHT_START_APP = 1;
    public static final int WEIGHT_START_GAME_FREQUENCY = 17;
    public static final int WEIGHT_START_GAME_NUM = 17;
    public static final int WEIGHT_START_NEW_APP = 8;
    public static final Map<String, Integer> eventAppWeight = new HashMap();
    public static final Map<String, Integer> eventGameWeight = new HashMap();

    List<NewEventInfoRequest> clearEvents(List<NewEventInfoRequest> list);

    int endWeight();

    String getEventType();

    List<NewEventInfoRequest> getEvents();

    String getPlatform();

    int getStatisticType();

    void initEventWeight();

    void onAppEvent(String str);

    boolean onFilter(List<NewEvent> list, NewEvent newEvent);

    void onGameEvent(String str, String str2);

    void onLoadData();

    void onRemove(List<NewEventInfoRequest> list);

    void setEventWeight(NewEvent newEvent);

    int startWeight();

    int stepLength();
}

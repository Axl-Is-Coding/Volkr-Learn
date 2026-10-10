package com.sandboxol.report.strategy;

import com.sandboxol.center.router.moduleInfo.report.NewReportEventType;
import com.sandboxol.report.entity.NewEvent;
import com.sandboxol.report.entity.NewEventInfoRequest;
import com.sandboxol.report.helper.NewEventReportHelper;
import com.sandboxol.report.strategy.FunnelGameFrequencyStrategy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class FunnelGameFrequencyStrategy extends BaseReportStrategy {
    private static final String EVENT_TYPE_REPORTED = "funnel_game_frequency_report";
    private Map<String, NewEventInfoRequest> hasReportEvents;

    /* JADX INFO: renamed from: com.sandboxol.report.strategy.FunnelGameFrequencyStrategy$1, reason: invalid class name */
    class AnonymousClass1 implements com.sandboxol.greendao.a.c<List<NewEventInfoRequest>> {
        AnonymousClass1() {
        }

        static /* synthetic */ int a(NewEvent newEvent, NewEvent newEvent2) {
            return -(newEvent2.getWeight() - newEvent.getWeight());
        }

        @Override // com.sandboxol.greendao.a.c
        public void onError(int i, String str) {
        }

        @Override // com.sandboxol.greendao.a.c
        public void onSuccess(List<NewEventInfoRequest> list) {
            FunnelGameFrequencyStrategy.this.hasReportEvents.clear();
            for (NewEventInfoRequest newEventInfoRequest : list) {
                Collections.sort(newEventInfoRequest.getEvents(), new Comparator() { // from class: com.sandboxol.report.strategy.b
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        return FunnelGameFrequencyStrategy.AnonymousClass1.a((NewEvent) obj, (NewEvent) obj2);
                    }
                });
                FunnelGameFrequencyStrategy.this.hasReportEvents.put(newEventInfoRequest.getGameId(), newEventInfoRequest);
            }
        }
    }

    public FunnelGameFrequencyStrategy(boolean z) {
        super(z);
        this.hasReportEvents = new HashMap();
        NewEventReportHelper.newInstance().loadByEventType(EVENT_TYPE_REPORTED, new AnonymousClass1());
    }

    private NewEventInfoRequest filterHasReportEvents(NewEventInfoRequest newEventInfoRequest, NewEventInfoRequest newEventInfoRequest2) {
        if (newEventInfoRequest.getEvents().size() <= 0) {
            return newEventInfoRequest2;
        }
        NewEventInfoRequest newEventInfoRequest3 = new NewEventInfoRequest(newEventInfoRequest2.getEventType(), newEventInfoRequest2.getPlatform(), newEventInfoRequest2.getGameId());
        for (int size = newEventInfoRequest.getEventList().size(); size < newEventInfoRequest2.getEvents().size(); size++) {
            newEventInfoRequest3.getEvents().add(newEventInfoRequest2.getEventList().get(size));
        }
        return newEventInfoRequest3;
    }

    @Override // com.sandboxol.report.strategy.BaseReportStrategy, com.sandboxol.report.strategy.IReportStrategy
    public List<NewEventInfoRequest> clearEvents(List<NewEventInfoRequest> list) {
        List<NewEventInfoRequest> listClearEvents = super.clearEvents(list);
        if (listClearEvents.size() == 0) {
            NewEventReportHelper.newInstance().removeByEventType(getEventType());
            NewEventReportHelper.newInstance().removeByEventType(EVENT_TYPE_REPORTED);
            return new ArrayList();
        }
        try {
            for (NewEventInfoRequest newEventInfoRequest : listClearEvents) {
                NewEventInfoRequest newEventInfoRequest2 = this.hasReportEvents.get(newEventInfoRequest.getGameId());
                if (newEventInfoRequest2 == null) {
                    newEventInfoRequest2 = new NewEventInfoRequest(EVENT_TYPE_REPORTED, newEventInfoRequest.getPlatform(), newEventInfoRequest.getGameId());
                    newEventInfoRequest2.getEvents().addAll(newEventInfoRequest.getEvents());
                    this.hasReportEvents.put(newEventInfoRequest2.getGameId(), newEventInfoRequest2);
                } else {
                    newEventInfoRequest2.getEvents().addAll(newEventInfoRequest.getEvents());
                }
                NewEventReportHelper.newInstance().insertOrReplace(newEventInfoRequest2);
            }
        } catch (OutOfMemoryError e2) {
            e2.printStackTrace();
            NewEventReportHelper.newInstance().removeByEventType(getEventType());
            NewEventReportHelper.newInstance().removeByEventType(EVENT_TYPE_REPORTED);
        }
        return listClearEvents;
    }

    @Override // com.sandboxol.report.strategy.IReportStrategy
    public int endWeight() {
        return 22;
    }

    @Override // com.sandboxol.report.strategy.IReportStrategy
    public String getEventType() {
        return NewReportEventType.FUNNEL_GAME_FREQUENCY;
    }

    @Override // com.sandboxol.report.strategy.BaseReportStrategy, com.sandboxol.report.strategy.IReportStrategy
    public List<NewEventInfoRequest> getEvents() {
        List<NewEventInfoRequest> events = super.getEvents();
        ArrayList arrayList = new ArrayList();
        for (NewEventInfoRequest newEventInfoRequest : events) {
            NewEventInfoRequest newEventInfoRequest2 = this.hasReportEvents.get(newEventInfoRequest.getGameId());
            if (newEventInfoRequest2 != null) {
                NewEventInfoRequest newEventInfoRequestFilterHasReportEvents = filterHasReportEvents(newEventInfoRequest2, newEventInfoRequest);
                if (newEventInfoRequestFilterHasReportEvents.getEvents().size() > 0) {
                    arrayList.add(newEventInfoRequestFilterHasReportEvents);
                }
            } else {
                arrayList.add(newEventInfoRequest);
            }
        }
        return arrayList;
    }

    @Override // com.sandboxol.report.strategy.IReportStrategy
    public String getPlatform() {
        return IReportStrategy.PLATFORM_GAME;
    }

    @Override // com.sandboxol.report.strategy.BaseReportStrategy, com.sandboxol.report.strategy.IReportStrategy
    public int getStatisticType() {
        return 1;
    }

    @Override // com.sandboxol.report.strategy.BaseReportStrategy, com.sandboxol.report.strategy.IReportStrategy
    public /* bridge */ /* synthetic */ void onAppEvent(String str) {
        super.onAppEvent(str);
    }

    @Override // com.sandboxol.report.strategy.BaseReportStrategy, com.sandboxol.report.strategy.IReportStrategy
    public boolean onFilter(List<NewEvent> list, NewEvent newEvent) {
        return list.size() > 0 ? newEvent.getWeight() - list.get(list.size() - 1).getWeight() == 1 || newEvent.getWeight() == startWeight() : newEvent.getWeight() == startWeight();
    }

    @Override // com.sandboxol.report.strategy.BaseReportStrategy, com.sandboxol.report.strategy.IReportStrategy
    public /* bridge */ /* synthetic */ void onGameEvent(String str, String str2) {
        super.onGameEvent(str, str2);
    }

    @Override // com.sandboxol.report.strategy.BaseReportStrategy, com.sandboxol.report.strategy.IReportStrategy
    public /* bridge */ /* synthetic */ void onLoadData() {
        super.onLoadData();
    }

    @Override // com.sandboxol.report.strategy.BaseReportStrategy, com.sandboxol.report.strategy.IReportStrategy
    public void onRemove(List<NewEventInfoRequest> list) {
        for (NewEventInfoRequest newEventInfoRequest : list) {
            this.hasReportEvents.remove(newEventInfoRequest.getGameId());
            NewEventReportHelper.newInstance().removeByEventTypeAndGameId(EVENT_TYPE_REPORTED, newEventInfoRequest.getGameId());
        }
    }

    @Override // com.sandboxol.report.strategy.IReportStrategy
    public int startWeight() {
        return 17;
    }

    @Override // com.sandboxol.report.strategy.IReportStrategy
    public int stepLength() {
        return 6;
    }
}

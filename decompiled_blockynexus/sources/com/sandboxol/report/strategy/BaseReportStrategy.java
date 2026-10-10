package com.sandboxol.report.strategy;

import com.sandboxol.report.entity.NewEvent;
import com.sandboxol.report.entity.NewEventInfoRequest;
import com.sandboxol.report.helper.NewEventReportHelper;
import com.sandboxol.report.strategy.BaseReportStrategy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes4.dex */
abstract class BaseReportStrategy implements IReportStrategy {
    private static final String TAG = "com.sandboxol.report.strategy.BaseReportStrategy";
    private Map<String, NewEventInfoRequest> eventMaps;
    private boolean isInit;
    private List<String> lostAppEvent;
    private Map<String, String> lostgameEvent;
    private ReentrantReadWriteLock readWriteLock;

    /* JADX INFO: renamed from: com.sandboxol.report.strategy.BaseReportStrategy$1, reason: invalid class name */
    class AnonymousClass1 implements com.sandboxol.greendao.a.c<List<NewEventInfoRequest>> {
        AnonymousClass1() {
        }

        static /* synthetic */ int a(NewEvent newEvent, NewEvent newEvent2) {
            return -(newEvent2.getWeight() - newEvent.getWeight());
        }

        @Override // com.sandboxol.greendao.a.c
        public void onError(int i, String str) {
            BaseReportStrategy.this.isInit = true;
        }

        @Override // com.sandboxol.greendao.a.c
        public void onSuccess(List<NewEventInfoRequest> list) {
            BaseReportStrategy.this.readWriteLock.writeLock().lock();
            BaseReportStrategy.this.eventMaps.clear();
            for (NewEventInfoRequest newEventInfoRequest : list) {
                Collections.sort(newEventInfoRequest.getEvents(), new Comparator() { // from class: com.sandboxol.report.strategy.a
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        return BaseReportStrategy.AnonymousClass1.a((NewEvent) obj, (NewEvent) obj2);
                    }
                });
                BaseReportStrategy.this.eventMaps.put(newEventInfoRequest.getGameId(), newEventInfoRequest);
            }
            BaseReportStrategy.this.readWriteLock.writeLock().unlock();
            BaseReportStrategy.this.isInit = true;
            if (BaseReportStrategy.this.lostAppEvent.size() > 0) {
                Iterator it = BaseReportStrategy.this.lostAppEvent.iterator();
                while (it.hasNext()) {
                    BaseReportStrategy.this.onAppEvent((String) it.next());
                }
                BaseReportStrategy.this.lostAppEvent.clear();
            }
            for (Map.Entry entry : BaseReportStrategy.this.lostgameEvent.entrySet()) {
                BaseReportStrategy.this.onGameEvent((String) entry.getValue(), (String) entry.getKey());
            }
        }
    }

    public BaseReportStrategy() {
        this.eventMaps = new HashMap();
        this.readWriteLock = new ReentrantReadWriteLock();
        this.lostAppEvent = new ArrayList();
        this.lostgameEvent = new HashMap();
        this.isInit = false;
        initEventWeight();
    }

    @Override // com.sandboxol.report.strategy.IReportStrategy
    public List<NewEventInfoRequest> clearEvents(List<NewEventInfoRequest> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (NewEventInfoRequest newEventInfoRequest : list) {
            int size = newEventInfoRequest.getEvents().size();
            newEventInfoRequest.setIsUpdate(false);
            NewEventReportHelper.newInstance().insertOrReplace(newEventInfoRequest);
            if (size > 0 && newEventInfoRequest.getEvents().get(size - 1).getWeight() == endWeight()) {
                arrayList.add(newEventInfoRequest);
            } else if (System.currentTimeMillis() - newEventInfoRequest.getTimestamp() > 86400000) {
                arrayList.add(newEventInfoRequest);
            } else {
                arrayList2.add(newEventInfoRequest);
            }
        }
        removeInTrue(arrayList);
        return arrayList2;
    }

    @Override // com.sandboxol.report.strategy.IReportStrategy
    public List<NewEventInfoRequest> getEvents() {
        ArrayList arrayList = new ArrayList();
        for (NewEventInfoRequest newEventInfoRequest : this.eventMaps.values()) {
            if (newEventInfoRequest.getEvents().size() > 0 && newEventInfoRequest.getIsUpdate()) {
                arrayList.add(newEventInfoRequest);
            }
        }
        return arrayList;
    }

    @Override // com.sandboxol.report.strategy.IReportStrategy
    public /* synthetic */ int getStatisticType() {
        return c.a(this);
    }

    @Override // com.sandboxol.report.strategy.IReportStrategy
    public /* synthetic */ void initEventWeight() {
        c.b(this);
    }

    @Override // com.sandboxol.report.strategy.IReportStrategy
    public void onAppEvent(String str) {
        if (!this.isInit) {
            this.lostAppEvent.add(str);
            return;
        }
        this.readWriteLock.readLock().lock();
        NewEventInfoRequest newEventInfoRequest = this.eventMaps.get("app");
        if (newEventInfoRequest == null) {
            newEventInfoRequest = new NewEventInfoRequest(getEventType(), getPlatform(), "app");
            this.eventMaps.put("app", newEventInfoRequest);
        } else {
            newEventInfoRequest.setTimestamp(System.currentTimeMillis());
        }
        NewEvent newEvent = new NewEvent(str);
        setEventWeight(newEvent);
        List<NewEvent> events = newEventInfoRequest.getEvents();
        if (onFilter(events, newEvent)) {
            events.add(newEvent);
            newEventInfoRequest.setIsUpdate(true);
            NewEventReportHelper.newInstance().insertOrReplace(newEventInfoRequest);
        }
        this.readWriteLock.readLock().unlock();
    }

    @Override // com.sandboxol.report.strategy.IReportStrategy
    public boolean onFilter(List<NewEvent> list, NewEvent newEvent) {
        return list.size() > 0 ? newEvent.getWeight() - list.get(list.size() - 1).getWeight() == 1 : newEvent.getWeight() == startWeight();
    }

    @Override // com.sandboxol.report.strategy.IReportStrategy
    public void onGameEvent(String str, String str2) {
        if (!this.isInit) {
            this.lostgameEvent.put(str2, str);
            return;
        }
        this.readWriteLock.readLock().lock();
        NewEventInfoRequest newEventInfoRequest = this.eventMaps.get(str2);
        if (newEventInfoRequest == null) {
            newEventInfoRequest = new NewEventInfoRequest(getEventType(), getPlatform(), str2, getStatisticType());
            this.eventMaps.put(str2, newEventInfoRequest);
        } else {
            newEventInfoRequest.setTimestamp(System.currentTimeMillis());
        }
        NewEvent newEvent = new NewEvent(str);
        setEventWeight(newEvent);
        List<NewEvent> events = newEventInfoRequest.getEvents();
        if (onFilter(events, newEvent)) {
            events.add(newEvent);
            newEventInfoRequest.setIsUpdate(true);
            NewEventReportHelper.newInstance().insertOrReplace(newEventInfoRequest);
        }
        this.readWriteLock.readLock().unlock();
    }

    @Override // com.sandboxol.report.strategy.IReportStrategy
    public void onLoadData() {
        NewEventReportHelper.newInstance().loadByEventType(getEventType(), new AnonymousClass1());
    }

    @Override // com.sandboxol.report.strategy.IReportStrategy
    public /* synthetic */ void onRemove(List<NewEventInfoRequest> list) {
        c.a(this, list);
    }

    protected void removeInTrue(List<NewEventInfoRequest> list) {
        onRemove(list);
        NewEventReportHelper.newInstance().removeEventList(list);
        onLoadData();
    }

    @Override // com.sandboxol.report.strategy.IReportStrategy
    public /* synthetic */ void setEventWeight(NewEvent newEvent) {
        c.a(this, newEvent);
    }

    public BaseReportStrategy(boolean z) {
        this();
        if (z) {
            onLoadData();
        } else {
            this.isInit = true;
        }
    }
}

package com.trello.rxlifecycle;

import rx.functions.Func1;

/* JADX INFO: compiled from: RxLifecycle.java */
/* JADX INFO: loaded from: classes5.dex */
class i implements Func1<ActivityEvent, ActivityEvent> {
    i() {
    }

    @Override // rx.functions.Func1
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ActivityEvent call(ActivityEvent activityEvent) {
        switch (k.f20091a[activityEvent.ordinal()]) {
            case 1:
                return ActivityEvent.DESTROY;
            case 2:
                return ActivityEvent.STOP;
            case 3:
                return ActivityEvent.PAUSE;
            case 4:
                return ActivityEvent.STOP;
            case 5:
                return ActivityEvent.DESTROY;
            case 6:
                throw new OutsideLifecycleException("Cannot bind to Activity lifecycle when outside of it.");
            default:
                throw new UnsupportedOperationException("Binding to " + activityEvent + " not yet implemented");
        }
    }
}

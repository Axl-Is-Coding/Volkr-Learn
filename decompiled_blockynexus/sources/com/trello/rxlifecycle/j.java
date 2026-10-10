package com.trello.rxlifecycle;

import rx.functions.Func1;

/* JADX INFO: compiled from: RxLifecycle.java */
/* JADX INFO: loaded from: classes5.dex */
class j implements Func1<FragmentEvent, FragmentEvent> {
    j() {
    }

    @Override // rx.functions.Func1
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public FragmentEvent call(FragmentEvent fragmentEvent) {
        switch (k.f20092b[fragmentEvent.ordinal()]) {
            case 1:
                return FragmentEvent.DETACH;
            case 2:
                return FragmentEvent.DESTROY;
            case 3:
                return FragmentEvent.DESTROY_VIEW;
            case 4:
                return FragmentEvent.STOP;
            case 5:
                return FragmentEvent.PAUSE;
            case 6:
                return FragmentEvent.STOP;
            case 7:
                return FragmentEvent.DESTROY_VIEW;
            case 8:
                return FragmentEvent.DESTROY;
            case 9:
                return FragmentEvent.DETACH;
            case 10:
                throw new OutsideLifecycleException("Cannot bind to Fragment lifecycle when outside of it.");
            default:
                throw new UnsupportedOperationException("Binding to " + fragmentEvent + " not yet implemented");
        }
    }
}

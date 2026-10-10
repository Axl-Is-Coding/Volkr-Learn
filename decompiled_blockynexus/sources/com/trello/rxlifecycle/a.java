package com.trello.rxlifecycle;

import rx.Observable;

/* JADX INFO: compiled from: ActivityLifecycleProvider.java */
/* JADX INFO: loaded from: classes5.dex */
public interface a {
    <T> Observable.Transformer<T, T> bindUntilEvent(ActivityEvent activityEvent);
}

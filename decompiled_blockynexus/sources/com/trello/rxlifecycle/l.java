package com.trello.rxlifecycle;

import rx.Observable;
import rx.functions.Func1;

/* JADX INFO: compiled from: RxLifecycle.java */
/* JADX INFO: loaded from: classes5.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Func1<Throwable, Boolean> f20093a = new g();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Func1<Boolean, Boolean> f20094b = new h();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Func1<ActivityEvent, ActivityEvent> f20095c = new i();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Func1<FragmentEvent, FragmentEvent> f20096d = new j();

    public static <T, R> Observable.Transformer<T, T> a(Observable<R> observable, R r) {
        com.trello.rxlifecycle.a.a.a(observable, "lifecycle == null");
        com.trello.rxlifecycle.a.a.a(r, "event == null");
        return new d(observable, r);
    }

    public static <T> Observable.Transformer<T, T> b(Observable<FragmentEvent> observable) {
        return a((Observable) observable, (Func1) f20096d);
    }

    public static <T> Observable.Transformer<T, T> a(Observable<ActivityEvent> observable) {
        return a((Observable) observable, (Func1) f20095c);
    }

    public static <T, R> Observable.Transformer<T, T> a(Observable<R> observable, Func1<R, R> func1) {
        com.trello.rxlifecycle.a.a.a(observable, "lifecycle == null");
        com.trello.rxlifecycle.a.a.a(func1, "correspondingEvents == null");
        return new f(observable.share(), func1);
    }
}

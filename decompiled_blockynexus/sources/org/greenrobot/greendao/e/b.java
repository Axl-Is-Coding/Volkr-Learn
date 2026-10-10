package org.greenrobot.greendao.e;

import rx.Scheduler;

/* JADX INFO: compiled from: RxDao.java */
/* JADX INFO: loaded from: classes5.dex */
public class b<T, K> extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final org.greenrobot.greendao.a<T, K> f23628b;

    public b(org.greenrobot.greendao.a<T, K> aVar) {
        this(aVar, null);
    }

    public b(org.greenrobot.greendao.a<T, K> aVar, Scheduler scheduler) {
        super(scheduler);
        this.f23628b = aVar;
    }
}

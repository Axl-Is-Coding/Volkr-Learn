package org.greenrobot.greendao.e;

import rx.Scheduler;

/* JADX INFO: compiled from: RxTransaction.java */
/* JADX INFO: loaded from: classes5.dex */
public class c extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final org.greenrobot.greendao.c f23629b;

    public c(org.greenrobot.greendao.c cVar) {
        this.f23629b = cVar;
    }

    public c(org.greenrobot.greendao.c cVar, Scheduler scheduler) {
        super(scheduler);
        this.f23629b = cVar;
    }
}

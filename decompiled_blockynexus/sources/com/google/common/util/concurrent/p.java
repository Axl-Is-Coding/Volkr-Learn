package com.google.common.util.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: Monitor.java */
/* JADX INFO: loaded from: classes2.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f14066a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ReentrantLock f14067b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private a f14068c;

    /* JADX INFO: compiled from: Monitor.java */
    public static abstract class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final p f14069a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Condition f14070b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f14071c = 0;

        protected a(p pVar) {
            com.google.common.base.m.a(pVar, "monitor");
            this.f14069a = pVar;
            this.f14070b = pVar.f14067b.newCondition();
        }
    }

    public p() {
        this(false);
    }

    public p(boolean z) {
        this.f14068c = null;
        this.f14066a = z;
        this.f14067b = new ReentrantLock(z);
    }
}

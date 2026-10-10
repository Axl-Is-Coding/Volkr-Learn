package com.google.android.datatransport.runtime.d.a;

import com.google.android.datatransport.runtime.d.a.C2218b;

/* JADX INFO: renamed from: com.google.android.datatransport.runtime.d.a.e, reason: case insensitive filesystem */
/* JADX INFO: compiled from: EventStoreConfig.java */
/* JADX INFO: loaded from: classes.dex */
abstract class AbstractC2221e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final AbstractC2221e f12891a;

    /* JADX INFO: renamed from: com.google.android.datatransport.runtime.d.a.e$a */
    /* JADX INFO: compiled from: EventStoreConfig.java */
    static abstract class a {
        a() {
        }

        abstract a a(int i);

        abstract a a(long j);

        abstract AbstractC2221e a();

        abstract a b(int i);

        abstract a b(long j);

        abstract a c(int i);
    }

    static {
        a aVarA = a();
        aVarA.b(10485760L);
        aVarA.b(200);
        aVarA.a(10000);
        aVarA.a(604800000L);
        aVarA.c(81920);
        f12891a = aVarA.a();
    }

    AbstractC2221e() {
    }

    static a a() {
        return new C2218b.a();
    }

    abstract int b();

    abstract long c();

    abstract int d();

    abstract int e();

    abstract long f();
}

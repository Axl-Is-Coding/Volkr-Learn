package com.google.android.datatransport.runtime.d.a;

import java.io.Closeable;

/* JADX INFO: renamed from: com.google.android.datatransport.runtime.d.a.d, reason: case insensitive filesystem */
/* JADX INFO: compiled from: EventStore.java */
/* JADX INFO: loaded from: classes.dex */
public interface InterfaceC2220d extends Closeable {
    int G();

    Iterable<com.google.android.datatransport.runtime.q> I();

    long a(com.google.android.datatransport.runtime.q qVar);

    AbstractC2226j a(com.google.android.datatransport.runtime.q qVar, com.google.android.datatransport.runtime.l lVar);

    void a(com.google.android.datatransport.runtime.q qVar, long j);

    void a(Iterable<AbstractC2226j> iterable);

    void b(Iterable<AbstractC2226j> iterable);

    boolean b(com.google.android.datatransport.runtime.q qVar);

    Iterable<AbstractC2226j> c(com.google.android.datatransport.runtime.q qVar);
}

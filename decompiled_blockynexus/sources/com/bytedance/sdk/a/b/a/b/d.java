package com.bytedance.sdk.a.b.a.b;

import com.bytedance.sdk.a.b.ac;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: compiled from: RouteDatabase.java */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set<ac> f4946a = new LinkedHashSet();

    public synchronized void a(ac acVar) {
        this.f4946a.add(acVar);
    }

    public synchronized void b(ac acVar) {
        this.f4946a.remove(acVar);
    }

    public synchronized boolean c(ac acVar) {
        return this.f4946a.contains(acVar);
    }
}

package com.bumptech.glide.load.engine;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: Jobs.java */
/* JADX INFO: loaded from: classes.dex */
final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<com.bumptech.glide.load.h, EngineJob<?>> f4620a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<com.bumptech.glide.load.h, EngineJob<?>> f4621b = new HashMap();

    y() {
    }

    EngineJob<?> a(com.bumptech.glide.load.h hVar, boolean z) {
        return a(z).get(hVar);
    }

    void b(com.bumptech.glide.load.h hVar, EngineJob<?> engineJob) {
        Map<com.bumptech.glide.load.h, EngineJob<?>> mapA = a(engineJob.f());
        if (engineJob.equals(mapA.get(hVar))) {
            mapA.remove(hVar);
        }
    }

    void a(com.bumptech.glide.load.h hVar, EngineJob<?> engineJob) {
        a(engineJob.f()).put(hVar, engineJob);
    }

    private Map<com.bumptech.glide.load.h, EngineJob<?>> a(boolean z) {
        return z ? this.f4621b : this.f4620a;
    }
}

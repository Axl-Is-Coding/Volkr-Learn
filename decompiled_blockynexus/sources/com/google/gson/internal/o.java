package com.google.gson.internal;

import java.util.concurrent.ConcurrentSkipListMap;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: ConstructorConstructor.java */
/* JADX INFO: loaded from: classes2.dex */
class o<T> implements w<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ p f14228a;

    o(p pVar) {
        this.f14228a = pVar;
    }

    @Override // com.google.gson.internal.w
    public T a() {
        return (T) new ConcurrentSkipListMap();
    }
}

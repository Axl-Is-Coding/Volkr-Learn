package com.google.gson.internal;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: renamed from: com.google.gson.internal.b, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ConstructorConstructor.java */
/* JADX INFO: loaded from: classes2.dex */
class C2272b<T> implements w<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ p f14124a;

    C2272b(p pVar) {
        this.f14124a = pVar;
    }

    @Override // com.google.gson.internal.w
    public T a() {
        return (T) new ConcurrentHashMap();
    }
}

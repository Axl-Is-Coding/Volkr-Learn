package com.google.gson.internal;

import java.util.TreeMap;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: renamed from: com.google.gson.internal.c, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ConstructorConstructor.java */
/* JADX INFO: loaded from: classes2.dex */
class C2292c<T> implements w<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ p f14207a;

    C2292c(p pVar) {
        this.f14207a = pVar;
    }

    @Override // com.google.gson.internal.w
    public T a() {
        return (T) new TreeMap();
    }
}

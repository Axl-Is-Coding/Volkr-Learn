package com.google.gson.internal;

import java.util.LinkedHashMap;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: renamed from: com.google.gson.internal.d, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ConstructorConstructor.java */
/* JADX INFO: loaded from: classes2.dex */
class C2293d<T> implements w<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ p f14208a;

    C2293d(p pVar) {
        this.f14208a = pVar;
    }

    @Override // com.google.gson.internal.w
    public T a() {
        return (T) new LinkedHashMap();
    }
}

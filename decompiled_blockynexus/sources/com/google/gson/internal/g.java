package com.google.gson.internal;

import java.lang.reflect.Type;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: ConstructorConstructor.java */
/* JADX INFO: loaded from: classes2.dex */
class g<T> implements w<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.google.gson.l f14214a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Type f14215b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ p f14216c;

    g(p pVar, com.google.gson.l lVar, Type type) {
        this.f14216c = pVar;
        this.f14214a = lVar;
        this.f14215b = type;
    }

    @Override // com.google.gson.internal.w
    public T a() {
        return (T) this.f14214a.a(this.f14215b);
    }
}

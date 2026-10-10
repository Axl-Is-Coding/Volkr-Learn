package com.google.gson.internal;

import java.lang.reflect.Type;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: ConstructorConstructor.java */
/* JADX INFO: loaded from: classes2.dex */
class h<T> implements w<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.google.gson.l f14217a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Type f14218b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ p f14219c;

    h(p pVar, com.google.gson.l lVar, Type type) {
        this.f14219c = pVar;
        this.f14217a = lVar;
        this.f14218b = type;
    }

    @Override // com.google.gson.internal.w
    public T a() {
        return (T) this.f14217a.a(this.f14218b);
    }
}

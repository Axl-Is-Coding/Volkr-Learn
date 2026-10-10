package com.google.gson.internal;

import java.lang.reflect.Method;

/* JADX INFO: compiled from: UnsafeAllocator.java */
/* JADX INFO: loaded from: classes2.dex */
class B extends E {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Method f14099a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f14100b;

    B(Method method, int i) {
        this.f14099a = method;
        this.f14100b = i;
    }

    @Override // com.google.gson.internal.E
    public <T> T b(Class<T> cls) throws Exception {
        E.a(cls);
        return (T) this.f14099a.invoke(null, cls, Integer.valueOf(this.f14100b));
    }
}

package com.google.gson.internal;

import java.lang.reflect.Method;

/* JADX INFO: compiled from: UnsafeAllocator.java */
/* JADX INFO: loaded from: classes2.dex */
class A extends E {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Method f14097a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Object f14098b;

    A(Method method, Object obj) {
        this.f14097a = method;
        this.f14098b = obj;
    }

    @Override // com.google.gson.internal.E
    public <T> T b(Class<T> cls) throws Exception {
        E.a(cls);
        return (T) this.f14097a.invoke(this.f14098b, cls);
    }
}

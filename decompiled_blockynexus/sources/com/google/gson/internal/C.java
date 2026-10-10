package com.google.gson.internal;

import java.lang.reflect.Method;

/* JADX INFO: compiled from: UnsafeAllocator.java */
/* JADX INFO: loaded from: classes2.dex */
class C extends E {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Method f14101a;

    C(Method method) {
        this.f14101a = method;
    }

    @Override // com.google.gson.internal.E
    public <T> T b(Class<T> cls) throws Exception {
        E.a(cls);
        return (T) this.f14101a.invoke(null, cls, Object.class);
    }
}

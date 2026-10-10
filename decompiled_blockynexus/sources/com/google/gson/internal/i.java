package com.google.gson.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: ConstructorConstructor.java */
/* JADX INFO: loaded from: classes2.dex */
class i<T> implements w<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Constructor f14220a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ p f14221b;

    i(p pVar, Constructor constructor) {
        this.f14221b = pVar;
        this.f14220a = constructor;
    }

    @Override // com.google.gson.internal.w
    public T a() {
        try {
            return (T) this.f14220a.newInstance(null);
        } catch (IllegalAccessException e2) {
            throw new AssertionError(e2);
        } catch (InstantiationException e3) {
            throw new RuntimeException("Failed to invoke " + this.f14220a + " with no args", e3);
        } catch (InvocationTargetException e4) {
            throw new RuntimeException("Failed to invoke " + this.f14220a + " with no args", e4.getTargetException());
        }
    }
}

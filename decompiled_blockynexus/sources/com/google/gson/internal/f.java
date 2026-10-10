package com.google.gson.internal;

import java.lang.reflect.Type;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: ConstructorConstructor.java */
/* JADX INFO: loaded from: classes2.dex */
class f<T> implements w<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final E f14210a = E.a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Class f14211b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Type f14212c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ p f14213d;

    f(p pVar, Class cls, Type type) {
        this.f14213d = pVar;
        this.f14211b = cls;
        this.f14212c = type;
    }

    @Override // com.google.gson.internal.w
    public T a() {
        try {
            return (T) this.f14210a.b(this.f14211b);
        } catch (Exception e2) {
            throw new RuntimeException("Unable to invoke no-args constructor for " + this.f14212c + ". Registering an InstanceCreator with Gson for this type may fix this problem.", e2);
        }
    }
}

package com.google.gson.internal.bind;

import com.google.gson.reflect.TypeToken;

/* JADX INFO: loaded from: classes2.dex */
class TypeAdapters$35 implements com.google.gson.y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Class f14180a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.google.gson.x f14181b;

    TypeAdapters$35(Class cls, com.google.gson.x xVar) {
        this.f14180a = cls;
        this.f14181b = xVar;
    }

    @Override // com.google.gson.y
    public <T2> com.google.gson.x<T2> a(com.google.gson.j jVar, TypeToken<T2> typeToken) {
        Class<? super T2> rawType = typeToken.getRawType();
        if (this.f14180a.isAssignableFrom(rawType)) {
            return new J(this, rawType);
        }
        return null;
    }

    public String toString() {
        return "Factory[typeHierarchy=" + this.f14180a.getName() + ",adapter=" + this.f14181b + "]";
    }
}

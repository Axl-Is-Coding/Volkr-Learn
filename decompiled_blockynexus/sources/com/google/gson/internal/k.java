package com.google.gson.internal;

import com.google.gson.JsonIOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.EnumSet;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: ConstructorConstructor.java */
/* JADX INFO: loaded from: classes2.dex */
class k<T> implements w<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Type f14223a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ p f14224b;

    k(p pVar, Type type) {
        this.f14224b = pVar;
        this.f14223a = type;
    }

    @Override // com.google.gson.internal.w
    public T a() {
        Type type = this.f14223a;
        if (!(type instanceof ParameterizedType)) {
            throw new JsonIOException("Invalid EnumSet type: " + this.f14223a.toString());
        }
        Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
        if (type2 instanceof Class) {
            return (T) EnumSet.noneOf((Class) type2);
        }
        throw new JsonIOException("Invalid EnumSet type: " + this.f14223a.toString());
    }
}

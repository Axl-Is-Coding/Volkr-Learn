package com.google.common.reflect;

import com.google.common.reflect.b;
import java.lang.reflect.Constructor;
import java.lang.reflect.Type;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: TypeToken.java */
/* JADX INFO: loaded from: classes2.dex */
class k<T> extends b.a<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ TypeToken f14009d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    k(TypeToken typeToken, Constructor constructor) {
        super(constructor);
        this.f14009d = typeToken;
    }

    @Override // com.google.common.reflect.a
    public TypeToken<T> a() {
        return this.f14009d;
    }

    @Override // com.google.common.reflect.b.a
    Type[] b() {
        TypeToken typeToken = this.f14009d;
        Type[] typeArrB = super.b();
        TypeToken.access$200(typeToken, typeArrB);
        return typeArrB;
    }

    @Override // com.google.common.reflect.b, com.google.common.reflect.a
    public String toString() {
        return a() + "(" + com.google.common.base.h.a(", ").a((Object[]) b()) + ")";
    }
}

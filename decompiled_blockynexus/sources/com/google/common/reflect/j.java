package com.google.common.reflect;

import com.alibaba.android.arouter.utils.Consts;
import com.google.common.reflect.b;
import java.lang.reflect.Method;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: TypeToken.java */
/* JADX INFO: loaded from: classes2.dex */
class j<T> extends b.C0133b<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ TypeToken f14008d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    j(TypeToken typeToken, Method method) {
        super(method);
        this.f14008d = typeToken;
    }

    @Override // com.google.common.reflect.a
    public TypeToken<T> a() {
        return this.f14008d;
    }

    @Override // com.google.common.reflect.b, com.google.common.reflect.a
    public String toString() {
        return a() + Consts.DOT + super.toString();
    }
}

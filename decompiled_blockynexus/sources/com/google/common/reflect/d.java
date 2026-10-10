package com.google.common.reflect;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: TypeCapture.java */
/* JADX INFO: loaded from: classes2.dex */
abstract class d<T> {
    d() {
    }

    final Type capture() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        com.google.common.base.m.a(genericSuperclass instanceof ParameterizedType, "%s isn't parameterized", genericSuperclass);
        return ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
    }
}

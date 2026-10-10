package com.google.common.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/* JADX INFO: compiled from: Reflection.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c {
    public static <T> T a(Class<T> cls, InvocationHandler invocationHandler) {
        com.google.common.base.m.a(invocationHandler);
        com.google.common.base.m.a(cls.isInterface(), "%s is not an interface", cls);
        return cls.cast(Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, invocationHandler));
    }
}

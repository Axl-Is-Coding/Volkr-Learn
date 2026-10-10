package com.google.common.util.concurrent;

import java.lang.reflect.Field;
import java.security.PrivilegedExceptionAction;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: AbstractFuture.java */
/* JADX INFO: loaded from: classes2.dex */
class c implements PrivilegedExceptionAction<Unsafe> {
    c() {
    }

    @Override // java.security.PrivilegedExceptionAction
    public Unsafe run() throws Exception {
        for (Field field : Unsafe.class.getDeclaredFields()) {
            field.setAccessible(true);
            Object obj = field.get(null);
            if (Unsafe.class.isInstance(obj)) {
                return (Unsafe) Unsafe.class.cast(obj);
            }
        }
        throw new NoSuchFieldError("the Unsafe");
    }
}

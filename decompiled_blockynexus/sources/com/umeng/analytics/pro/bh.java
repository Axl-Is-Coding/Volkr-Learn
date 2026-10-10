package com.umeng.analytics.pro;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: TEnumHelper.java */
/* JADX INFO: loaded from: classes5.dex */
public class bh {
    public static bg a(Class<? extends bg> cls, int i) {
        try {
            return (bg) cls.getMethod("findByValue", Integer.TYPE).invoke(null, Integer.valueOf(i));
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return null;
        }
    }
}

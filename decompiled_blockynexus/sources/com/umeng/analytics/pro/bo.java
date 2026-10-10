package com.umeng.analytics.pro;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: FieldMetaData.java */
/* JADX INFO: loaded from: classes5.dex */
public class bo implements Serializable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Map<Class<? extends bc>, Map<? extends bj, bo>> f20719d = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f20720a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte f20721b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final bp f20722c;

    public bo(String str, byte b2, bp bpVar) {
        this.f20720a = str;
        this.f20721b = b2;
        this.f20722c = bpVar;
    }

    public static void a(Class<? extends bc> cls, Map<? extends bj, bo> map) {
        f20719d.put(cls, map);
    }

    public static Map<? extends bj, bo> a(Class<? extends bc> cls) {
        if (!f20719d.containsKey(cls)) {
            try {
                cls.newInstance();
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("IllegalAccessException for TBase class: " + cls.getName() + ", message: " + e2.getMessage());
            } catch (InstantiationException e3) {
                throw new RuntimeException("InstantiationException for TBase class: " + cls.getName() + ", message: " + e3.getMessage());
            }
        }
        return f20719d.get(cls);
    }
}

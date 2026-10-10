package com.alibaba.mtl.appmonitor.c;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: BalancedPool.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f3578a = new a();
    private Map<Class<? extends b>, c<? extends b>> o = new HashMap();

    private a() {
    }

    public static a a() {
        return f3578a;
    }

    public <T extends b> T a(Class<T> cls, Object... objArr) {
        T tNewInstance;
        b bVarA = a(cls).a();
        if (bVarA == null) {
            try {
                tNewInstance = cls.newInstance();
            } catch (Exception e2) {
                com.alibaba.mtl.appmonitor.b.b.m17a((Throwable) e2);
                tNewInstance = (T) bVarA;
            }
        } else {
            tNewInstance = (T) bVarA;
        }
        if (tNewInstance != null) {
            tNewInstance.fill(objArr);
        }
        return tNewInstance;
    }

    public <T extends b> void a(T t) {
        if (t == null || (t instanceof e) || (t instanceof d)) {
            return;
        }
        a(t.getClass()).a(t);
    }

    private synchronized <T extends b> c<T> a(Class<T> cls) {
        c<T> cVar;
        cVar = (c) this.o.get(cls);
        if (cVar == null) {
            cVar = new c<>();
            this.o.put(cls, cVar);
        }
        return cVar;
    }
}

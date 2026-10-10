package com.ironsource.mediationsdk.utils;

import com.ironsource.mediationsdk.AbstractC2373ua;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SessionCappingManager.java */
/* JADX INFO: loaded from: classes2.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, Integer> f15047a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map<String, Integer> f15048b = new HashMap();

    public l(List<AbstractC2373ua> list) {
        for (AbstractC2373ua abstractC2373ua : list) {
            this.f15047a.put(abstractC2373ua.r(), 0);
            this.f15048b.put(abstractC2373ua.r(), Integer.valueOf(abstractC2373ua.u()));
        }
    }

    public void a(AbstractC2373ua abstractC2373ua) {
        synchronized (this) {
            String strR = abstractC2373ua.r();
            if (this.f15047a.containsKey(strR)) {
                this.f15047a.put(strR, Integer.valueOf(this.f15047a.get(strR).intValue() + 1));
            }
        }
    }

    public boolean b(AbstractC2373ua abstractC2373ua) {
        synchronized (this) {
            String strR = abstractC2373ua.r();
            if (this.f15047a.containsKey(strR)) {
                return this.f15047a.get(strR).intValue() >= abstractC2373ua.u();
            }
            return false;
        }
    }

    public boolean a() {
        for (String str : this.f15048b.keySet()) {
            if (this.f15047a.get(str).intValue() < this.f15048b.get(str).intValue()) {
                return false;
            }
        }
        return true;
    }
}

package com.ironsource.sdk.data;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: DemandSource.java */
/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f15387a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f15388b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Map<String, String> f15390d;
    private b.f.d.g.a g;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f15389c = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f15391e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f15392f = false;

    public d(String str, String str2, Map<String, String> map, b.f.d.g.a aVar) {
        this.f15388b = str;
        this.f15387a = str2;
        this.f15390d = map;
        this.g = aVar;
    }

    public void a(boolean z) {
        this.f15392f = z;
    }

    public boolean b() {
        return this.f15392f;
    }

    public int c() {
        return this.f15391e;
    }

    public String d() {
        return this.f15387a;
    }

    public Map<String, String> e() {
        return this.f15390d;
    }

    public String f() {
        return this.f15388b;
    }

    public b.f.d.g.a g() {
        return this.g;
    }

    public int h() {
        return this.f15389c;
    }

    public boolean i() {
        Map<String, String> map = this.f15390d;
        if (map == null || !map.containsKey("rewarded")) {
            return false;
        }
        return Boolean.parseBoolean(this.f15390d.get("rewarded"));
    }

    public boolean a(int i) {
        return this.f15389c == i;
    }

    public synchronized void b(int i) {
        this.f15391e = i;
    }

    public void c(int i) {
        this.f15389c = i;
    }

    public Map<String, String> a() {
        HashMap map = new HashMap();
        map.put("demandSourceId", this.f15388b);
        map.put("demandSourceName", this.f15387a);
        Map<String, String> map2 = this.f15390d;
        if (map2 != null) {
            map.putAll(map2);
        }
        return map;
    }
}

package com.android.volley;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: Cache.java */
/* JADX INFO: loaded from: classes.dex */
public interface a {

    /* JADX INFO: renamed from: com.android.volley.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Cache.java */
    public static class C0049a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public byte[] f3976a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f3977b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f3978c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f3979d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f3980e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f3981f;
        public Map<String, String> g = Collections.emptyMap();
        public List<g> h;

        public boolean a() {
            return this.f3980e < System.currentTimeMillis();
        }

        public boolean b() {
            return this.f3981f < System.currentTimeMillis();
        }
    }

    void a(String str, C0049a c0049a);

    C0049a get(String str);

    void initialize();
}

package com.bytedance.sdk.adnet.face;

import com.bytedance.sdk.adnet.core.Header;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: ICache.java */
/* JADX INFO: loaded from: classes.dex */
public interface a {

    /* JADX INFO: renamed from: com.bytedance.sdk.adnet.face.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ICache.java */
    public static class C0073a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f5566a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public byte[] f5567b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f5568c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f5569d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f5570e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f5571f;
        public long g;
        public Map<String, String> h = Collections.emptyMap();
        public List<Header> i;

        public boolean a() {
            return this.f5571f < System.currentTimeMillis();
        }

        public boolean b() {
            return this.g < System.currentTimeMillis();
        }
    }

    C0073a a(String str);

    void a();

    void a(String str, C0073a c0073a);
}

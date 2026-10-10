package com.bytedance.sdk.adnet.core;

import com.bytedance.sdk.adnet.err.VAdError;
import com.bytedance.sdk.adnet.face.a;
import java.util.Map;

/* JADX INFO: compiled from: Response.java */
/* JADX INFO: loaded from: classes.dex */
public class m<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f5538a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a.C0073a f5539b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final VAdError f5540c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f5541d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f5542e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f5543f;
    public Map<String, Object> g;
    public long h;

    /* JADX INFO: compiled from: Response.java */
    public interface a<T> {
        void a(m<T> mVar);

        void b(m<T> mVar);
    }

    private m(T t, a.C0073a c0073a) {
        this.f5541d = false;
        this.f5542e = 0L;
        this.f5543f = 0L;
        this.h = 0L;
        this.f5538a = t;
        this.f5539b = c0073a;
        this.f5540c = null;
        if (c0073a != null) {
            this.h = c0073a.f5566a;
        }
    }

    public static <T> m<T> a(T t, a.C0073a c0073a) {
        return new m<>(t, c0073a);
    }

    public m b(long j) {
        this.f5543f = j;
        return this;
    }

    public static <T> m<T> a(VAdError vAdError) {
        return new m<>(vAdError);
    }

    public boolean a() {
        return this.f5540c == null;
    }

    public m a(long j) {
        this.f5542e = j;
        return this;
    }

    public String a(String str, String str2) {
        Map<String, String> map;
        String str3;
        a.C0073a c0073a = this.f5539b;
        return (c0073a == null || (map = c0073a.h) == null || (str3 = map.get(str)) == null) ? str2 : str3;
    }

    private m(VAdError vAdError) {
        i iVar;
        this.f5541d = false;
        this.f5542e = 0L;
        this.f5543f = 0L;
        this.h = 0L;
        this.f5538a = null;
        this.f5539b = null;
        this.f5540c = vAdError;
        if (this.h != 0 || vAdError == null || (iVar = vAdError.networkResponse) == null) {
            return;
        }
        this.h = iVar.f5524a;
    }
}

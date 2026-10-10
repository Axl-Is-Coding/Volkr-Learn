package com.bytedance.sdk.openadsdk.h;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import com.bytedance.sdk.openadsdk.h.a.c;
import com.bytedance.sdk.openadsdk.utils.o;
import java.util.Set;

/* JADX INFO: compiled from: Proxy.java */
/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static volatile com.bytedance.sdk.openadsdk.h.a.b f6888a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static volatile com.bytedance.sdk.openadsdk.h.a.c f6889b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile boolean f6891d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static volatile boolean f6893f;
    public static volatile Integer i;
    private static volatile com.bytedance.sdk.openadsdk.h.b.c j;

    @SuppressLint({"StaticFieldLeak"})
    private static volatile Context k;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final boolean f6890c = o.c();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static volatile boolean f6892e = true;
    static volatile int g = 0;
    public static volatile int h = 3;

    public static Context a() {
        return k;
    }

    public static void b(boolean z) {
        f6893f = z;
    }

    public static com.bytedance.sdk.openadsdk.h.a.b c() {
        return f6888a;
    }

    public static void a(boolean z) {
        f6892e = z;
    }

    public static com.bytedance.sdk.openadsdk.h.a.c b() {
        return f6889b;
    }

    public static void a(int i2) {
        g = i2;
    }

    public static void a(com.bytedance.sdk.openadsdk.h.a.c cVar, Context context) {
        if (cVar != null && context != null) {
            k = context.getApplicationContext();
            if (f6889b != null) {
                return;
            }
            com.bytedance.sdk.openadsdk.h.a.b bVar = f6888a;
            if (bVar != null && bVar.f6825a.getAbsolutePath().equals(cVar.f6827a.getAbsolutePath())) {
                throw new IllegalArgumentException("DiskLruCache 和 DiskCache 不能使用相同的目录");
            }
            f6889b = cVar;
            j = com.bytedance.sdk.openadsdk.h.b.c.a(context);
            f6889b.a(new c.a() { // from class: com.bytedance.sdk.openadsdk.h.e.1
                @Override // com.bytedance.sdk.openadsdk.h.a.c.a
                public void a(String str) {
                    if (e.f6890c) {
                        Log.i("TAG_PROXY_DiskLruCache", "new cache created: " + str);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.h.a.c.a
                public void a(Set<String> set) {
                    e.j.a(set, 0);
                    if (e.f6890c) {
                        Log.i("TAG_PROXY_DiskLruCache", "cache file removed, " + set);
                    }
                }
            });
            f fVarA = f.a();
            fVarA.a(cVar);
            fVarA.a(j);
            d dVarC = d.c();
            dVarC.a(cVar);
            dVarC.a(j);
            return;
        }
        throw new IllegalArgumentException("DiskLruCache and Context can't be null !!!");
    }
}

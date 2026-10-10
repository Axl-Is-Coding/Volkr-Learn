package com.bytedance.sdk.openadsdk.h.a;

import android.content.Context;
import com.bytedance.sdk.openadsdk.h.e;
import com.bytedance.sdk.openadsdk.h.g.d;
import java.io.File;

/* JADX INFO: compiled from: DiskCache.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f6825a;

    public void a() {
        d.a(new Runnable() { // from class: com.bytedance.sdk.openadsdk.h.a.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.b();
            }
        });
    }

    public void b() {
        com.bytedance.sdk.openadsdk.h.d.c().d();
        Context contextA = e.a();
        if (contextA != null) {
            com.bytedance.sdk.openadsdk.h.b.c.a(contextA).a(1);
        }
        for (File file : this.f6825a.listFiles()) {
            try {
                file.delete();
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.h.a.a
    public File c(String str) {
        return e(str);
    }

    @Override // com.bytedance.sdk.openadsdk.h.a.a
    public File d(String str) {
        return e(str);
    }

    File e(String str) {
        return new File(this.f6825a, str);
    }
}

package com.bytedance.sdk.openadsdk.core.widget.webview.a;

import android.webkit.WebResourceResponse;
import com.bytedance.sdk.openadsdk.core.d.h;
import com.bytedance.sdk.openadsdk.core.d.k;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.g.j;
import com.bytedance.sdk.openadsdk.core.widget.webview.a.e;
import com.bytedance.sdk.openadsdk.utils.i;
import com.bytedance.sdk.openadsdk.utils.o;
import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: TTDynamic.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    public static void a() {
        b.a();
        d.a();
    }

    public static void b() {
        try {
            f.d();
            File fileF = b.f();
            if (fileF != null && fileF.exists()) {
                if (fileF.getParentFile() != null) {
                    i.c(fileF.getParentFile());
                } else {
                    i.c(fileF);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static void c() {
        d.a().c();
    }

    public static String d() {
        return c.c();
    }

    public static void e() {
        d.a().d();
    }

    public static k f() {
        return b.a().d();
    }

    public static boolean g() {
        return b.a().c();
    }

    public static void a(h hVar) {
        d.a().a(hVar);
    }

    public static void a(j jVar) {
        d.a().a(jVar, "");
    }

    public static void a(Set<String> set) {
        d.a().a(set);
    }

    public static l a(String str) {
        return d.a().a(str);
    }

    public static WebResourceResponse a(String str, e.a aVar) throws Throwable {
        File file;
        if (g()) {
            Iterator<k.a> it = f().d().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                k.a next = it.next();
                if (next.a() != null && next.a().equals(str)) {
                    file = new File(b.f(), com.bytedance.sdk.openadsdk.utils.h.a(next.a()));
                    String strA = com.bytedance.sdk.openadsdk.utils.h.a(file);
                    if (next.b() == null || !next.b().equals(strA)) {
                        break;
                    }
                }
            }
            file = null;
        } else {
            file = null;
        }
        if (file != null) {
            try {
                return new WebResourceResponse(aVar.a(), "utf-8", new FileInputStream(file));
            } catch (Throwable th) {
                o.c("TTDynamic", "get html WebResourceResponse error", th);
            }
        }
        return null;
    }

    public static l b(h hVar) {
        if (hVar == null || hVar.u() == null) {
            return null;
        }
        return d.a().a(hVar.u().b());
    }
}

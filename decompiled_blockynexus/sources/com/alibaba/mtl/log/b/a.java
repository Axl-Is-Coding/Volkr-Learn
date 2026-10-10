package com.alibaba.mtl.log.b;

import android.text.TextUtils;
import com.alibaba.mtl.log.d.i;
import java.util.List;

/* JADX INFO: compiled from: CoreStatics.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static StringBuilder f3613a = new StringBuilder();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile long f3614e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static long f3615f;
    private static long g;
    private static long h;
    private static long i;
    private static long j;
    private static long k;
    private static long l;
    private static long m;
    private static long n;
    private static long o;
    private static long p;
    private static long q;
    private static long r;
    private static long s;
    private static long t;
    private static int u;

    /* JADX INFO: renamed from: u, reason: collision with other field name */
    private static long f55u;
    private static int v;

    /* JADX INFO: renamed from: v, reason: collision with other field name */
    private static long f56v;
    private static int w;

    /* JADX INFO: renamed from: w, reason: collision with other field name */
    private static long f57w;
    private static long x;
    private static long y;

    public static synchronized void A() {
        t++;
    }

    public static synchronized void B() {
        f55u++;
    }

    public static synchronized void C() {
        w++;
        if (f3614e == 0 && g == 0) {
            return;
        }
        if (com.alibaba.mtl.log.a.o || w >= 6) {
            c(true);
        }
    }

    public static synchronized void a(List<com.alibaba.mtl.log.model.a> list, int i2) {
        if (list == null) {
            return;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            com.alibaba.mtl.log.model.a aVar = list.get(i4);
            if (aVar != null) {
                if (!"6005".equalsIgnoreCase(aVar.X)) {
                    i3++;
                }
                f3613a.append(aVar.ab);
                if (i4 != list.size() - 1) {
                    f3613a.append(",");
                }
            }
        }
        i.a("CoreStatics", "[uploadInc]:", Long.valueOf(g), "count:", Integer.valueOf(i2));
        g += (long) i2;
        i.a("CoreStatics", "[uploadInc]:", Long.valueOf(g));
        if (i3 != i2) {
            i.a("CoreStatics", "Mutil Process Upload Error");
        }
    }

    @Deprecated
    public static synchronized void c(boolean z) {
    }

    public static synchronized void d(int i2) {
        u += i2;
    }

    private static boolean e(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return "6005".equalsIgnoreCase(str.trim());
    }

    public static synchronized void m(String str) {
        if (e(str)) {
            return;
        }
        if ("65501".equalsIgnoreCase(str)) {
            y++;
        } else if ("65133".equalsIgnoreCase(str)) {
            f57w++;
        } else if ("65502".equalsIgnoreCase(str)) {
            x++;
        } else if ("65503".equalsIgnoreCase(str)) {
            f56v++;
        }
        f3614e++;
    }

    public static synchronized void n(String str) {
        if (e(str)) {
            return;
        }
        f3615f++;
    }

    public static synchronized void s() {
        h++;
    }

    public static synchronized void t() {
        i++;
    }

    public static synchronized void u() {
        n++;
    }

    public static synchronized void v() {
        o++;
    }

    public static synchronized void w() {
        p++;
    }

    public static synchronized void x() {
        q++;
    }

    public static synchronized void y() {
        r++;
    }

    public static synchronized void z() {
        s++;
    }
}

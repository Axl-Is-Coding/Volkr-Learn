package com.tencent.tp;

import android.app.Activity;
import android.content.Context;
import com.tencent.tp.n;

/* JADX INFO: loaded from: classes5.dex */
public class g {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile g f19695d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public n.a f19696a = new h(this);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private n f19697b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f19698c;

    public static g a() {
        if (f19695d == null) {
            synchronized (g.class) {
                if (f19695d == null) {
                    f19695d = new g();
                }
            }
        }
        return f19695d;
    }

    private void a(Context context, String str, String str2, String str3, n.a aVar) {
        this.f19697b = new n(context, str, str2, str3, aVar);
        this.f19697b.a();
    }

    private void a(n nVar) {
        n nVar2;
        if (nVar != null && (nVar2 = this.f19697b) == nVar) {
            nVar2.c();
            this.f19697b = null;
        }
    }

    private void b(String str) {
        a(this.f19697b);
    }

    private void c(String str) {
        try {
            d(str);
        } catch (Throwable unused) {
        }
    }

    private void d(String str) {
        if (str.startsWith(q.a("hnbwjs:"))) {
            String[] strArrSplit = str.substring(7).split("\\|");
            if (strArrSplit == null || strArrSplit.length < 8) {
                r.a(q.a("*#07#:OnnNyfHznnvbzWjs.kvmnzViyNcjr xhy zmm"));
                return;
            }
            String str2 = strArrSplit[0];
            String str3 = strArrSplit[1];
            String str4 = strArrSplit[2];
            String str5 = strArrSplit[4];
            Activity activityJ = v.j();
            if (activityJ == null) {
                r.a(q.a("*#07#:bzoXpmmzioVxodqdot avdgzy"));
            } else {
                this.f19698c = str2;
                a(activityJ, str3, str4, str5, this.f19696a);
            }
        }
    }

    public void a(String str) {
        if (str.startsWith(q.a("hnbwjs:"))) {
            c(str);
        } else if (str.startsWith(q.a("cdyz_hnbwjs:"))) {
            b(str);
        }
    }
}

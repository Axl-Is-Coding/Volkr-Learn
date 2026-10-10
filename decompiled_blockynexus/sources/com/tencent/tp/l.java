package com.tencent.tp;

import android.content.Context;
import com.umeng.analytics.pro.ci;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class l implements d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile l f19700d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private d f19701a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f19702b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f19703c = false;

    private l() {
        Class<?> cls;
        try {
            cls = Class.forName("com.tencent.tp.SMI");
        } catch (Throwable unused) {
            this.f19701a = null;
        }
        if (cls == null) {
            throw new Exception("com.tencent.tp.SMI NOT found");
        }
        this.f19701a = (d) cls.newInstance();
        b();
        c();
    }

    public static l a() {
        if (f19700d == null) {
            synchronized (l.class) {
                if (f19700d == null) {
                    f19700d = new l();
                }
            }
        }
        return f19700d;
    }

    private String a(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        int length = str.length();
        char[] cArr = new char[length];
        for (int i = 0; i < length; i++) {
            cArr[i] = (char) (str.charAt(i) ^ '*');
        }
        return new String(cArr);
    }

    private void b() {
        String strD;
        String strA = a(new String(new byte[]{99, 89, 111, 68, 75, 72, 70, 79, 78, 117, 27, ci.n, 75, 70, 70, 69, 93, 117, 89, 79, 68, 89, 67, 94, 67, 92, 79}));
        if (strA == null || (strD = r.d(strA)) == null) {
            return;
        }
        this.f19702b = Integer.parseInt(strD) != 0;
    }

    private void c() {
        String strD = r.d("IsEnabled_1:is_mtp");
        if (strD != null) {
            this.f19703c = Integer.parseInt(strD) == 1;
        }
    }

    @Override // com.tencent.tp.d
    public String a(Context context) {
        d dVar = this.f19701a;
        return (dVar == null || !this.f19702b) ? "NotImp" : dVar.a(context);
    }

    @Override // com.tencent.tp.d
    public List b(Context context) {
        return (this.f19701a == null || !(this.f19702b || this.f19703c)) ? new ArrayList() : this.f19701a.b(context);
    }

    @Override // com.tencent.tp.d
    public List c(Context context) {
        d dVar = this.f19701a;
        return (dVar == null || !this.f19702b) ? new ArrayList() : dVar.c(context);
    }
}

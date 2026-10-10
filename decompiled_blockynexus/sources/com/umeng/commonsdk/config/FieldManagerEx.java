package com.umeng.commonsdk.config;

import android.content.Context;
import android.util.Pair;
import com.umeng.commonsdk.config.d;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
public class FieldManagerEx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f21039a = "cfgfd";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static b f21040b = b.a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f21041c = false;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final FieldManagerEx f21042a = new FieldManagerEx();

        private a() {
        }
    }

    public static FieldManagerEx a() {
        return a.f21042a;
    }

    public static boolean allow(String str) {
        b bVar = f21040b;
        return b.a(str);
    }

    public static synchronized boolean b() {
        return f21041c;
    }

    private FieldManagerEx() {
    }

    public synchronized void a(Context context) {
        String str;
        String[] strArr = {d.a.class.getName(), d.b.class.getName(), d.c.class.getName(), d.EnumC0181d.class.getName()};
        Pair<Long, String> pairA = a(UMEnvelopeBuild.imprintProperty(context, "cfgfd", "1001@536870911,536870911,262143,2047"));
        if (((Long) pairA.first).longValue() <= 1000 || (str = (String) pairA.second) == null || str.length() <= 0) {
            str = "1001@536870911,536870911,262143,2047";
        }
        String[] strArrSplit = str.split(",");
        int length = strArrSplit.length;
        if (length > 0) {
            ArrayList arrayList = new ArrayList();
            g gVar = new g();
            for (int i = 0; i < length; i++) {
                arrayList.add(gVar);
                ((e) arrayList.get(i)).a(strArrSplit[i], f21040b, d.b(strArr[i]));
            }
        }
        f21041c = true;
    }

    public synchronized void a(Context context, String str) {
        String str2;
        String str3 = "1001@536870911,536870911,262143,2047";
        String[] strArr = {d.a.class.getName(), d.b.class.getName(), d.c.class.getName(), d.EnumC0181d.class.getName()};
        if (str != null) {
            Pair<Long, String> pairA = a(str);
            if (((Long) pairA.first).longValue() > 1000 && (str2 = (String) pairA.second) != null && str2.length() > 0) {
                str3 = str2;
            }
        }
        String[] strArrSplit = str3.split(",");
        int length = strArrSplit.length;
        if (length > 0) {
            ArrayList arrayList = new ArrayList();
            g gVar = new g();
            for (int i = 0; i < length; i++) {
                arrayList.add(gVar);
                ((e) arrayList.get(i)).a(strArrSplit[i], f21040b, d.b(strArr[i]));
            }
        }
        f21041c = true;
    }

    private static Pair<Long, String> a(String str) {
        Pair<Long, String> pair = new Pair<>(-1L, null);
        if (str != null && str.length() >= 2) {
            String[] strArrSplit = str.split("@");
            if (strArrSplit.length < 2) {
                return pair;
            }
            try {
                long j = Long.parseLong(strArrSplit[0]);
                return new Pair<>(Long.valueOf(j), strArrSplit[1]);
            } catch (Throwable unused) {
            }
        }
        return pair;
    }
}

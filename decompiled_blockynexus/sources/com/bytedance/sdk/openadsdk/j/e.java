package com.bytedance.sdk.openadsdk.j;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.ab;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/* JADX INFO: compiled from: TrackAdUrlUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class e {
    private static int a(int i) {
        int i2 = 2;
        if (i != 2) {
            i2 = 3;
            if (i != 3) {
                i2 = 4;
                if (i != 4) {
                    i2 = 5;
                    if (i != 5 && i != 15) {
                        return -1;
                    }
                }
            }
        }
        return i2;
    }

    public static List<String> a(List<String> list, boolean z) {
        String strA = j.a(o.a());
        if (list == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (next.contains("{TS}") || next.contains("__TS__")) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                next = next.replace("{TS}", String.valueOf(jCurrentTimeMillis)).replace("__TS__", String.valueOf(jCurrentTimeMillis));
            }
            if ((next.contains("{UID}") || next.contains("__UID__")) && !TextUtils.isEmpty(strA)) {
                next = next.replace("{UID}", strA).replace("__UID__", strA);
            }
            if (z) {
                next = a(next);
            }
            arrayList.add(next);
        }
        return arrayList;
    }

    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return str.replace("[ss_random]", String.valueOf(new Random().nextLong())).replace("[ss_timestamp]", String.valueOf(System.currentTimeMillis()));
        } catch (Exception e2) {
            e2.printStackTrace();
            return str;
        }
    }

    public static List<String> a(List<String> list, boolean z, com.bytedance.sdk.openadsdk.core.d.h hVar) {
        String strA = j.a(o.a());
        if (list == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (next.contains("{TS}") || next.contains("__TS__")) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                next = next.replace("{TS}", String.valueOf(jCurrentTimeMillis)).replace("__TS__", String.valueOf(jCurrentTimeMillis));
            }
            if ((next.contains("{UID}") || next.contains("__UID__")) && !TextUtils.isEmpty(strA)) {
                next = next.replace("{UID}", strA).replace("__UID__", strA);
            }
            if (next.contains("__CID__") && hVar != null && !TextUtils.isEmpty(hVar.J())) {
                next = next.replace("__CID__", hVar.J());
            }
            if (next.contains("__CTYPE__") && hVar != null) {
                next = next.replace("__CTYPE__", String.valueOf(a(hVar.N())));
            }
            if (next.contains("__GAID__")) {
                next = next.replace("__GAID__", b.a.a.a.a.b.b.a().b());
            }
            if (next.contains("__ANDROIDID1__")) {
                next = next.replace("__ANDROIDID1__", j.c(o.a()));
            }
            if (next.contains("__OS__")) {
                next = next.replace("__OS__", "0");
            }
            if (next.contains("__IP__")) {
                next = next.replace("__IP__", com.bytedance.sdk.openadsdk.utils.g.a(true));
            }
            if (next.contains("__UA1__")) {
                next = next.replace("__UA1__", URLEncoder.encode(ab.c()));
            }
            if (z) {
                next = a(next);
            }
            arrayList.add(next);
        }
        return arrayList;
    }
}

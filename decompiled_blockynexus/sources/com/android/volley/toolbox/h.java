package com.android.volley.toolbox;

import com.alibaba.sdk.android.feedback.xblink.webview.HybridPlusWebView;
import com.android.volley.a;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeMap;

/* JADX INFO: compiled from: HttpHeaderParser.java */
/* JADX INFO: loaded from: classes.dex */
public class h {
    public static a.C0049a a(com.android.volley.j jVar) {
        long j;
        long j2;
        boolean z;
        long j3;
        long j4;
        long jCurrentTimeMillis = System.currentTimeMillis();
        Map<String, String> map = jVar.f4011c;
        String str = map.get("Date");
        long jA = str != null ? a(str) : 0L;
        String str2 = map.get("Cache-Control");
        int i = 0;
        if (str2 != null) {
            String[] strArrSplit = str2.split(",", 0);
            j = 0;
            int i2 = 0;
            j2 = 0;
            while (i < strArrSplit.length) {
                String strTrim = strArrSplit[i].trim();
                if (strTrim.equals("no-cache") || strTrim.equals("no-store")) {
                    return null;
                }
                if (strTrim.startsWith("max-age=")) {
                    try {
                        j = Long.parseLong(strTrim.substring(8));
                    } catch (Exception unused) {
                    }
                } else if (strTrim.startsWith("stale-while-revalidate=")) {
                    j2 = Long.parseLong(strTrim.substring(23));
                } else if (strTrim.equals("must-revalidate") || strTrim.equals("proxy-revalidate")) {
                    i2 = 1;
                }
                i++;
            }
            i = i2;
            z = true;
        } else {
            j = 0;
            j2 = 0;
            z = false;
        }
        String str3 = map.get("Expires");
        long jA2 = str3 != null ? a(str3) : 0L;
        String str4 = map.get("Last-Modified");
        long jA3 = str4 != null ? a(str4) : 0L;
        String str5 = map.get("ETag");
        if (z) {
            j3 = jCurrentTimeMillis + (j * 1000);
            if (i != 0) {
                j4 = j3;
            } else {
                Long.signum(j2);
                j4 = (j2 * 1000) + j3;
            }
        } else if (jA <= 0 || jA2 < jA) {
            j3 = 0;
            j4 = j3;
        } else {
            j4 = (jA2 - jA) + jCurrentTimeMillis;
            j3 = j4;
        }
        a.C0049a c0049a = new a.C0049a();
        c0049a.f3976a = jVar.f4010b;
        c0049a.f3977b = str5;
        c0049a.f3981f = j3;
        c0049a.f3980e = j4;
        c0049a.f3978c = jA;
        c0049a.f3979d = jA3;
        c0049a.g = map;
        c0049a.h = jVar.f4012d;
        return c0049a;
    }

    static List<com.android.volley.g> b(Map<String, String> map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            arrayList.add(new com.android.volley.g(entry.getKey(), entry.getValue()));
        }
        return arrayList;
    }

    public static long a(String str) {
        try {
            return a().parse(str).getTime();
        } catch (ParseException e2) {
            com.android.volley.p.a(e2, "Unable to parse dateStr: %s, falling back to 0", str);
            return 0L;
        }
    }

    static String a(long j) {
        return a().format(new Date(j));
    }

    private static SimpleDateFormat a() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat;
    }

    public static String a(Map<String, String> map, String str) {
        String str2 = map.get("Content-Type");
        if (str2 != null) {
            String[] strArrSplit = str2.split(";", 0);
            for (int i = 1; i < strArrSplit.length; i++) {
                String[] strArrSplit2 = strArrSplit[i].trim().split("=", 0);
                if (strArrSplit2.length == 2 && strArrSplit2[0].equals(HybridPlusWebView.CHARSET)) {
                    return strArrSplit2[1];
                }
            }
        }
        return str;
    }

    public static String a(Map<String, String> map) {
        return a(map, "ISO-8859-1");
    }

    static Map<String, String> a(List<com.android.volley.g> list) {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (com.android.volley.g gVar : list) {
            treeMap.put(gVar.a(), gVar.b());
        }
        return treeMap;
    }
}

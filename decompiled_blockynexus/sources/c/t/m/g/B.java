package c.t.m.g;

import c.t.m.g.qc;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class B extends AbstractC0462s {
    private static B s = new B();

    private B() {
    }

    public static String a(String str, boolean z, Map<String, String> map) {
        String strD = qc.d();
        map.put("A23", fc.j);
        C0414bb c0414bb = new C0414bb();
        c0414bb.a(String.valueOf(str));
        c0414bb.f3095a = System.currentTimeMillis();
        c0414bb.f3096b = A.f2864a;
        c0414bb.f3097c = strD;
        map.put("A1", fc.i);
        map.put("A2", C0455pa.a());
        map.put("A4", C0455pa.b());
        map.put("A6", C0455pa.c());
        map.put("A7", C0455pa.e());
        map.put("A23", fc.j);
        map.put("A33", qc.f());
        map.put("A10", A.f2867d);
        map.put("A9", A.f2866c);
        map.put("A19", strD);
        c0414bb.a(map);
        StringBuilder sb = new StringBuilder();
        sb.append(C0455pa.a(System.currentTimeMillis(), "yyyy-MM-dd HH:mm:ss.SSS") + "|");
        sb.append("INFO|");
        sb.append(qc.a.f3362a + "|");
        sb.append(A.f2865b + "|");
        sb.append("beacon|");
        sb.append("1.8.1|");
        String strEncode = c0414bb.f3096b;
        try {
            strEncode = URLEncoder.encode(strEncode, "utf-8");
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
        sb.append(strEncode + "|");
        sb.append("|");
        sb.append("upload_ip|");
        sb.append("|");
        sb.append(c0414bb.f3097c + "|");
        sb.append(c0414bb.a() + "|");
        sb.append(z + "|");
        sb.append("0|");
        sb.append("0|");
        sb.append(a(c0414bb.b()) + "|");
        sb.append(C0455pa.a(c0414bb.f3095a, "yyyy-MM-dd HH:mm:ss") + "|");
        sb.append("upload_time");
        return sb.toString();
    }

    private static String a(Map<String, String> map) {
        Set<String> setKeySet;
        if (map == null || (setKeySet = map.keySet()) == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (String str : setKeySet) {
            sb.append("&");
            sb.append(str);
            sb.append("=");
            sb.append(map.get(str));
        }
        String strSubstring = sb.substring(1);
        sb.setLength(0);
        return strSubstring;
    }

    public static B e() {
        return s;
    }

    @Override // c.t.m.g.AbstractC0462s
    public final int a() {
        return qc.a.a("report_insert_new_record_num_limit", 5, 100, 100);
    }

    @Override // c.t.m.g.AbstractC0462s
    public final String b() {
        return "beacon";
    }
}

package c.t.m.g;

import java.util.Map;

/* JADX INFO: renamed from: c.t.m.g.na, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0449na {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f3311a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f3312b = true;

    public static void a(String str, int i, int i2, String str2, Map<String, String> map, Map<String, String> map2, boolean z) {
        jc.a(str, i, i2, str2, map, map2, z);
    }

    public static boolean a(String str, int i, Map<String, String> map) {
        if (i == fc.c()) {
            if (f3311a && ("HLReqRspEvent".equals(str) || "HLHttpAgent".equals(str))) {
                f3311a = false;
                return true;
            }
            if (f3312b && "HLHttpDirect".equals(str)) {
                String str2 = map.get("B15");
                if (!C0455pa.a(str2) && str2.equals("app")) {
                    f3312b = false;
                    return true;
                }
            }
        }
        return false;
    }

    public static void b(String str, int i, int i2, String str2, Map<String, String> map, Map<String, String> map2, boolean z) {
        jc.b(str, i, i2, str2, map, map2, z);
    }
}

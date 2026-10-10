package c.t.m.g;

import android.os.Handler;
import c.t.m.g.qc;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class jc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Handler f3264a = fc.j();

    /* JADX WARN: Removed duplicated region for block: B:146:0x01a9 A[Catch: Throwable -> 0x0332, TryCatch #0 {Throwable -> 0x0332, blocks: (B:4:0x0018, B:15:0x0038, B:156:0x01c9, B:158:0x01cf, B:159:0x01e2, B:161:0x01e8, B:162:0x01fb, B:164:0x0201, B:165:0x020e, B:167:0x0214, B:168:0x0221, B:170:0x0227, B:172:0x0236, B:174:0x023d, B:176:0x029f, B:177:0x02a4, B:179:0x02c3, B:180:0x02c8, B:183:0x02d4, B:184:0x02d7, B:186:0x02ef, B:188:0x02f5, B:189:0x02fa, B:193:0x032f, B:22:0x0051, B:153:0x01c1, B:23:0x0057, B:26:0x005f, B:29:0x0070, B:146:0x01a9, B:151:0x01b8, B:59:0x00b3, B:67:0x00c6, B:70:0x00d4, B:72:0x00dc, B:74:0x00e4, B:77:0x00ec, B:81:0x00fb, B:85:0x0109, B:88:0x0114, B:97:0x012c, B:103:0x013d, B:105:0x0145, B:107:0x014d, B:116:0x0165, B:118:0x016b, B:7:0x0021, B:10:0x002c), top: B:196:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:198:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ void a(java.lang.String r19, int r20, int r21, java.lang.String r22, java.util.Map r23, java.util.Map r24, boolean r25, int r26) {
        /*
            Method dump skipped, instruction units count: 819
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.t.m.g.jc.a(java.lang.String, int, int, java.lang.String, java.util.Map, java.util.Map, boolean, int):void");
    }

    public static boolean a(String str, int i, int i2, String str2, Map<String, String> map, Map<String, String> map2, boolean z) {
        boolean zA = qc.a.a(1);
        if (zA) {
            f3264a.post(new kc(str, i, i2, str2, map, map2, z));
        }
        return zA;
    }

    public static void b(String str, int i, int i2, String str2, Map<String, String> map, Map<String, String> map2, boolean z) {
        f3264a.post(new lc(str, i, i2, str2, map, map2, z));
    }
}

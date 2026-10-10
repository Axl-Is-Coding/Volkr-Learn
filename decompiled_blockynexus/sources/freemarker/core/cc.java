package freemarker.core;

import com.alibaba.android.arouter.utils.Consts;

/* JADX INFO: compiled from: _CoreStringUtils.java */
/* JADX INFO: loaded from: classes5.dex */
public final class cc {
    public static String a(String str) {
        return d(str);
    }

    public static String b(String str) {
        return d(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String c(java.lang.String r6) {
        /*
            r0 = 0
            r1 = 0
        L2:
            int r2 = r6.length()
            r3 = 34
            r4 = 92
            if (r0 >= r2) goto L3c
            char r2 = r6.charAt(r0)
            if (r0 != 0) goto L19
            boolean r5 = freemarker.template.utility.h.b(r2)
            if (r5 == 0) goto L1f
            goto L39
        L19:
            boolean r5 = freemarker.template.utility.h.a(r2)
            if (r5 != 0) goto L39
        L1f:
            r5 = 64
            if (r2 == r5) goto L39
            if (r1 == 0) goto L27
            if (r1 != r4) goto L34
        L27:
            r1 = 45
            if (r2 == r1) goto L37
            r1 = 46
            if (r2 == r1) goto L37
            r1 = 58
            if (r2 != r1) goto L34
            goto L37
        L34:
            r1 = 34
            goto L3c
        L37:
            r1 = 92
        L39:
            int r0 = r0 + 1
            goto L2
        L3c:
            if (r1 == 0) goto L51
            if (r1 == r3) goto L4d
            if (r1 != r4) goto L47
            java.lang.String r6 = d(r6)
            return r6
        L47:
            freemarker.core.BugException r6 = new freemarker.core.BugException
            r6.<init>()
            throw r6
        L4d:
            java.lang.String r6 = freemarker.template.utility.h.c(r6)
        L51:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: freemarker.core.cc.c(java.lang.String):java.lang.String");
    }

    private static String d(String str) {
        return freemarker.template.utility.h.a(freemarker.template.utility.h.a(freemarker.template.utility.h.a(str, "-", "\\-"), Consts.DOT, "\\."), ":", "\\:");
    }
}

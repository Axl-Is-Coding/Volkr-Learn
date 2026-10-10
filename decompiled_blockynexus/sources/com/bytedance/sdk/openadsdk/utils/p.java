package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import android.text.TextUtils;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: MimeDetector.java */
/* JADX INFO: loaded from: classes.dex */
public class p {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile p f7122c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, String> f7123a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f7124b = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Context f7125d;

    private p(Context context) {
        if (context != null && this.f7125d == null) {
            this.f7125d = context.getApplicationContext();
            a();
        }
        this.f7125d = context;
    }

    private static String b(String str) {
        int iIndexOf = str.indexOf(47);
        int iIndexOf2 = str.indexOf(59);
        if (iIndexOf < 0) {
            return null;
        }
        String lowerCase = str.substring(0, iIndexOf).trim().toLowerCase(Locale.ENGLISH);
        if (!c(lowerCase)) {
            return null;
        }
        String lowerCase2 = (iIndexOf2 < 0 ? str.substring(iIndexOf + 1) : str.substring(iIndexOf + 1, iIndexOf2)).trim().toLowerCase(Locale.ENGLISH);
        if (!c(lowerCase2)) {
            return null;
        }
        StringBuilder sb = new StringBuilder(lowerCase.length() + lowerCase2.length() + 1);
        sb.append(lowerCase);
        sb.append('/');
        sb.append(lowerCase2);
        return sb.toString();
    }

    private static boolean c(String str) {
        int length = str.length();
        if (length == 0) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (!a(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private String d(String str) {
        String str2;
        String strE = e(str);
        if (strE.isEmpty()) {
            return null;
        }
        a();
        Map<String, String> map = this.f7123a;
        if (map == null || map.isEmpty()) {
            return null;
        }
        do {
            str2 = this.f7123a.get(strE);
            if (str2 == null) {
                strE = e(strE);
            }
            if (str2 != null) {
                break;
            }
        } while (!strE.isEmpty());
        return str2;
    }

    private static String e(String str) {
        int iIndexOf;
        return (str == null || str.isEmpty() || (iIndexOf = str.indexOf(46)) < 0 || iIndexOf >= str.length() + (-1)) ? "" : str.substring(iIndexOf + 1);
    }

    private void f(String str) {
        String strTrim = str.trim();
        if (strTrim.isEmpty()) {
            return;
        }
        if (strTrim.charAt(0) == '#') {
            return;
        }
        String strReplaceAll = strTrim.replaceAll("\\s*#.*", "");
        if (strReplaceAll.indexOf(61) <= 0) {
            String[] strArrSplit = strReplaceAll.split("\\s+");
            for (int i = 1; i < strArrSplit.length; i++) {
                a(strArrSplit[i], strArrSplit[0]);
            }
            return;
        }
        Matcher matcher = Pattern.compile("\\btype=(\"\\p{Graph}+?/\\p{Graph}+?\"|\\p{Graph}+/\\p{Graph}+\\b)").matcher(strReplaceAll);
        if (matcher.find()) {
            String strSubstring = matcher.group().substring(5);
            if (strSubstring.charAt(0) == '\"') {
                strSubstring = strSubstring.substring(1, strSubstring.length() - 1);
            }
            Matcher matcher2 = Pattern.compile("\\bexts=(\"[\\p{Graph}|\\p{Blank}]+?\"|\\p{Graph}+\\b)").matcher(strReplaceAll);
            if (matcher2.find()) {
                String strSubstring2 = matcher2.group().substring(5);
                if (strSubstring2.charAt(0) == '\"') {
                    strSubstring2 = strSubstring2.substring(1, strSubstring2.length() - 1);
                }
                for (String str2 : strSubstring2.split("[\\p{Blank}|\\p{Punct}]+")) {
                    a(str2, strSubstring);
                }
            }
        }
    }

    public static String a(Context context, String str) {
        if (str != null) {
            try {
                if (str.startsWith("http") && str.contains("?")) {
                    str = str.split("\\?")[0];
                    if (str.endsWith("/")) {
                        str = str.substring(0, str.length() - 1);
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return a(context).a(str);
    }

    static p a(Context context) {
        if (f7122c == null) {
            synchronized (p.class) {
                if (f7122c == null) {
                    f7122c = new p(context);
                }
            }
        }
        return f7122c;
    }

    public final String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String strD = d(str);
        if (TextUtils.isEmpty(strD)) {
            return null;
        }
        return b(strD);
    }

    private static boolean a(char c2) {
        return c2 > ' ' && c2 < 127 && "()<>@,;:/[]?=\\\"".indexOf(c2) < 0;
    }

    private void a() {
        if (this.f7125d == null || this.f7124b) {
            return;
        }
        synchronized (this) {
            if (!this.f7124b) {
                List list = (List) AccessController.doPrivileged(new PrivilegedAction<List<String>>() { // from class: com.bytedance.sdk.openadsdk.utils.p.1
                    /* JADX WARN: Removed duplicated region for block: B:48:0x005b A[EXC_TOP_SPLITTER, SYNTHETIC] */
                    /* JADX WARN: Removed duplicated region for block: B:54:0x0062 A[EXC_TOP_SPLITTER, SYNTHETIC] */
                    @Override // java.security.PrivilegedAction
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public java.util.List<java.lang.String> run() throws java.lang.Throwable {
                        /*
                            r5 = this;
                            r0 = 0
                            java.util.ArrayList r1 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L43 java.lang.Throwable -> L46
                            r1.<init>()     // Catch: java.lang.Throwable -> L43 java.lang.Throwable -> L46
                            com.bytedance.sdk.openadsdk.utils.p r2 = com.bytedance.sdk.openadsdk.utils.p.this     // Catch: java.lang.Throwable -> L43 java.lang.Throwable -> L46
                            android.content.Context r2 = com.bytedance.sdk.openadsdk.utils.p.a(r2)     // Catch: java.lang.Throwable -> L43 java.lang.Throwable -> L46
                            android.content.res.AssetManager r2 = r2.getAssets()     // Catch: java.lang.Throwable -> L43 java.lang.Throwable -> L46
                            java.lang.String r3 = "tt_mime_type.pro"
                            java.io.InputStream r2 = r2.open(r3)     // Catch: java.lang.Throwable -> L43 java.lang.Throwable -> L46
                            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L3c java.lang.Throwable -> L40
                            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L3c java.lang.Throwable -> L40
                            r4.<init>(r2)     // Catch: java.lang.Throwable -> L3c java.lang.Throwable -> L40
                            r3.<init>(r4)     // Catch: java.lang.Throwable -> L3c java.lang.Throwable -> L40
                        L20:
                            java.lang.String r0 = r3.readLine()     // Catch: java.lang.Throwable -> L39 java.lang.Throwable -> L41
                            if (r0 == 0) goto L30
                            boolean r4 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L39 java.lang.Throwable -> L41
                            if (r4 != 0) goto L20
                            r1.add(r0)     // Catch: java.lang.Throwable -> L39 java.lang.Throwable -> L41
                            goto L20
                        L30:
                            if (r2 == 0) goto L35
                            r2.close()     // Catch: java.lang.Throwable -> L35
                        L35:
                            r3.close()     // Catch: java.lang.Throwable -> L38
                        L38:
                            return r1
                        L39:
                            r0 = move-exception
                            r1 = r0
                            goto L3e
                        L3c:
                            r1 = move-exception
                            r3 = r0
                        L3e:
                            r0 = r2
                            goto L59
                        L40:
                            r3 = r0
                        L41:
                            r0 = r2
                            goto L47
                        L43:
                            r1 = move-exception
                            r3 = r0
                            goto L59
                        L46:
                            r3 = r0
                        L47:
                            java.util.List r1 = java.util.Collections.emptyList()     // Catch: java.lang.Throwable -> L58
                            if (r0 == 0) goto L52
                            r0.close()     // Catch: java.lang.Throwable -> L51
                            goto L52
                        L51:
                        L52:
                            if (r3 == 0) goto L57
                            r3.close()     // Catch: java.lang.Throwable -> L57
                        L57:
                            return r1
                        L58:
                            r1 = move-exception
                        L59:
                            if (r0 == 0) goto L60
                            r0.close()     // Catch: java.lang.Throwable -> L5f
                            goto L60
                        L5f:
                        L60:
                            if (r3 == 0) goto L65
                            r3.close()     // Catch: java.lang.Throwable -> L65
                        L65:
                            goto L67
                        L66:
                            throw r1
                        L67:
                            goto L66
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.utils.p.AnonymousClass1.run():java.util.List");
                    }
                });
                this.f7123a = new HashMap(list.size());
                String strSubstring = "";
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    String str = strSubstring + ((String) it.next());
                    if (str.endsWith("\\")) {
                        strSubstring = str.substring(0, str.length() - 1);
                    } else {
                        f(str);
                        strSubstring = "";
                    }
                }
                if (!strSubstring.isEmpty()) {
                    f(strSubstring);
                }
                this.f7124b = true;
            }
        }
    }

    private void a(String str, String str2) {
        if (str == null || str.isEmpty() || str2 == null || str2.isEmpty() || this.f7123a.containsKey(str)) {
            return;
        }
        this.f7123a.put(str, str2);
    }
}

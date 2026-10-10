package com.bytedance.sdk.a.b;

import com.alibaba.android.arouter.utils.Consts;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: HttpUrl.java */
/* JADX INFO: loaded from: classes.dex */
public final class s {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final char[] f5289d = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final String f5290a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final String f5291b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int f5292c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f5293e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f5294f;
    private final List<String> g;
    private final List<String> h;
    private final String i;
    private final String j;

    /* JADX INFO: compiled from: HttpUrl.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f5295a;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        String f5298d;
        List<String> g;
        String h;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f5296b = "";

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        String f5297c = "";

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f5299e = -1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final List<String> f5300f = new ArrayList();

        /* JADX INFO: renamed from: com.bytedance.sdk.a.b.s$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: HttpUrl.java */
        enum EnumC0068a {
            SUCCESS,
            MISSING_SCHEME,
            UNSUPPORTED_SCHEME,
            INVALID_PORT,
            INVALID_HOST
        }

        public a() {
            this.f5300f.add("");
        }

        private boolean f(String str) {
            return str.equals(Consts.DOT) || str.equalsIgnoreCase("%2e");
        }

        private boolean g(String str) {
            return str.equals("..") || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e");
        }

        public a a(String str) {
            if (str == null) {
                throw new NullPointerException("scheme == null");
            }
            if (str.equalsIgnoreCase("http")) {
                this.f5295a = "http";
            } else {
                if (!str.equalsIgnoreCase("https")) {
                    throw new IllegalArgumentException("unexpected scheme: " + str);
                }
                this.f5295a = "https";
            }
            return this;
        }

        public a b(String str) {
            if (str == null) {
                throw new NullPointerException("username == null");
            }
            this.f5296b = s.a(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }

        public a c(String str) {
            if (str == null) {
                throw new NullPointerException("password == null");
            }
            this.f5297c = s.a(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }

        public a d(String str) {
            if (str == null) {
                throw new NullPointerException("host == null");
            }
            String strE = e(str, 0, str.length());
            if (strE != null) {
                this.f5298d = strE;
                return this;
            }
            throw new IllegalArgumentException("unexpected host: " + str);
        }

        public a e(String str) {
            this.g = str != null ? s.b(s.a(str, " \"'<>#", true, false, true, true)) : null;
            return this;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f5295a);
            sb.append(com.tendcloud.tenddata.aa.f19741a);
            if (!this.f5296b.isEmpty() || !this.f5297c.isEmpty()) {
                sb.append(this.f5296b);
                if (!this.f5297c.isEmpty()) {
                    sb.append(':');
                    sb.append(this.f5297c);
                }
                sb.append('@');
            }
            if (this.f5298d.indexOf(58) != -1) {
                sb.append('[');
                sb.append(this.f5298d);
                sb.append(']');
            } else {
                sb.append(this.f5298d);
            }
            int iA = a();
            if (iA != s.a(this.f5295a)) {
                sb.append(':');
                sb.append(iA);
            }
            s.a(sb, this.f5300f);
            if (this.g != null) {
                sb.append('?');
                s.b(sb, this.g);
            }
            if (this.h != null) {
                sb.append('#');
                sb.append(this.h);
            }
            return sb.toString();
        }

        private static int f(String str, int i, int i2) {
            int i3;
            try {
                i3 = Integer.parseInt(s.a(str, i, i2, "", false, false, false, true, null));
            } catch (NumberFormatException unused) {
            }
            if (i3 <= 0 || i3 > 65535) {
                return -1;
            }
            return i3;
        }

        private static String e(String str, int i, int i2) {
            return com.bytedance.sdk.a.b.a.c.a(s.a(str, i, i2, false));
        }

        a b() {
            int size = this.f5300f.size();
            for (int i = 0; i < size; i++) {
                this.f5300f.set(i, s.a(this.f5300f.get(i), "[]", true, true, false, true));
            }
            List<String> list = this.g;
            if (list != null) {
                int size2 = list.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = this.g.get(i2);
                    if (str != null) {
                        this.g.set(i2, s.a(str, "\\^`{|}", true, true, true, true));
                    }
                }
            }
            String str2 = this.h;
            if (str2 != null) {
                this.h = s.a(str2, " \"#<>\\^`{|}", true, true, false, false);
            }
            return this;
        }

        public s c() {
            if (this.f5295a != null) {
                if (this.f5298d != null) {
                    return new s(this);
                }
                throw new IllegalStateException("host == null");
            }
            throw new IllegalStateException("scheme == null");
        }

        private void d() {
            if (this.f5300f.remove(r0.size() - 1).isEmpty() && !this.f5300f.isEmpty()) {
                this.f5300f.set(r0.size() - 1, "");
            } else {
                this.f5300f.add("");
            }
        }

        public a a(int i) {
            if (i > 0 && i <= 65535) {
                this.f5299e = i;
                return this;
            }
            throw new IllegalArgumentException("unexpected port: " + i);
        }

        private static int c(String str, int i, int i2) {
            int i3 = 0;
            while (i < i2) {
                char cCharAt = str.charAt(i);
                if (cCharAt != '\\' && cCharAt != '/') {
                    break;
                }
                i3++;
                i++;
            }
            return i3;
        }

        private static int d(String str, int i, int i2) {
            while (i < i2) {
                char cCharAt = str.charAt(i);
                if (cCharAt == ':') {
                    return i;
                }
                if (cCharAt == '[') {
                    do {
                        i++;
                        if (i < i2) {
                        }
                    } while (str.charAt(i) != ']');
                }
                i++;
            }
            return i2;
        }

        int a() {
            int i = this.f5299e;
            return i != -1 ? i : s.a(this.f5295a);
        }

        EnumC0068a a(s sVar, String str) {
            int iA;
            int i;
            int i2;
            int iA2 = com.bytedance.sdk.a.b.a.c.a(str, 0, str.length());
            int iB = com.bytedance.sdk.a.b.a.c.b(str, iA2, str.length());
            if (b(str, iA2, iB) != -1) {
                if (str.regionMatches(true, iA2, "https:", 0, 6)) {
                    this.f5295a = "https";
                    iA2 += 6;
                } else if (str.regionMatches(true, iA2, "http:", 0, 5)) {
                    this.f5295a = "http";
                    iA2 += 5;
                } else {
                    return EnumC0068a.UNSUPPORTED_SCHEME;
                }
            } else if (sVar != null) {
                this.f5295a = sVar.f5290a;
            } else {
                return EnumC0068a.MISSING_SCHEME;
            }
            int iC = c(str, iA2, iB);
            char c2 = '?';
            char c3 = '#';
            if (iC < 2 && sVar != null && sVar.f5290a.equals(this.f5295a)) {
                this.f5296b = sVar.d();
                this.f5297c = sVar.e();
                this.f5298d = sVar.f5291b;
                this.f5299e = sVar.f5292c;
                this.f5300f.clear();
                this.f5300f.addAll(sVar.i());
                if (iA2 == iB || str.charAt(iA2) == '#') {
                    e(sVar.j());
                }
                i = iA2;
            } else {
                int i3 = iA2 + iC;
                boolean z = false;
                boolean z2 = false;
                while (true) {
                    iA = com.bytedance.sdk.a.b.a.c.a(str, i3, iB, "@/\\?#");
                    byte bCharAt = iA != iB ? str.charAt(iA) : (byte) -1;
                    if (bCharAt == -1 || bCharAt == c3 || bCharAt == 47 || bCharAt == 92 || bCharAt == c2) {
                        break;
                    }
                    if (bCharAt == 64) {
                        if (!z) {
                            int iA3 = com.bytedance.sdk.a.b.a.c.a(str, i3, iA, ':');
                            i2 = iA;
                            String strA = s.a(str, i3, iA3, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                            if (z2) {
                                strA = this.f5296b + "%40" + strA;
                            }
                            this.f5296b = strA;
                            if (iA3 != i2) {
                                this.f5297c = s.a(str, iA3 + 1, i2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                z = true;
                            }
                            z2 = true;
                        } else {
                            i2 = iA;
                            this.f5297c += "%40" + s.a(str, i3, i2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                        }
                        i3 = i2 + 1;
                    }
                    c2 = '?';
                    c3 = '#';
                }
                i = iA;
                int iD = d(str, i3, i);
                int i4 = iD + 1;
                if (i4 < i) {
                    this.f5298d = e(str, i3, iD);
                    this.f5299e = f(str, i4, i);
                    if (this.f5299e == -1) {
                        return EnumC0068a.INVALID_PORT;
                    }
                } else {
                    this.f5298d = e(str, i3, iD);
                    this.f5299e = s.a(this.f5295a);
                }
                if (this.f5298d == null) {
                    return EnumC0068a.INVALID_HOST;
                }
            }
            int iA4 = com.bytedance.sdk.a.b.a.c.a(str, i, iB, "?#");
            a(str, i, iA4);
            if (iA4 < iB && str.charAt(iA4) == '?') {
                int iA5 = com.bytedance.sdk.a.b.a.c.a(str, iA4, iB, '#');
                this.g = s.b(s.a(str, iA4 + 1, iA5, " \"'<>#", true, false, true, true, null));
                iA4 = iA5;
            }
            if (iA4 < iB && str.charAt(iA4) == '#') {
                this.h = s.a(str, 1 + iA4, iB, "", true, false, false, false, null);
            }
            return EnumC0068a.SUCCESS;
        }

        private static int b(String str, int i, int i2) {
            if (i2 - i < 2) {
                return -1;
            }
            char cCharAt = str.charAt(i);
            if ((cCharAt >= 'a' && cCharAt <= 'z') || (cCharAt >= 'A' && cCharAt <= 'Z')) {
                while (true) {
                    i++;
                    if (i >= i2) {
                        break;
                    }
                    char cCharAt2 = str.charAt(i);
                    if (cCharAt2 < 'a' || cCharAt2 > 'z') {
                        if (cCharAt2 < 'A' || cCharAt2 > 'Z') {
                            if (cCharAt2 < '0' || cCharAt2 > '9') {
                                if (cCharAt2 != '+' && cCharAt2 != '-' && cCharAt2 != '.') {
                                    if (cCharAt2 == ':') {
                                        return i;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return -1;
        }

        private void a(String str, int i, int i2) {
            if (i == i2) {
                return;
            }
            char cCharAt = str.charAt(i);
            if (cCharAt != '/' && cCharAt != '\\') {
                List<String> list = this.f5300f;
                list.set(list.size() - 1, "");
            } else {
                this.f5300f.clear();
                this.f5300f.add("");
                i++;
            }
            while (true) {
                int i3 = i;
                if (i3 >= i2) {
                    return;
                }
                i = com.bytedance.sdk.a.b.a.c.a(str, i3, i2, "/\\");
                boolean z = i < i2;
                a(str, i3, i, z, true);
                if (z) {
                    i++;
                }
            }
        }

        private void a(String str, int i, int i2, boolean z, boolean z2) {
            String strA = s.a(str, i, i2, " \"<>^`{}|/\\?#", z2, false, false, true, null);
            if (f(strA)) {
                return;
            }
            if (g(strA)) {
                d();
                return;
            }
            if (this.f5300f.get(r11.size() - 1).isEmpty()) {
                this.f5300f.set(r11.size() - 1, strA);
            } else {
                this.f5300f.add(strA);
            }
            if (z) {
                this.f5300f.add("");
            }
        }
    }

    s(a aVar) {
        this.f5290a = aVar.f5295a;
        this.f5293e = a(aVar.f5296b, false);
        this.f5294f = a(aVar.f5297c, false);
        this.f5291b = aVar.f5298d;
        this.f5292c = aVar.a();
        this.g = a(aVar.f5300f, false);
        List<String> list = aVar.g;
        this.h = list != null ? a(list, true) : null;
        String str = aVar.h;
        this.i = str != null ? a(str, false) : null;
        this.j = aVar.toString();
    }

    public URI a() {
        String string = n().b().toString();
        try {
            return new URI(string);
        } catch (URISyntaxException e2) {
            try {
                return URI.create(string.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
            } catch (Exception unused) {
                throw new RuntimeException(e2);
            }
        }
    }

    public String b() {
        return this.f5290a;
    }

    public boolean c() {
        return this.f5290a.equals("https");
    }

    public String d() {
        if (this.f5293e.isEmpty()) {
            return "";
        }
        int length = this.f5290a.length() + 3;
        String str = this.j;
        return this.j.substring(length, com.bytedance.sdk.a.b.a.c.a(str, length, str.length(), ":@"));
    }

    public String e() {
        if (this.f5294f.isEmpty()) {
            return "";
        }
        return this.j.substring(this.j.indexOf(58, this.f5290a.length() + 3) + 1, this.j.indexOf(64));
    }

    public boolean equals(Object obj) {
        return (obj instanceof s) && ((s) obj).j.equals(this.j);
    }

    public String f() {
        return this.f5291b;
    }

    public int g() {
        return this.f5292c;
    }

    public String h() {
        int iIndexOf = this.j.indexOf(47, this.f5290a.length() + 3);
        String str = this.j;
        return this.j.substring(iIndexOf, com.bytedance.sdk.a.b.a.c.a(str, iIndexOf, str.length(), "?#"));
    }

    public int hashCode() {
        return this.j.hashCode();
    }

    public List<String> i() {
        int iIndexOf = this.j.indexOf(47, this.f5290a.length() + 3);
        String str = this.j;
        int iA = com.bytedance.sdk.a.b.a.c.a(str, iIndexOf, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (iIndexOf < iA) {
            int i = iIndexOf + 1;
            int iA2 = com.bytedance.sdk.a.b.a.c.a(this.j, i, iA, '/');
            arrayList.add(this.j.substring(i, iA2));
            iIndexOf = iA2;
        }
        return arrayList;
    }

    public String j() {
        if (this.h == null) {
            return null;
        }
        int iIndexOf = this.j.indexOf(63) + 1;
        String str = this.j;
        return this.j.substring(iIndexOf, com.bytedance.sdk.a.b.a.c.a(str, iIndexOf, str.length(), '#'));
    }

    public String k() {
        if (this.h == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        b(sb, this.h);
        return sb.toString();
    }

    public String l() {
        if (this.i == null) {
            return null;
        }
        return this.j.substring(this.j.indexOf(35) + 1);
    }

    public String m() {
        return d("/...").b("").c("").c().toString();
    }

    public a n() {
        a aVar = new a();
        aVar.f5295a = this.f5290a;
        aVar.f5296b = d();
        aVar.f5297c = e();
        aVar.f5298d = this.f5291b;
        aVar.f5299e = this.f5292c != a(this.f5290a) ? this.f5292c : -1;
        aVar.f5300f.clear();
        aVar.f5300f.addAll(i());
        aVar.e(j());
        aVar.h = l();
        return aVar;
    }

    public String toString() {
        return this.j;
    }

    static void b(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            String str = list.get(i);
            String str2 = list.get(i + 1);
            if (i > 0) {
                sb.append('&');
            }
            sb.append(str);
            if (str2 != null) {
                sb.append('=');
                sb.append(str2);
            }
        }
    }

    public s c(String str) {
        a aVarD = d(str);
        if (aVarD != null) {
            return aVarD.c();
        }
        return null;
    }

    public static s e(String str) {
        a aVar = new a();
        if (aVar.a(null, str) == a.EnumC0068a.SUCCESS) {
            return aVar.c();
        }
        return null;
    }

    public a d(String str) {
        a aVar = new a();
        if (aVar.a(this, str) == a.EnumC0068a.SUCCESS) {
            return aVar;
        }
        return null;
    }

    public static int a(String str) {
        if (str.equals("http")) {
            return 80;
        }
        return str.equals("https") ? 443 : -1;
    }

    static void a(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            sb.append('/');
            sb.append(list.get(i));
        }
    }

    static List<String> b(String str) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i <= str.length()) {
            int iIndexOf = str.indexOf(38, i);
            if (iIndexOf == -1) {
                iIndexOf = str.length();
            }
            int iIndexOf2 = str.indexOf(61, i);
            if (iIndexOf2 != -1 && iIndexOf2 <= iIndexOf) {
                arrayList.add(str.substring(i, iIndexOf2));
                arrayList.add(str.substring(iIndexOf2 + 1, iIndexOf));
            } else {
                arrayList.add(str.substring(i, iIndexOf));
                arrayList.add(null);
            }
            i = iIndexOf + 1;
        }
        return arrayList;
    }

    public static s a(URL url) {
        return e(url.toString());
    }

    static String a(String str, boolean z) {
        return a(str, 0, str.length(), z);
    }

    private List<String> a(List<String> list, boolean z) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            String str = list.get(i);
            arrayList.add(str != null ? a(str, z) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    static String a(String str, int i, int i2, boolean z) {
        for (int i3 = i; i3 < i2; i3++) {
            char cCharAt = str.charAt(i3);
            if (cCharAt == '%' || (cCharAt == '+' && z)) {
                com.bytedance.sdk.a.a.c cVar = new com.bytedance.sdk.a.a.c();
                cVar.a(str, i, i3);
                a(cVar, str, i3, i2, z);
                return cVar.o();
            }
        }
        return str.substring(i, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static void a(com.bytedance.sdk.a.a.c r5, java.lang.String r6, int r7, int r8, boolean r9) {
        /*
        L0:
            if (r7 >= r8) goto L42
            int r0 = r6.codePointAt(r7)
            r1 = 37
            if (r0 != r1) goto L2d
            int r1 = r7 + 2
            if (r1 >= r8) goto L2d
            int r2 = r7 + 1
            char r2 = r6.charAt(r2)
            int r2 = com.bytedance.sdk.a.b.a.c.a(r2)
            char r3 = r6.charAt(r1)
            int r3 = com.bytedance.sdk.a.b.a.c.a(r3)
            r4 = -1
            if (r2 == r4) goto L39
            if (r3 == r4) goto L39
            int r7 = r2 << 4
            int r7 = r7 + r3
            r5.i(r7)
            r7 = r1
            goto L3c
        L2d:
            r1 = 43
            if (r0 != r1) goto L39
            if (r9 == 0) goto L39
            r1 = 32
            r5.i(r1)
            goto L3c
        L39:
            r5.a(r0)
        L3c:
            int r0 = java.lang.Character.charCount(r0)
            int r7 = r7 + r0
            goto L0
        L42:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.a.b.s.a(com.bytedance.sdk.a.a.c, java.lang.String, int, int, boolean):void");
    }

    static boolean a(String str, int i, int i2) {
        int i3 = i + 2;
        return i3 < i2 && str.charAt(i) == '%' && com.bytedance.sdk.a.b.a.c.a(str.charAt(i + 1)) != -1 && com.bytedance.sdk.a.b.a.c.a(str.charAt(i3)) != -1;
    }

    static String a(String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        int iCharCount = i;
        while (iCharCount < i2) {
            int iCodePointAt = str.codePointAt(iCharCount);
            if (iCodePointAt >= 32 && iCodePointAt != 127 && (iCodePointAt < 128 || !z4)) {
                if (str2.indexOf(iCodePointAt) == -1 && ((iCodePointAt != 37 || (z && (!z2 || a(str, iCharCount, i2)))) && (iCodePointAt != 43 || !z3))) {
                    iCharCount += Character.charCount(iCodePointAt);
                } else {
                    com.bytedance.sdk.a.a.c cVar = new com.bytedance.sdk.a.a.c();
                    cVar.a(str, i, iCharCount);
                    a(cVar, str, iCharCount, i2, str2, z, z2, z3, z4, charset);
                    return cVar.o();
                }
            } else {
                com.bytedance.sdk.a.a.c cVar2 = new com.bytedance.sdk.a.a.c();
                cVar2.a(str, i, iCharCount);
                a(cVar2, str, iCharCount, i2, str2, z, z2, z3, z4, charset);
                return cVar2.o();
            }
        }
        return str.substring(i, i2);
    }

    static void a(com.bytedance.sdk.a.a.c cVar, String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        com.bytedance.sdk.a.a.c cVar2 = null;
        while (i < i2) {
            int iCodePointAt = str.codePointAt(i);
            if (!z || (iCodePointAt != 9 && iCodePointAt != 10 && iCodePointAt != 12 && iCodePointAt != 13)) {
                if (iCodePointAt == 43 && z3) {
                    cVar.b(z ? "+" : "%2B");
                } else if (iCodePointAt >= 32 && iCodePointAt != 127 && ((iCodePointAt < 128 || !z4) && str2.indexOf(iCodePointAt) == -1 && (iCodePointAt != 37 || (z && (!z2 || a(str, i, i2)))))) {
                    cVar.a(iCodePointAt);
                } else {
                    if (cVar2 == null) {
                        cVar2 = new com.bytedance.sdk.a.a.c();
                    }
                    if (charset != null && !charset.equals(com.bytedance.sdk.a.b.a.c.f4968e)) {
                        cVar2.a(str, i, Character.charCount(iCodePointAt) + i, charset);
                    } else {
                        cVar2.a(iCodePointAt);
                    }
                    while (!cVar2.e()) {
                        int iH = cVar2.h() & 255;
                        cVar.i(37);
                        cVar.i((int) f5289d[(iH >> 4) & 15]);
                        cVar.i((int) f5289d[iH & 15]);
                    }
                }
            }
            i += Character.charCount(iCodePointAt);
        }
    }

    static String a(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        return a(str, 0, str.length(), str2, z, z2, z3, z4, null);
    }
}

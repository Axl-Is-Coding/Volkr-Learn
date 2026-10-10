package okhttp3;

import com.alibaba.android.arouter.utils.Consts;
import com.tendcloud.tenddata.aa;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import okio.Buffer;

/* JADX INFO: compiled from: HttpUrl.java */
/* JADX INFO: loaded from: classes5.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f23466a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final String f23467b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f23468c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f23469d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final String f23470e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final int f23471f;
    private final List<String> g;
    private final List<String> h;
    private final String i;
    private final String j;

    v(a aVar) {
        this.f23467b = aVar.f23472a;
        this.f23468c = a(aVar.f23473b, false);
        this.f23469d = a(aVar.f23474c, false);
        this.f23470e = aVar.f23475d;
        this.f23471f = aVar.b();
        this.g = a(aVar.f23477f, false);
        List<String> list = aVar.g;
        this.h = list != null ? a(list, true) : null;
        String str = aVar.h;
        this.i = str != null ? a(str, false) : null;
        this.j = aVar.toString();
    }

    public static int a(String str) {
        if (str.equals("http")) {
            return 80;
        }
        return str.equals("https") ? 443 : -1;
    }

    public String b() {
        if (this.f23469d.isEmpty()) {
            return "";
        }
        return this.j.substring(this.j.indexOf(58, this.f23467b.length() + 3) + 1, this.j.indexOf(64));
    }

    public String c() {
        int iIndexOf = this.j.indexOf(47, this.f23467b.length() + 3);
        String str = this.j;
        return this.j.substring(iIndexOf, okhttp3.a.e.a(str, iIndexOf, str.length(), "?#"));
    }

    public List<String> d() {
        int iIndexOf = this.j.indexOf(47, this.f23467b.length() + 3);
        String str = this.j;
        int iA = okhttp3.a.e.a(str, iIndexOf, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (iIndexOf < iA) {
            int i = iIndexOf + 1;
            int iA2 = okhttp3.a.e.a(this.j, i, iA, '/');
            arrayList.add(this.j.substring(i, iA2));
            iIndexOf = iA2;
        }
        return arrayList;
    }

    public String e() {
        if (this.h == null) {
            return null;
        }
        int iIndexOf = this.j.indexOf(63) + 1;
        String str = this.j;
        return this.j.substring(iIndexOf, okhttp3.a.e.a(str, iIndexOf, str.length(), '#'));
    }

    public boolean equals(Object obj) {
        return (obj instanceof v) && ((v) obj).j.equals(this.j);
    }

    public String f() {
        if (this.f23468c.isEmpty()) {
            return "";
        }
        int length = this.f23467b.length() + 3;
        String str = this.j;
        return this.j.substring(length, okhttp3.a.e.a(str, length, str.length(), ":@"));
    }

    public String g() {
        return this.f23470e;
    }

    public boolean h() {
        return this.f23467b.equals("https");
    }

    public int hashCode() {
        return this.j.hashCode();
    }

    public a i() {
        a aVar = new a();
        aVar.f23472a = this.f23467b;
        aVar.f23473b = f();
        aVar.f23474c = b();
        aVar.f23475d = this.f23470e;
        aVar.f23476e = this.f23471f != a(this.f23467b) ? this.f23471f : -1;
        aVar.f23477f.clear();
        aVar.f23477f.addAll(d());
        aVar.a(e());
        aVar.h = a();
        return aVar;
    }

    public List<String> j() {
        return this.g;
    }

    public int k() {
        return this.f23471f;
    }

    public String l() {
        if (this.h == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        a(sb, this.h);
        return sb.toString();
    }

    public int m() {
        List<String> list = this.h;
        if (list != null) {
            return list.size() / 2;
        }
        return 0;
    }

    public String n() {
        a aVarC = c("/...");
        aVarC.f("");
        aVarC.c("");
        return aVarC.a().toString();
    }

    public String o() {
        return this.f23467b;
    }

    public URI p() {
        a aVarI = i();
        aVarI.c();
        String string = aVarI.toString();
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

    public String toString() {
        return this.j;
    }

    /* JADX INFO: compiled from: HttpUrl.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f23472a;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        String f23475d;
        List<String> g;
        String h;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f23473b = "";

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        String f23474c = "";

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f23476e = -1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final List<String> f23477f = new ArrayList();

        public a() {
            this.f23477f.add("");
        }

        private boolean g(String str) {
            return str.equals(Consts.DOT) || str.equalsIgnoreCase("%2e");
        }

        private boolean h(String str) {
            return str.equals("..") || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e");
        }

        public a a(int i) {
            if (i > 0 && i <= 65535) {
                this.f23476e = i;
                return this;
            }
            throw new IllegalArgumentException("unexpected port: " + i);
        }

        public a b(String str) {
            if (str == null) {
                throw new NullPointerException("host == null");
            }
            String strA = a(str, 0, str.length());
            if (strA != null) {
                this.f23475d = strA;
                return this;
            }
            throw new IllegalArgumentException("unexpected host: " + str);
        }

        public a c(String str) {
            if (str == null) {
                throw new NullPointerException("password == null");
            }
            this.f23474c = v.a(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }

        public a d(String str) {
            this.g = str != null ? v.e(v.a(str, " \"'<>#", false, false, true, true)) : null;
            return this;
        }

        public a e(String str) {
            if (str == null) {
                throw new NullPointerException("scheme == null");
            }
            if (str.equalsIgnoreCase("http")) {
                this.f23472a = "http";
            } else {
                if (!str.equalsIgnoreCase("https")) {
                    throw new IllegalArgumentException("unexpected scheme: " + str);
                }
                this.f23472a = "https";
            }
            return this;
        }

        public a f(String str) {
            if (str == null) {
                throw new NullPointerException("username == null");
            }
            this.f23473b = v.a(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            String str = this.f23472a;
            if (str != null) {
                sb.append(str);
                sb.append(aa.f19741a);
            } else {
                sb.append("//");
            }
            if (!this.f23473b.isEmpty() || !this.f23474c.isEmpty()) {
                sb.append(this.f23473b);
                if (!this.f23474c.isEmpty()) {
                    sb.append(':');
                    sb.append(this.f23474c);
                }
                sb.append('@');
            }
            String str2 = this.f23475d;
            if (str2 != null) {
                if (str2.indexOf(58) != -1) {
                    sb.append('[');
                    sb.append(this.f23475d);
                    sb.append(']');
                } else {
                    sb.append(this.f23475d);
                }
            }
            if (this.f23476e != -1 || this.f23472a != null) {
                int iB = b();
                String str3 = this.f23472a;
                if (str3 == null || iB != v.a(str3)) {
                    sb.append(':');
                    sb.append(iB);
                }
            }
            v.b(sb, this.f23477f);
            if (this.g != null) {
                sb.append('?');
                v.a(sb, this.g);
            }
            if (this.h != null) {
                sb.append('#');
                sb.append(this.h);
            }
            return sb.toString();
        }

        private void d(String str, int i, int i2) {
            if (i == i2) {
                return;
            }
            char cCharAt = str.charAt(i);
            if (cCharAt != '/' && cCharAt != '\\') {
                List<String> list = this.f23477f;
                list.set(list.size() - 1, "");
            } else {
                this.f23477f.clear();
                this.f23477f.add("");
                i++;
            }
            while (true) {
                int i3 = i;
                if (i3 >= i2) {
                    return;
                }
                i = okhttp3.a.e.a(str, i3, i2, "/\\");
                boolean z = i < i2;
                a(str, i3, i, z, true);
                if (z) {
                    i++;
                }
            }
        }

        private static int f(String str, int i, int i2) {
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

        public a a(String str) {
            this.g = str != null ? v.e(v.a(str, " \"'<>#", true, false, true, true)) : null;
            return this;
        }

        a c() {
            int size = this.f23477f.size();
            for (int i = 0; i < size; i++) {
                this.f23477f.set(i, v.a(this.f23477f.get(i), "[]", true, true, false, true));
            }
            List<String> list = this.g;
            if (list != null) {
                int size2 = list.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = this.g.get(i2);
                    if (str != null) {
                        this.g.set(i2, v.a(str, "\\^`{|}", true, true, true, true));
                    }
                }
            }
            String str2 = this.h;
            if (str2 != null) {
                this.h = v.a(str2, " \"#<>\\^`{|}", true, true, false, false);
            }
            return this;
        }

        int b() {
            int i = this.f23476e;
            return i != -1 ? i : v.a(this.f23472a);
        }

        public a a(String str, String str2) {
            if (str != null) {
                if (this.g == null) {
                    this.g = new ArrayList();
                }
                this.g.add(v.a(str, " \"'<>#&=", true, false, true, true));
                this.g.add(str2 != null ? v.a(str2, " \"'<>#&=", true, false, true, true) : null);
                return this;
            }
            throw new NullPointerException("encodedName == null");
        }

        public a b(String str, String str2) {
            if (str != null) {
                if (this.g == null) {
                    this.g = new ArrayList();
                }
                this.g.add(v.a(str, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, true));
                this.g.add(str2 != null ? v.a(str2, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, true) : null);
                return this;
            }
            throw new NullPointerException("name == null");
        }

        private static int e(String str, int i, int i2) {
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

        private void d() {
            if (this.f23477f.remove(r0.size() - 1).isEmpty() && !this.f23477f.isEmpty()) {
                this.f23477f.set(r0.size() - 1, "");
            } else {
                this.f23477f.add("");
            }
        }

        private static int b(String str, int i, int i2) {
            int i3;
            try {
                i3 = Integer.parseInt(v.a(str, i, i2, "", false, false, false, true, null));
            } catch (NumberFormatException unused) {
            }
            if (i3 <= 0 || i3 > 65535) {
                return -1;
            }
            return i3;
        }

        public v a() {
            if (this.f23472a != null) {
                if (this.f23475d != null) {
                    return new v(this);
                }
                throw new IllegalStateException("host == null");
            }
            throw new IllegalStateException("scheme == null");
        }

        private static int c(String str, int i, int i2) {
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

        a a(v vVar, String str) {
            int iA;
            int i;
            int iA2 = okhttp3.a.e.a(str, 0, str.length());
            int iB = okhttp3.a.e.b(str, iA2, str.length());
            int iE = e(str, iA2, iB);
            if (iE != -1) {
                if (str.regionMatches(true, iA2, "https:", 0, 6)) {
                    this.f23472a = "https";
                    iA2 += 6;
                } else if (str.regionMatches(true, iA2, "http:", 0, 5)) {
                    this.f23472a = "http";
                    iA2 += 5;
                } else {
                    throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but was '" + str.substring(0, iE) + "'");
                }
            } else if (vVar != null) {
                this.f23472a = vVar.f23467b;
            } else {
                throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no colon was found");
            }
            int iF = f(str, iA2, iB);
            char c2 = '?';
            char c3 = '#';
            if (iF < 2 && vVar != null && vVar.f23467b.equals(this.f23472a)) {
                this.f23473b = vVar.f();
                this.f23474c = vVar.b();
                this.f23475d = vVar.f23470e;
                this.f23476e = vVar.f23471f;
                this.f23477f.clear();
                this.f23477f.addAll(vVar.d());
                if (iA2 == iB || str.charAt(iA2) == '#') {
                    a(vVar.e());
                }
            } else {
                int i2 = iA2 + iF;
                boolean z = false;
                boolean z2 = false;
                while (true) {
                    iA = okhttp3.a.e.a(str, i2, iB, "@/\\?#");
                    byte bCharAt = iA != iB ? str.charAt(iA) : (byte) -1;
                    if (bCharAt == -1 || bCharAt == c3 || bCharAt == 47 || bCharAt == 92 || bCharAt == c2) {
                        break;
                    }
                    if (bCharAt == 64) {
                        if (!z) {
                            int iA3 = okhttp3.a.e.a(str, i2, iA, ':');
                            i = iA;
                            String strA = v.a(str, i2, iA3, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                            if (z2) {
                                strA = this.f23473b + "%40" + strA;
                            }
                            this.f23473b = strA;
                            if (iA3 != i) {
                                this.f23474c = v.a(str, iA3 + 1, i, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                z = true;
                            }
                            z2 = true;
                        } else {
                            i = iA;
                            this.f23474c += "%40" + v.a(str, i2, i, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                        }
                        i2 = i + 1;
                    }
                    c2 = '?';
                    c3 = '#';
                }
                int iC = c(str, i2, iA);
                int i3 = iC + 1;
                if (i3 < iA) {
                    this.f23475d = a(str, i2, iC);
                    this.f23476e = b(str, i3, iA);
                    if (this.f23476e == -1) {
                        throw new IllegalArgumentException("Invalid URL port: \"" + str.substring(i3, iA) + '\"');
                    }
                } else {
                    this.f23475d = a(str, i2, iC);
                    this.f23476e = v.a(this.f23472a);
                }
                if (this.f23475d == null) {
                    throw new IllegalArgumentException("Invalid URL host: \"" + str.substring(i2, iC) + '\"');
                }
                iA2 = iA;
            }
            int iA4 = okhttp3.a.e.a(str, iA2, iB, "?#");
            d(str, iA2, iA4);
            if (iA4 < iB && str.charAt(iA4) == '?') {
                int iA5 = okhttp3.a.e.a(str, iA4, iB, '#');
                this.g = v.e(v.a(str, iA4 + 1, iA5, " \"'<>#", true, false, true, true, null));
                iA4 = iA5;
            }
            if (iA4 < iB && str.charAt(iA4) == '#') {
                this.h = v.a(str, 1 + iA4, iB, "", true, false, false, false, null);
            }
            return this;
        }

        private void a(String str, int i, int i2, boolean z, boolean z2) {
            String strA = v.a(str, i, i2, " \"<>^`{}|/\\?#", z2, false, false, true, null);
            if (g(strA)) {
                return;
            }
            if (h(strA)) {
                d();
                return;
            }
            if (this.f23477f.get(r11.size() - 1).isEmpty()) {
                this.f23477f.set(r11.size() - 1, strA);
            } else {
                this.f23477f.add(strA);
            }
            if (z) {
                this.f23477f.add("");
            }
        }

        private static String a(String str, int i, int i2) {
            return okhttp3.a.e.a(v.a(str, i, i2, false));
        }
    }

    static void a(StringBuilder sb, List<String> list) {
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

    public a c(String str) {
        try {
            a aVar = new a();
            aVar.a(this, str);
            return aVar;
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    static void b(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            sb.append('/');
            sb.append(list.get(i));
        }
    }

    static List<String> e(String str) {
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

    public v f(String str) {
        a aVarC = c(str);
        if (aVarC != null) {
            return aVarC.a();
        }
        return null;
    }

    public static v d(String str) {
        try {
            return b(str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public String b(int i) {
        List<String> list = this.h;
        if (list != null) {
            return list.get((i * 2) + 1);
        }
        throw new IndexOutOfBoundsException();
    }

    public String a(int i) {
        List<String> list = this.h;
        if (list != null) {
            return list.get(i * 2);
        }
        throw new IndexOutOfBoundsException();
    }

    public static v b(String str) {
        a aVar = new a();
        aVar.a((v) null, str);
        return aVar.a();
    }

    public String a() {
        if (this.i == null) {
            return null;
        }
        return this.j.substring(this.j.indexOf(35) + 1);
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
                Buffer buffer = new Buffer();
                buffer.writeUtf8(str, i, i3);
                a(buffer, str, i3, i2, z);
                return buffer.readUtf8();
            }
        }
        return str.substring(i, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static void a(okio.Buffer r5, java.lang.String r6, int r7, int r8, boolean r9) {
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
            int r2 = okhttp3.a.e.a(r2)
            char r3 = r6.charAt(r1)
            int r3 = okhttp3.a.e.a(r3)
            r4 = -1
            if (r2 == r4) goto L39
            if (r3 == r4) goto L39
            int r7 = r2 << 4
            int r7 = r7 + r3
            r5.writeByte(r7)
            r7 = r1
            goto L3c
        L2d:
            r1 = 43
            if (r0 != r1) goto L39
            if (r9 == 0) goto L39
            r1 = 32
            r5.writeByte(r1)
            goto L3c
        L39:
            r5.writeUtf8CodePoint(r0)
        L3c:
            int r0 = java.lang.Character.charCount(r0)
            int r7 = r7 + r0
            goto L0
        L42:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.v.a(okio.Buffer, java.lang.String, int, int, boolean):void");
    }

    static boolean a(String str, int i, int i2) {
        int i3 = i + 2;
        return i3 < i2 && str.charAt(i) == '%' && okhttp3.a.e.a(str.charAt(i + 1)) != -1 && okhttp3.a.e.a(str.charAt(i3)) != -1;
    }

    static String a(String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        int iCharCount = i;
        while (iCharCount < i2) {
            int iCodePointAt = str.codePointAt(iCharCount);
            if (iCodePointAt >= 32 && iCodePointAt != 127 && (iCodePointAt < 128 || !z4)) {
                if (str2.indexOf(iCodePointAt) == -1 && ((iCodePointAt != 37 || (z && (!z2 || a(str, iCharCount, i2)))) && (iCodePointAt != 43 || !z3))) {
                    iCharCount += Character.charCount(iCodePointAt);
                } else {
                    Buffer buffer = new Buffer();
                    buffer.writeUtf8(str, i, iCharCount);
                    a(buffer, str, iCharCount, i2, str2, z, z2, z3, z4, charset);
                    return buffer.readUtf8();
                }
            } else {
                Buffer buffer2 = new Buffer();
                buffer2.writeUtf8(str, i, iCharCount);
                a(buffer2, str, iCharCount, i2, str2, z, z2, z3, z4, charset);
                return buffer2.readUtf8();
            }
        }
        return str.substring(i, i2);
    }

    static void a(Buffer buffer, String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        Buffer buffer2 = null;
        while (i < i2) {
            int iCodePointAt = str.codePointAt(i);
            if (!z || (iCodePointAt != 9 && iCodePointAt != 10 && iCodePointAt != 12 && iCodePointAt != 13)) {
                if (iCodePointAt == 43 && z3) {
                    buffer.writeUtf8(z ? "+" : "%2B");
                } else if (iCodePointAt >= 32 && iCodePointAt != 127 && ((iCodePointAt < 128 || !z4) && str2.indexOf(iCodePointAt) == -1 && (iCodePointAt != 37 || (z && (!z2 || a(str, i, i2)))))) {
                    buffer.writeUtf8CodePoint(iCodePointAt);
                } else {
                    if (buffer2 == null) {
                        buffer2 = new Buffer();
                    }
                    if (charset != null && !charset.equals(okhttp3.a.e.j)) {
                        buffer2.writeString(str, i, Character.charCount(iCodePointAt) + i, charset);
                    } else {
                        buffer2.writeUtf8CodePoint(iCodePointAt);
                    }
                    while (!buffer2.exhausted()) {
                        int i3 = buffer2.readByte() & 255;
                        buffer.writeByte(37);
                        buffer.writeByte((int) f23466a[(i3 >> 4) & 15]);
                        buffer.writeByte((int) f23466a[i3 & 15]);
                    }
                }
            }
            i += Character.charCount(iCodePointAt);
        }
    }

    static String a(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, Charset charset) {
        return a(str, 0, str.length(), str2, z, z2, z3, z4, charset);
    }

    static String a(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        return a(str, 0, str.length(), str2, z, z2, z3, z4, null);
    }
}

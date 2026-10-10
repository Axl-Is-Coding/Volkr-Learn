package okhttp3;

import com.umeng.umcrash.UMCustomLogInfoBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: Headers.java */
/* JADX INFO: loaded from: classes5.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String[] f23464a;

    u(a aVar) {
        List<String> list = aVar.f23465a;
        this.f23464a = (String[]) list.toArray(new String[list.size()]);
    }

    public String a(int i) {
        return this.f23464a[i * 2];
    }

    public String b(String str) {
        return a(this.f23464a, str);
    }

    public List<String> c(String str) {
        int iB = b();
        ArrayList arrayList = null;
        for (int i = 0; i < iB; i++) {
            if (str.equalsIgnoreCase(a(i))) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(b(i));
            }
        }
        return arrayList != null ? Collections.unmodifiableList(arrayList) : Collections.emptyList();
    }

    public boolean equals(Object obj) {
        return (obj instanceof u) && Arrays.equals(((u) obj).f23464a, this.f23464a);
    }

    public int hashCode() {
        return Arrays.hashCode(this.f23464a);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int iB = b();
        for (int i = 0; i < iB; i++) {
            sb.append(a(i));
            sb.append(": ");
            sb.append(b(i));
            sb.append(UMCustomLogInfoBuilder.LINE_SEP);
        }
        return sb.toString();
    }

    /* JADX INFO: compiled from: Headers.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final List<String> f23465a = new ArrayList(20);

        a a(String str) {
            int iIndexOf = str.indexOf(":", 1);
            if (iIndexOf != -1) {
                b(str.substring(0, iIndexOf), str.substring(iIndexOf + 1));
                return this;
            }
            if (str.startsWith(":")) {
                b("", str.substring(1));
                return this;
            }
            b("", str);
            return this;
        }

        a b(String str, String str2) {
            this.f23465a.add(str);
            this.f23465a.add(str2.trim());
            return this;
        }

        public a c(String str) {
            int i = 0;
            while (i < this.f23465a.size()) {
                if (str.equalsIgnoreCase(this.f23465a.get(i))) {
                    this.f23465a.remove(i);
                    this.f23465a.remove(i);
                    i -= 2;
                }
                i += 2;
            }
            return this;
        }

        public String b(String str) {
            for (int size = this.f23465a.size() - 2; size >= 0; size -= 2) {
                if (str.equalsIgnoreCase(this.f23465a.get(size))) {
                    return this.f23465a.get(size + 1);
                }
            }
            return null;
        }

        public a c(String str, String str2) {
            u.a(str);
            u.a(str2, str);
            c(str);
            b(str, str2);
            return this;
        }

        public a a(String str, String str2) {
            u.a(str);
            u.a(str2, str);
            b(str, str2);
            return this;
        }

        public a a(u uVar) {
            int iB = uVar.b();
            for (int i = 0; i < iB; i++) {
                b(uVar.a(i), uVar.b(i));
            }
            return this;
        }

        public u a() {
            return new u(this);
        }
    }

    public a a() {
        a aVar = new a();
        Collections.addAll(aVar.f23465a, this.f23464a);
        return aVar;
    }

    public int b() {
        return this.f23464a.length / 2;
    }

    private u(String[] strArr) {
        this.f23464a = strArr;
    }

    public String b(int i) {
        return this.f23464a[(i * 2) + 1];
    }

    private static String a(String[] strArr, String str) {
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    public static u a(String... strArr) {
        if (strArr != null) {
            if (strArr.length % 2 == 0) {
                String[] strArr2 = (String[]) strArr.clone();
                for (int i = 0; i < strArr2.length; i++) {
                    if (strArr2[i] != null) {
                        strArr2[i] = strArr2[i].trim();
                    } else {
                        throw new IllegalArgumentException("Headers cannot be null");
                    }
                }
                for (int i2 = 0; i2 < strArr2.length; i2 += 2) {
                    String str = strArr2[i2];
                    String str2 = strArr2[i2 + 1];
                    a(str);
                    a(str2, str);
                }
                return new u(strArr2);
            }
            throw new IllegalArgumentException("Expected alternating header names and values");
        }
        throw new NullPointerException("namesAndValues == null");
    }

    static void a(String str) {
        if (str != null) {
            if (!str.isEmpty()) {
                int length = str.length();
                for (int i = 0; i < length; i++) {
                    char cCharAt = str.charAt(i);
                    if (cCharAt <= ' ' || cCharAt >= 127) {
                        throw new IllegalArgumentException(okhttp3.a.e.a("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(cCharAt), Integer.valueOf(i), str));
                    }
                }
                return;
            }
            throw new IllegalArgumentException("name is empty");
        }
        throw new NullPointerException("name == null");
    }

    static void a(String str, String str2) {
        if (str != null) {
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char cCharAt = str.charAt(i);
                if ((cCharAt <= 31 && cCharAt != '\t') || cCharAt >= 127) {
                    throw new IllegalArgumentException(okhttp3.a.e.a("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(cCharAt), Integer.valueOf(i), str2, str));
                }
            }
            return;
        }
        throw new NullPointerException("value for name " + str2 + " == null");
    }
}

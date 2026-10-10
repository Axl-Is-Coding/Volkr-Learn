package com.bytedance.sdk.a.b;

import com.umeng.umcrash.UMCustomLogInfoBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: Headers.java */
/* JADX INFO: loaded from: classes.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String[] f5287a;

    r(a aVar) {
        List<String> list = aVar.f5288a;
        this.f5287a = (String[]) list.toArray(new String[list.size()]);
    }

    public String a(String str) {
        return a(this.f5287a, str);
    }

    public String b(int i) {
        return this.f5287a[(i * 2) + 1];
    }

    public boolean equals(Object obj) {
        return (obj instanceof r) && Arrays.equals(((r) obj).f5287a, this.f5287a);
    }

    public int hashCode() {
        return Arrays.hashCode(this.f5287a);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int iA = a();
        for (int i = 0; i < iA; i++) {
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
        final List<String> f5288a = new ArrayList(20);

        private void d(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("name == null");
            }
            if (str.isEmpty()) {
                throw new IllegalArgumentException("name is empty");
            }
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char cCharAt = str.charAt(i);
                if (cCharAt <= ' ' || cCharAt >= 127) {
                    throw new IllegalArgumentException(com.bytedance.sdk.a.b.a.c.a("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(cCharAt), Integer.valueOf(i), str));
                }
            }
            if (str2 == null) {
                throw new NullPointerException("value for name " + str + " == null");
            }
            int length2 = str2.length();
            for (int i2 = 0; i2 < length2; i2++) {
                char cCharAt2 = str2.charAt(i2);
                if ((cCharAt2 <= 31 && cCharAt2 != '\t') || cCharAt2 >= 127) {
                    throw new IllegalArgumentException(com.bytedance.sdk.a.b.a.c.a("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(cCharAt2), Integer.valueOf(i2), str, str2));
                }
            }
        }

        a a(String str) {
            int iIndexOf = str.indexOf(":", 1);
            return iIndexOf != -1 ? b(str.substring(0, iIndexOf), str.substring(iIndexOf + 1)) : str.startsWith(":") ? b("", str.substring(1)) : b("", str);
        }

        a b(String str, String str2) {
            this.f5288a.add(str);
            this.f5288a.add(str2.trim());
            return this;
        }

        public a c(String str, String str2) {
            d(str, str2);
            b(str);
            b(str, str2);
            return this;
        }

        public a b(String str) {
            int i = 0;
            while (i < this.f5288a.size()) {
                if (str.equalsIgnoreCase(this.f5288a.get(i))) {
                    this.f5288a.remove(i);
                    this.f5288a.remove(i);
                    i -= 2;
                }
                i += 2;
            }
            return this;
        }

        public a a(String str, String str2) {
            d(str, str2);
            return b(str, str2);
        }

        public r a() {
            return new r(this);
        }
    }

    public int a() {
        return this.f5287a.length / 2;
    }

    public List<String> b(String str) {
        int iA = a();
        ArrayList arrayList = null;
        for (int i = 0; i < iA; i++) {
            if (str.equalsIgnoreCase(a(i))) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(b(i));
            }
        }
        return arrayList != null ? Collections.unmodifiableList(arrayList) : Collections.emptyList();
    }

    public String a(int i) {
        return this.f5287a[i * 2];
    }

    private static String a(String[] strArr, String str) {
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    public a b() {
        a aVar = new a();
        Collections.addAll(aVar.f5288a, this.f5287a);
        return aVar;
    }
}

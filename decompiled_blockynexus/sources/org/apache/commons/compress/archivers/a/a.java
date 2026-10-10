package org.apache.commons.compress.archivers.a;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: TarArchiveEntry.java */
/* JADX INFO: loaded from: classes5.dex */
public class a implements d, org.apache.commons.compress.archivers.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a[] f23514a = new a[0];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f23515b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f23516c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f23517d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f23518e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f23519f;
    private long g;
    private long h;
    private boolean i;
    private byte j;
    private String k;
    private String l;
    private String m;
    private String n;
    private String o;
    private int p;
    private int q;
    private boolean r;
    private long s;
    private boolean t;
    private boolean u;
    private final File v;
    private final Map<String, String> w;

    private a() {
        this.f23515b = "";
        this.f23518e = 0L;
        this.f23519f = 0L;
        this.g = 0L;
        this.k = "";
        this.l = "ustar\u0000";
        this.m = "00";
        this.o = "";
        this.p = 0;
        this.q = 0;
        this.w = new HashMap();
        String property = System.getProperty("user.name", "");
        this.n = property.length() > 31 ? property.substring(0, 31) : property;
        this.v = null;
    }

    public boolean a(a aVar) {
        return aVar != null && a().equals(aVar.a());
    }

    public void b(String str) {
        this.k = str;
    }

    public void c(String str) {
        this.f23515b = a(str, this.f23516c);
    }

    public void d(long j) {
        this.f23518e = j;
    }

    public boolean e() {
        return this.j == 75;
    }

    public boolean equals(Object obj) {
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        return a((a) obj);
    }

    public boolean f() {
        return this.j == 76;
    }

    public boolean g() {
        return this.j == 103;
    }

    public boolean h() {
        return this.j == 83;
    }

    public int hashCode() {
        return a().hashCode();
    }

    public boolean i() {
        byte b2 = this.j;
        return b2 == 120 || b2 == 88;
    }

    public String a() {
        return this.f23515b;
    }

    public void b(long j) {
        this.h = j / 1000;
    }

    public void c(long j) {
        if (j >= 0) {
            this.g = j;
            return;
        }
        throw new IllegalArgumentException("Size is out of range: " + j);
    }

    public void d(String str) {
        this.n = str;
    }

    public void a(long j) {
        this.f23519f = j;
    }

    public long b() {
        return this.g;
    }

    public boolean d() {
        return this.r;
    }

    public void a(String str) {
        this.o = str;
    }

    public void b(int i) {
        if (i >= 0) {
            this.q = i;
            return;
        }
        throw new IllegalArgumentException("Minor device number is out of range: " + i);
    }

    public boolean c() {
        File file = this.v;
        if (file != null) {
            return file.isDirectory();
        }
        if (this.j == 53) {
            return true;
        }
        return (i() || g() || !a().endsWith("/")) ? false : true;
    }

    void d(Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            a(entry.getKey(), entry.getValue(), map);
        }
    }

    public void a(int i) {
        if (i >= 0) {
            this.p = i;
            return;
        }
        throw new IllegalArgumentException("Major device number is out of range: " + i);
    }

    void b(Map<String, String> map) {
        this.t = true;
        this.s = Integer.parseInt(map.get("GNU.sparse.realsize"));
        this.f23515b = map.get("GNU.sparse.name");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0093  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(java.lang.String r3, java.lang.String r4, java.util.Map<java.lang.String, java.lang.String> r5) {
        /*
            Method dump skipped, instruction units count: 334
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.archivers.a.a.a(java.lang.String, java.lang.String, java.util.Map):void");
    }

    void c(Map<String, String> map) {
        this.u = true;
        if (map.containsKey("SCHILY.realsize")) {
            this.s = Long.parseLong(map.get("SCHILY.realsize"));
        }
    }

    public a(byte[] bArr, org.apache.commons.compress.archivers.zip.d dVar) throws IOException {
        this();
        a(bArr, dVar);
    }

    public void a(byte[] bArr, org.apache.commons.compress.archivers.zip.d dVar) throws IOException {
        a(bArr, dVar, false);
    }

    private void a(byte[] bArr, org.apache.commons.compress.archivers.zip.d dVar, boolean z) throws IOException {
        String strA;
        String strA2;
        String strA3;
        String strA4;
        String strA5;
        String strA6;
        if (z) {
            strA = f.a(bArr, 0, 100);
        } else {
            strA = f.a(bArr, 0, 100, dVar);
        }
        this.f23515b = strA;
        this.f23517d = (int) f.c(bArr, 100, 8);
        this.f23518e = (int) f.c(bArr, 108, 8);
        this.f23519f = (int) f.c(bArr, 116, 8);
        this.g = f.c(bArr, 124, 12);
        this.h = f.c(bArr, 136, 12);
        this.i = f.a(bArr);
        this.j = bArr[156];
        if (z) {
            strA2 = f.a(bArr, 157, 100);
        } else {
            strA2 = f.a(bArr, 157, 100, dVar);
        }
        this.k = strA2;
        this.l = f.a(bArr, 257, 6);
        this.m = f.a(bArr, 263, 2);
        if (z) {
            strA3 = f.a(bArr, 265, 32);
        } else {
            strA3 = f.a(bArr, 265, 32, dVar);
        }
        this.n = strA3;
        if (z) {
            strA4 = f.a(bArr, 297, 32);
        } else {
            strA4 = f.a(bArr, 297, 32, dVar);
        }
        this.o = strA4;
        byte b2 = this.j;
        if (b2 == 51 || b2 == 52) {
            this.p = (int) f.c(bArr, 329, 8);
            this.q = (int) f.c(bArr, 337, 8);
        }
        int iA = a(bArr);
        if (iA == 2) {
            this.r = f.a(bArr, 482);
            this.s = f.b(bArr, 483, 12);
            return;
        }
        if (iA != 4) {
            if (z) {
                strA6 = f.a(bArr, 345, 155);
            } else {
                strA6 = f.a(bArr, 345, 155, dVar);
            }
            if (c() && !this.f23515b.endsWith("/")) {
                this.f23515b += "/";
            }
            if (strA6.length() > 0) {
                this.f23515b = strA6 + "/" + this.f23515b;
                return;
            }
            return;
        }
        if (z) {
            strA5 = f.a(bArr, 345, 131);
        } else {
            strA5 = f.a(bArr, 345, 131, dVar);
        }
        if (strA5.length() > 0) {
            this.f23515b = strA5 + "/" + this.f23515b;
        }
    }

    private static String a(String str, boolean z) {
        int iIndexOf;
        String lowerCase = System.getProperty("os.name").toLowerCase(Locale.ENGLISH);
        if (lowerCase != null) {
            if (lowerCase.startsWith("windows")) {
                if (str.length() > 2) {
                    char cCharAt = str.charAt(0);
                    if (str.charAt(1) == ':' && ((cCharAt >= 'a' && cCharAt <= 'z') || (cCharAt >= 'A' && cCharAt <= 'Z'))) {
                        str = str.substring(2);
                    }
                }
            } else if (lowerCase.contains("netware") && (iIndexOf = str.indexOf(58)) != -1) {
                str = str.substring(iIndexOf + 1);
            }
        }
        String strReplace = str.replace(File.separatorChar, '/');
        while (!z && strReplace.startsWith("/")) {
            strReplace = strReplace.substring(1);
        }
        return strReplace;
    }

    private int a(byte[] bArr) {
        if (org.apache.commons.compress.a.a.a("ustar ", bArr, 257, 6)) {
            return 2;
        }
        if (org.apache.commons.compress.a.a.a("ustar\u0000", bArr, 257, 6)) {
            return org.apache.commons.compress.a.a.a("tar\u0000", bArr, 508, 4) ? 4 : 3;
        }
        return 0;
    }

    void a(Map<String, String> map) {
        this.t = true;
        this.s = Integer.parseInt(map.get("GNU.sparse.size"));
        if (map.containsKey("GNU.sparse.name")) {
            this.f23515b = map.get("GNU.sparse.name");
        }
    }
}

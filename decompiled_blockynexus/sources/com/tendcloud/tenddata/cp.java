package com.tendcloud.tenddata;

import android.os.Process;
import java.util.Properties;
import java.util.zip.CRC32;

/* JADX INFO: compiled from: td */
/* JADX INFO: loaded from: classes5.dex */
public class cp extends Properties implements Comparable<cp> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f19957a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private byte[] f19958b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f19959c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f19960d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private CRC32 f19961e;

    /* JADX INFO: compiled from: td */
    public static final class a {
        public static final String DATA = "data";
        public static final String LENGTH = "length";
        public static final String RCS32 = "rcs32";
    }

    /* JADX INFO: compiled from: td */
    public static final class b {
        public static final String TYPE_ANTICHEATING = "Type";
    }

    public cp(String str) {
        this.f19957a = str;
    }

    public static String a() {
        return System.currentTimeMillis() + "_" + Long.toString(Process.myPid());
    }

    public String b() {
        return this.f19957a;
    }

    public byte[] c() {
        return this.f19958b;
    }

    public int d() {
        return this.f19959c;
    }

    public int e() {
        return this.f19960d;
    }

    public final void writeData(byte[] bArr) {
        if (bArr == null) {
            return;
        }
        if (this.f19961e == null) {
            this.f19961e = new CRC32();
        }
        this.f19958b = new byte[bArr.length];
        System.arraycopy(bArr, 0, this.f19958b, 0, bArr.length);
        this.f19960d = this.f19958b.length;
        this.f19961e.reset();
        this.f19961e.update(this.f19958b);
        this.f19959c = (int) this.f19961e.getValue();
    }

    public int a(String str, int i) {
        String str2 = (String) setProperty(str, String.valueOf(i));
        if (str2 == null) {
            return 0;
        }
        return Integer.parseInt(str2);
    }

    public byte[] b(String str) {
        return c(super.getProperty(str));
    }

    public byte[] c(String str) {
        if (str != null) {
            return str.getBytes();
        }
        return null;
    }

    public cp(byte[] bArr) {
        this(a(), bArr);
    }

    private cp(String str, byte[] bArr) {
        this(str);
        this.f19961e = new CRC32();
        writeData(bArr);
    }

    public byte[] a(String str, byte[] bArr) {
        String str2 = (String) setProperty(str, a(bArr));
        if (str2 == null) {
            return null;
        }
        return c(str2);
    }

    public int a(String str) {
        return Integer.parseInt(super.getProperty(str));
    }

    public String a(byte[] bArr) {
        return new String(bArr);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(cp cpVar) {
        return b().compareTo(cpVar.b());
    }
}

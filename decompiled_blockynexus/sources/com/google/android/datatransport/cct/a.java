package com.google.android.datatransport.cct;

import com.google.android.datatransport.runtime.j;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: CCTDestination.java */
/* JADX INFO: loaded from: classes.dex */
public final class a implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final String f12724a = e.a("hts/frbslgiggolai.o/0clgbthfra=snpoo", "tp:/ieaeogn.ogepscmvc/o/ac?omtjo_rt3");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final String f12725b = e.a("hts/frbslgigp.ogepscmv/ieo/eaybtho", "tp:/ieaeogn-agolai.o/1frlglgc/aclg");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f12726c = e.a("AzSCki82AwsLzKd5O8zo", "IayckHiZRO1EFl1aGoK");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Set<com.google.android.datatransport.b> f12727d = Collections.unmodifiableSet(new HashSet(Arrays.asList(com.google.android.datatransport.b.a("proto"), com.google.android.datatransport.b.a("json"))));

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f12728e = new a(f12724a, null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f12729f = new a(f12725b, f12726c);
    private final String g;
    private final String h;

    public a(String str, String str2) {
        this.g = str;
        this.h = str2;
    }

    @Override // com.google.android.datatransport.runtime.j
    public Set<com.google.android.datatransport.b> a() {
        return f12727d;
    }

    public byte[] b() {
        if (this.h == null && this.g == null) {
            return null;
        }
        Object[] objArr = new Object[4];
        objArr[0] = "1$";
        objArr[1] = this.g;
        objArr[2] = "\\";
        String str = this.h;
        if (str == null) {
            str = "";
        }
        objArr[3] = str;
        return String.format("%s%s%s%s", objArr).getBytes(Charset.forName("UTF-8"));
    }

    public String c() {
        return this.h;
    }

    public String d() {
        return this.g;
    }

    @Override // com.google.android.datatransport.runtime.i
    public byte[] getExtras() {
        return b();
    }

    @Override // com.google.android.datatransport.runtime.i
    public String getName() {
        return "cct";
    }

    public static a a(byte[] bArr) {
        String str = new String(bArr, Charset.forName("UTF-8"));
        if (!str.startsWith("1$")) {
            throw new IllegalArgumentException("Version marker missing from extras");
        }
        String[] strArrSplit = str.substring(2).split(Pattern.quote("\\"), 2);
        if (strArrSplit.length != 2) {
            throw new IllegalArgumentException("Extra is not a valid encoded LegacyFlgDestination");
        }
        String str2 = strArrSplit[0];
        if (str2.isEmpty()) {
            throw new IllegalArgumentException("Missing endpoint in CCTDestination extras");
        }
        String str3 = strArrSplit[1];
        if (str3.isEmpty()) {
            str3 = null;
        }
        return new a(str2, str3);
    }
}

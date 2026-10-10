package com.umeng.analytics.pro;

import com.umeng.analytics.pro.bv;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

/* JADX INFO: compiled from: TSerializer.java */
/* JADX INFO: loaded from: classes5.dex */
public class bl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ByteArrayOutputStream f20712a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final cn f20713b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private cb f20714c;

    public bl() {
        this(new bv.a());
    }

    public byte[] a(bc bcVar) throws bi {
        this.f20712a.reset();
        bcVar.write(this.f20714c);
        return this.f20712a.toByteArray();
    }

    public String b(bc bcVar) throws bi {
        return new String(a(bcVar));
    }

    public bl(cd cdVar) {
        this.f20712a = new ByteArrayOutputStream();
        this.f20713b = new cn(this.f20712a);
        this.f20714c = cdVar.a(this.f20713b);
    }

    public String a(bc bcVar, String str) throws bi {
        try {
            return new String(a(bcVar), str);
        } catch (UnsupportedEncodingException unused) {
            throw new bi("JVM DOES NOT SUPPORT ENCODING: " + str);
        }
    }
}

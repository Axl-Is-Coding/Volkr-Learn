package com.umeng.analytics.pro;

/* JADX INFO: compiled from: TField.java */
/* JADX INFO: loaded from: classes5.dex */
public class bw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f20754a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte f20755b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final short f20756c;

    public bw() {
        this("", (byte) 0, (short) 0);
    }

    public boolean a(bw bwVar) {
        return this.f20755b == bwVar.f20755b && this.f20756c == bwVar.f20756c;
    }

    public String toString() {
        return "<TField name:'" + this.f20754a + "' type:" + ((int) this.f20755b) + " field-id:" + ((int) this.f20756c) + ">";
    }

    public bw(String str, byte b2, short s) {
        this.f20754a = str;
        this.f20755b = b2;
        this.f20756c = s;
    }
}

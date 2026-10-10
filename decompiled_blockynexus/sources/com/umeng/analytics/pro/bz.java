package com.umeng.analytics.pro;

/* JADX INFO: compiled from: TMessage.java */
/* JADX INFO: loaded from: classes5.dex */
public final class bz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f20762a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte f20763b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f20764c;

    public bz() {
        this("", (byte) 0, 0);
    }

    public boolean a(bz bzVar) {
        return this.f20762a.equals(bzVar.f20762a) && this.f20763b == bzVar.f20763b && this.f20764c == bzVar.f20764c;
    }

    public boolean equals(Object obj) {
        if (obj instanceof bz) {
            return a((bz) obj);
        }
        return false;
    }

    public String toString() {
        return "<TMessage name:'" + this.f20762a + "' type: " + ((int) this.f20763b) + " seqid:" + this.f20764c + ">";
    }

    public bz(String str, byte b2, int i) {
        this.f20762a = str;
        this.f20763b = b2;
        this.f20764c = i;
    }
}

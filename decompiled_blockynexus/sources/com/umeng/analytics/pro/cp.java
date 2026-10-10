package com.umeng.analytics.pro;

/* JADX INFO: compiled from: TTransport.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class cp {
    public abstract int a(byte[] bArr, int i, int i2) throws cq;

    public void a(int i) {
    }

    public abstract boolean a();

    public abstract void b() throws cq;

    public void b(byte[] bArr) throws cq {
        b(bArr, 0, bArr.length);
    }

    public abstract void b(byte[] bArr, int i, int i2) throws cq;

    public abstract void c();

    public int d(byte[] bArr, int i, int i2) throws cq {
        int i3 = 0;
        while (i3 < i2) {
            int iA = a(bArr, i + i3, i2 - i3);
            if (iA <= 0) {
                throw new cq("Cannot read. Remote side has closed. Tried to read " + i2 + " bytes, but only got " + i3 + " bytes. (This is often indicative of an internal error on the server side. Please check your server logs.)");
            }
            i3 += iA;
        }
        return i3;
    }

    public void d() throws cq {
    }

    public byte[] f() {
        return null;
    }

    public int g() {
        return 0;
    }

    public int h() {
        return -1;
    }

    public boolean i() {
        return a();
    }
}

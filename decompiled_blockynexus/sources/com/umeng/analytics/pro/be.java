package com.umeng.analytics.pro;

import java.io.ByteArrayOutputStream;

/* JADX INFO: compiled from: TByteArrayOutputStream.java */
/* JADX INFO: loaded from: classes5.dex */
public class be extends ByteArrayOutputStream {
    public be(int i) {
        super(i);
    }

    public byte[] a() {
        return ((ByteArrayOutputStream) this).buf;
    }

    public int b() {
        return ((ByteArrayOutputStream) this).count;
    }

    public be() {
    }
}

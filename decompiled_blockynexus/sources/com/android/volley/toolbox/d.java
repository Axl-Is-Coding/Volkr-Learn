package com.android.volley.toolbox;

import java.util.Comparator;

/* JADX INFO: compiled from: ByteArrayPool.java */
/* JADX INFO: loaded from: classes.dex */
class d implements Comparator<byte[]> {
    d() {
    }

    @Override // java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(byte[] bArr, byte[] bArr2) {
        return bArr.length - bArr2.length;
    }
}

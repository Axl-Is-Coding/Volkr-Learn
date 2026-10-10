package com.alibaba.mtl.log.d;

/* JADX INFO: compiled from: IntUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class f {
    public static byte[] getBytes(int i) {
        byte[] bArr = {(byte) ((i >> 8) % 256), (byte) (i % 256), (byte) (i % 256), (byte) (i % 256)};
        int i2 = i >> 8;
        int i3 = i2 >> 8;
        return bArr;
    }
}

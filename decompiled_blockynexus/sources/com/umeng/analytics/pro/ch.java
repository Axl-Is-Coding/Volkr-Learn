package com.umeng.analytics.pro;

import java.util.BitSet;

/* JADX INFO: compiled from: TTupleProtocol.java */
/* JADX INFO: loaded from: classes5.dex */
public final class ch extends bv {

    /* JADX INFO: compiled from: TTupleProtocol.java */
    public static class a implements cd {
        @Override // com.umeng.analytics.pro.cd
        public cb a(cp cpVar) {
            return new ch(cpVar);
        }
    }

    public ch(cp cpVar) {
        super(cpVar);
    }

    @Override // com.umeng.analytics.pro.cb
    public Class<? extends cj> D() {
        return cm.class;
    }

    public void a(BitSet bitSet, int i) throws bi {
        for (byte b2 : b(bitSet, i)) {
            a(b2);
        }
    }

    public BitSet b(int i) throws bi {
        double d2 = i;
        Double.isNaN(d2);
        int iCeil = (int) Math.ceil(d2 / 8.0d);
        byte[] bArr = new byte[iCeil];
        for (int i2 = 0; i2 < iCeil; i2++) {
            bArr[i2] = u();
        }
        return a(bArr);
    }

    public static BitSet a(byte[] bArr) {
        BitSet bitSet = new BitSet();
        for (int i = 0; i < bArr.length * 8; i++) {
            if ((bArr[(bArr.length - (i / 8)) - 1] & (1 << (i % 8))) > 0) {
                bitSet.set(i);
            }
        }
        return bitSet;
    }

    public static byte[] b(BitSet bitSet, int i) {
        double d2 = i;
        Double.isNaN(d2);
        byte[] bArr = new byte[(int) Math.ceil(d2 / 8.0d)];
        for (int i2 = 0; i2 < bitSet.length(); i2++) {
            if (bitSet.get(i2)) {
                int length = (bArr.length - (i2 / 8)) - 1;
                bArr[length] = (byte) ((1 << (i2 % 8)) | bArr[length]);
            }
        }
        return bArr;
    }
}

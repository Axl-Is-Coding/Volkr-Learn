package androidx.core.d;

import java.util.Comparator;

/* JADX INFO: compiled from: FontsContractCompat.java */
/* JADX INFO: loaded from: classes.dex */
class e implements Comparator<byte[]> {
    e() {
    }

    @Override // java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(byte[] bArr, byte[] bArr2) {
        int length;
        int length2;
        if (bArr.length == bArr2.length) {
            for (int i = 0; i < bArr.length; i++) {
                if (bArr[i] != bArr2[i]) {
                    length = bArr[i];
                    length2 = bArr2[i];
                }
            }
            return 0;
        }
        length = bArr.length;
        length2 = bArr2.length;
        return length - length2;
    }
}

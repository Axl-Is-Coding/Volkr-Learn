package c.t.m.g;

import java.util.Comparator;

/* JADX INFO: compiled from: TL */
/* JADX INFO: loaded from: classes.dex */
class Ra implements Comparator<byte[]> {
    Ra() {
    }

    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(byte[] bArr, byte[] bArr2) {
        return bArr.length - bArr2.length;
    }
}

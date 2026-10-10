package com.google.zxing.a.a;

/* JADX INFO: compiled from: BinaryShiftToken.java */
/* JADX INFO: loaded from: classes2.dex */
final class b extends h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final short f14398c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final short f14399d;

    b(h hVar, int i, int i2) {
        super(hVar);
        this.f14398c = (short) i;
        this.f14399d = (short) i2;
    }

    @Override // com.google.zxing.a.a.h
    public void a(com.google.zxing.common.a aVar, byte[] bArr) {
        int i = 0;
        while (true) {
            short s = this.f14399d;
            if (i >= s) {
                return;
            }
            if (i == 0 || (i == 31 && s <= 62)) {
                aVar.a(31, 5);
                short s2 = this.f14399d;
                if (s2 > 62) {
                    aVar.a(s2 - 31, 16);
                } else if (i == 0) {
                    aVar.a(Math.min((int) s2, 31), 5);
                } else {
                    aVar.a(s2 - 31, 5);
                }
            }
            aVar.a(bArr[this.f14398c + i], 8);
            i++;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("<");
        sb.append((int) this.f14398c);
        sb.append("::");
        sb.append((this.f14398c + this.f14399d) - 1);
        sb.append('>');
        return sb.toString();
    }
}

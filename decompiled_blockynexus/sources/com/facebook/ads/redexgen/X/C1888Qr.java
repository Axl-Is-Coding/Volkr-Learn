package com.facebook.ads.redexgen.X;

import java.io.ByteArrayInputStream;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Qr, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1888Qr implements C0K {
    public ByteArrayInputStream A00;
    public final byte[] A01;

    public C1888Qr(byte[] bArr) {
        this.A01 = bArr;
    }

    @Override // com.facebook.ads.redexgen.X.C0K
    public final void ABj(int i) throws C1889Qs {
        this.A00 = new ByteArrayInputStream(this.A01);
        this.A00.skip(i);
    }

    @Override // com.facebook.ads.redexgen.X.C0K
    public final void close() throws C1889Qs {
    }

    @Override // com.facebook.ads.redexgen.X.C0K
    public final int length() throws C1889Qs {
        return this.A01.length;
    }

    @Override // com.facebook.ads.redexgen.X.C0K
    public final int read(byte[] bArr) throws C1889Qs {
        return this.A00.read(bArr, 0, bArr.length);
    }
}

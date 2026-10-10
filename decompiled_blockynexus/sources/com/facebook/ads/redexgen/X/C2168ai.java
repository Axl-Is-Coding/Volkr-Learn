package com.facebook.ads.redexgen.X;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.io.IOException;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.ai, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2168ai implements HC {
    public final int A00;
    public final HC A01;
    public final IK A02;

    public C2168ai(HC hc, IK ik, int i) {
        this.A01 = (HC) C1662Hr.A01(hc);
        this.A02 = (IK) C1662Hr.A01(ik);
        this.A00 = i;
    }

    @Override // com.facebook.ads.redexgen.X.HC
    @Nullable
    public final Uri A7J() {
        return this.A01.A7J();
    }

    @Override // com.facebook.ads.redexgen.X.HC
    public final long ABi(HG hg) throws IOException {
        this.A02.A02(this.A00);
        return this.A01.ABi(hg);
    }

    @Override // com.facebook.ads.redexgen.X.HC
    public final void close() throws IOException {
        this.A01.close();
    }

    @Override // com.facebook.ads.redexgen.X.HC
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        this.A02.A02(this.A00);
        return this.A01.read(bArr, i, i2);
    }
}

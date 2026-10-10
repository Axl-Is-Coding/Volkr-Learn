package com.facebook.ads.redexgen.X;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.io.IOException;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ao, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1498Ao extends AbstractC2103Za implements F3 {
    public long A00;
    public boolean A01;
    public final int A02;
    public final int A03;
    public final Uri A04;
    public final CD A05;
    public final HB A06;

    @Nullable
    public final Object A07;
    public final String A08;

    public C1498Ao(Uri uri, HB hb, CD cd, int i, @Nullable String str, int i2, @Nullable Object obj) {
        this.A04 = uri;
        this.A06 = hb;
        this.A05 = cd;
        this.A03 = i;
        this.A08 = str;
        this.A02 = i2;
        this.A00 = -9223372036854775807L;
        this.A07 = obj;
    }

    private void A00(long j, boolean z) {
        this.A00 = j;
        this.A01 = z;
        A01(new C2118Zs(this.A00, this.A01, false, this.A07), null);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC2103Za
    public final void A02() {
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC2103Za
    public final void A03(XX xx, boolean z) {
        A00(this.A00, false);
    }

    @Override // com.facebook.ads.redexgen.X.F8
    public final InterfaceC2114Zo A4P(F6 f6, H4 h4) {
        C1662Hr.A03(f6.A02 == 0);
        return new C1499Ap(this.A04, this.A06.A4D(), this.A05.A4H(), this.A03, A00(f6), this, h4, this.A08, this.A02);
    }

    @Override // com.facebook.ads.redexgen.X.F8
    public final void A8n() throws IOException {
    }

    @Override // com.facebook.ads.redexgen.X.F3
    public final void ABF(long j, boolean z) {
        if (j == -9223372036854775807L) {
            j = this.A00;
        }
        if (this.A00 == j && this.A01 == z) {
            return;
        }
        A00(j, z);
    }

    @Override // com.facebook.ads.redexgen.X.F8
    public final void ACb(InterfaceC2114Zo interfaceC2114Zo) {
        ((C1499Ap) interfaceC2114Zo).A0S();
    }
}
